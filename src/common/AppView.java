package common;

import data.comparators.AppComparator;
import data.models.Product;

import java.util.ArrayList;

public abstract class AppView {
    public final String title;
    public final ArrayList<AppView> children;

    public boolean hasNextPage = false;
    public  int nowPage = 0;

    public final int limit = 5;

    public final ArrayList<AppComparator<Product>> availableComparators = new ArrayList<>();
    public AppComparator<Product> selectedComparator;

    public AppView(String title, ArrayList<AppView> children) {
        this.title = title;
        this.children = children;
    }

    public void displayCart() {
    }

    public void action() {

    }
}
