package com.santiago.rifa.interfaces;

import com.santiago.rifa.model.Person;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Santiago43
 */
public interface IPersonRepository extends CrudRepository<Person, Long> {
    
}
