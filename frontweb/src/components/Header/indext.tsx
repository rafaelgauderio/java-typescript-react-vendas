import React from 'react';
import './styles.css';
import logoHeader from '../../assets/images/logo.svg';

function Header () {
  return (
    <header>
    <div className="vendas-logo-container">
        <img src={logoHeader} alt="vendas" />
        <h1>Dashboard de Vendas</h1>
        <p>           
          <a href="https://github.com/rafaelgauderio" target="_blank"> Desenvolvido por@rafaeldeluca</a>
        </p>
    </div>
</header>
  )
}

export default Header;
