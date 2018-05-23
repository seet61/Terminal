package ru.sbt.exceptions;

public class TerminalServer implements Terminal{
    private int balance = 1000;

    public TerminalServer() {
    }

    @Override
    public Integer getBalance(Integer userId) throws BadUserBalance {
        if (this.balance == 0) {
            throw new BadUserBalance("Balance of userId:" + userId + " is 0");
        }
        return this.balance;
    }

    @Override
    public boolean cashReplenishment(Integer userId, Integer sum) {
        if (sum%100 == 0) {
            this.balance += sum;
            return true;
        }
        return false;
    }

    @Override
    public boolean cashWithdrawal(Integer userId, Integer sum) {
        if (sum%100 == 0) {
            this.balance -= sum;
            return true;
        }
        return false;
    }
}
