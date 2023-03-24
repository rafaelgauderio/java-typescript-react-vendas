package com.rafaeldeluca.vendas.repositories;

import java.time.LocalDate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.rafaeldeluca.vendas.entities.Sale;

// Repositórios são os componentes responsáveis por acessar o bando de dados

@Repository
public interface SaleRepository extends JpaRepository<Sale,Long> {
	
	// tem que fazer a consulta que recebe data como argumentos. não tem pronta no JpaRepository 
	
	@Query("SELECT objeto "
			+ "FROM Sale objeto "
			+ "WHERE objeto.date "
			+ "BETWEEN :minimumDate AND :maximumDate "
			+ "ORDER BY objeto.total DESC")
	Page<Sale> findAllSales(LocalDate minimumDate, LocalDate maximumDate, Pageable pageableRequest);	
	

}
