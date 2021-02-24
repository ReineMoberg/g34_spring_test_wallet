package se.lexicon.model;

import java.util.Objects;

public class Account {

    private int id;
    private boolean status;
    private AccountType accountType;
    private int balance;

    // default
    public Account() {
    }

    // select data
    public Account(int id, boolean status, AccountType accountType, int balance) {
        this.id = id;
        this.status = status;
        this.accountType = accountType;
        this.balance = balance;
    }

    // insert data
    public Account(boolean status, AccountType accountType, int balance) {
        this.status = status;
        this.accountType = accountType;
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return id == account.id && status == account.status && balance == account.balance && accountType == account.accountType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, status, accountType, balance);
    }


    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", status=" + status +
                ", accountType=" + accountType +
                ", balance=" + balance +
                '}';
    }
}
