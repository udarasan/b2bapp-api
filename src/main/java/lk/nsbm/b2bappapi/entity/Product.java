package lk.nsbm.b2bappapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int PID;
    private String productName;
    private String sellerID;
    private String productDetail;
    private String productQTy;
    private String onePiecePrice;
    private String totalPrice;
    private String productLocation;
    private String productCategoryID;
    private String productImage;

}
