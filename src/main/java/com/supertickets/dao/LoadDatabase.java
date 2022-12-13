package com.supertickets.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.supertickets.model.Evento;
import com.supertickets.model.Ticket;
import com.supertickets.model.Cliente;
import com.supertickets.model.ClienteTicket;

@Configuration
class LoadDatabase {

  private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

  @Bean
  CommandLineRunner initDatabase(EventoRepository eventoRepository, TicketRepository ticketRepository,
      ClienteRepository clienteRepository, ClienteTicketRepository clienteTicketRepository) {

    return args -> {
      eventoRepository.save(new Evento("Copa do Mundo", "Catar"));
      eventoRepository.save(new Evento("Como procrastinar em PDS", "Natal, RN. Brasil"));
      eventoRepository.save(new Evento("Depressão pós-copa, uma realidade", "SP. Brasil"));
      eventoRepository
          .save(new Evento("Passar vergonha em PDS", "RJ. Brasil"));
      eventoRepository.findAll().forEach(evento -> log.info("Preloaded " + evento));

      ticketRepository.save(new Ticket(20.00, 1L));
      ticketRepository.save(new Ticket(12.00, 2L));
      ticketRepository.save(new Ticket(500.99, 3L));
      ticketRepository.findAll().forEach(ticket -> log.info("Preloaded " + ticket));

      clienteRepository.save(new Cliente("Ratinho", "4002-8922", "39-12928319"));
      clienteRepository.save(new Cliente("Pelé", "6966-8921", "42-142456264"));
      clienteRepository.save(new Cliente("Bolsonaro", "6666-6666", "666-66666666"));
      clienteRepository.findAll().forEach(cliente -> log.info("Preloaded " + cliente));

      clienteTicketRepository.save(new ClienteTicket(8L, 5L));
      clienteTicketRepository.save(new ClienteTicket(8L, 5L));
      clienteTicketRepository.save(new ClienteTicket(9L, 6L));
      clienteTicketRepository.findAll().forEach(clienteTicket -> log.info("Preloaded " + clienteTicket));
    };
  }
}
