package Model;

import java.io.Serializable;

public class Product implements Serializable {
    private long productCode;
    private String name;
    private String manufacturer;
    private double cost;
    private String otherDescription;

    public Product(long productCode, String name, String manufacturer, double cost, String otherDescription) {
        this.productCode = productCode;
        this.name = name;
        this.manufacturer = manufacturer;
        this.cost = cost;
        this.otherDescription = otherDescription;
    }

    public Product(int productCode, String name, String manufacturer, double cost) {
        this.productCode = productCode;
        this.name = name;
        this.manufacturer = manufacturer;
        this.cost = cost;
        this.otherDescription = "Khong";
    }

    public Product(){

    }


    public long getProductCode() {
        return productCode;
    }

    public void setProductCode(long productCode) {
        this.productCode = productCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getOtherDescription() {
        return otherDescription;
    }

    public void setOtherDescription(String otherDescription) {
        this.otherDescription = otherDescription;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productCode=" + productCode +
                ", name='" + name + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", cost=" + cost +
                ", otherDescription='" + otherDescription + '\'' +
                '}';
    }
}

