package com.rafaeldeluca.vendas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rafaeldeluca.vendas.entities.Sale;

// Repositórios são os componentes responsáveis por acessar o bando de dados

@Repository
public interface SaleRepository extends JpaRepository<Sale,Long> {	
	

}
