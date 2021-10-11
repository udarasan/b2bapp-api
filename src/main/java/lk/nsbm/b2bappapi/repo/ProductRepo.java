package lk.nsbm.b2bappapi.repo;

import lk.nsbm.b2bappapi.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product,String> {
}
