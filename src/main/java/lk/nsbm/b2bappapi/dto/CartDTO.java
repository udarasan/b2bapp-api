package lk.nsbm.b2bappapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CartDTO {
    private int cid;
    private int pid;
    private String name;
    private int onePrice;
    private int totlePrice;
    private String iamge;
    private String uid;
    private int qty;
}
