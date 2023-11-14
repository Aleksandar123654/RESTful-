package fmi.bookshop.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter

public class Author {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "author_id", nullable = false)
	private Long id;
	@CreationTimestamp
	@Column(name = "date_created")
	private LocalDateTime created;
	@UpdateTimestamp
	@Column(name = "date_updated")
	private LocalDateTime updated;
	@Column(name = "author_title", nullable = false)
	private String title;
	@Column(name = "author_description")
	private String description;

	@Column(name = "is_active", nullable = false)
	private Boolean active;
	@ManyToOne
	private Book owner;
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
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Boolean getActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}
	public Book getOwner() {
		return owner;
	}
	public void setOwner(Book owner) {
		this.owner = owner;
	}
	public void setName(Object name) {
		// TODO Auto-generated method stub
	
	}
	public void setBirthDate(Object birthDate) {
		// TODO Auto-generated method stub
		
	}
	public Object getName() {
		// TODO Auto-generated method stub
		return null;
	}
	public Object getBirthDate() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
