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
public class CanNotBeStoredException extends Exception{
    
    public CanNotBeStoredException(){
    }
     public CanNotBeStoredException(String message){
         super(message);
    }
}
