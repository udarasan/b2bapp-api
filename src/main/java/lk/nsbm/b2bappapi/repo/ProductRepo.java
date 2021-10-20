package lk.nsbm.b2bappapi.repo;

import lk.nsbm.b2bappapi.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepo extends JpaRepository<Product,Integer> {
    @Query(value = "SELECT * FROM Product WHERE productName=?1", nativeQuery = true)
    Product findByName(String name);

}
