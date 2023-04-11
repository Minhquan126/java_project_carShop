package rickkeiAcademy.view;

import rickkeiAcademy.config.Config;
import rickkeiAcademy.controller.ProducerController;
import rickkeiAcademy.model.producer.Producer;

import java.util.List;

public class ProducersManagement {
    ProducerController producerController = new ProducerController();
    List<Producer> producerList = producerController.getListProducer();

    public void productView() {
        while (true) {
            System.out.println("******************* Quản lý hãng xe ********************");
            System.out.println("1 . Thêm hãng sản xuất mới");
            System.out.println("2 . Hiển thị danh mục hãng sản xuất");
            System.out.println("3 . Thay đổi thông tin hãng sản xuất");
            System.out.println("4 . Xóa hãng sản xuất");
            System.out.println("5 . Trở về trang admin");
            System.out.println("Nhập để chọn chức năng");
            int choice = Config.scanner().nextInt();
            switch (choice) {
                case 1:
                    createProducer();
                    break;
                case 2:
                    showListProducer();
                    break;
                case 3:
                    updateProducer();
                    break;
                case 4:
                    deleteProducer();
                    break;
                case 5:
                    new AdminView().adminView();
                    break;
                default:
                    System.err.println("Chọn không chính xác!");
            }
        }
    }

    public void createProducer() {
        System.out.println("Nhập số hãng xe cần thêm mới :");
        int side = Config.scanner().nextInt();
        for (int i = 0; i < side; i++) {
            Producer producer = new Producer();
            if (producerList.size() == 0) {
                producer.setProducerId(1);
            } else {
                producer.setProducerId(producerList.get(producerList.size() - 1).getProducerId() + 1);
            }
            producer.inputDataProducer();
            producerController.createProducer(producer);
        }
        System.out.println("Thêm mới hãng xe thành công");
    }

    public void showListProducer() {
        for (Producer producer : producerList) {
            producer.displayProducer();
        }
    }

    public void updateProducer() {
        Producer producer = new Producer();
        showListProducer();
        System.out.println("Nhập mã hãng xe cần thay đổi thông tin");
        int idUpdate = Config.scanner().nextInt();
if (producerController.findById(idUpdate) == null){
    System.err.println("Hãng xe không tồn tại!");
} else {
    producer.setProducerId(idUpdate);
    System.out.println("Nhập lại tên hãng xe");
    producer.setProducerName(Config.scanner().nextLine());
    System.out.println("Nhập lại quốc gia");
    producer.setProducerCountry(Config.scanner().nextLine());
    producerController.updateProducer(producer);
    System.out.println("Thay đổi thông tin thành công");
}

    }

    public void deleteProducer() {
        showListProducer();
        System.out.println("Nhập mã hãng xe cần xóa");
        int idDel = Config.scanner().nextInt();
        producerController.deleteProducer(idDel);
    }
}
