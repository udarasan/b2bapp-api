package lk.nsbm.b2bappapi.service.impl;

import lk.nsbm.b2bappapi.dto.ProductDTO;
import lk.nsbm.b2bappapi.repo.ProductRepo;
import lk.nsbm.b2bappapi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepo productRepo;

    @Override
    public void addProduct(ProductDTO productDTO) {

    }
}
