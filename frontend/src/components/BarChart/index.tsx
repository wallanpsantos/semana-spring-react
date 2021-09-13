import axios from 'axios';
import { useEffect, useState } from 'react';
import Chart from 'react-apexcharts';
import { SaleSuccess } from 'types/sale';
import { round } from 'utils/format';
import { BASE_URL } from 'utils/requests';

type SeriesData = {
    name: String;
    data: number[];
}

type ChartData = {
    labels: {
        categories: String[];
    };
    series: SeriesData[];
}

function BarChart(): JSX.Element {

    const [chartData, setChartData] = useState<ChartData>(
        {
            labels: {
                categories: []
            },
            series: [
                {
                    name: "",
                    data: []
                }
            ]
        }
    );

    useEffect(() => {
        axios.get(`${BASE_URL}/sales/success-by-seller`)
            .then(response => {
                const data = response.data as SaleSuccess[];
                const dataLabels = data.map(e => e.sellerName);
                const dataSeries = data.map(e => round(100 * (e.deals / e.visited), 1));

                setChartData({
                    labels: {
                        categories: dataLabels
                    },
                    series: [
                        {
                            name: "% Sucesso",
                            data: dataSeries
                        }
                    ]
                });
            });
    }, []);

    const options = {
        plotOptions: {
            bar: {
                horizontal: true,
            }
        },
    };

    return (
        <>
            <Chart
                options={{ ...options, xaxis: chartData.labels }}
                series={chartData.series}
                type="bar"
                height="240"
            />
        </>

    );
}

export default BarChart;