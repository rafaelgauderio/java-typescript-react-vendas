import Header from "./components/Header/indext"
import NotificationButton from "./components/NotificationButton"
import SalesCard from "./components/SalesCard"

function App() {

  return (
    <>
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
