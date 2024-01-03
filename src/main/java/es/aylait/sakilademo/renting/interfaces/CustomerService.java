package es.aylait.sakilademo.renting.interfaces;

import es.aylait.sakilademo.renting.domain.Customer;
import es.aylait.sakilademo.renting.domain.CustomerResume;

public interface CustomerService {
	public Iterable<Customer> getAll();
	public Iterable<Customer> findByName(String name, String lastName);
	public Iterable<Customer> findByName(String name);
	public Iterable<CustomerResume> customerRentalResume();
}
