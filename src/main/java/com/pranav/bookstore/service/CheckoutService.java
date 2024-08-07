package com.pranav.bookstore.service;

import com.pranav.bookstore.models.Cart;
import com.pranav.bookstore.repository.CartRepository;
import com.pranav.bookstore.repository.Library;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.TreeMap;

@Service
public class CheckoutService {

    @Autowired
    CartRepository cartRepo;
    @Autowired
    Library library;

    public Cart addToCart(String username, String itemId, double priceOfOne, int quantity) {
        Optional<Cart> cartOpt = cartRepo.findByUsername(username);
        Cart cart = (cartOpt.isPresent())?cartOpt.get():new Cart();
        if(cartOpt.isPresent()) {
            cartRepo.delete(cart);
        } else {
            cart.setUsername(username);
        }
        TreeMap<String, Integer> map = cart.getCart();
        if (map == null) {
            map = new TreeMap<>();
            cart.setCart(map);
        }
        if (map.containsKey(itemId)) {
            int val = map.get(itemId)+quantity;
            map.replace(itemId, val);
        } else
            map.put(itemId, quantity);
        return cartRepo.save(cart);
    }
}
