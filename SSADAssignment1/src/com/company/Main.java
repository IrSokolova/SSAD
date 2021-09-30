package com.company;

class Account{
    private String login;
    private String password;

    public Account(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

class User extends Account{
    public User(String login, String password) {
        super(login, password);
    }
}
class Admin extends Account{
    public Admin(String login, String password) {
        super(login, password);
    }
}

class AIShop{
    // search function по hashmap (key - array of key words, blah blah blah )
    // корзина
    // payment
    // История поиска
}

class Item{

}

interface AbstractFactory{
    // CreateItems...
    // Irochka
}

// Registration and addition Tanechka

public class Main {

    public static void main(String[] args) {
	// Продумать выход
    }
}
