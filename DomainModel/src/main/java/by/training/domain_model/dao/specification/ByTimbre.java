package by.training.domain_model.dao.specification;

import by.training.domain_model.dao.Specification;
import by.training.domain_model.entity.Record;
import by.training.domain_model.entity.Song;

public class ByTimbre implements Specification<Record> {

    private String searchName;

    public ByTimbre(String searchName) {
        this.searchName = searchName;
    }

    @Override
    public boolean match(Record record) {
        if (record instanceof Song) {
            Song composition = (Song) record;
            return composition.getTimbre().name().equals(searchName.toUpperCase());
        } else {
            return false;
        }
    }
}