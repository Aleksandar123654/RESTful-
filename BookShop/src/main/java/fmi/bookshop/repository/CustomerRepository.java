package fmi.bookshop.repository;

import org.springframework.data.repository.CrudRepository;

import fmi.bookshop.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long>{

}
