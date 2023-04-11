package rickkeiAcademy.config;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Config<T> {
    public static Scanner scanner() {
        Scanner scanner = new Scanner(System.in);
        return scanner;
    }

    public static final String PATH_PRODUCT = "C:\\Users\\ADMIN\\Desktop\\modul3_project\\src\\rickkeiAcademy\\database\\product.txt";
    public static final String PATH_USER = "C:\\Users\\ADMIN\\Desktop\\modul3_project\\src\\rickkeiAcademy\\database\\user.txt";
    public static final String PATH_USERLOGIN = "C:\\Users\\ADMIN\\Desktop\\modul3_project\\src\\rickkeiAcademy\\database\\userLogin.txt";
    public static final String PATH_PRODUCER = "C:\\Users\\ADMIN\\Desktop\\modul3_project\\src\\rickkeiAcademy\\database\\producer.txt";
    public static final String PATH_PAY_HISTORY = "C:\\Users\\ADMIN\\Desktop\\modul3_project\\src\\rickkeiAcademy\\database\\payHistory.txt";
    public List<T> readFormFile(String path) {
        List<T> list = new ArrayList<>();
        try {
            FileInputStream fos = new FileInputStream(path);
            ObjectInputStream oos = new ObjectInputStream(fos);
            list = (List<T>) oos.readObject();
            fos.close();
            oos.close();
        } catch (FileNotFoundException e) {
            System.err.println("File not found!");
        } catch (EOFException eof) {
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public void writeFormFile(String path, List<T> list) {
        try {
            FileOutputStream fis = new FileOutputStream(path);
            ObjectOutputStream ois = new ObjectOutputStream(fis);
            ois.writeObject(list);
            fis.close();
            ois.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
