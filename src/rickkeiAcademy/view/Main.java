package rickkeiAcademy.view;

import rickkeiAcademy.config.Config;
import rickkeiAcademy.controller.UserController;
import rickkeiAcademy.model.role.Role;
import rickkeiAcademy.model.role.RoleName;
import rickkeiAcademy.model.user.User;

public class Main {
    public static void main(String[] args) {
//        User user = new User();
//        user.setId(1);
//        user.setUserName("admin");
//        user.setPassword("12345");
//        user.setRole(new Role(1,RoleName.ADMIN));
//        new UserController().register(user);
//        new UserManagement().showListUsers();
        new Navbar().navbar();
//        new AdminView().adminView();
//        new ProducersManagement().productView();
//        new ProductsManagement().productView();
    }
}
