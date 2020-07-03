package by.zercomp.processor.service.impl;

import by.zercomp.processor.exception.InvalidDataException;
import by.zercomp.processor.service.CharReplacer;
import by.zercomp.processor.validator.TextValidator;

public class CharReplacerAsCharSeqImpl implements CharReplacer {

    @Override
    public String replaceInEachWord(String src, int index, char symbol) throws InvalidDataException {
        if (src == null || index < 0) {
            throw new InvalidDataException("argument must be not null nor zero");
        }
        TextValidator validator = new TextValidator();
        String[] stringArray = src.split(" ");
        char[][] storage = new char[stringArray.length][];
        int counter = 0;
        for (String item: stringArray) {
            storage[counter] = item.toCharArray();
            if(validator.inRange(item, index)) {
                storage[counter][index] = symbol;
            }
            counter++;
        }
        return convertCharsToString(storage);
    }

    @Override
    public String replaceMakeCorrections(String src, String before, String after) throws InvalidDataException {
        if (src == null || before == null || after == null) {
            throw new InvalidDataException("arguments must be not null");
        }
        String[] strings = src.split(" ");
        char[][] storage = new char[strings.length][];
        int counter = 0;
        for (String item: strings) {
            storage[counter] = item.toCharArray();

        }
        return null;
    }

    @Override
    public String replaceWordsBySubStr(String src, int length, String substring) {
        return null;
    }

    private String convertCharsToString(char[][] src) {
        StringBuilder builder = new StringBuilder();
        for (char[] item: src) {
            builder.append(item);
            builder.append(" ");
        }
        return builder.toString();
    }

    //test method
    public static void main(String[] args) {
        char symbol = 'й';
        int index = 5;
        String src = "qweqwer qer qeirgqeirg qeutgr qeugr qeuity qeuir geu tqoue tqouh";

    }

}
