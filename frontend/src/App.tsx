import BarChart from "components/BarChart";
import DataTable from "components/DataTable";
import DonutChart from "components/DonutChart";
import Footer from "components/Footer";
import NavBar from "components/NavBar";

function App(): JSX.Element {
  return (
    <>
      <div className="container">

        <NavBar />

        <h1 className="text-success py-3">Dashboard de Vendas</h1>

        <div className="row px-3" >
          <div className="col-sm-6">
            <h5 className="text-center text-secondary">Taxa de sucesso (%)</h5>
            <BarChart />
          </div>

          <div className="col-sm-6">
            <h5 className="text-center text-secondary">Todas as vendas</h5>
            <DonutChart />
          </div>
        </div>

        <div className="py-3">
          <h2 className="text-success">Todas as vendas</h2>
          <DataTable />
        </div>

        <Footer />

      </div>
    </>
  );
}

export default App;
