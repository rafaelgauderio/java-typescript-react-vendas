package com.rafaeldeluca.vendas.controlles;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rafaeldeluca.vendas.entities.Sale;
import com.rafaeldeluca.vendas.services.SaleService;

// Controlador é quem implenta a API
// controlador disponibiliza os endpoints necessários para o front-end acessar o backend

@RestController
@RequestMapping(value="/sales")
public class SaleController {
	
	@Autowired
	private SaleService saleService;
	
	@GetMapping
	public List<Sale> findAllSales () {
		List salesList = saleService.findSales();
		return salesList;		
		
	}

}
