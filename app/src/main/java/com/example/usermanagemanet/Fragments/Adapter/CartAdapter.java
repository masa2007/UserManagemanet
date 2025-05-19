package com.example.usermanagemanet.Fragments.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.usermanagemanet.Fragments.Classes.Animal;
import com.example.usermanagemanet.Fragments.Classes.CartFragment;

import com.example.usermanagemanet.R;

import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewHolder> {

    private final List<Animal> cartItems;
    private final Context context;

    public CartAdapter(List<Animal> cartItems, Context context) {
        this.cartItems = cartItems;
        this.context = context;
    }

    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.fragment_cart, parent, false);
        return new CartViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CartViewHolder holder, int position) {
        Animal animal = cartItems.get(position);

        holder.typeTextView.setText(animal.getType());
        holder.priceTextView.setText(animal.getprice() + " ₪");
        holder.placeTextView.setText("place: " + animal.getPlace());

        Glide.with(context)
                .load(animal.getPhoto())
                .placeholder(R.drawable.ic_launcher_background)
                .into(holder.animalImageView);

        holder.removeButton.setOnClickListener(v -> {
            CartFragment.getInstance().removeFromCart(animal);
            notifyItemRemoved(position);
            notifyItemRangeChanged(position, cartItems.size());
            Toast.makeText(context, "Animal has removed from cart", Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    public int getItemCount() {
        return cartItems.size();
    }

    public static class CartViewHolder extends RecyclerView.ViewHolder {
        TextView typeTextView, priceTextView, placeTextView;
        ImageView animalImageView;
        Button removeButton;

        public CartViewHolder(@NonNull View itemView) {
            super(itemView);
            typeTextView = itemView.findViewById(R.id.cart_item_type);
            priceTextView = itemView.findViewById(R.id.cart_item_price);
            placeTextView = itemView.findViewById(R.id.cart_item_place);
            animalImageView = itemView.findViewById(R.id.cart_item_image);
            removeButton = itemView.findViewById(R.id.cart_item_remove);
        }
    }
}
