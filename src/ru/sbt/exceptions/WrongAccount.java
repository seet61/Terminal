package ru.sbt.exceptions;

public class WrongAccount extends Exception {
    public WrongAccount() {
    }

    public WrongAccount(String message) {
        super(message);
    }
}
