import axios from 'axios';
import Chart from 'react-apexcharts';
import { SaleSum } from 'types/sale';
import { BASE_URL } from 'utils/requests';

type ChartData = {
    labels: string[];
    series: number[];
}

function DonutChart(): JSX.Element {

    // FORMA FORA DO PADRAO
    let chartData: ChartData = { labels: [], series: [] };

    // FORMA FORA DO PADRAO
    axios.get(`${BASE_URL}/sales/amount-by-seller`).then(response => {
        const data = response.data as SaleSum[];
        const dataLabels = data.map(l => l.sellerName);
        const dataSeries = data.map(s => s.sum);

        chartData = { labels: dataLabels, series: dataSeries };

        console.log(chartData);
    });

    const options = {
        legend: {
            show: true
        }
    }

    return (
        <>
            <Chart
                options={{ ...options, labels: chartData.labels }}
                series={chartData.series}
                type="donut"
                height="240"
            />
        </>
    );
}

export default DonutChart;