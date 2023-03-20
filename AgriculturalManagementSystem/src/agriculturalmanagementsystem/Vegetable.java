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
public class Vegetable extends Crop implements Comparable<Vegetable> {
    
    private String cultivatedRegion;
     

    
    public Vegetable(String name,String type, int weight,String cultivatedRegion,int ID ) {
        super(name, type, weight,ID);
        this.cultivatedRegion = cultivatedRegion;
    }

    public String getCultivatedRegion() {
        return cultivatedRegion;
    }

    public void setCultivatedRegion(String cultivatedRegion) {
        this.cultivatedRegion = cultivatedRegion;
    }

    
    @Override
    public String consumeIt() {
        return "vegetables are cooked";
    }

     @Override
    public String storeIt() throws CanNotBeStoredException {
        throw new CanNotBeStoredException();
    }


    @Override
    public int compareTo(Vegetable v) {
        if(super.name==v.name){
        return 0;}
        return (super.weight-v.weight);
    }
    
   
    @Override
    public String toString() {
        return "Vegetable{" + "cultivatedRegion=" + cultivatedRegion + '}';
    }

    
    
}
