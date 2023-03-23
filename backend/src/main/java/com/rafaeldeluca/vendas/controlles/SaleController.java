package com.rafaeldeluca.vendas.controlles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	
	// Por default o pageable retorna os 20 primeiros elementos senão colocar nenhum parametro 
	// controlador recebe as datas do front end como string. 
	@GetMapping
	public Page<Sale> findAllSales (
			@RequestParam(value="minDate", defaultValue="") String minDate,
			@RequestParam(value="maxDate", defaultValue="") String maxDate,
			Pageable pageableRequest) {
		Page salesList = saleService.findSales(minDate, maxDate, pageableRequest);
		return salesList;		
		
	}

}
