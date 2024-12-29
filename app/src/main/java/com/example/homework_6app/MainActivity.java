package com.example.homework_6app;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.homework_6app.adapter.CategoryAdapter;
import com.example.homework_6app.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Инициализация RecyclerView
        recyclerView = findViewById(R.id.categoryRecyclerView);

        // Настройка LinearLayoutManager с горизонтальной ориентацией
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);

        ArrayList<Category> categories = new ArrayList<>();
        categories.add(new Category(R.drawable.ic_burger, "Burgers"));
        categories.add(new Category(R.drawable.ic_pizza, "Pizza"));
        categories.add(new Category(R.drawable.ic_kitchen, "Chicken"));

        CategoryAdapter adapter = new CategoryAdapter(categories);
        binding.categoryRecyclerView.setAdapter(adapter);
    }
}