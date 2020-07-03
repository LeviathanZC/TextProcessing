package by.zercomp.processor.service.impl;

import by.zercomp.processor.dao.DAO;
import by.zercomp.processor.dao.impl.FileDAO;
import by.zercomp.processor.exception.InvalidDataException;
import by.zercomp.processor.service.CharRemover;


public class CharRemoverAsCharImpl implements CharRemover {
    @Override
    public String removeNonLetterOrSpaceChars(String src) throws InvalidDataException {
        if (src == null) {
            throw new InvalidDataException("argument must not be null.");
        }
        return String.valueOf(pickLetters(src.toCharArray()));
    }

    private char[] pickLetters(char[] src) {
        int length = src.length;
        char[] charset = new char[length];
        for (int i = 0, index = 0; i < length; i++) {
            if (Character.isLetter(src[i])) {
                charset[index++] = src[i];
            }
        }
        return trimToSize(charset, length - countNulls(charset));
    }

    private char[] trimToSize(char[] src, int length) {
        char[] array = new char[length];
        for (int i = 0; i < length; i++) {
            array[i] = src[i];
        }
        return array;
    }

    private int countNulls(char[] src) {
        int counter = 0;
        for (int i = 0; i < src.length; i++) {
            if(src[i] == 0) {
                counter++;
            }
        }
        return counter;
    }

    @Override
    public String removeWordsByLength(String src, int length, char startsWith) {
        return null;
    }

    public static void main(String[] args) throws InvalidDataException {
        DAO dao = new FileDAO("/home/leviathan/Sorting/sample.txt");
        CharRemover remover = new CharRemoverAsCharImpl();
        System.out.println(remover.removeNonLetterOrSpaceChars(dao.read()));
    }
}
