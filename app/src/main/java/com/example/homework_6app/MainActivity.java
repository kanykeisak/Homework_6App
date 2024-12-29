package com.example.homework_6app;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

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
    private ActivityMainBinding binding;
    private ArrayList<Category> categoryList;
    private CategoryAdapter categoryAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        binding.categoryRecyclerView.setLayoutManager(layoutManager);

        ArrayList<Category> categories = new ArrayList<>();
        categories.add(new Category(R.drawable.ic_burger, "Burgers"));
        categories.add(new Category(R.drawable.ic_pizza, "Pizza"));
        categories.add(new Category(R.drawable.ic_kitchen, "Chicken"));

        CategoryAdapter adapter = new CategoryAdapter(categories);
        binding.categoryRecyclerView.setAdapter(adapter);

        binding.edSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int start, int before, int count) {
                searchFood(charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {}
        });
    }

    // Метод для поиска и перемещения элемента на первую позицию
    private void searchFood(String query) {
        for (int i = 0; i < categoryList.size(); i++) {
            if (categoryList.get(i).getName().toLowerCase().contains(query.toLowerCase())) {
                // Перемещаем найденную категорию на первую позицию
                Category selectedCategory = categoryList.get(i);
                categoryList.remove(i);
                categoryList.add(0, selectedCategory);  // Добавление в начало списка

                // Уведомление адаптера о изменении данных
                categoryAdapter.notifyDataSetChanged();
                break;
            }
        }
    }
}