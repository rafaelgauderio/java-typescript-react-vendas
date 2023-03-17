import React from 'react';
import NotificationButton from '../NotificationButton';
import './styles.css';
import DatePiacker from 'react-datepicker';
import "react-datepicker/dist/react-datepicker.css";

function SalesCard() {
    return (
        <div className="vendas-card">
            
            <div>
                <div className="vendas-form-control-container">
                <h2 className="vendas-dashboard-title">Vendas por data</h2>
                    <DatePiacker 
                    selected={new Date()}
                    onChange={(date: Date) => {}}
                    dateFormat="dd/MM/yyyy"
                    className="vendas-form-control"
                    />
                </div>
                <div className="vendas-form-control-container">
                    <DatePiacker 
                    selected={new Date()}
                    onChange={(date: Date) => {}}
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
                        <tr>
                            <td className="breakpoint-992">#341</td>
                            <td className="breakpoint-576">08/07/2022</td>
                            <td>Rafael</td>
                            <td className="breakpoint-992">15</td>
                            <td className="breakpoint-992">11</td>
                            <td>R$ 54300.00</td>
                            <td>
                                <div className="vendas-red-button-container">
                                    <NotificationButton />
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td className="breakpoint-992">#341</td>
                            <td className="breakpoint-576">08/07/2022</td>
                            <td>Luca</td>
                            <td className="breakpoint-992">15</td>
                            <td className="breakpoint-992">11</td>
                            <td>R$ 14700.00</td>
                            <td>
                                <div className="vendas-red-button-container">
                                    <NotificationButton />
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td className="breakpoint-992">#341</td>
                            <td className="breakpoint-576">08/07/2022</td>
                            <td>Atena</td>
                            <td className="breakpoint-992">15</td>
                            <td className="breakpoint-992">11</td>
                            <td>R$ 12300.00</td>
                            <td>
                                <div className="vendas-red-button-container">
                                    <NotificationButton />
                                </div>
                            </td>
                        </tr>
                    </tbody>

                </table>
            </div>

        </div>
    )
}

export default SalesCard;