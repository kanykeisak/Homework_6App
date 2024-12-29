package com.example.homework_6app.adapter;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.homework_6app.Category;
import com.example.homework_6app.databinding.ItemCategoryBinding;

import java.util.ArrayList;
import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {

    private ArrayList<Category> list;
    private int selectedPosition = -1;

    public CategoryAdapter(ArrayList<Category> list){
        this.list = list;
    }
    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemCategoryBinding binding = ItemCategoryBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new CategoryViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        holder.bind(list.get(position), position);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class CategoryViewHolder extends RecyclerView.ViewHolder {
        private ItemCategoryBinding binding;

        public CategoryViewHolder( ItemCategoryBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

            // Обработка клика по элементу
            binding.getRoot().setOnClickListener(v -> {
                int oldSelectedPosition = selectedPosition;
                selectedPosition = getAdapterPosition();

                // Перемещаем выбранный элемент в начало списка, если позиция изменилась
                if (selectedPosition != oldSelectedPosition) {
                    Category selectedCategory = list.get(selectedPosition);
                    list.remove(selectedPosition);
                    list.add(0, selectedCategory);
                    notifyItemMoved(selectedPosition, 0);  // Перемещение элемента в начало
                }

                // Обновляем адаптер
                notifyDataSetChanged();
            });
        }

        public void bind(Category category, int position) {
            binding.tvName.setText(category.getName());
            binding.ivIcon.setImageResource(category.getIconResId());

            if (position == selectedPosition) {
                binding.getRoot().setBackgroundColor(Color.RED);
            } else {
                binding.getRoot().setBackgroundColor(Color.WHITE);
            }
        }
    }
    public void moveItemToFirstPosition() {
        if (selectedPosition != -1) {
            Category selectedCategory = list.get(selectedPosition);
            list.remove(selectedPosition);
            list.add(0, selectedCategory);  // Добавление на первую позицию
            selectedPosition = 0;  // Обновление выбранной позиции
            notifyDataSetChanged();
        }
    }
}
