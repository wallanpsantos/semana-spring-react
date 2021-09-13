import axios from 'axios';
import { useEffect, useState } from 'react';
import Chart from 'react-apexcharts';
import { SaleSum } from 'types/sale';
import { BASE_URL } from 'utils/requests';

type ChartData = {
    labels: string[];
    series: number[];
}

function DonutChart(): JSX.Element {

    const [chartData, setChartData] = useState<ChartData>({ labels: [], series: [] });

    useEffect(() => {
        axios.get(`${BASE_URL}/sales/amount-by-seller`).then(response => {
            const data = response.data as SaleSum[];
            const dataLabels = data.map(l => l.sellerName);
            const dataSeries = data.map(s => s.sum);

            setChartData({ labels: dataLabels, series: dataSeries });
        });
    }, []);

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