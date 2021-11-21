package lk.nsbm.b2bappapi.repo;

import lk.nsbm.b2bappapi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepo extends JpaRepository<User,Integer> {
    @Query(value = "SELECT * FROM User WHERE email=?1", nativeQuery = true)
    User getUser(String email);

    @Query(value = "select count(userID) from User where userType='Employee'" , nativeQuery = true)
    int getAvailableEmployeeCount();

    boolean existsByEmail(String Email);

    User findByEmail(String Email);

    @Modifying
    @Query(value = "update User set password =?2 where email=?1",nativeQuery = true)
    void updatePassword(String Email,String password);

    @Query(value = "SELECT * FROM User WHERE user_type=?1", nativeQuery = true)
    List<User> findAllByUserType(String userType);
}