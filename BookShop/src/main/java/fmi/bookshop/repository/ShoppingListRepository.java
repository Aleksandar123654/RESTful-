package fmi.bookshop.repository;

import org.springframework.data.repository.CrudRepository;

import fmi.bookshop.model.ShoppingList;

public interface ShoppingListRepository extends CrudRepository<ShoppingList, Long>{

}
