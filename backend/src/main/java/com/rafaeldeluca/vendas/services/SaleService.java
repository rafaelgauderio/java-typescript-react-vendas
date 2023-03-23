package com.rafaeldeluca.vendas.services;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rafaeldeluca.vendas.entities.Sale;
import com.rafaeldeluca.vendas.repositories.SaleRepository;

@Service
public class SaleService {

	@Autowired
	private SaleRepository saleRepository;

	// service converta as data recebidas como string do controlador em Date
	@Transactional(readOnly = true)
	public Page<Sale> findSales(String minDate, String maxDate, Pageable pageableRequest) {

		// caso não seja informado os parametros data mínima e máxima a data mínima será a data de 
		// 3 anos atrás e a data máxima será hoje
		
		LocalDate today = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());
				
		LocalDate maximumDate;
		
		LocalDate minimumDate = minDate.equals("") ? today.minusYears(3) : LocalDate.parse(minDate);

		if (minDate.equals("")) {
			maximumDate = today;
		} else {
			maximumDate = LocalDate.parse(maxDate);
		}

		Page<Sale> vendas;
		vendas = saleRepository.findAllSales(minimumDate, maximumDate, pageableRequest);
		return vendas;
		// return saleRepository.findAll();

	}

}
