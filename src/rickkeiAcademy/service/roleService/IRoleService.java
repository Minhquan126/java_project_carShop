package rickkeiAcademy.service.roleService;

import rickkeiAcademy.model.role.Role;
import rickkeiAcademy.model.role.RoleName;

import java.util.List;

public interface IRoleService {
    List<Role> findAll();
    Role findByName(RoleName name);
}
