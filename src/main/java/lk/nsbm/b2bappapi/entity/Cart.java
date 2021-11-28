package lk.nsbm.b2bappapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "cart_table")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cid;
    private int pid;
    private String name;
    private int onePrice;
    private int totlePrice;
    private String iamge;
    private String uid;
    private int qty;

}
