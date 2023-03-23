package com.rafaeldeluca.vendas.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rafaeldeluca.vendas.entities.Sale;
import com.rafaeldeluca.vendas.repositories.SaleRepository;

@Service
public class SaleService  {
	
	@Autowired
	private SaleRepository saleRepository;
	
	@Transactional(readOnly=true)
	public List<Sale> findSales () {
		
		List<Sale> vendas = new ArrayList<Sale> ();
		vendas = saleRepository.findAll();
		return vendas;
		//return saleRepository.findAll();
		
	}

}
