package fmi.bookshop.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "shopping_lists")
@NoArgsConstructor
@Getter
@Setter

public class ShoppingList {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "shopping_list_id", nullable = false)
	private Long id;
	@CreationTimestamp
	@Column(name = "date_created")
	private LocalDateTime created;
	@UpdateTimestamp
	@Column(name = "date_updated")
	private LocalDateTime updated;
	@Column(name = "shopping_list_category", nullable = false)
	private String category;
	@Column(name = "is_active", nullable = false)
	private Boolean active;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
	
	
	private List<Book> Books = new ArrayList<>();
	
	
	@ManyToOne
	private Customer owner;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public LocalDateTime getCreated() {
		return created;
	}


	public void setCreated(LocalDateTime created) {
		this.created = created;
	}


	public LocalDateTime getUpdated() {
		return updated;
	}


	public void setUpdated(LocalDateTime updated) {
		this.updated = updated;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public Boolean getActive() {
		return active;
	}


	public void setActive(Boolean active) {
		this.active = active;
	}


	public List<Book> getBooks() {
		return Books;
	}


	public void setBooks(List<Book> books) {
		Books = books;
	}


	public Customer getOwner() {
		return owner;
	}


	public void setOwner(Customer owner) {
		this.owner = owner;
	}


	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}


	public void setName(Object name) {
		// TODO Auto-generated method stub
		
	}
	
	

}


