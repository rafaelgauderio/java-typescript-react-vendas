package com.rafaeldeluca.vendas.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rafaeldeluca.vendas.entities.Sale;
import com.rafaeldeluca.vendas.repositories.SaleRepository;

@Service
public class SaleService  {
	
	@Autowired
	private SaleRepository saleRepository;
	
	@Transactional(readOnly=true)
	public Page<Sale> findSales (Pageable pageableRequest) {
		
		Page<Sale> vendas;  
		vendas = saleRepository.findAll(pageableRequest);
		return vendas;
		//return saleRepository.findAll();
		
	}

}
