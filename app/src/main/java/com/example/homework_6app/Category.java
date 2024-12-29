package com.example.homework_6app;

public class Category {
    private int iconResId;
    private String name;

    public Category(int iconResId,String name){
        this.iconResId = iconResId;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Category{" +
                "iconResId=" + iconResId +
                ", name='" + name + '\'' +
                '}';
    }

    public int getIconResId() {
        return iconResId;
    }

    public String getName() {
        return name;
    }
}
