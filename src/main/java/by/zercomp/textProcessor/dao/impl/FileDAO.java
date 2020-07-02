package by.zercomp.textProcessor.dao.impl;

import by.zercomp.textProcessor.dao.DAO;

import java.io.File;

public class FileDAO implements DAO {

    private String path;

    public FileDAO(String path) {
        this.path = path;
    }

    @Override
    public String read() {
        final File file;

        return null;
    }
}
