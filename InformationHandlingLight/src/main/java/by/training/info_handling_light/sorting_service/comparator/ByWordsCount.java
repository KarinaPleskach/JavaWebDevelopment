package by.training.info_handling_light.sorting_service.comparator;

import by.training.info_handling_light.bean.composite.LeafTextElement;
import by.training.info_handling_light.bean.model.Sentence;

class ByWordsCount implements TextComparator {
    @Override
    public int compare(LeafTextElement o1, LeafTextElement o2) {
        return ((Sentence)o1).getElements().size() - ((Sentence)o2).getElements().size();
    }
}
