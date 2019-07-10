package by.training.domain_model.dao.specification;

import by.training.domain_model.dao.Specification;
import by.training.domain_model.entity.Record;

public class BySongName implements Specification<Record> {

    private String searchName;

    public BySongName(String searchName) {
        this.searchName = searchName;
    }

    @Override
    public boolean match(Record record) {
        return (record.getSongName().equalsIgnoreCase(searchName));
    }
}