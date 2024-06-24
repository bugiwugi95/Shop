package view;

import common.AppView;
import data.service.ShopService;

import java.util.ArrayList;
import java.util.Scanner;

public class AddToCartView extends AppView {

    public AddToCartView(ShopService service) {
        super("Корзина", new ArrayList<>());
        this.service = service;
    }

  public   final ShopService service;

    @Override
    public void action() {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите id продукта");
        String productId = in.nextLine();
        if (productId == null) return;
        System.out.println("Введите кол-во продукта");
        int count = in.nextInt();
        final boolean res = service.addToCart(productId,count);
        if (res){
            System.out.println("товар добавлен");
        }else {
            System.out.println(" Пусто");
        }
    }
}
