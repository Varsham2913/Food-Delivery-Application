package com.tap.model;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Cart {

     Map<Integer, CartItem> cart;

    // Constructor
    public Cart() {
    	cart = new HashMap<Integer, CartItem>();
    }

    // Add item to cart
    public void addItem(CartItem item) {
        int itemId = item.getMenuId();
        if (cart.containsKey(itemId)) {
            CartItem existingItem = cart.get(itemId);
            existingItem.setQuantity(existingItem.getQuantity() + item.getQuantity());
        } else {
            cart.put(itemId, item);
        }
    }

    // Update item quantity in cart
    public void updateItem(int menuId, int quantity) {
        if (cart.containsKey(menuId)) {
            if (quantity <= 0) {
                cart.remove(menuId);
            } else {
                cart.get(menuId).setQuantity(quantity);
            }
        }
    }

    // Remove item from cart
    public void removeItem(int menuId) {
        cart.remove(menuId);
    }
    
    
    
    public  Map<Integer, CartItem> getItems(){
		return cart;
    	
    }
    
    public double getTotalPrice() {
    	int totalPrice = 0;
		Collection<CartItem> cartItems = cart.values();
		for(CartItem cartItem : cartItems) {
			totalPrice += cartItem.getPrice()*cartItem.getQuantity();
		}
		return totalPrice;
	}
    
    
    public void clear() {
    	cart.clear();
    }
}
