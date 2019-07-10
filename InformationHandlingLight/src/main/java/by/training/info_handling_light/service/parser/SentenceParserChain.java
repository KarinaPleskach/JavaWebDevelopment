package by.training.info_handling_light.service.parser;

import by.training.info_handling_light.bean.composite.LeafTextElement;
import by.training.info_handling_light.bean.model.Sentence;

class SentenceParserChain extends TextElementParserChain {
    @Override
    public LeafTextElement parseLine(String line) throws ParserException {
        Sentence paragraph = new Sentence();
        String[] lexemes = line.split(" ");
//        Arrays.stream(words)
//                .forEach(lexeme -> paragraph.addElement(nextParse(lexeme)));
        for (String lexeme : lexemes) {
            paragraph.addElement(nextParse(lexeme));
        }
        return paragraph;
    }
}
