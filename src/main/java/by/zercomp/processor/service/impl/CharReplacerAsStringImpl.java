package by.zercomp.processor.service.impl;

import by.zercomp.processor.service.CharReplacer;

import java.util.StringJoiner;

public class CharReplacerAsStringImpl implements CharReplacer {

    @Override
    public String replaceInEachWord(String src, int index, char symbol) {
        final String[] words = src.split("\\s");
        StringJoiner joiner = new StringJoiner(" ");
        StringBuilder wordBuilder;
        for (int i = 0; i < words.length; i++) {
            if (index < words[i].length() && index > -1) {
                wordBuilder = new StringBuilder(src);
                wordBuilder.setCharAt(index, symbol);
                words[i] = wordBuilder.toString();
            }
            joiner.add(words[i]);
        }
        return joiner.toString();
    }

    @Override
    public String replaceMakeCorrections(String src, char before, char after) {
        return null;
    }

    @Override
    public String replaceWordsBySubStr(String src, int length, String substring) {
        return null;
    }


}
