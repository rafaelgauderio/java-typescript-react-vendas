import React from 'react';
import './styles.css';
import notificationIcon from '../../assets/images/notification.svg';
import { BASE_URL } from '../../utils/request';
import axios from 'axios';
import { toast } from 'react-toastify';

type PropsParameter = {
    saleId: number;
};

function actionNotificationOnClick(idDaVenda : number) {
  axios(`${BASE_URL}/sales/${idDaVenda}/notification`)
    .then(requestResponse => {
      //console.log("Enviado a notificação");
      toast.success("SMS enviado com sucesso");
    })
}

function NotificationButton ( {saleId} : PropsParameter ) {
  
  return (
    <div className='vendas-red-button'onClick={() => actionNotificationOnClick(saleId)}>
        <img src={notificationIcon} alt="Notificar"></img>
    </div>
  )
}

export default NotificationButton;
