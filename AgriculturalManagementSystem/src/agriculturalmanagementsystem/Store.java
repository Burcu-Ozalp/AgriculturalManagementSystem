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
import java.util.Random;



public class Store implements CropKeeper  {

    
   
    private int ID=5000;
    private static int count=0;
    private String storeName;
    private double maxCapacityArea;
    private double usedCapacityArea;
    private double KGperSquareMeter=10;
    protected ArrayList <Fruit> fruitList=new ArrayList<>();

    public Store(String storeName, double maxCapacityArea, double usedCapacityArea, double KGperSquareMeter) {
        Random rnd =new Random();
        this.ID += count;
        count++;
        this.storeName = storeName;
        this.maxCapacityArea = maxCapacityArea;
        this.usedCapacityArea = usedCapacityArea;
        this.KGperSquareMeter = KGperSquareMeter;
    }
    public Store(String storeName, double maxCapacityArea, double KGperSquareMeter) {
        this.storeName = storeName;
         this.ID += count;
        count++;
        this.maxCapacityArea = maxCapacityArea;
        this.KGperSquareMeter = KGperSquareMeter;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public void setMaxCapacityArea(double maxCapacityArea) {
        this.maxCapacityArea = maxCapacityArea;
    }

    public void setUsedCapacityArea(double usedCapacityArea) {
        this.usedCapacityArea = usedCapacityArea;
    }

    public void setKGperSquareMeter(double KGperSquareMeter) {
        this.KGperSquareMeter = KGperSquareMeter;
    }

    public void setFruitList(ArrayList<Fruit> fruitList) {
        this.fruitList = fruitList;
    }

    public int getID() {
        return ID;
    }

    public String getStoreName() {
        return storeName;
    }

    public double getMaxCapacityArea() {
        return maxCapacityArea;
    }

    public double getUsedCapacityArea() {
        return usedCapacityArea;
    }

    public double getKGperSquareMeter() {
        return KGperSquareMeter;
    }

    public ArrayList<Fruit> getFruitList() {
        return fruitList;
    }
    
    public double availableCapacity(){
    double freeCapacity=this.maxCapacityArea-this.usedCapacityArea;
    return freeCapacity;
    }
    
    public boolean canBeStored(Fruit f){
        for(int i=0; i<fruitList.size(); i++){
        if(fruitList.get(i).name!=f.name || fruitList.get(i).color!=f.color){
        } }
        if(f.weight<=availableCapacity()){
        return true;}
        else
        return false;
    }
    
    public String importCrop(Fruit f) throws CapacityNotEnoughException{
    if(this.canBeStored(f)==true){
    fruitList.add(f);
    this.usedCapacityArea=this.usedCapacityArea+f.weight;
    }
       throw new CapacityNotEnoughException();
    }
    
    public void exportCrop(Fruit f) throws FruitNotFoundException{
    if(fruitList.size()>0){
    fruitList.remove(f);
    this.usedCapacityArea=this.usedCapacityArea-f.weight;
    }
    else
        throw new FruitNotFoundException();
       
    }
    
    @Override
    public void howToStore() {
        System.out.println("fruits in large refrigerated cooler rooms");
        System.out.println("vegetables in sheds, not listed");
    }

    @Override
    public String toString() {
        return "Store{" + "ID=" + ID + ", storeName=" + storeName + ", maxCapacityArea=" + maxCapacityArea + ", usedCapacityArea=" + usedCapacityArea + ", KGperSquareMeter=" + KGperSquareMeter + ", fruitList=" + fruitList + '}';
    }
    
    
}
