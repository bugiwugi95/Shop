package view;

import common.AppView;
import data.models.CartItem;
import data.models.Product;
import data.service.ShopService;

import java.util.ArrayList;

public class CartView extends AppView {

    public CartView(ShopService service) {
        super("Cart", new ArrayList<>());
        this.service = service;
    }

    public final ShopService service;

    @Override
    public void action() {
        ArrayList<CartItem> cart = service.getCart();
        for (CartItem p : cart) {
            System.out.println(p.product.id + " " + p.product.title + " " + p.product.price);
        }
        System.out.println();
    }
}
