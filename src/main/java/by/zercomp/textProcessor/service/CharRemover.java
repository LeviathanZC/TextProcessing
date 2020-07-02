package by.zercomp.textProcessor.service;

public interface CharRemover {

    String removeNonLetterOrSpaceChars(String src);

    String  removeWordsByLength(String src, int length, char startsWith);

}
