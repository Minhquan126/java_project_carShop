package rickkeiAcademy.view;

import dto.response.ResponseMessage;
import rickkeiAcademy.config.Config;
import rickkeiAcademy.controller.UserController;
import rickkeiAcademy.model.user.User;

import java.util.List;

public class Navbar {
    UserController userController = new UserController();
    public void navbar(){
        while (true) {
            System.out.println("****************************MINH QUAN AUTO****************************");
            System.out.println("1 . Đăng ký");
            System.out.println("2 . Đăng nhập");
            int choice = Config.scanner().nextInt();
            switch (choice) {
                case 1:
                    register();
                case 2:
                    login();
                    break;
                default:
                    System.err.println("Nhập không chính xác!");
            }
        }
    }
    public void register(){
        List<User> listUser = userController.getListUser();
        User user = new User();
        System.out.println("=========================FORM REGISTER=========================");
        int id = 0;
        if (listUser.size() == 0){
            user.setId(1);
        } else {
            user.setId(listUser.get(listUser.size() -1).getId() + 1);
        }
        user.inputData();
       ResponseMessage message = userController.register(user);
       if (message.getMessage().equals("userName existed")){
           System.err.println("Tên đăng nhập đã tồn tại, vui lòng chọn tên đăng nhập khác");
           register();
       } else if (message.getMessage().equals("email existed")) {
           System.err.println("Email đã tồn tại, vui lòng nhập lại email");
           register();
       } else {
           System.out.println("Đăng ký thành công");
       }
    }
    public void login(){
        System.out.println("=========================FORM LOGIN=========================");
        System.out.println("Tên đăng nhập");
        String userName = Config.scanner().nextLine();
        System.out.println("Mật khẩu");
        String password = Config.scanner().nextLine();
        if (userController.login(userName,password)){
            if (userController.checkRole()){
                new AdminView().adminView();
            }
                new UserView().userView();
        } else {
            System.err.println("Tài khoản không tồn tại, vui lòng thử lại");
            login();
        }
    }
}
