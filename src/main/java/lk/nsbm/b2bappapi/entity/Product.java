package lk.nsbm.b2bappapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int PID;
    private String productName;
    private String productDetail;
    private String productQTy;
    private String onePiecePrice;
    private String totalPrice;
    private String productLocation;
    private String productCategoryID;
    @NonNull
    private String productImage;

    @ManyToOne
    @JoinColumn(name = "userID",referencedColumnName = "userID")
    private User sellerID;



}
