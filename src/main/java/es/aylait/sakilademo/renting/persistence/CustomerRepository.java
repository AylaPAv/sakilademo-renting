package es.aylait.sakilademo.renting.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.aylait.sakilademo.renting.domain.Customer;

@Repository("customerRepository")
public interface CustomerRepository extends JpaRepository<Customer, Long> {
	Iterable<Customer> findByFirstNameContaining(String firstName);
	Iterable<Customer> findByFirstNameContainingAndLastNameContaining(String name, String lastName);
}
