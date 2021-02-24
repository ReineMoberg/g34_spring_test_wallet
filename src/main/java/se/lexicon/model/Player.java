package se.lexicon.model;

import java.util.Objects;

public class Player {

    private String id;
    private String name;
    private String email;
    private String phone;
    private Account account;

    public Player() {
    }

    public Player(String id, String name, String email, String phone, Account account) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.account = account;
    }

    public Player(String name, String email, String phone, Account account) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.account = account;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(id, player.id) && Objects.equals(name, player.name) && Objects.equals(email, player.email) && Objects.equals(phone, player.phone) && Objects.equals(account, player.account);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, phone, account);
    }

    @Override
    public String toString() {
        return "Player{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", account=" + account +
                '}';
    }
}
