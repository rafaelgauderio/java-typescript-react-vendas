import React from 'react';
import './styles.css';
import notificationIcon from '../../assets/images/notification.svg';


function NotificationButton () {
  return (
    <div className='vendas-red-button'>
        <img src={notificationIcon} alt="Notificar"></img>
    </div>
  )
}

export default NotificationButton;
