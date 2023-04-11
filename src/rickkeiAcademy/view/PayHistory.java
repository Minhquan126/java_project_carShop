package rickkeiAcademy.view;

import rickkeiAcademy.config.Config;
import rickkeiAcademy.model.CartItem.CartItem;
import rickkeiAcademy.model.bill.Bill;
import rickkeiAcademy.model.user.User;

import java.util.List;

public class PayHistory {

    public void payHistory(){
        List<Bill> list = new Config<Bill>().readFormFile(Config.PATH_PAY_HISTORY);
        for (Bill bill: list) {
            bill.displayBill();
        }
    }
}
