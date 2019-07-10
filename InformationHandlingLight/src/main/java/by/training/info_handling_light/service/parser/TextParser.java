package by.training.info_handling_light.service.parser;

import by.training.info_handling_light.bean.composite.LeafTextElement;
import by.training.info_handling_light.bean.model.Text;

class TextParser implements Parser<Text> {

    @Override
    public Text parse(String text) throws ParserException {
        ParserChain<LeafTextElement> parserChain = new LexemeParserChain()
                .linkWith( new SentenceParserChain())
                .linkWith( new ParagraphParserChain())
                .linkWith( new TextParserChain())
                .linkWith( new InvalidParserChain());
        return (Text)parserChain.parseLine(text);
    }
}
