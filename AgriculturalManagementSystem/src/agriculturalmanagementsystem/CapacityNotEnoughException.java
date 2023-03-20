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
public class CapacityNotEnoughException extends Exception {
   
    public CapacityNotEnoughException(){
    }
     public CapacityNotEnoughException(String message){
         super(message);
    }
}
