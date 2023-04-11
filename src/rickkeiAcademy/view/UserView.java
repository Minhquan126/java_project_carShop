package rickkeiAcademy.view;

import rickkeiAcademy.config.Config;
import rickkeiAcademy.controller.CartItemController;
import rickkeiAcademy.controller.ProductControl;
import rickkeiAcademy.controller.UserController;
import rickkeiAcademy.model.CartItem.CartItem;
import rickkeiAcademy.model.product.Product;

import java.util.List;

public class UserView {
    UserController userController = new UserController();
    ProductControl productControl = new ProductControl();
    CartItemController cartItemController = new CartItemController();
    List<Product> productList = productControl.getProducts();
    List<CartItem> cartItemList = cartItemController.getListCartItem();

    public void userView() {
        while (true) {
            System.out.println("***********************Welcome" + " " + userController.getUserLogin().getUserName() + "*************************");
            showListProduct();
            System.out.println("1 . Xem chi tiết xe");
            System.out.println("2 . Thêm vào giỏ hàng");
            System.out.println("3 . Đến giỏ hàng");
            System.out.println("4 . Đăng xuất");
            System.out.println("Nhập để chọn :");
            int choice = Config.scanner().nextInt();
            switch (choice) {
                case 1:
                    showDetail();
                    break;
                case 2:
                    addToCart();
//                    new CartView().showListCart();
                    break;
                case 3:
                    new CartView().cartView();
                    break;
                case 4:
                    logOut();
                    break;
                default:
                    System.err.println("Chọn không chính xác");
            }
        }
    }

    public void showListProduct() {
        for (Product product : productList) {
            System.out.printf("Mã xe          : %d \n", product.getProductId());
            System.out.printf("Tên xe         : %s \n", product.getProductName());
            System.out.printf("Giá xe         : %.1f \n", product.getPrice());
            System.out.println("Trạng thái xe : " + (product.isProductStatus() ? "Đang bán" : "Cần liên hệ \n"));
            System.out.println("----------------------------------------------------------");
        }
    }

    public void showDetail() {
        System.out.println("Nhập mã xe :");
        int id = Config.scanner().nextInt();
        for (Product product : productList) {
            if (product.getProductId() == id) {
                product.displayDataProduct();
            }
        }
    }

    public void addToCart() {
        CartItem cartItem = new CartItem();
        System.out.println("Nhập mã xe :");
        int idCar = Config.scanner().nextInt();
        System.out.println("Nhập số lượng :");
        cartItem.setQuantity(Config.scanner().nextInt());
        if (cartItemList.size() == 0) {
            cartItem.setId(1);
        } else {
            cartItem.setId(cartItemList.get(cartItemList.size() - 1).getId() + 1);
        }
        Product product = productControl.findById(idCar);
        if (product == null) {
            return;
        }
        cartItem.setProduct(product);
        cartItemController.createCartItem(cartItem);
    }

    public void logOut() {
        userController.logOut();
        new Navbar().navbar();
    }
}
