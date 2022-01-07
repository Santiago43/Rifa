package com.santiago.rifa.interfaces;

import com.santiago.rifa.model.Ticket;
import java.util.List;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * Ticket Repository
 * @author santi
 */
public interface ITicketRepository extends CrudRepository<Ticket, Long> {
    @Query("select * from ticket where person_id=:personId")
    public List<Ticket> getByPersonId(Long personId);
}
