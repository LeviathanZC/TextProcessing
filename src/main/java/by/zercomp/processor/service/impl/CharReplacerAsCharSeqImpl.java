package by.zercomp.processor.service.impl;

import by.zercomp.processor.dao.DAO;
import by.zercomp.processor.dao.impl.ConsoleDAO;
import by.zercomp.processor.dao.impl.FileDAO;
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
        for (String item : stringArray) {
            storage[counter] = item.toCharArray();
            if (validator.inRange(item, index)) {
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
        if (before.length() != 2 || after.length() != 2) {
            throw new InvalidDataException("strings must be 2 chars only");
        }
        String[] strings = src.split(" ");
        int total = strings.length;
        char[][] storage = new char[total][];
        char[] beforeChar = before.toCharArray();
        char newChar = after.toCharArray()[1];
        int counter = 0;
        int lastIndex;
        for (String item : strings) {
            lastIndex = item.length() - 1;
            char[] word = item.toCharArray();
            for (int j = 0; j < lastIndex; j++) {
                if (word[j] == beforeChar[0] && word[j + 1] == beforeChar[1]) {
                    word[j + 1] = newChar;
                }
            }
            storage[counter++] = word;
        }
        return convertCharsToString(storage);
    }


    @Override
    public String replaceWordsBySubStr(String src, int length, String substring) {
        return null;
    }

    private String convertCharsToString(char[][] src) {
        StringBuilder builder = new StringBuilder();
        for (char[] item : src) {
            builder.append(item);
            builder.append(" ");
        }
        return builder.toString();
    }


    //test method
    public static void main(String[] args) throws InvalidDataException {
        char symbol = 'й';
        int index = 5;
        String src = "qweqwer qer qeirgqeirg qeutgr qeugr qeuity qeuir geu tqoue tqouh";
        String path = "/home/leviathan/Sorting/sample.txt";
        DAO dao = new FileDAO(path);
        CharReplacer cr = new CharReplacerAsCharSeqImpl();
        System.out.println(cr.replaceMakeCorrections(dao.read(), "Lo", "ХУ"));
    }

}
