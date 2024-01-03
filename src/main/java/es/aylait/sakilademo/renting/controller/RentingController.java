package es.aylait.sakilademo.renting.controller;

import java.util.Iterator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.aylait.sakilademo.renting.domain.Customer;
import es.aylait.sakilademo.renting.domain.CustomerResume;
import es.aylait.sakilademo.renting.handlexception.ResourceNotFoundException;
import es.aylait.sakilademo.renting.interfaces.CustomerService;

@RestController
@RequestMapping("/renting/api")
public class RentingController {
	
	@Autowired
	private CustomerService customerService;
	
	private static final Logger LOG = LoggerFactory.getLogger(RentingController.class);
	
//	@Autowired
//	public RentingController(CustomerService customerService) {
//		this.customerService = customerService;
//	}
	
	@GetMapping("/customer")
	public  ResponseEntity<Iterable<Customer>> getAllCustomer(){
		Iterable<Customer> response = this.customerService.getAll();
		
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
	@GetMapping("/customer/{name}")
	public ResponseEntity<Iterable<Customer>> getCustomerByName(@PathVariable String name){
		Iterable<Customer> response = this.customerService.findByName(name);
		Iterator<?> iterator = response.iterator();
		
		if(!iterator.hasNext()) throw new ResourceNotFoundException(String.format("No s'ha trobat el client %s", name));
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
	@GetMapping("/customer/{name}/{lastname}")
	public ResponseEntity<Iterable<Customer>> getCustomerByNameLastName(@PathVariable String name, String lastName){
		Iterable<Customer> response = this.customerService.findByName(name, lastName);
		Iterator<?> iterator = response.iterator();
		
		if(!iterator.hasNext()) throw new ResourceNotFoundException(String.format("No s'ha trobat el client %s %s", name, lastName));
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@GetMapping("/customer/resume")
	public ResponseEntity<Iterable<CustomerResume>> getCustomerResume(){
		Iterable<CustomerResume> response = this.customerService.customerRentalResume();
		
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
