package homework10.task1;

import java.util.Optional;

/**
 * Хранилище сущностей.
 * @param <T> тип сущности.
 * @param <ID> тип id у сущности.
 */

public interface Storage<T extends Entity<ID>, ID> {
    Optional<T> findById(ID id);
    void save(T entity);
    void deleteById(ID id);
}
