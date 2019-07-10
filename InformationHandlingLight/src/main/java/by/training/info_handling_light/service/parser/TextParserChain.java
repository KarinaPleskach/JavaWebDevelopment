package by.training.info_handling_light.service.parser;

import by.training.info_handling_light.bean.composite.LeafTextElement;
import by.training.info_handling_light.bean.model.Text;

import java.util.Arrays;

class TextParserChain extends TextElementParserChain {
    @Override
    public LeafTextElement parseLine(String line) throws ParserException {
        Text text = new Text();
        String[] paragraphs = line.split("\r\n");
//        Arrays.stream(paragraphs)
//                .forEach(paragraph -> text.addElement(nextParse(paragraph)));
        for (String paragraph : paragraphs) {
            text.addElement(nextParse(paragraph));
        }
        return text;
    }
}
