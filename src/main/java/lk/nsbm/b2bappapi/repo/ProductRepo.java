package lk.nsbm.b2bappapi.repo;

import lk.nsbm.b2bappapi.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepo extends JpaRepository<Product,Integer> {
    @Query(value = "SELECT * FROM product WHERE productName=?1", nativeQuery = true)
    Product findByName(String name);

    @Query(value = "SELECT * FROM product order by pid desc limit 6;", nativeQuery = true)
    List<Product>findAllTop();


    @Query(value = "SELECT * FROM product where product_name LIKE %?1% and total_price >= ?2 and total_price <= ?3 and product_location = ?4", nativeQuery = true)
    List<Product> findAllFilterProducts(String productName, String minPrice, String maxPrice, String productLocation);
    //SELECT * FROM product where product_name LIKE'%E Metter%' and total_price>='1000' and total_price<='1000' and product_location='Colombo';
    @Query(value = "SELECT * FROM product where userid  = ?1", nativeQuery = true)
    List<Product>findAllBySellerID(String userID);
}
