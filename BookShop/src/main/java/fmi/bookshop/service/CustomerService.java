package fmi.bookshop.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import fmi.bookshop.model.Customer;
import fmi.bookshop.repository.CustomerRepository;
import fmi.bookshop.request.CustomerRequest;
import fmi.bookshop.response.CustomerResponse;

@Service

public class CustomerService {

	private final CustomerRepository customerRepository;

	public CustomerService(CustomerRepository customerRepository) {
		super();
		this.customerRepository = customerRepository;
	}
	
	public CustomerResponse findCustomerById(Long id) {
		Optional<Customer> result = customerRepository.findById(id);
		if (result.isPresent()) {
			if (result.get().getActive()) {
				CustomerResponse resp = new CustomerResponse();
				resp.setId(result.get().getId());
				resp.setUsername(result.get().getUsername());
				List<Long> t = new ArrayList<>();
				result.get().getShoppingLists().stream().forEach(r -> t.add(r.getId()));
				resp.setShoppingLists(t);
				return resp;
			}
		}
		return null;
	}
	
	public CustomerResponse createCustomer(CustomerRequest customer) {
		Customer p = new Customer();
		p.setUsername(customer.getUsername());
		p.setShoppingLists(new ArrayList<>());
		p.setActive(true);
		p = customerRepository.save(p);
		CustomerResponse resp = new CustomerResponse();
		resp.setId(p.getId());
		resp.setUsername(p.getUsername());
		resp.setShoppingLists(new ArrayList<>());
		return resp;
	}
	
	public CustomerResponse updateCustomer(CustomerRequest customer, Long id) {
		Customer result = customerRepository.findById(id).orElse(null);
		if (result != null) {
			if (result.getActive()) {
				if (customer.getUsername() != null) {
					result.setUsername(customer.getUsername());
				}
				result = customerRepository.save(result);
				CustomerResponse resp = new CustomerResponse();
				resp.setId(result.getId());
				resp.setUsername(result.getUsername());
				List<Long> t = new ArrayList<>();
				result.getShoppingLists().stream().forEach(r -> t.add(r.getId()));
				resp.setShoppingLists(t);;
				return resp;
			}
		}
		return null;
	}
	
	public Boolean deleteCustomer(Long id) {
		Customer result = customerRepository.findById(id).orElse(null);
		if (result != null) {
			result.setActive(false);
			customerRepository.save(result);
			return true;
		}
		return false;
	}
}
