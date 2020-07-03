package by.zercomp.processor.service;

import by.zercomp.processor.exception.InvalidDataException;

public interface CharRemover {

    String removeNonLetterOrSpaceChars(String src) throws InvalidDataException;

    String  removeWordsByLength(String src, int length, char startsWith);

}
