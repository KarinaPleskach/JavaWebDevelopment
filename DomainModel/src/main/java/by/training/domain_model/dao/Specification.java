package by.training.domain_model.dao;

public interface Specification<T> {
    boolean match(T bean);
}
