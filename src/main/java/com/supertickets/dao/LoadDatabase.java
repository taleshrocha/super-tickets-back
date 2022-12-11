package com.supertickets.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.supertickets.model.Evento;
import com.supertickets.model.Ticket;

@Configuration
class LoadDatabase {

  private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

  @Bean
  CommandLineRunner initDatabase(EventoRepository eventoRepository, TicketRepository ticketRepository) {

    return args -> {
      eventoRepository.save(new Evento("Copa do Mundo", "Catar"));
      eventoRepository.save(new Evento("Como procrastinar em PDS", "Natal, RN. Brasil"));
      eventoRepository.save(new Evento("Depressão pós-copa, uma realidade", "SP. Brasil"));
      eventoRepository.findAll().forEach(evento -> log.info("Preloaded " + evento));

      ticketRepository.save(new Ticket(20.00, 1L));
      ticketRepository.save(new Ticket(12.00, 2L));
      ticketRepository.save(new Ticket(500.99, 3L));
      ticketRepository.findAll().forEach(ticket -> log.info("Preloaded " + ticket));
    };
  }

}
