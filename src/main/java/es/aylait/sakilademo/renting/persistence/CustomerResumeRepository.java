package es.aylait.sakilademo.renting.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.aylait.sakilademo.renting.domain.CustomerResume;

@Repository("customreResumeRepository")
public interface CustomerResumeRepository extends JpaRepository<CustomerResume,Long> {
	Iterable<CustomerResume> customerRentalResume();
}
