package com.santiago.rifa.controller;

import com.santiago.rifa.model.Person;
import com.santiago.rifa.service.PersonService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
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
 * @author Santiago43
 */
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RestController
@RequestMapping("/Person")
public class PersonController {
    @Autowired
    PersonService service;
    @GetMapping()
    public List<Person> list(HttpEntity<byte[]> requestEntity) {
        String token = requestEntity.getHeaders().getFirst("token");
        if("123456ABC".equals(token)){
            return service.getAll();
        }
        return null;
    }
    
    @GetMapping("/{id}")
    public Object get(@PathVariable("id") String id) {
        return null;
    }
    
    @PutMapping("/update")
    public Boolean put(@RequestBody Person person) {
        return service.update(person);
    }
    
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Boolean post(@RequestBody Person person) {
        return service.create(person);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        return null;
    }
    
    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "No autorizado")
    public void handleError() {
    }
    
}
