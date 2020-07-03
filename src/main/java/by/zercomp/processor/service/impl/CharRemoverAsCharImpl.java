package by.zercomp.processor.service.impl;

import by.zercomp.processor.exception.InvalidDataException;
import by.zercomp.processor.service.CharRemover;


public class CharRemoverAsCharImpl implements CharRemover {
    @Override
    public String removeNonLetterOrSpaceChars(String src) throws InvalidDataException {
        if (src == null) {
            throw new InvalidDataException("argument must not be null.");
        }
        char[] common = src.toCharArray();
    }

    private char[] pickLetters(char[] src) {
        int length = src.length;
        char[] charset = new char[length];
        for (int i = 0, index = 0; i < length; i++) {
            if (Character.isLetter(src[i])) {
                charset[index++] = src[i];
            }
        }
        return trimToSize(charset, src.length - charset.length);
    }

    private char[] trimToSize(char[] src, int length) {
        char[] array = new char[length];
        for (int i = 0; i < length; i++) {
            array[i] = src[i];
        }
        return array;
    }

    @Override
    public String removeWordsByLength(String src, int length, char startsWith) {
        return null;
    }


}
