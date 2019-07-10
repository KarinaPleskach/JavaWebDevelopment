package by.training.info_handling_light.sorting_service.comparator;

import by.training.info_handling_light.bean.composite.LeafTextElement;
import by.training.info_handling_light.bean.model.Lexeme;

class ByWordLength implements TextComparator {
    @Override
    public int compare(LeafTextElement o1, LeafTextElement o2) {
        return ((Lexeme) o1).getCleanValue().length() - ((Lexeme) o2).getCleanValue().length();
    }
}
