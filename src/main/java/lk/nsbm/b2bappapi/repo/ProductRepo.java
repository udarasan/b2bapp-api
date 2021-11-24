package lk.nsbm.b2bappapi.repo;

import lk.nsbm.b2bappapi.entity.Product;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;
public interface ProductRepo extends JpaRepository<Product,Integer> {
    @Query(value = "SELECT * FROM product WHERE productName=?1", nativeQuery = true)
    Product findByName(String name);

    @Query(value = "SELECT * FROM product order by pid desc limit 6;", nativeQuery = true)
    List<Product>findAllTop();


    @Query(value = "SELECT * FROM product where product_name LIKE %?1% and (total_price between ?2 and ?3) and product_location = ?4 and (productqty >=?5 and productqty<=?6)", nativeQuery = true)
    List<Product> findAllFilterProducts(String productName, Integer minPrice, Integer maxPrice, String productLocation,Integer minQTY,Integer maxQTY);

    //total_price >= ?2 and total_price <= ?3
    //SELECT * FROM product where product_name LIKE'%E Metter%' and total_price>='1000' and total_price<='1000' and product_location='Colombo';

    @Query(value = "SELECT * FROM product where userid  = ?1", nativeQuery = true)
    List<Product>findAllBySellerID(String userID);

    @Query(value = "SELECT * FROM product where product_categoryid  = ?1", nativeQuery = true)
    List<Product> findAllByCategory(String category);

    @Query(value = "SELECT * FROM product order by product_location asc;", nativeQuery = true)
    List<Product> findAllByPc();
}
