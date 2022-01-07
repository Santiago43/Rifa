package com.santiago.rifa.repository;

import com.santiago.rifa.interfaces.IPersonRepository;
import com.santiago.rifa.model.Person;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author santi
 */
@Repository
public class PersonRepository {
    @Autowired
    private IPersonRepository crud;
    public List<Person> getAll(){
        return (List<Person>) crud.findAll();
    }
   public Optional <Person> getPerson(long id){
       return crud.findById(id);
   } 
   public Person save (Person person){
       return crud.save(person);
   }
   
   public void delete(Person person){
       crud.delete(person);
    }
}
