import React, {useState, useEffect} from 'react';

const STRIKE_FILTER = 5850;
const INTERVAL = 60000; //Update the frontend every minute.

const OptionSummaryTables = () => {
    const [summaries, setSummaries] = useState ({})
    const [lastUpdateTime, setLastUpdateTime] = useState(null);

    // Function that fetches daily summary data from the backend
    const fetchData = () => {
        fetch('/daily-summary')
            .then(response => response.json())
            .then(data => {
                console.log('Data received: ', data)
                const processedData = processData(data);
                setSummaries(processedData);
                setLastUpdateTime(new Date());
            })
            .catch(error => console.error("Error fetching data:", error));
    };

    //Effect hook to get the initial data fetch, and then fetch the data on a set interval
    useEffect(() => {
        fetchData(); // Initial fetch data function call when the component mounts
        const intervalId = setInterval(fetchData, INTERVAL);

        // When the component unmounts, clear the interval
        return () => clearInterval(intervalId)
        }, []); //No dependency, so this effect only runs once when the component mounts


    //Function to take the incoming daily summary data, retrieve the expiration date, strike price, and create a grouped
    // data object to represent how the data will be displayed in the table. Will be stored in summaries
    // "2024-10-11": {
    //    5700: {item}
    //    5800: {item}
    // },
    // "2024-10-18": {
    //    5700: {item}
    //    5800: {item}
    // },
    const processData = (data) => {
        // Group data by expiration date and strike price
        const groupedData = {};
        data.forEach(item => {
            //Filter to use call's or puts
            if ((item.strikePrice <= STRIKE_FILTER && item.optionType === 'P') ||
                item.strikePrice > STRIKE_FILTER && item.optionType === 'C') {
            const expirationDate = item.expirationDate;
            const strikePrice = item.strikePrice
            if (!groupedData[expirationDate]) {
                groupedData[expirationDate] = {};
            }
            groupedData[expirationDate][strikePrice] = item;
            }
        });
        return groupedData;
    };

    // Function to format price to 2 decimal places
    const formatPrice = (price) => price.toFixed(2);

    // Function to format the change in price to show a + or -
    const formatChange = (change) => (change > 0 ? '+' : '') + change.toFixed(2);

    // Function to format the color of the change. Red for negative, green for positive
    const getChangeStyle = (change) => ({
        color: change > 0 ? 'green' : 'red'
    });

    //Gets a sorted set of unique strikes(ascending). First gets the values of the summaries objects. Then the keys of those values. Then makes it unique with a set. Then sorts
    const strikes = [...new Set(Object.values(summaries).flatMap(s => Object.keys(s)))].sort((a, b) => parseFloat(a) - parseFloat(b));

    return(
        <div>
            <h2>Fixed Strike Volatility</h2>
            {lastUpdateTime && (
                <p>Last updated: {lastUpdateTime.toLocaleTimeString()}</p>
            )}
            <table>
                <thead>
                    <tr>
                        <th>Expiration</th>
                        {strikes.map(strike => (
                            <th key={strike}>{strike}</th>
                        ))}
                    </tr>
                </thead>
                <tbody>
                {Object.entries(summaries).map(([expirationDate, strikeData]) => (
                    <tr key={expirationDate}>
                        <td>{expirationDate}</td>
                        {strikes.map(strike => {
                            const data = strikeData[strike];
                            if (!data) return <td key={strike}>-</td>;
                            const change = data.closingPrice - data.openingPrice;
                            return (
                                <td key={strike}>
                                    <div>{formatPrice(data.openingPrice)}</div>
                                    <div>{formatPrice(data.closingPrice)}</div>
                                    <div style={getChangeStyle(change)}>({formatChange(change)})</div>
                                </td>
                            );
                        })}
                    </tr>
                ))}
                </tbody>
              </table>
        </div>
    );
};

export default OptionSummaryTables;