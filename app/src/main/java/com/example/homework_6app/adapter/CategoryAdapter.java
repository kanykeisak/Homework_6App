package com.example.homework_6app.adapter;

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
        holder.bind(list.get(position));
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
        }

        public void bind(Category category) {
            binding.tvName.setText(category.getName());
            binding.ivIcon.setImageResource(category.getIconResId()); // Установка ресурса изображения
        }
    }
}
