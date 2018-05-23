package ru.sbt.exceptions;

import java.util.Date;

public class PinValidator {
    private int userId = 123;
    private int password = 4567;
    private int attempt = 0;
    private long timeBlock = 0;
    private int block = 5000;

    public PinValidator() {
    }

    /**
     * Проверка пина
     * @param userId
     * @param pin
     * @return
     */
    public boolean checkPin(Integer userId, Integer pin) throws AccountIsLockedException, WrongAccount {
        // Проверяем что это наш пользователь
        if (this.userId == userId) {
            this.attempt++;
            // Попыток не больше трех
            if (this.attempt <= 3) {
                // Проверяем не заблокирован ли
                if (timeBlock == 0 || timeBlock < (new Date()).getTime()) {
                    timeBlock = 0;
                    if (this.password == pin) {
                        return true;
                    }
                } else {
                    throw new AccountIsLockedException("Account is locked. Wait " + block + " sec.");
                }
            } else {
                timeBlock = (new Date()).getTime() + block;
                this.attempt = 0;
                throw new AccountIsLockedException("Account is locked. Wait " + block + " sec.");
            }
        } else {
            throw new WrongAccount("Bad account");
        }
        return false;
    }
}
