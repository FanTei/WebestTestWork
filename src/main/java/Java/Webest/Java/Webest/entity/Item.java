package Java.Webest.Java.Webest.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.RedisHash;

@Data
@RedisHash("Item")
@AllArgsConstructor
@NoArgsConstructor
public class Item {
    private int id;
    private float price;
}
