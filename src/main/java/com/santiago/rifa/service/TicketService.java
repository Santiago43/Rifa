package com.santiago.rifa.service;

import com.santiago.rifa.model.Ticket;
import com.santiago.rifa.repository.TicketRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Ticket Service
 * @author santi
 */
@Service
public class TicketService {
    @Autowired
    private TicketRepository repo;
    public boolean create(Ticket ticket){
        return repo.save(ticket)!=null;
    }
    public boolean update(Ticket ticket){
        Optional<Ticket> opt = repo.getTicket(ticket.getId());
        if(!opt.isEmpty()){
            if(ticket.isChoosen() && !opt.get().isChoosen()){
                opt.get().setChoosen(ticket.isChoosen());
                opt.get().setPerson(ticket.getPerson());
                return repo.save(ticket)!=null;
            }
        }
        return false;
    }
    public List<Ticket> getAll(){
        return repo.getAll();
    }
    
    public Optional<Ticket> getTicket(Long ticketId){
        return repo.getTicket(ticketId);
    }
    public List <Ticket> getByPersonId(Long personId){
        return repo.findByPersonId(personId);
    }
}
