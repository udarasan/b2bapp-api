package lk.nsbm.b2bappapi.service.impl;

import lk.nsbm.b2bappapi.dto.CartDTO;
import lk.nsbm.b2bappapi.entity.Cart;
import lk.nsbm.b2bappapi.repo.CartRepo;
import lk.nsbm.b2bappapi.service.CartService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepo cartRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void addToCart(CartDTO dto) {
        System.out.println("UID____"+cartRepo.existsByUid(dto.getUid()));
        System.out.println("PID____"+cartRepo.existsByPid(dto.getPid()));
        System.out.println("-------------------------------------------------");
        System.out.println("BOTH____"+cartRepo.existsByPidAndUid(dto.getPid(),dto.getUid()));

        if (cartRepo.existsByPidAndUid(dto.getPid(),dto.getUid())) {

                int availableQty = cartRepo.getTotalQty(dto.getPid(),dto.getUid());
                System.out.println(availableQty+"Avble");
                int newQty = availableQty + 1;
                System.out.println("NewQTY"+newQty);

                cartRepo.updateQty(dto.getPid(), newQty);
            }
        else {
            cartRepo.save(modelMapper.map(dto, Cart.class));
        }
    }

    @Override
    public ArrayList<CartDTO> getCartItemsByUserID(String userID) {
        List<Cart> all = cartRepo.findAllByUid(userID);
        return modelMapper.map(all, new TypeToken<ArrayList<CartDTO>>() {
        }.getType());
    }

    @Override
    public int getProductsCountByUserID(int userID) {
        return cartRepo.getProductsCountByUserID(userID);
    }

    @Override
    public int getOneTotalPriceByUserID(int userID) {
        return cartRepo.getOneTotalPriceByUserID(userID);
    }
}
