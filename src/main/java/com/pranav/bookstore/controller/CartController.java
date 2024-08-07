package com.pranav.bookstore.controller;

import com.pranav.bookstore.models.Cart;
import com.pranav.bookstore.service.CheckoutService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/checkout")
@AllArgsConstructor
public class CartController {

    @Autowired
    private final CheckoutService checkoutService;

    @PatchMapping("/addToCart")
    public Cart addToCart(@RequestParam String username,
                          @RequestParam String itemId,
                          @RequestParam double priceOfOne,
                          @RequestParam(required = false, defaultValue = "1") int quantity) {
        return checkoutService.addToCart(username,itemId,priceOfOne,quantity);
    }

}
