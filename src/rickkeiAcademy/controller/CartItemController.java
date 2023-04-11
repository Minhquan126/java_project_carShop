package rickkeiAcademy.controller;

import rickkeiAcademy.model.CartItem.CartItem;
import rickkeiAcademy.service.CartItemService.CartItemServiceIMPL;
import rickkeiAcademy.service.CartItemService.ICartItemService;

import java.util.List;

public class CartItemController {
    ICartItemService cartItemService = new CartItemServiceIMPL();
    public List<CartItem> getListCartItem(){
        return cartItemService.fileAll();
    }
    public void createCartItem(CartItem cartItem){
cartItemService.save(cartItem);
    }
    public void findById(int id){
        cartItemService.findById(id);
    }
    public void deleteCartItem(int id){
        cartItemService.deleteById(id);
    }
    public void payment(){
        cartItemService.payment();
    }
}
