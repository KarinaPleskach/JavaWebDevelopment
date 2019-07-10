package by.training.domain_model.dao.specification;

import by.training.domain_model.dao.Specification;
import by.training.domain_model.entity.Composition;
import by.training.domain_model.entity.Record;
import by.training.domain_model.entity.performer.impl.SoloArtist;

public class BySoloArtist  implements Specification<Record> {

    private static final char paramDelimiter = ' ';

    private String searchName;

    public BySoloArtist(String searchName) {
        this.searchName = searchName;
    }

    @Override
    public boolean match(Record record) {
        if (record instanceof Composition) {
            Composition composition = (Composition) record;
            if (((Composition) record).getPerformer() instanceof SoloArtist) {
                String performer = composition.getPerformer().getPerformer();
                return performer.equalsIgnoreCase(searchName);
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}