package com.example.usermanagemanet.Fragments.Classes;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

public class CartFragment extends Fragment {
    private static CartFragment instance;
    private final List<Animal> cartItems;

    public CartFragment() {
        cartItems = new ArrayList<>();
    }

    public static CartFragment getInstance() {
        if (instance == null) {
            instance = new CartFragment();
        }
        return instance;
    }

    public void addToCart(Animal animal) {
        cartItems.add(animal);
    }

    public void removeFromCart(Animal animal) {
        cartItems.remove(animal);
    }

    public List<Animal> getCartItems() {
        return cartItems;
    }

    public int getTotalPrice() {
        int total = 0;
        for (Animal a : cartItems) {
            total += a.getprice();
        }
        return total;
    }

    public void clearCart() {
        cartItems.clear();
    }


}
