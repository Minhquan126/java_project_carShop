package rickkeiAcademy.service.userService;

import rickkeiAcademy.model.role.RoleName;
import rickkeiAcademy.model.user.User;
import rickkeiAcademy.service.IGeneric;

import java.util.List;

public interface IUserService extends IGeneric<User> {
    public boolean existedByUsername(String username);
    public boolean existedByEmail(String email);
    void changeRole(int id);
    void changeStatus(int id);
    boolean login(String userName,String password);
    User getCurrentUser();
    void logOut();
    boolean checkRole();
}
