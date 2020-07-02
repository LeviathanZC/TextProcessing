package by.zercomp.processor.validator;

public class TextValidator {

    public boolean inRange(String word, int index) {
        if (word == null) {
            return false;
        }
        return index > -1 && index < word.length();
    }

}
