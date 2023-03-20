/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agriculturalmanagementsystem;

/**
 *
 * @author Burcu
 */
public class Fruit extends Crop implements Comparable<Fruit>{

    private String taste;
    private double price;
    protected String color;
   
    
    
    public Fruit(String name,String type,int weight,String cultivatedSeason,String taste, double price,int ID) {
        super(name,type, weight, cultivatedSeason,ID);
        this.taste = taste;
        this.price = price;
        
    }


    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    
    
    public String getTaste() {
        return taste;
    }

    public void setTaste(String taste) {
        this.taste = taste;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
    
    
    @Override
    public String consumeIt() {
        return "fruits are consumed raw";
    }

    @Override
    public String storeIt() {
       return "Fruit is stored";
    }

    @Override
    public int compareTo(Fruit f) {
        if(this.color==f.color && super.name==f.name){
        return 0;}
        return (super.weight-f.weight);
    }

    @Override
    public String toString() {
        return "Fruit{" + "taste=" + taste + ", price=" + price + ", color=" + color + '}';
    }
    
}
