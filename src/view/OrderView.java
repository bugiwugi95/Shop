package view;

import common.AppView;
import data.models.Product;
import data.service.ShopService;

import java.util.ArrayList;
import java.util.Scanner;

public class OrderView extends AppView {

    public OrderView(ShopService service) {
        super("Оформление заказа", new ArrayList<AppView>());
        this.service = service;
    }

    public final ShopService service;

    @Override
    public void action() {
        Scanner in = new Scanner(System.in);
        System.out.println("NAme");
        String name = in.nextLine();
        System.out.println("Phone");
        String phone = in.nextLine();

        service.createOrder(name,phone,"address","rub","18:30");
    }
}
