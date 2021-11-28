package lk.nsbm.b2bappapi.controller;

import lk.nsbm.b2bappapi.dto.CartDTO;
import lk.nsbm.b2bappapi.service.CartService;
import lk.nsbm.b2bappapi.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/cart")
@CrossOrigin
public class CardController {

    @Autowired
    private CartService cartService;

    @PostMapping(path = "/addProductToCart", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity addToCart(@RequestBody CartDTO dto) {
        cartService.addToCart(dto);
        return new ResponseEntity(new StandardResponse("201", "Done", dto), HttpStatus.CREATED);
    }

    @GetMapping(path = "/getCartItemsByUserID/{userID}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getProductsByUserID(@PathVariable String userID) {
        ArrayList<CartDTO> allCartItemsByUserId = cartService.getCartItemsByUserID(userID);
        return new ResponseEntity(new StandardResponse("200", "Done", allCartItemsByUserId), HttpStatus.OK);
    }

    @GetMapping(path = "/itemCount/{userID}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getProductsCountByUserID(@PathVariable int userID) {
        int count = cartService.getProductsCountByUserID(userID);
        return new ResponseEntity(new StandardResponse("200", "Done", count), HttpStatus.OK);
    }
    @GetMapping(path = "/oneTPrice/{userID}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getOneTotalPriceByUserID(@PathVariable int userID) {
        int count = cartService.getOneTotalPriceByUserID(userID);
        return new ResponseEntity(new StandardResponse("200", "Done", count), HttpStatus.OK);
    }

}
