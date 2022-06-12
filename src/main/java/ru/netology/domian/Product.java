package ru.netology.domian;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Product {
    protected int id;
    protected String name;
    protected double price;



    public boolean matches(String search) {
        if(name.contains(search)) {
            return true;
        }
        return false;

            }
}
