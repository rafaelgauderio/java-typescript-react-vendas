package com.rafaeldeluca.vendas.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.rafaeldeluca.vendas.entities.Sale;
import com.rafaeldeluca.vendas.repositories.SaleRepository;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@Service
public class SmsService {
	
	// annotation @value busca os valores das variáveis de ambiente espeficicada e salva na variavel abaixo espeficicada

	@Value("${twilio.sid}")
	private String twilioSid;

	@Value("${twilio.key}")
	private String twilioKey;

	@Value("${twilio.phone.from}")
	private String twilioPhoneFrom;

	@Value("${twilio.phone.to}")
	private String twilioPhoneTo;
	
	@Autowired
	private SaleRepository saleRepository;

	public void sendSmsToSeller(Long saleId) {
		
				
		// buscar um objeto venda do banco de dados
		Sale sale = saleRepository.findById(saleId).get();
		int month = sale.getDate().getMonthValue();
		int year = sale.getDate().getYear();
		
		String messageToSeller =  "Vendedor " + sale.getSellerName() + " atingiu a meta no período "
				+ month + "/" + year + ".\n"
						+ "Valor das vendas: " + String.format("R$ %.2f",sale.getTotal()); 
				
		

		Twilio.init(twilioSid, twilioKey);

		PhoneNumber to = new PhoneNumber(twilioPhoneTo);
		PhoneNumber from = new PhoneNumber(twilioPhoneFrom);

		Message finalMessage = Message.creator(to, from, messageToSeller).create();

		System.out.println(finalMessage.getSid());
	}
}