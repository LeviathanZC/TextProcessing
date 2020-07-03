package by.zercomp.processor.service.impl;

import by.zercomp.processor.exception.InvalidDataException;
import by.zercomp.processor.service.CharReplacer;
import by.zercomp.processor.validator.TextValidator;

import java.util.StringJoiner;

public class CharReplacerAsStringImpl implements CharReplacer {

    private StringJoiner joiner;
    private TextValidator validator;

    @Override
    public String replaceInEachWord(String src, int index, char symbol) throws InvalidDataException {
        if (src == null || index < 0) {
            throw new InvalidDataException("argument must be not null nor negative");
        }
        final String[] words = src.split("\\s");
        joiner = new StringJoiner(" ");
        validator = new TextValidator();
        for (int i = 0; i < words.length; i++) {
            if (validator.inRange(words[i], index)) {
                words[i] = replaceCharAt(src, i, symbol);
            }
            joiner.add(words[i]);
        }
        return joiner.toString();
    }

    @Override
    public String replaceMakeCorrections(String src, String before, String after) throws InvalidDataException {
        if (src == null || before == null || after == null) {
            throw new InvalidDataException("arguments must be not null");
        }
        return src.replaceAll(before, after);
    }

    @Override
    public String replaceWordsBySubStr(String src, int length, String placeholder) throws InvalidDataException {
        if (src == null || placeholder == null || length < 0) {
            throw new InvalidDataException("arguments must be not null nor zero");
        }
        final String[] words = src.split("\\s");
        joiner = new StringJoiner(" ");
        validator = new TextValidator();
        for (int i = 0; i < words.length; i++) {
            if(words[i].length() == length) {
                joiner.add(placeholder);
            } else {
                joiner.add(words[i]);
            }
        }
        return joiner.toString();
    }

    private String replaceCharAt(String src, int index, char ch) {
        StringBuilder wordBuilder = new StringBuilder(src);
        wordBuilder.setCharAt(index, ch);
        return wordBuilder.toString();
    }

}
