package lk.nsbm.b2bappapi.service;

import lk.nsbm.b2bappapi.dto.ProductDTO;

import java.util.ArrayList;

public interface ProductService {

    void saveProduct(ProductDTO dto);

    ArrayList<ProductDTO> getAllProducts();

    ProductDTO searchProduct(String name);

    void deleteProduct(int id);

    void updateProduct(ProductDTO dto);
}
