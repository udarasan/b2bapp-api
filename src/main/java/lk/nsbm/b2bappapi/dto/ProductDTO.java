package lk.nsbm.b2bappapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductDTO {
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
