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
import java.util.ArrayList;

public class Supplier implements CropKeeper {

    private String name;
    private int id = 1000;
    private static int count=0;
    private double budget;
    protected ArrayList<Crop> cropList;

 

    public Supplier(String name, double budget, ArrayList<Crop> cropList) {
        this.name = name;
        this.budget = budget;
        this.cropList = new ArrayList<>();
        this.id += count;
        count++;
    }

    public Supplier(String name, double budget) {
        this.name = name;
        this.budget = budget;
        this.cropList = new ArrayList<>();
        this.id += count;
        count++;
    }
    
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public int getId() {
        return id;
    }

    public void buyCrop(Crop c) throws SupplierHasNotEnoughMoneyException, FruitNotAvailableException {
        if (c instanceof Fruit) {
            Fruit f = (Fruit) c;
            boolean b = true;
            for (int i = 0; i < cropList.size(); i++) {
                if (cropList.get(i).equals(f)) {
                    b = true;
                } else {
                    b = false;
                    throw new FruitNotAvailableException();
                }
            }

            if (this.budget >= f.getPrice()) {
            } else {
                throw new SupplierHasNotEnoughMoneyException();
            }
            if (b == true && this.budget >= f.getPrice()) {
                this.cropList.add(f);
                this.budget = this.budget - f.getPrice();
            }
        }
    }

    public void sellCrop(Crop c) throws FruitNotFoundException {
        if (c instanceof Fruit) {
            Fruit f = (Fruit) c;
            for (int i = 0; i < cropList.size(); i++) {
                if (cropList.get(i) == f) {
                    this.cropList.remove(f);
                    this.budget = this.budget + f.getPrice();
                } else {
                    throw new FruitNotFoundException();
                }

            }
        }
    }

    @Override
    public void howToStore() {
        System.out.println("fruits in large refrigerated cooler rooms");
        System.out.println("vegetables in sheds, not listed");
    }


    public ArrayList<Crop> getCropList() {
        return cropList;
    }

    @Override
    public String toString() {
        return "Supplier{" + "name=" + name + ", id=" + id + ", budget=" + budget + ", cropList=" + cropList + '}';
    }
    
    
}
