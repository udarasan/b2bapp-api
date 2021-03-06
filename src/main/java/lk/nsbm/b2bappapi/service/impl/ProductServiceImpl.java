package lk.nsbm.b2bappapi.service.impl;

import lk.nsbm.b2bappapi.dto.ProductDTO;
import lk.nsbm.b2bappapi.entity.Product;
import lk.nsbm.b2bappapi.exception.ValidateException;
import lk.nsbm.b2bappapi.repo.ProductRepo;
import lk.nsbm.b2bappapi.repo.UserRepo;
import lk.nsbm.b2bappapi.service.ProductService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public void saveProduct(ProductDTO dto) {

        productRepo.save(modelMapper.map(dto, Product.class));
    }

    @Override
    public ArrayList<ProductDTO> getAllProducts() {
        List<Product> all = productRepo.findAll();
        return modelMapper.map(all, new TypeToken<ArrayList<ProductDTO>>() {
        }.getType());
    }

    @Override
    public ProductDTO searchProduct(String name) {
        Optional<Product> product = Optional.ofNullable(productRepo.findByName(name));
        if (product.isPresent()) {
            return modelMapper.map(product.get(), ProductDTO.class);
        }else {
            throw new ValidateException("No Product for This Name..!");
        }
    }

    @Override
    public void deleteProduct(int id) {
        if (!productRepo.existsById(id)) {
            throw new ValidateException("No Product for Delete..!");
        }
        productRepo.deleteById(id);
    }

    @Override
    public void updateProduct(ProductDTO dto) {
        if (productRepo.existsById(dto.getPID())) {
            productRepo.save(modelMapper.map(dto, Product.class));
        }
        else {
            throw new ValidateException("No Product for This id..!");
        }
    }

    @Override
    public ArrayList<ProductDTO> getAllTopProducts() {
        List<Product> all = productRepo.findAllTop();
        
        return modelMapper.map(all, new TypeToken<ArrayList<ProductDTO>>() {
        }.getType());
    }

    @Override
    public ArrayList<ProductDTO> getAllFilterProducts(String productName,Integer minPrice,Integer maxPrice,String
            productLocation,Integer minQTY,Integer maxQTY) {
        List<Product> all = productRepo.findAllFilterProducts(productName,minPrice,maxPrice,productLocation,minQTY,maxQTY);

        return modelMapper.map(all, new TypeToken<ArrayList<ProductDTO>>() {
        }.getType());
    }

    @Override
    public ArrayList<ProductDTO> getProductsByUserID(String userID) {
        System.out.println("ok2");
        List<Product> all = productRepo.findAllBySellerID(userID);
        return modelMapper.map(all, new TypeToken<ArrayList<ProductDTO>>() {
        }.getType());
    }

    @Override
    public ArrayList<ProductDTO> getAllProductByCategory(String category) {
        List<Product> all = productRepo.findAllByCategory(category);
        return modelMapper.map(all, new TypeToken<ArrayList<ProductDTO>>() {
        }.getType());
    }

    @Override
    public ArrayList<ProductDTO> getAllProductsDesc() {
        List<Product> all = productRepo.findAllByPc();

        return modelMapper.map(all, new TypeToken<ArrayList<ProductDTO>>() {
        }.getType());
    }
}
