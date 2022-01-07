package com.santiago.rifa.service;

import com.santiago.rifa.model.Person;
import com.santiago.rifa.repository.PersonRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Santiago43
 */
@Service
public class PersonService {
    @Autowired
    private PersonRepository repo;
    public boolean create(Person person){
        return repo.save(person)!=null;
    }
    public boolean update(Person person){
        Optional<Person> opt = repo.getPerson(person.getId());
        if(!opt.isEmpty()){
            if(person.getName()!=null){
                opt.get().setName(person.getName());
            }
            if(person.getPhone()!=null){
                opt.get().setPhone(person.getPhone());
            }
            return repo.save(opt.get())!=null;
        }
        return false;
    }
    public List<Person> getAll(){
        return repo.getAll();
    }
}
