package Java.Webest.Java.Webest.client;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@org.springframework.cloud.openfeign.FeignClient(name = "priceClient", url = "${price.url.general}")
public interface FeignPriceClient extends PriceClient {
    @Override
    @GetMapping("${price.url.parametr}")
    public float getItemPrice(@PathVariable int id);
}
