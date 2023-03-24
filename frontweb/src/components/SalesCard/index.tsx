import React, { useEffect, useState } from 'react';
import NotificationButton from '../NotificationButton';
import './styles.css';
import DatePiacker from 'react-datepicker';
import "react-datepicker/dist/react-datepicker.css";
import axios from 'axios';
import { BASE_URL } from '../../utils/request';
import { Sale } from '../../models/sale';

// o resultado de um component react visual na tela é resultado de dados que estão dentro do componente
// para mudar o visual é necessário alterar os dados do componente
// assim o próprio engine do react vê os dados alterados e atualiza o visual do componente na tela

// useState. Ao alterar o estado do componente vai ser alterado o visual no frontEnd

function SalesCard() {

    let lastYear = new Date(new Date().setDate(new Date().getDate() - 365));
    let today = new Date();

    const [dataMinima, setDataMinima] = useState(new Date(lastYear));
    const [dataMaxima, setDataMaxima] = useState(new Date(today));

    // o type do useState vai ser um lista de Sale e o valor inicial um lista empty.
    const [sales, setSales] = useState<Sale[]>([]);

    useEffect(() => {
        // fazendo requisição no backend com axios
        // a requisição retorna um objeto do tipo Promise

        axios.get(`${BASE_URL}/sales`)
            .then(requestResponse => {
                //console.log("testar requisicao")
                //console.log(requestResponse.data);
                setSales(requestResponse.data.content);
            });
    }, []);

    return (
        <div className="vendas-card">

            <div>
                <div className="vendas-form-control-container">
                    <h2 className="vendas-dashboard-title">Vendas por data</h2>
                    <DatePiacker
                        selected={dataMinima}
                        onChange={(parameterMinDate: Date) => setDataMinima(parameterMinDate)}
                        dateFormat="dd/MM/yyyy"
                        className="vendas-form-control"
                    />
                </div>
                <div className="vendas-form-control-container">
                    <DatePiacker
                        selected={dataMaxima}
                        onChange={(parameterMaxDate: Date) => setDataMaxima(parameterMaxDate)}
                        dateFormat="dd/MM/yyyy"
                        className="vendas-form-control"
                    />
                </div>
            </div>

            <div>
                <table className="vendas-dashboard-table">
                    <thead>
                        <tr>
                            <th className="breakpoint-992">ID</th>
                            <th className="breakpoint-576">Data</th>
                            <th>Vendedor</th>
                            <th className="breakpoint-992">Visitas</th>
                            <th className="breakpoint-992">Vendas</th>
                            <th>Total</th>
                            <th>Notificar</th>
                        </tr>
                    </thead>
                    <tbody>
                        {sales.map(itemDasVendas => {
                            return (
                                <tr key={itemDasVendas.id}>
                                    <td className="breakpoint-992">{itemDasVendas.id}</td>
                                    <td className="breakpoint-576">{new Date(itemDasVendas.date).toLocaleDateString()}</td>
                                    <td>{itemDasVendas.sellerName}</td>
                                    <td className="breakpoint-992">{itemDasVendas.visited}</td>
                                    <td className="breakpoint-992">{itemDasVendas.sales}</td>
                                    <td>R$ {itemDasVendas.total.toFixed(2)}</td>
                                    <td>
                                        <div className="vendas-red-button-container">
                                            <NotificationButton />
                                        </div>
                                    </td>
                                </tr>
                            )
                        })}
                    </tbody>

                </table>
            </div>

        </div>
    )
}

export default SalesCard;