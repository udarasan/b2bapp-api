package lk.nsbm.b2bappapi.repo;

import lk.nsbm.b2bappapi.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CartRepo extends JpaRepository<Cart, Integer> {


    boolean existsByUid(String uid);

    boolean existsByPid(int pid);

    boolean existsByPidAndUid(int pid,String uid);

    @Query(value = "SELECT SUM(qty) FROM cart_table where pid = ?1 and uid=?2", nativeQuery = true)
    int getTotalQty(int pid,String uid);

    @Modifying
    @Query(value = "UPDATE cart_table SET qty = ?2 WHERE pid = ?1", nativeQuery = true)
    void updateQty(int pid, int newQty);

    List<Cart> findAllByUid(String uid);

    @Query(value = "select SUM(qty) from cart_table where uid=?1", nativeQuery = true)
    int getProductsCountByUserID(int count);

    @Query(value = "select SUM(one_price*qty) from cart_table where uid=?1", nativeQuery = true)
    int getOneTotalPriceByUserID(int userID);
}
