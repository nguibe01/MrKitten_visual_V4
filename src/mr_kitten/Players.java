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
 * Write a description of class Players here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Players
{
    // instance variables - replace the example below with your own
    private String playerName;
    private String currentPlayerRoom;
    private static ArrayList<Item> inventory;
    private int inventoryWeight = 0;
    private static int maxWeight = 130;
    private static int playerHP;
    
    /**
     * Constructor for objects of class Players
     */
    public Players(String name)
    {
        inventory = new ArrayList<Item>();
        playerName = name;
        currentPlayerRoom = "livingRoom";
        playerHP = 120;
    }
    
    /**
     * Get the inventory of player
     */
    public ArrayList<Item> getInventory(){
        return inventory;
    }
    
    /*
     * Print the inventory of player in SWING interface
     */
    public static void printInventoryIN(Interface in)
    {
        if (inventory.isEmpty()){
            in.jTextArea1.setText("it's empty !!");
        }
        else {
            String s=("");
            for (int i = 0;i<inventory.size();i++){
                Item currentItem = inventory.get(i);
                s = s +("   *********   "
                    +"\n Name : "+currentItem.getName()+"\t"
                    +"\n Description :"+currentItem.getDescription()
                    +"\n "+currentItem.getWeight()+"g \n");
            }
            in.jTextArea1.setText(s);
        }
        
    }
    
    /**
     * Print the inventory of players for the console game
     */
    public static void printInventory()
    {
        for (int i = 0;i<inventory.size();i++){
            Item currentItem = inventory.get(i);
            System.out.println("   *********   ");
            System.out.println("Name : "+currentItem.getName()+"\t");
            System.out.println("Description :"+currentItem.getDescription());
            System.out.println(currentItem.getWeight()+"g");
        }
    }
    
    /**
     * Get playerHP
     * @return 
     */
    public int getPlayerHP(){
        return playerHP;
    }
    
    /**
     * Modify playerHP
     * @param newPlayerHP 
     */
    public static void setPlayerHP(int newPlayerHP){
        playerHP = newPlayerHP;
    }
    
    /*
     * Grab an item by his name
     */
    public void grabItem (String name)
    {
        ArrayList<Item> tabItem = Game.getListItem();
        boolean exist = false;
        for (int i=0;i<tabItem.size();i++){
            Item currentItem = tabItem.get(i);
            if (currentItem.getName().equals(name)){
                exist = true;
                //Check the weight
                if (inventoryWeight + currentItem.getWeight() <= maxWeight){
                    inventory.add(currentItem);
                    inventoryWeight += currentItem.getWeight();
                }
                else {
                    //Choose to delete a item
                    System.out.println("You're too heavy dude! Inventory is full! maxWeight = "+maxWeight);
                    System.out.println("Do you want delete a item ? (n/y)");
                    Scanner keyboard = new Scanner(System.in);
                    String answer = keyboard.nextLine();
                    if(answer.equals("y")){
                        System.out.println(" Which item ? ");
                        printInventory();
                        System.out.println("enter the name of item :");
                        Scanner keyboard2 = new Scanner(System.in);
                        String answer2 = keyboard2.nextLine();
                        deleteItem(answer2);
                    }
                }
            }
        }
        if (!exist){
            System.out.println("This item does not exist, check your spelling!");
        }
    }
    
    /*
     * delete an item from the inventory
     */
    public void deleteItem (String name)
    {
        if (getInventItem(name)){
            for (int i = 0;i<inventory.size();i++){
                Item currentItem = inventory.get(i);
                if(currentItem.getName().equals (name)){            
                    inventory.remove(currentItem);
                    inventoryWeight -= currentItem.getWeight();
                    System.out.println("Item deleted");
                }
            }
        }
        else{
            System.out.println("You can't delete an item that you don't have!");
        }
    }
    
    /*
     * Use an Item
     */
    public void useItem (String name)
    {
        //répercute les effets des items sur les stats du joueur
        deleteItem(name);
    }
    
    /*
     * Search for an item in the players inventory
     */
    public static boolean getInventItem(String name)
    {
        for (int i = 0;i<inventory.size();i++){
            Item currentItem = inventory.get(i);
            if(currentItem.getName().equals (name)){
                return true;
            }
        }
        return false;
    }
    
        /*
     * print the description of the item, if the item is not referenced, print an error
     */
    public static void getItemDescription (String name)
    {
        for (int i=0;i<inventory.size();i++){
            Item currentItem = inventory.get(i);
            if (currentItem.getName().equals (name)){
                System.out.println(currentItem.getDescription());
                return;
            }
        }
        System.out.println("This item doesn't seems to exist, at least not in your inventory!");
    }
      
}

