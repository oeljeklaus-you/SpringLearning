package cn.edu.hust.scope;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StoreService {
    @Autowired
    private ShoppingCart shoppingCart;
}
