package Java.Webest.Java.Webest.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Map;


@Data
@AllArgsConstructor
public class CartResponse {
    private Map<DTOItem, Float> items;
    private float totalPrice;
}