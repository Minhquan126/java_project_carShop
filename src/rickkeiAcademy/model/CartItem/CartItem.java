package rickkeiAcademy.model.CartItem;

import rickkeiAcademy.model.product.Product;

import java.io.Serializable;
import java.util.Date;

public class CartItem implements Serializable {
    private int id;
    private Product product;
    private int quantity;

    public CartItem() {
    }

    public CartItem(int id, Product product, int quantity) {
        this.id = id;
        this.product = product;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


    public void displayCartItem(){
        int total = 0;
//        System.out.println("===================CART====================");
            System.out.println("Mã xe : "+ id + "." +"Tên xe : " + product.getProductName() + "." +
                    "Số lượng : " + quantity);
//            total += product.getPrice()* quantity;
//        System.out.println("Tổng tiền : " + total);
    }
}
