import React from 'react'
import ReactDOM from 'react-dom/client'
import App from './App'
import './index.css'

// biblioteca React faz o processo de renderização
// React processa as informações e apresenta um resultado um tela gráfixa
// Renderização = processo de transformar código em imagens

ReactDOM.createRoot(document.getElementById('root') as HTMLElement).render(
  <React.StrictMode>
    <App />
  </React.StrictMode>,
)
