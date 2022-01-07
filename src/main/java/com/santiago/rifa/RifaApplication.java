package com.santiago.rifa;

import com.santiago.rifa.model.Ticket;
import com.santiago.rifa.repository.TicketRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.santiago.rifa"})
public class RifaApplication {

    @Autowired
    private TicketRepository repo;

    public static void main(String[] args) {
        SpringApplication.run(RifaApplication.class, args);

    }

    @Bean
    ApplicationRunner applicationRunner() {
        return args -> {
            List<Ticket> ps = repo.getAll();
            if (ps.isEmpty()) {
                for (int i = 0; i < 1000; i++) {
                    Ticket ticket = new Ticket();
                    ticket.setChoosen(false);
                    repo.save(ticket);
                }
            }
            System.out.println(repo.getAll().size());
        };
    }
}
