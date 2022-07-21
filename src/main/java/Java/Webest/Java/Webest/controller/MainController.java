package Java.Webest.Java.Webest.controller;

import Java.Webest.Java.Webest.entity.Cart;
import Java.Webest.Java.Webest.entity.CartResponse;
import Java.Webest.Java.Webest.entity.DTOItem;
import Java.Webest.Java.Webest.service.ItemsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class MainController {
    private final ItemsService itemsService;

    public MainController(ItemsService itemsService) {
        this.itemsService = itemsService;
    }

    @GetMapping("/all")
    public ResponseEntity<CartResponse> getEndCart(@RequestBody Cart cart) {
        DTOItem[] items = cart.getItems();
        Map<DTOItem, Float> itemsAndItemTotalPrice = new HashMap<>();
        for (DTOItem item : items) {
            float itemTotalPrice = itemsService.saveAndGetItemTotalPrice(item);
            itemsAndItemTotalPrice.put(item, itemTotalPrice);
        }
        CartResponse cartResponse = new CartResponse(itemsAndItemTotalPrice, getCartTotalPrice(itemsAndItemTotalPrice));
        return new ResponseEntity<>(cartResponse, HttpStatus.OK);

    }

    private float getCartTotalPrice(Map<DTOItem, Float> itemsAndItemTotalPrice) {
        return (float) itemsAndItemTotalPrice.values().stream().mapToDouble(i -> i).sum();
    }
}
