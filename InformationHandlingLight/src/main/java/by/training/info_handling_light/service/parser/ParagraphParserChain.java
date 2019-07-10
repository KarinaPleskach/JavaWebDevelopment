package by.training.info_handling_light.service.parser;

import by.training.info_handling_light.bean.composite.LeafTextElement;
import by.training.info_handling_light.bean.model.Paragraph;

import java.util.Arrays;

class ParagraphParserChain extends TextElementParserChain {
    @Override
    public LeafTextElement parseLine(String line) throws ParserException {
        line = line.replace("\t", "");
        Paragraph paragraph = new Paragraph();
        String[] sentences = line.split("\\. |\\.$");
//        Arrays.stream(sentences)
//                .forEach(sentence -> paragraph.addElement(nextParse(sentence)));
        for (String sentence : sentences) {
            paragraph.addElement(nextParse(sentence));
        }
        return paragraph;
    }
}
