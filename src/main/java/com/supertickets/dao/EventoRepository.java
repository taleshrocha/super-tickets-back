package com.supertickets.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.supertickets.model.Evento;

public interface EventoRepository extends JpaRepository<Evento, Long> {

}
