package by.training.info_handling_light.repository;

public interface Repository<T> {
    void update(T element);
    T get() throws RepositoryException;
}
