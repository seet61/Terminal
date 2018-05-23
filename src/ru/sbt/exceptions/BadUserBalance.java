package ru.sbt.exceptions;

public class BadUserBalance extends Exception {
    public BadUserBalance() {
    }

    public BadUserBalance(String message) {
        super(message);
    }
}
