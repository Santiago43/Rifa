package com.santiago.rifa.controller;

import com.santiago.rifa.model.Ticket;
import com.santiago.rifa.service.TicketService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author santi
 */
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RestController
@RequestMapping("/Ticket")
public class TicketController {
    @Autowired
    private TicketService service;
    @GetMapping("/all")
    public List<Ticket> list() {
        return service.getAll();
    }
    @GetMapping("/Person/{id}")
    public List<Ticket> listByPerson(@PathVariable("id") Long id) {
        return service.getByPersonId(id);
    }
    @GetMapping("/{id}")
    public Optional<Ticket> get(@PathVariable String id) {
        return service.getTicket(Long.parseLong(id));
    }
    @ResponseStatus(value=HttpStatus.CREATED)
    @PutMapping("/update")
    public Boolean put(@RequestBody Ticket ticket) {
        return service.update(ticket);
    }
    
    @PostMapping()
    public ResponseEntity<?> post(@RequestBody Object input) {
        return null;
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        return null;
    }
    
    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Internal error")
    public void handleError() {
    }
    
}
