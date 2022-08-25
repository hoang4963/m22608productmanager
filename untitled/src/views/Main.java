package views;

import Controller.ProductManager;
import Model.Product;

import java.io.*;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static final String LINK_FILE = "C:\\Users\\Acer\\Desktop\\codegym\\Module2APJ\\260822\\exercise\\ProductManager\\ProductManager.txt";
    public static void main(String[] args) {
        Product product1 = new Product(1,"Sung AK","Nga", 1000,"Manh");
        Product product2 = new Product(2,"Sung M4A1S","My", 1200,"Chinh xac");
        ProductManager productManager = new ProductManager();
        productManager.add(product1);
        productManager.add(product2);
        writeFile(productManager);
        int input;
        do {
            System.out.println("Nhap -1 de thoat");
            System.out.println("1. Them");
            System.out.println("2. Xoa");
            System.out.println("3. Tim");
            System.out.println("4. Show data");
            Scanner scanner = new Scanner(System.in);
            input = scanner.nextInt();
            addDeleteFind(input);
        }
        while (input != -1);
    }

    public static void writeFile(ProductManager productList) {
        try {
            FileOutputStream fos = new FileOutputStream(LINK_FILE);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(productList);
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static ProductManager readProduct(){
        ProductManager productManager = null;
        try {
            FileInputStream fis = new FileInputStream(LINK_FILE);
            ObjectInputStream ois = new ObjectInputStream(fis);
            productManager = (ProductManager) ois.readObject();
            fis.close();
            ois.close();
        }
        catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return productManager;
    }
    public static void addProduct(){
        ProductManager productManager = readProduct();
        System.out.println("Nhap ma san pham(chi nhap dang so): ");
        Scanner scanner = new Scanner(System.in);
        long code = scanner.nextLong();
        System.out.println("Nhap ten san pham: ");
        Scanner scanner1 = new Scanner(System.in);
        String name = scanner1.nextLine();
        System.out.println("Hang san xuat: ");
        Scanner scanner2 = new Scanner(System.in);
        String manufacturer = scanner2.nextLine();
        System.out.println("Gia tien: ");
        Scanner scanner3 = new Scanner(System.in);
        double cost = scanner3.nextDouble();
        System.out.println("Them mo ta: ");
        Scanner scanner4 = new Scanner(System.in);
        String otherDescriptin = scanner4.nextLine();
        Product product = new Product(code,name,manufacturer,cost,otherDescriptin);
            productManager.add(product);
        writeFile(productManager);
    }
    public static void deleteProduct(){
        ProductManager productManager = readProduct();
        System.out.println("Nhap vi tri can xoa");
        Scanner scanner = new Scanner(System.in);
        int index = scanner.nextInt();
        productManager.delete(index);
        writeFile(productManager);
    }
    public static void findProduct(){
        ProductManager productManager = readProduct();
        int chose;
        do {
            System.out.println("Nhap -1 de thoat");
            System.out.println("1. Theo ten");
            System.out.println("2. Theo gia tien");
            System.out.println("3. Theo vi tri");
            System.out.println("4. Tro lai");
            Scanner scanner = new Scanner(System.in);
             chose = scanner.nextInt();
             choseFindProduct(chose,productManager);
        }while (chose != -1);
    }
    public static void addDeleteFind(int chose){
        switch (chose) {
            case 1 -> addProduct();
            case 2 -> deleteProduct();
            case 3 -> findProduct();
            case 4 -> show();
            case -1 -> System.out.println("out");
            default -> System.out.println("Nhap 1 hoac 2 hoac 3 hoac 4 hoac -1");
        }
    }
    public static void show(){
        ProductManager productManager = readProduct();
        for (int i = 0; i < productManager.size(); i++) {
            System.out.println(productManager.get(i));
        }
    }

    public static void findFlowName(ProductManager productManager){
        System.out.println("Nhap ten");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        for (int i = 0; i < productManager.size(); i++) {
            if (Objects.equals(productManager.get(i).getName(), name)){
                System.out.println(productManager.get(i).toString());
            }
        }
    }
    public static void findFlowcost(ProductManager productManager){
        int chose;
        do {
            System.out.println("Nhap tru -1 de thoat");
            System.out.println("1. Lon hon");
            System.out.println("2. Nho hon");
            System.out.println("3. Tro lai");
            Scanner scanner = new Scanner(System.in);
            chose = scanner.nextInt();
            choseFindFlowCost(productManager, chose);
        }while (chose != -1);
    }

    private static void choseFindFlowCost(ProductManager productManager, int chose) {
        switch (chose){
            case 1:
            {
                System.out.println("Nhap so tien: ");
                Scanner scanner1 = new Scanner(System.in);
                double cost = scanner1.nextDouble();
                System.out.println("Nhung san pham co gia cao hon " + cost +" la: ");
                for (int i = 0; i < productManager.size(); i++) {
                    if (productManager.get(i).getCost() > cost){
                        System.out.println(productManager.get(i).toString());
                    }
                }
            }
            case 2:{
                System.out.println("Nhap so tien: ");
                Scanner scanner2 = new Scanner(System.in);
                double cost = scanner2.nextDouble();
                System.out.println("Nhung san pham co thap cao hon " + cost +" la: ");
                for (int i = 0; i < productManager.size(); i++) {
                    if (productManager.get(i).getCost() < cost){
                        System.out.println(productManager.get(i).toString());
                    }
                }
            }
            case 3:
                findProduct();
            default:
                System.out.println("Nhap 1 hoac 2 hoac 3 thoi");
        }
    }

    public static void findFlowIndex(ProductManager productManager){
        System.out.println("nhap vi tri: ");
        Scanner scanner = new Scanner(System.in);
        int index = scanner.nextInt();
        if (index <0 || index >= productManager.size()){
            System.out.println("khong co san pham nay");
        }
        else {
            System.out.println(productManager.get(index).toString());
        }
    }
    public static void choseFindProduct(int chose, ProductManager productManager){
        switch (chose){
            case 1:
                findFlowName(productManager);
            case 2:
                findFlowcost(productManager);
            case 3:
                findFlowIndex(productManager);
            case 4:
                findProduct();
            default:
                System.out.println("Nhap lai");
        }
    }
}
