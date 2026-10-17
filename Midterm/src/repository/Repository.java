package repository;


import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.function.Predicate;

public class Repository <K, V extends Entity<K>> {

    private HashMap<K, V> map = new HashMap<>();

    public void save(V entity) {
        map.put(entity.getId(), entity);
    }

    public V findById(K id) {
        return map.get(id);
    }

    public List<V> findAll(Predicate<? super V> filter) {
        List<V> result = new ArrayList<>();
        for (V entity : map.values()) {
            if (filter.test(entity)) {
                result.add(entity);
            }
        }
        return result;
    }

    public boolean delete(K id) {
        return map.remove(id) != null;
    }

}
