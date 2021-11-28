package lk.nsbm.b2bappapi.service;

import lk.nsbm.b2bappapi.dto.CartDTO;
import lk.nsbm.b2bappapi.dto.ProductDTO;

import java.util.ArrayList;

public interface CartService {


    void addToCart(CartDTO dto);

    ArrayList<CartDTO> getCartItemsByUserID(String userID);

    int getProductsCountByUserID(int userID);

    int getOneTotalPriceByUserID(int userID);
}
