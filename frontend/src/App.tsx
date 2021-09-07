import DataTable from "components/DataTable";
import Footer from "components/Footer";
import NavBar from "components/NavBar";

function App(): JSX.Element {
  return (
    <>
      <NavBar />
      <div className="container">
        <h1 className="text-primary">Salve!</h1>
      </div>
      <DataTable />
      <Footer />
    </>
  );
}

export default App;
