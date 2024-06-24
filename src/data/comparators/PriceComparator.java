package data.comparators;

import data.models.Product;

import java.util.Comparator;

public class PriceComparator implements Comparator<Product> {

    public boolean isAsc;

    public PriceComparator() {
        this.isAsc = true;
    }
    public PriceComparator(boolean isAsc) {
        this.isAsc = isAsc;
    }
    @Override
    public int compare(Product o1, Product o2) {
        if (isAsc) {
            return o2.price - o1.price;
        } else {
            return o1.price - o2.price;
        }

    }
}
