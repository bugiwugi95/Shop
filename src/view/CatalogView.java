package view;

import common.AppView;
import data.comparators.AppComparator;
import data.models.Product;
import data.service.ShopService;

import java.util.ArrayList;

public class CatalogView extends AppView {

    public CatalogView(ShopService service, ArrayList<AppView> children, ArrayList<AppComparator<Product>> comparators) {
        super("Каталог", children);
        this.service = service;
        availableComparators.addAll(comparators);
        if (!availableComparators.isEmpty()) {
            selectedComparator = availableComparators.get(0);
        }

    }

    public final ShopService service;

    @Override
    public void action() {
        ArrayList<Product> catalog = service.getCatalog(nowPage, limit, selectedComparator.comparator);
        hasNextPage = catalog.size() == limit;
        for (Product p : catalog) {
            System.out.println(p.id + " " + p.title + " " + p.price);
        }
        System.out.println();
    }
}
