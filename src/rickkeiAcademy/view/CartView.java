package rickkeiAcademy.view;

import rickkeiAcademy.config.Config;
import rickkeiAcademy.controller.CartItemController;
import rickkeiAcademy.controller.UserController;
import rickkeiAcademy.model.CartItem.CartItem;
import rickkeiAcademy.model.bill.Bill;
import rickkeiAcademy.model.user.User;

import java.util.ArrayList;
import java.util.List;

public class CartView {
    UserController userController = new UserController();
    CartItemController cartItemController = new CartItemController();
    List<User> listUser = new Config<User>().readFormFile(Config.PATH_USER);
    List<Bill> billList = new Config<Bill>().readFormFile(Config.PATH_PAY_HISTORY);
    List<CartItem> listItem = cartItemController.getListCartItem();
    public void cartView(){
        while (true){
            showListCart();
            System.out.println("1 . Xóa ");
            System.out.println("2 . Thay đổi số lượng");
            System.out.println("3 . Thanh toán ");
            System.out.println("4 . Trở lại trang chủ");
            System.out.println("Nhập để chọn");
            int choice = Config.scanner().nextInt();
            switch (choice){
                case 1:
                    deleteCart();
                    break;
                    case 2:
                        changeQuantity();
                    break;
                    case 3:
                        payment();
                    break;
                    case 4:
                        new UserView().userView();
                    break;
                default:
                    System.out.println("Chọn không chính xác!");
            }
        }
    }
    public void showListCart(){
        System.out.println("===================CART====================");
         int total = 0;
        for (CartItem cart: listItem
        ) {
            System.out.println("Mã xe : "+ cart.getId() + " / " +"Tên xe : " + cart.getProduct().getProductName() + " / " +
                    "Số lượng : " + cart.getQuantity());
            total += cart.getProduct().getPrice()* cart.getQuantity();
        }
        System.out.println("Tổng tiền : " + total);
        System.out.println("-----------------------------------------------");
    }
    public void deleteCart(){
        System.out.println("Nhập id cần xoá");
        int id = Config.scanner().nextInt();
        cartItemController.deleteCartItem(id);
    }
    public void changeQuantity(){
        System.out.println("Nhập mã đơn hàng :");
        int id = Config.scanner().nextInt();
        System.out.println("Nhập số lượng :");
        int quantity = Config.scanner().nextInt();
        List<CartItem> list = userController.getUserLogin().getList();
        for (CartItem cartItem:list) {
            if (cartItem.getId() == id){
                cartItem.setQuantity(quantity);
                new Config<User>().writeFormFile(Config.PATH_USER,listUser);
            }
        }
    }
    public void payment(){
         String date = String.valueOf(java.time.LocalDateTime.now());
         Bill bill = new Bill(userController.getUserLogin().getId(),date, listItem);
        billList.add(bill);
        new Config<Bill>().writeFormFile(Config.PATH_PAY_HISTORY,billList);
        System.out.println("--------------------Hóa đơn---------------------");
        System.out.println(date);
        System.out.println("Khách hàng : " + userController.getUserLogin().getName());
        int total = 0;
        for (CartItem cart: listItem
        ) {
            System.out.println("Mã xe : "+ cart.getId() + " / " +"Tên xe : " + cart.getProduct().getProductName() + " / " +
                    "Số lượng : " + cart.getQuantity());
            total += cart.getProduct().getPrice()* cart.getQuantity();
        }
        System.out.println("Tổng tiền : " + total);
        System.out.println("-------------------------------------------------");
       cartItemController.payment();
    }
}
