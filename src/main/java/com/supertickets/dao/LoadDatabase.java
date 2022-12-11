package com.supertickets.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.supertickets.model.Evento;

@Configuration
class LoadDatabase {

  private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

  @Bean
  CommandLineRunner initDatabase(EventoRepository eventoRepository) {

    return args -> {
      eventoRepository.save(new Evento("Copa do Mundo", "Catar"));
      eventoRepository.save(new Evento("Como procrastinar em PDS", "Natal, RN. Brasil"));
      eventoRepository.save(new Evento("Depressão pós-copa, uma realidade", "SP. Brasil"));
      eventoRepository.findAll().forEach(evento -> log.info("Preloaded " + evento));
    };
  }

}
