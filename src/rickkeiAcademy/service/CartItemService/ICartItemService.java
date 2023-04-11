package rickkeiAcademy.service.CartItemService;

import rickkeiAcademy.model.CartItem.CartItem;
import rickkeiAcademy.service.IGeneric;

public interface ICartItemService extends IGeneric<CartItem> {
    void payment();
}
