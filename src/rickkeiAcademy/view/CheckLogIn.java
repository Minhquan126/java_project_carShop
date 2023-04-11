package rickkeiAcademy.view;

import rickkeiAcademy.config.Config;
import rickkeiAcademy.controller.UserController;

public class CheckLogIn {
     UserController userController = new UserController();
    public void checkLogIn(){
        while (true){
            System.out.println("1 . Đăng ký");
            System.out.println("2 . Quên mật khẩu");
            System.out.println("Nhập để chọn");
            int choice = Config.scanner().nextInt();
            switch (choice){
                case 1:
                    new Navbar().register();
                    break;
                    case 2:
                    break;
                default:
                    System.out.println("Nhập không chính xác!");
            }
        }
    }
    public void rePassword(){

        System.out.println("Nhập số điện thoại :");
        String phoneNumber = Config.scanner().nextLine();

    }
}
