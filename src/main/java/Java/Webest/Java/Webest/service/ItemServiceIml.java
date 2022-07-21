package Java.Webest.Java.Webest.service;

import Java.Webest.Java.Webest.client.FeignPriceClient;
import Java.Webest.Java.Webest.entity.DTOItem;
import Java.Webest.Java.Webest.entity.Item;
import Java.Webest.Java.Webest.repository.ItemCacheRepository;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceIml implements ItemsService {
    private final ItemCacheRepository cacheRepository;
    private final FeignPriceClient priceClient;

    public ItemServiceIml(ItemCacheRepository repository, FeignPriceClient feignAmountClient) {
        this.cacheRepository = repository;
        this.priceClient = feignAmountClient;
    }

    public Float saveAndGetItemTotalPrice(DTOItem item) {
        if (!cacheRepository.existsById(item.getId())) {
            int id = item.getId();
            float price = priceClient.getItemPrice(id);
            cacheRepository.save(new Item(id, price));
        }
        return getItemTotalPrice(item);
    }


    private float getItemTotalPrice(DTOItem item) {
        Item hashItem = cacheRepository.getItemById(item.getId());
        float itemPrice = hashItem.getPrice();
        int amount = item.getAmount();
        return itemPrice * amount;
    }


}
