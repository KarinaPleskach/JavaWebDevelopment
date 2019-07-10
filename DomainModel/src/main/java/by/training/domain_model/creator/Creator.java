package by.training.domain_model.creator;

public interface Creator<T> {
    T create(String line);
}
