package fmi.bookshop.response;

import java.util.ArrayList;
import java.util.List;

public class CustomerResponse {
	
	private Long id;
	private String username;
	private List<Long> shoppingLists = new ArrayList<>();
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public List<Long> getShoppingLists() {
		return shoppingLists;
	}
	public void setShoppingLists(List<Long> shoppingLists) {
		this.shoppingLists = shoppingLists;
	}

}
