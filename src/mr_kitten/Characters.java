/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mr_kitten;

/**
 *
 * @author Noëmie
 */
public class Characters {
    
    //Declare attribut of characters class
    private String name;
    private int ennemiHP;
    private int ennemiAD;
    private String talk;
    private String room;
    
    /**
     * Constructor of class
     * @param n
     * @param hp
     * @param ad
     * @param t
     * @param r 
     */
    public Characters(String n, int hp, int ad, String t, String r){
        name=n;
        ennemiHP=hp;
        ennemiAD=ad;
        talk=t;
        room=r;
    }
    
    /**
     * Get name of characterss
     * @return 
     */
    public String getName(){
        return name;
    }
    
    /**
     * Get ennemi HP
     * @return 
     */
    public int getEnnemiHP(){
        return ennemiHP;
    }
    
    /**
     * Get ennemi AD
     * @return 
     */
    public int getEnnemiAD() {
        return ennemiAD;
    }
    
    /**
     * Get talk of character
     * @return 
     */
    public String getTalk() {
        return talk;
    }
    
    /**
     * Get room of character
     * @return 
     */
    public String getRoom() {
        return room;
    }
    
}
