package by.zercomp.textProcessor.dao.impl;

import by.zercomp.textProcessor.dao.DAO;

import java.io.*;

public class FileDAO implements DAO {

    private String path;
    private StringBuilder sb;

    public FileDAO(String path) {
        this.path = path;
    }

    @Override
    public String read() {
        //Java 7 - был добавлен try-with-resources для автоматического закрытия потоков
        try (BufferedReader input = new BufferedReader(new FileReader(this.path))) {
            sb = new StringBuilder();
            String currentLine;
            while ((currentLine = input.readLine()) != null) {
                sb.append(currentLine);
            }
            return sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}
