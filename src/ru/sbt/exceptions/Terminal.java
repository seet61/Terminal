package ru.sbt.exceptions;

public interface Terminal {
    // get balance for userId
    Integer getBalance (Integer userId) throws BadUserBalance;

    // replenishment cash from userId balance
    boolean cashReplenishment(Integer userId, Integer sum);

    // withdrawal cash from userId balance
    boolean cashWithdrawal(Integer userId, Integer sum);
}
