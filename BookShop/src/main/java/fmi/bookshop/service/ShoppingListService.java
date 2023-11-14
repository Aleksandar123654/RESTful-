package fmi.bookshop.service;

import fmi.bookshop.model.ShoppingList;
import fmi.bookshop.repository.ShoppingListRepository;
import fmi.bookshop.request.ShoppingListRequest;
import fmi.bookshop.response.ShoppingListResponse;

public class ShoppingListService {

	private final ShoppingListRepository shoppingListRepository;

    public ShoppingListService(ShoppingListRepository shoppingListRepository) {
        this.shoppingListRepository = shoppingListRepository;
    }

    public ShoppingListResponse findShoppingListById(Long id) {
        java.util.Optional<ShoppingList> result = shoppingListRepository.findById(id);
        return result.map(this::mapToShoppingListResponse).orElse(null);
    }

    public ShoppingListResponse createShoppingList(ShoppingListRequest shoppingListRequest) {
        ShoppingList shoppingList = new ShoppingList();
        shoppingList.setName(shoppingListRequest.getName());
        shoppingList = shoppingListRepository.save(shoppingList);
        return mapToShoppingListResponse(shoppingList);
    }

    public ShoppingListResponse updateShoppingList(ShoppingListRequest shoppingListRequest, Long id) {
        ShoppingList shoppingList = shoppingListRepository.findById(id).orElse(null);
        if (shoppingList != null) {
            shoppingList.setName(shoppingListRequest.getName());
            shoppingList = shoppingListRepository.save(shoppingList);
            return mapToShoppingListResponse(shoppingList);
        }
        return null;
    }

    public Boolean deleteShoppingList(Long id) {
        java.util.Optional<ShoppingList> result = shoppingListRepository.findById(id);
        if (result.isPresent()) {
            shoppingListRepository.delete(result.get());
            return true;
        }
        return false;
    }

    private ShoppingListResponse mapToShoppingListResponse(ShoppingList shoppingList) {
        ShoppingListResponse response = new ShoppingListResponse();
        response.setId(shoppingList.getId());
        response.setName(shoppingList.getName());

        return response;
    }
	
}
