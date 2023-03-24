import Header from "./components/Header/indext";
import NotificationButton from "./components/NotificationButton";
import SalesCard from "./components/SalesCard";
import { ToastContainer } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';

function App() {

  return (
    <>
    <ToastContainer />
    <Header />
    <main>
      <section id="sales-dashboard">
        <div className="vendas-container">
          <SalesCard />
        </div>
      </section>
    </main>
    </>
  )
  
}

export default App
