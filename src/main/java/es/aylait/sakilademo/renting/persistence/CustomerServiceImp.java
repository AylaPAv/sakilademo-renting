package es.aylait.sakilademo.renting.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import es.aylait.sakilademo.renting.domain.Customer;
import es.aylait.sakilademo.renting.domain.CustomerResume;
import es.aylait.sakilademo.renting.interfaces.CustomerService;

@Service("customerService")
public class CustomerServiceImp implements CustomerService {
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private CustomerResumeRepository customerResumeRepository;
	
//	@Autowired
//	public CustomerServiceImp(CustomerRepository customerRepository) {
//		this.customerRepository = customerRepository;
//	}
	
	public Iterable<Customer> getAll(){
		return this.customerRepository.findAll();
	}
	
	public Iterable<Customer> findByName(String name, String lastName){
		return this.customerRepository.findByFirstNameContainingAndLastNameContaining(name, lastName);
	}
	
	public Iterable<Customer> findByName(String name){
		return this.customerRepository.findByFirstNameContaining(name);
	}

	@Override
	public Iterable<CustomerResume> customerRentalResume() {
		return this.customerResumeRepository.customerRentalResume();
	}
}
