package org.fasttrackit.onlineshop.web;

import org.fasttrackit.onlineshop.service.CartService;
import org.fasttrackit.onlineshop.transfer.Cart.AddProductToCartRequest;
import org.fasttrackit.onlineshop.transfer.Cart.CartResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("/carts")
public class CartController {

    @Autowired
    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PutMapping
    private ResponseEntity addProductToCart(@RequestBody @Valid AddProductToCartRequest request)
    {
        cartService.addProductToCart(request);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}")
    private ResponseEntity<CartResponse> getCart(@PathVariable("id") long customerId)
    {
        CartResponse cart = cartService.getCart(customerId);
        return new ResponseEntity<>(cart,HttpStatus.OK);
    }





}
