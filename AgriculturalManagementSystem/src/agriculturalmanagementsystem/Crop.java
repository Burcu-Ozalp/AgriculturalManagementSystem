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

public abstract class Crop {

    protected final String name;
    protected final int weight;
    private String cultivatedSeason;
    protected String type;
    protected int ID;
    
    
    public Crop(String name,String type, int weight, String cultivatedSeason,int ID) {
        this.name = name;
        this.type=type;
        this.weight = weight;
        this.cultivatedSeason = cultivatedSeason;
    }

    public Crop(String name,String type, int weight,  int ID) {
        this.name = name;
        this.weight = weight;
        this.type = type;
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    public String getCultivatedSeason() {
        return cultivatedSeason;
    }

    @Override
    public abstract String toString();

    public abstract String consumeIt();

    public abstract String storeIt() throws CanNotBeStoredException;
}
