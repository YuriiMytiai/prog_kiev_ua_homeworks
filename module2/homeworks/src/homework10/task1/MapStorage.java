package homework10.task1;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class MapStorage<T extends Entity<ID>, ID> implements Storage<T, ID> {
    private final Map<ID, T> products = new HashMap<>();

    @Override
    public Optional<T> findById(ID id) {
        if (!products.containsKey(id)) return Optional.empty();
        return Optional.of(products.get(id));
    }

    @Override
    public void save(T entity) {
        products.put(entity.getId(), entity);
    }

    @Override
    public void deleteById(ID id) {
        products.remove(id);
    }
}
