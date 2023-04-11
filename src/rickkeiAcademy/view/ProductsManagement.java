package rickkeiAcademy.view;

import rickkeiAcademy.config.Config;
import rickkeiAcademy.controller.ProducerController;
import rickkeiAcademy.controller.ProductControl;
import rickkeiAcademy.model.producer.Producer;
import rickkeiAcademy.model.product.Product;

import java.util.List;

public class ProductsManagement {
    ProductControl productControl = new ProductControl();
    ProducerController producerController = new ProducerController();
    List<Product> productList = productControl.getProducts();
    List<Producer> producerList = producerController.getListProducer();

    public void productView() {
        while (true) {
            System.out.println("************* Quản lý sản phẩm ******************");
            System.out.println("1. Thêm mới xe");
            System.out.println("2. Hiển thị danh sách xe");
            System.out.println("3. Sửa thông tin xe");
            System.out.println("4. Xóa xe");
            System.out.println("5. Trang quản lý hãng xe");
            System.out.println("6. Trở về trang admin");
            System.out.println("Nhập chức năng :");
            int choice = Config.scanner().nextInt();
            switch (choice) {
                case 1:
                    createProduct();
                    break;
                case 2:
                    showListProducts();
                    break;
                case 3:
                    updateProduct();
                    break;
                case 4:
                    deleteProduct();
                    break;
                case 5:
                  new  ProducersManagement().productView();
                    break;
                case 6:
                    new AdminView().adminView();
                    break;
                default:
                    System.out.println("Nhập sai chức năng");
            }
        }
    }

    public void showListProducts() {
        for (Product product : productList) {
            product.displayDataProduct();
        }
    }

    public void createProduct() {
        System.out.println("Nhập số sản phẩm cần thêm mới : ");
        int quantity = Config.scanner().nextInt();
        for (int i = 0; i < quantity; i++) {
            System.out.println("Nhập sản phẩm thú : " + (i + 1));
            Product product = new Product();
            if (productList.size() == 0) {
                product.setProductId(1);
            } else {
                product.setProductId(productList.get(productList.size() - 1).getProductId() + 1);
            }
            product.inputDataProduct(producerList);
            productControl.createProduct(product);
        }
        System.out.println("Thêm mới sản phẩm thành công!");
    }

    public void updateProduct() {
        showListProducts();
        Product product = new Product();
        System.out.println("Nhập mã sản phẩm cần sửa :");
        int id = Config.scanner().nextInt();
        if (productControl.findById(id) == null) {
            System.err.println("Sản phẩm không tồn tại");
        } else {
            product.setProductId(id);
            System.out.println("Nhập tên mới");
            product.setProductName(Config.scanner().nextLine());
            new ProducersManagement().showListProducer();
            System.out.println("Chọn mã hãng xe:");
            int idProducer = Config.scanner().nextInt();
            for (Producer producer:producerList) {
                if (producer.getProducerId() == idProducer){
                    product.setProducer(producer);
                }
            }
            System.out.println("Nhập giá mới");
            product.setPrice(Config.scanner().nextFloat());
            System.out.println("Nhập trạng thái mới");
            product.setProductStatus(Config.scanner().hasNextBoolean());
            productControl.updateProduct(product);
            System.out.println("Sửa thành công");
        }
    }

    public void deleteProduct() {
        showListProducts();
        System.out.println("Chọn mã sản phẩm cần xóa :");
        int id = Config.scanner().nextInt();
        productControl.deleteProduct(id);
        System.out.println("Xoá thành công");
    }

}
