package by.zercomp.textProcessor.dao.impl;

import by.zercomp.textProcessor.dao.DAO;

import java.io.*;

public class FileDAO implements DAO {

    private String path;
    private FileReader freader;
    private BufferedReader input;
    private StringBuilder sb;

    public FileDAO(String path) {
        this.path = path;
    }

    @Override
    public String read() {
        try {
            freader = new FileReader(this.path);
            input = new BufferedReader(freader);
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
