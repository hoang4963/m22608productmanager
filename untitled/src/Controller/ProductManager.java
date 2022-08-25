package Controller;

import Model.Product;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class ProductManager implements Serializable {
    List<Product> productList;
    public ProductManager(){
        productList = new ArrayList<>();
    }
    public void add(Product p){
        productList.add(p);
    }
    public void delete(int index){
        productList.remove(index);
    }
    public Product get(int index){
        return productList.get(index);
    }
    public int size(){
        return productList.size();
    }
    public void show(){
        for (int i = 0; i < productList.size(); i++) {
            System.out.println(productList.get(i));
        }
    }
}
