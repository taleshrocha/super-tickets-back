package com.supertickets.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.supertickets.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
