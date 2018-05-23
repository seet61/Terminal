package ru.sbt.exceptions;

import java.util.Date;
import java.util.Scanner;

public class TerminalImpl {
    //private final TerminalServer server;
    //private final PinValidator pinValidator;

    public static void main(String[] args) {
        int userId = 0;
        int pin = 0;
        int sum = 0;
        boolean status = false;
        PinValidator pinValidator = new PinValidator();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите userId: ");
        userId = scanner.nextInt();
        do {
            try {
                System.out.print("Введите пароль: ");
                pin = scanner.nextInt();
                status = pinValidator.checkPin(userId, pin);
                System.out.println(status);
                if (status == true) {
                    TerminalServer server = new TerminalServer();
                    System.out.println("Баланс: " + server.getBalance(userId));
                    System.out.print("Введите сумму зачисления: ");
                    sum = scanner.nextInt();
                    server.cashReplenishment(userId, sum);
                    System.out.println("Баланс: " + server.getBalance(userId));
                    System.out.print("Введите сумму снятия: ");
                    sum = scanner.nextInt();
                    server.cashWithdrawal(userId, sum);
                    System.out.println("Баланс: " + server.getBalance(userId));

                }
            } catch (AccountIsLockedException e) {
                System.err.println(e.getMessage());
            } catch (WrongAccount e) {
                System.err.println(e.getMessage());
                System.exit(0);
            } catch (BadUserBalance e) {
                System.err.println(e.getMessage());
            }
        } while (status == false);
    }
}
