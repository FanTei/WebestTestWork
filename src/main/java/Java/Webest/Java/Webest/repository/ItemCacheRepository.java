package Java.Webest.Java.Webest.repository;

import Java.Webest.Java.Webest.entity.Item;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemCacheRepository extends CrudRepository<Item, Integer> {
    boolean existsById(Integer id);

    Item getItemById(Integer id);
}
