package com.company;

import java.util.*;
import java.util.stream.Collectors;

class Account {
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

class User extends Account {

    private List<Item> cart = new ArrayList<>();// корзина

    private Set<String> searchHistory = new HashSet<>();

    public User(String login, String password) {
        super(login, password);
    }

    public void addToCart(Item item) {
        searchHistory.addAll(item.getKeywords());
        cart.add(item);
    }

    public void removeFromCart(Item item) {
        cart.remove(item);
    }

    public Set<String> getSearchHistory() {
        return this.searchHistory;
    }

    public float calculateTotalPrice() {
        float sum = 0;

        for (Item item : cart) {
            sum += item.getPrice();
        }

        return sum;
    }

    public void clearCart() {
        cart.removeAll(cart);
    }

}

class Admin extends Account {
    public Admin(String login, String password) {
        super(login, password);
    }
}

class AIShop {

    private final static int KEYWORDS_SUBSET_SIZE = 5;
    private final static int RECOMMENDATIONS_SIZE = 5;

    private List<Item> items;

    public List<Item> getItemsByKey(String keyword) { // search function по hashmap (key - set of key words, blah blah blah ) est'
        return items.stream().filter(item -> item.isApplicable(keyword)).collect(Collectors.toList());
    }

    public List<Item> getRecommendations(User user) {
        Set<String> searchHistory = user.getSearchHistory();
        int fromIndex = Random.getRandInt(searchHistory.size() - KEYWORDS_SUBSET_SIZE);
        int toIndex = fromIndex + KEYWORDS_SUBSET_SIZE;

        List<String> keywords = new ArrayList<>(searchHistory).subList(fromIndex, toIndex);
        List<Item> recommendations =
                keywords.stream().map(this::getItemsByKey).flatMap(Collection::stream).collect(Collectors.toList());

        if (recommendations.size() > RECOMMENDATIONS_SIZE) {
            return recommendations.subList(0, RECOMMENDATIONS_SIZE);
        } else {
            return recommendations;
        }
    }

    // payment

    // История поиска est'
}

// [Item(), Item()]

class Item {
    private String type;
    private float price;
    private String color;
    private String print;
    private Set<String> keywords;

    public boolean isApplicable(String userKeyword) {
        return this.keywords.contains(userKeyword);
    }

    public Item(String type, float price, String color, String print) {
        this.type = type;
        this.price = price;
        this.color = color;
        this.print = print;
        this.keywords.add(type);
        this.keywords.add(color);
        this.keywords.add(print);
    }

    public Set<String> getKeywords() {
        return this.keywords;
    }

    public float getPrice() {
        return this.price;
    }

}

interface AbstractFactory {
    // CreateItems...
    // Irochka
}

class Random {
    static Random random = new Random();

    public static int getRandInt(int limit) {
        return random.getRandInt(limit);
    }
}

// Registration and addition Tanechka

public class Main {

    public static void main(String[] args) {

    }
}
