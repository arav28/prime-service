package edu.iu.arsivak.primeservice.repository;

import edu.iu.arsivak.primeservice.model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthenticationDBRepository extends CrudRepository<Customer,String> {

    Customer findByUsername(String username);
}
