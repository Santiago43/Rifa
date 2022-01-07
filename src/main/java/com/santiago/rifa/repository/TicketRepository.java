package com.santiago.rifa.repository;

import com.santiago.rifa.interfaces.ITicketRepository;
import com.santiago.rifa.model.Ticket;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Ticket repository
 * @author Santiago43
 */
@Repository
public class TicketRepository {
    @Autowired
    private ITicketRepository crud;
    public List<Ticket> getAll(){
        return (List<Ticket>) crud.findAll();
    }
   public Optional <Ticket> getTicket(long id){
       return crud.findById(id);
   } 
   public Ticket save (Ticket ticket){
       return crud.save(ticket);
   }
   
   public void delete(Ticket ticket){
       crud.delete(ticket);
    }
   public List<Ticket> findByPersonId(Long personId){
       return crud.getByPersonId(personId);
   }
}
