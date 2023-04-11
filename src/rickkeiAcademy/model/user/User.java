package rickkeiAcademy.model.user;

import rickkeiAcademy.config.Config;
import rickkeiAcademy.model.CartItem.CartItem;
import rickkeiAcademy.model.role.Role;
import rickkeiAcademy.model.role.RoleName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class User implements Serializable {
private int id;
private String name;
private String userName;
private String email;
private String password;
private boolean userStatus;
private String phoneNumber;
private String address;
private Role role;
private List<CartItem> list=new ArrayList<>();

    public User() {
    }

    public User(int id, String name, String userName, String email, String password, boolean userStatus, String phoneNumber, String address, Role role,List<CartItem> list) {
        this.id = id;
        this.name = name;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.userStatus = userStatus;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.role = role;
        this.list = list;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isUserStatus() {
        return userStatus;
    }

    public void setUserStatus(boolean userStatus) {
        this.userStatus = userStatus;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public List<CartItem> getList() {
        return list;
    }

    public void setList(List<CartItem> list) {
        this.list = list;
    }

//    public void inputDataUser(){
//        System.out.println("Nhập Họ tên :");
//        String name = Config.scanner().nextLine();
//        String regexName = "^[A-Z0-9a-z]{4,9}$";
//        if (!name.matches(regexName)){
//            System.err.println("Họ và Tên không chính xác!");
//            inputDataUser();
//        } else {
//            setName(name);
//        }
//        System.out.println("Nhập tên đăng nhập :");
//        String userName = Config.scanner().nextLine();
//        if (!userName.matches(regexName)){
//            System.err.println("Tên đăng nhập không chính xác!");
//            inputDataUser();
//        } else {
//            setUserName(userName);
//        }
//        System.out.println("Nhập email :");
//        String email = Config.scanner().nextLine();
//        String regexEmail = "^[A-Z0-9a-z]+@[A-Za-z0-9]+\\.[A-Za-z0-9]{2,4}$";
//        if (!email.matches(regexEmail)){
//            System.err.println("Email không chính xác!");
//            inputDataUser();
//        } else {
//            setEmail(email);
//        }
//        System.out.println("Nhập mật khẩu :");
//        String password = Config.scanner().nextLine();
//        String regexPassword = "^[A-Z0-9a-z]{5,10}$";
//        if (!password.matches(regexPassword)){
//            System.err.println("Mật khẩu quá ngắn!");
//            inputDataUser();
//        } else {
//            setPassword(password);
//        }
//        setPassword(password);
//        System.out.println("Nhập số điện thoại :");
//        String phoneNumber = Config.scanner().nextLine();
//        String regexPhoneNumber = "^[0-9]{9,10}$";
//        if (!phoneNumber.matches(regexPhoneNumber)){
//            System.err.println("Số điện thoại không chính xác!");
//            inputDataUser();
//        } else {
//            setPhoneNumber(phoneNumber);
//        }
//        System.out.println("Nhập địa chỉ :");
//        String address = Config.scanner().nextLine();
//            setAddress(address);
//        setRole(new Role(2, RoleName.USER));
//        setUserStatus(true);
//    }
    public void inputData(){
        while (true) {
            System.out.println("Nhập Họ tên :");
            String name = Config.scanner().nextLine();
            String regexName = "^[A-Z0-9a-z]{3,9}$";
            if (!name.matches(regexName)) {
                System.err.println("Họ và Tên không chính xác!");
            } else {
                setName(name);
                break;
            }
        }

        while (true){
            System.out.println("Nhập tên đăng nhập :");
            String userName = Config.scanner().nextLine();
            String regexUserName = "^[A-Z0-9a-z]{3,9}$";
            if (!userName.matches(regexUserName)){
                System.err.println("Tên đăng nhập không chính xác!");
            } else {
                setUserName(userName);
                break;
            }
        }
        while (true){
            System.out.println("Nhập email :");
            String email = Config.scanner().nextLine();
            String regexEmail = "^[A-Z0-9a-z]+@[A-Za-z0-9]+\\.[A-Za-z0-9]{2,4}$";
            if (!email.matches(regexEmail)){
                System.err.println("Email không chính xác!");
            } else {
                setEmail(email);
                break;
            }
        }
        while (true){
            System.out.println("Nhập mật khẩu :");
            String password = Config.scanner().nextLine();
            String regexPassword = "^[A-Z0-9a-z]{5,10}$";
            if (!password.matches(regexPassword)){
                System.err.println("Mật khẩu quá ngắn!");
            } else {
                setPassword(password);
                break;
            }
        }
        while (true){
            System.out.println("Nhập số điện thoại :");
            String phoneNumber = Config.scanner().nextLine();
            String regexPhoneNumber = "^[0-9]{9,10}$";
            if (!phoneNumber.matches(regexPhoneNumber)){
                System.err.println("Số điện thoại không chính xác!");
            } else {
                setPhoneNumber(phoneNumber);
                break;
            }
        }
        System.out.println("Nhập địa chỉ :");
        String address = Config.scanner().nextLine();
        setAddress(address);
        setRole(new Role(2, RoleName.USER));
        setUserStatus(true);
    }
    public void displayUser(){
        System.out.println("------------------------------------------------");
        System.out.printf("Mã người dùng : %d \n",getId());
        System.out.printf("Họ và tên     : %s \n",getName());
        System.out.printf("Email         : %s \n",getEmail());
        System.out.printf("Số điện thoại : %s \n",getPhoneNumber());
        System.out.printf("Địa chỉ       : %s \n",getAddress());
        System.out.println("Trạng thái   : " + (isUserStatus()?"Đang hoạt động":"Bị khóa mõm"));
        System.out.println("Quyền        : " + getRole().getName());
    }
    public void displayCart(){
        int total = 0;
        System.out.println("===================CART====================");
        for (CartItem cartItem:list) {
            System.out.println("Mã xe : "+ cartItem.getId() +"Tên xe : " + cartItem.getProduct().getProductName() + "." +
                    "Số lượng : " + cartItem.getQuantity());
            total += cartItem.getProduct().getPrice()* cartItem.getQuantity();
        }
        System.out.println("Tổng tiền : " + total);
        System.out.println("------------------------------------------------");
    }
}
