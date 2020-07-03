package by.zercomp.processor.dao.impl;

import by.zercomp.processor.dao.DAO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ConsoleDAO implements DAO {

    private BufferedReader reader;

    public ConsoleDAO(InputStream stream) {
        this.reader = new BufferedReader(new InputStreamReader(stream));
    }

    @Override
    public String read() {
        try {
            return this.reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}
