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
    private String productQTy;
    private String onePiecePrice;
    private String totalPrice;
    private String productLocation;
    private String productCategoryID;
    private String productImage;
}
