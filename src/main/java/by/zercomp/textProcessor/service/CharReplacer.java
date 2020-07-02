package by.zercomp.textProcessor.service;

public interface CharReplacer {

    String replaceInEachWord(String[] src, int index, char symbol);

    String replaceMakeCorrections(String src, char before, char after);

    String replaceWordsBySubStr(String src, int length, String substring);

}
