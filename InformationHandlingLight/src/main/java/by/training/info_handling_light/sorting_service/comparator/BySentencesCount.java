package by.training.info_handling_light.sorting_service.comparator;

import by.training.info_handling_light.bean.composite.LeafTextElement;
import by.training.info_handling_light.bean.model.Paragraph;

class BySentencesCount implements TextComparator {
    @Override
    public int compare(LeafTextElement o1, LeafTextElement o2) {
        return ((Paragraph) o1).getElements().size() - ((Paragraph)o2).getElements().size();
    }
}
