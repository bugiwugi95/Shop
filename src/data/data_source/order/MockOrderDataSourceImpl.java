package data.data_source.order;

import data.models.Order;
import data.models.Product;

public  class MockOrderDataSourceImpl extends OrderDataSource{

    private Order order;
    @Override
  public   void createOrder(Order order) {
        this.order = order;
    }

    @Override
    public  Order getOrder() {
        return order;
    }
}
