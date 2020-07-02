package by.zercomp.textProcessor.dao.impl;

import by.zercomp.textProcessor.dao.DAO;

import java.util.Scanner;

public class ConsoleDAO implements DAO {

    private Scanner input;

    public ConsoleDAO(Scanner scanner) {
        this.input = scanner;
    }

    @Override
    public String read() {
        return this.input.next();
    }
}
