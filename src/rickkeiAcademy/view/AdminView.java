package rickkeiAcademy.view;

import rickkeiAcademy.config.Config;
import rickkeiAcademy.controller.UserController;

public class AdminView {
    UserController userController = new UserController();
    public void adminView(){
        while (true){
            System.out.println("==========================ADMIN PAGE================================");
            System.out.println("1 . Đến trang quản lý người dùng");
            System.out.println("2 . Đến trang quản lý sản phẩm");
            System.out.println("3 . Quản lý lịch sử bán hàng");
            System.out.println("4 . Đăng xuất");
            System.out.println("Nhập để chọn");
            int choice = Config.scanner().nextInt();
            switch (choice){
                case 1:
                    new UserManagement().userManagement();
                    break;
                case 2:
                    new ProductsManagement().productView();
                    break;
                case 3:
                    new PayHistory().payHistory();
                    break;
                case 4:
                    logOut();
                    break;
                default:
                    System.err.println("Chọn không chính xác!");
            }
        }
    }
    public void logOut(){
        userController.logOut();
        new Navbar().navbar();
    }
}
