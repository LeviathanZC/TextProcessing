package by.zercomp.processor.service;

import by.zercomp.processor.exception.InvalidDataException;

public interface CharReplacer {

    String replaceInEachWord(String src, int index, char symbol) throws InvalidDataException;

    String replaceMakeCorrections(String src, String before, String after) throws InvalidDataException;

    String replaceWordsBySubStr(String src, int length, String substring) throws InvalidDataException;

}
