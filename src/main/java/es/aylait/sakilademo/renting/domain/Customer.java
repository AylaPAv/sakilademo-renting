package es.aylait.sakilademo.renting.domain;

import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="customer")
@NoArgsConstructor
public class Customer {
	@NotNull
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="customer_id")
	private Long id ;
	
	@Column(name="store_id")
    private Long storeId;
    @NotNull
    @Column(name="first_name")
    private String firstName;
    @NotNull
    @Column(name="last_name")
    private String lastName;
    private String email;
    @NotNull
    @Column(name="address_id")
    private Long addressId;
    @NotNull
    @Column(name="activebool")
    private Boolean activeBool; //Default true
    @Column(name="create_date", updatable=false)
    private LocalDateTime createDate; //Default now
    @Column(name="last_update")
    private LocalDateTime lastUpdate; //Default now
    private Integer active;
    
    private void setActiveBool(Boolean activeBool) {
    	this.activeBool = activeBool;
    }
    
    private void setCreateDate(LocalDateTime createDate) {
    	this.createDate = createDate;
    }
    
    private void setLastUpdate(LocalDateTime lastUpdate) {
    	this.lastUpdate = lastUpdate;
    }
    
    @PrePersist
    private void Create() {
    	this.setActiveBool(true);
    	this.setCreateDate(LocalDateTime.now());
    	this.setLastUpdate(LocalDateTime.now());
    }
    
    @PreUpdate
    private void Update() {
    	this.setLastUpdate(LocalDateTime.now());
    }
    
}
