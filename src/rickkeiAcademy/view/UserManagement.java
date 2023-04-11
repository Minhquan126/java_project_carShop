package rickkeiAcademy.view;

import rickkeiAcademy.config.Config;
import rickkeiAcademy.controller.UserController;
import rickkeiAcademy.model.role.RoleName;
import rickkeiAcademy.model.user.User;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.List;

public class UserManagement {
    UserController userController = new UserController();
    public void userManagement(){
while (true){
    System.out.println("========================QUẢN LÝ NGƯỜI DÙNG============================");
    System.out.println("1 . Hiển thị danh sách người dùng");
    System.out.println("2 . Thay đổi trạng thái người dùng");
    System.out.println("3 . Cấp quyền!");
    System.out.println("4 . Quay về trang Admin");
    System.out.println("Nhập để chọn chức năng");
    int choice = Config.scanner().nextInt();
    switch (choice){
        case 1:
            showListUsers();
            break;
        case 2:
            changeStatus();
            break;
        case 3:
            changeRole();
            break;
        case 4:
            new AdminView().adminView();
        default:
            System.err.println("Chọn không chính xác!");
    }
}
    }
    public void changeStatus(){
        System.out.println("Nhập mã người dùng ");
        int id = Config.scanner().nextInt();
        userController.changeStatus(id);
    }
    public void showListUsers(){
        List<User> listUser = userController.getListUser();
        for (User user:listUser) {
            user.displayUser();
            if (user.getRole().getName() == RoleName.USER) {
                System.out.println("===================CART====================");
                user.displayCart();
            }
        }
    }
    public void changeRole(){
        System.out.println("Nhập mã người dùng được cấp quyền ");
        int id = Config.scanner().nextInt();
        userController.changeRole(id);
    }
    public void deleteUser(){
        System.out.println("Nhập mã người dùng muốn xóa");
        int idDel = Config.scanner().nextInt();
        userController.deleteUser(idDel);
    }
}
