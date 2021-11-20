package lk.nsbm.b2bappapi.dto;

import lk.nsbm.b2bappapi.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductDTO {
    private int PID;
    private String productName;
    private User sellerID;
    private String productDetail;
    private int productQTy;
    private int onePiecePrice;
    private int totalPrice;
    private String productLocation;
    private String productCategoryID;
    private String productImage;
}
