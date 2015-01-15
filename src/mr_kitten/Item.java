/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mr_kitten;

/**
 *
 * @author Arya
 */
import java.util.*;

/**
 * Items with description and weight
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Item
{
    // instance variables - replace the example below with your own
    private String itemName;
    private int itemWeight;
    private String itemDescription;
        
    /**
     * Constructor for objects of class Item
     */
    public Item(String name, String description, int weight)
    {
        itemName = name;
        itemDescription = description;
        itemWeight = weight;
    }
    
    /**
     * Get name of item
     * @return 
     */
    public String getName()
    {
        return itemName;
    }
    
    /**
     * Get description of item
     * @return 
     */
    public String getDescription()
    {
        return itemDescription;
    }
    
    /**
     * Get weight of item
     * @return 
     */
    public int getWeight()
    {
        return itemWeight;
    }
    
    /**
     * Look a item
     * @return 
     */
    public String lookItem()
    {
        String s = (getName()+ "\n"+ getDescription());
        return s;
    }
     
}
