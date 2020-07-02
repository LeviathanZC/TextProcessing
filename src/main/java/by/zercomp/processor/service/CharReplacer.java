package by.zercomp.processor.service;

public interface CharReplacer {

    String replaceInEachWord(String src, int index, char symbol);

    String replaceMakeCorrections(String src, String before, String after);

    String replaceWordsBySubStr(String src, int length, String substring);

}
