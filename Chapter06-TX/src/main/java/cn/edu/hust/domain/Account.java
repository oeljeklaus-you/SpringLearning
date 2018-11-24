package cn.edu.hust.domain;

public class Account {
    private int id;
    private String username;
    private int money;

    public Account(int id, String username, int money) {
        this.id = id;
        this.username = username;
        this.money = money;
    }

    public Account() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
