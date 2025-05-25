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

import com.example.usermanagemanet.Fragments.Classes.Animal;
import com.example.usermanagemanet.Fragments.Classes.CartFragment;
import com.example.usermanagemanet.Fragments.fragment.FireBaseServices;
import com.example.usermanagemanet.R;
// import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AnimalAdapter extends RecyclerView.Adapter<AnimalAdapter.MyViewHolder> {
    Context context;
    ArrayList<Animal> amlList;
    private FireBaseServices fbs;

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView ivAnimal;
        TextView tvType, tvGender, tvAge, tvColor, tvPlace, tvPrice;
        Button btnAddToCart;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ivAnimal = itemView.findViewById(R.id.ivAnimal);
            tvType = itemView.findViewById(R.id.tvType);
            tvGender = itemView.findViewById(R.id.tvGender);
            tvAge = itemView.findViewById(R.id.tvAge);
            tvColor = itemView.findViewById(R.id.tvColor);
            tvPlace = itemView.findViewById(R.id.tvPlace);
            tvPrice = itemView.findViewById(R.id.tvPrice);
            btnAddToCart = itemView.findViewById(R.id.addToCartButton);
        }
    }

    public AnimalAdapter(Context context, ArrayList<Animal> amlList) {
        this.context = context;
        this.amlList = amlList;
        this.fbs = FireBaseServices.getInstance();
    }

    @NonNull
    @Override
    public AnimalAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View v = LayoutInflater.from(context).inflate(R.layout.animal_item, parent, false);
        return new AnimalAdapter.MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull AnimalAdapter.MyViewHolder holder, int position) {
        Animal aml = amlList.get(position);

        holder.tvType.setText("🐾 النوع: " + aml.getType());
        holder.tvGender.setText("الجنس: " + aml.getGender());
        holder.tvAge.setText("العمر: " + aml.getAge());
        holder.tvColor.setText("اللون: " + aml.getColor());
        holder.tvPlace.setText("المكان: " + aml.getPlace());
        holder.tvPrice.setText("₪ السعر: " + aml.getprice());

        // ❌ تم تعطيل تحميل الصور - وضع صورة افتراضية مؤقتًا
        holder.ivAnimal.setImageResource(R.drawable.ic_launcher_background);

        holder.btnAddToCart.setOnClickListener(v -> {
            if (aml.getAdopt().equals("buy")) {
                CartFragment.getInstance().addToCart(aml);
                Toast.makeText(context, "✅ تمت إضافة الحيوان إلى السلة", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(context, "❌ لا يمكن إضافة حيوان للتبني إلى السلة", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return amlList.size();
    }
}
