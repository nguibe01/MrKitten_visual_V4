package mr_kitten;


import java.util.Random;
import java.util.*;
import java.io.*;
import java.awt.*;

/**
 *  This class is the main class of the "World of Zuul" application. 
 *  "World of Zuul" is a very simple, text based adventure game.  Users 
 *  can walk around some scenery. That's all. It should really be extended 
 *  to make it more interesting!
 * 
 *  To play this game, create an instance of this class and call the "play"
 *  method.
 * 
 *  This main class creates and initialises all the others: it creates all
 *  rooms, creates the parser and starts the game.  It also evaluates and
 *  executes the commands that the parser returns.
 * 
 * @author  Michael Kolling and David J. Barnes
 * @version 2006.03.30
 */

public class Game 
{
    private Parser parser;
    protected Room currentRoom;
    Players MrKitten;
    private static ArrayList<Item> items;
    private ArrayList<Characters> characters;
    String nLine=System.getProperty("line.separator"); //Allow to make a new line
    String ennemi;
    int ennemiHP;
    int ennemiAD;
    boolean nextQuestion;
    String sewer;
    /**
     * Create the game and initialise its internal map.
     */
    public Game() 
    {
        items = new ArrayList<Item>();
        characters = new ArrayList<Characters>();
        MrKitten = new Players("Mr.Kitten");
        parser = new Parser();
        createRooms();
        createItems();
        createCharacters();
        ennemi=("");
        ennemiHP=0;
        ennemiAD=0;
        nextQuestion=false;
        sewer=("");
     }
    
    /**
     * Get the boolean of next question
     */
    public boolean getNextQuestion()
    {
        return nextQuestion;
    }
    
    /**
     * Set the boolean of next question
     */
    
    public void setNextQuestion(boolean newB){
        nextQuestion = newB;
    }
    
    /**
     * Get the name of ennemi during the fight
     */
    public String getEnnemi(){
        return ennemi;
    }
    /**
     * Set the name of ennemi during the fight
     */
    public void setEnnemi(String newEnnemi){
        ennemi=newEnnemi;
    }
    /**
     * Get the ennemiHP during the fight
     */
    public int getEnnemiHP(){
        return ennemiHP;
    }
    /**
     * Set the ennemiHP during the fight
     */
    public void setEnnemiHP(int newEnnemiHP){
        ennemiHP=newEnnemiHP;
    }
    /**
     * Get ennemiAD during the fight
     */
    public int getEnnemiAD(){
        return ennemiAD;
    }
    /**
     * Set the name of ennemi during the fight
     */
    public void setEnnemiAD(int newEnnemiAD){
        ennemiAD=newEnnemiAD;
    }
    /**
     * Getter to access list of items and list of characters
     * @return 
     */
    public static ArrayList<Item> getListItem(){
        return items;
    }
    
    /**
     * Get the list of character of game
     * @return 
     */
    public ArrayList<Characters> getListCharacters(){
        return characters;
    }
    
    /**
     * Get the player of game : Mr.Kitten
     * @return 
     */
    public Players getPlayers(){
        return MrKitten;
    }
    
    /**
     * Get the current room of game
     * @return 
     */
    public Room getRoom(){
        return currentRoom;
    }
    
    /**
     * Create all the rooms and link their exits together.
     */
    private void createRooms()
    {
        //Declare rooms;
        Room kitchen,livingRoom,bedroom,street1,street2,sewer,petshop,harbor,theGreatDescent,dory,theFishPalace;
        Room tavernSanRicardo,starWars,theCloset,theEnd;
                
        kitchen = new Room ("You are in the Kitchen of the Master's house","kitchen","\\kitchen.png");
        livingRoom = new Room ("You are in the Living room of the Master's house","livingRoom","\\livingroom.png");
        bedroom = new Room ("You are in the Bedroom of the Master's house","bedroom","\\bedroom.png");
        street1 = new Room ("You are in the Street near the entrance of the house","street1","\\street.png");
        street2 = new Room ("You are in the Street near the Petshop","street2","\\street.png");
        sewer = new Room ("You are in the Sewer under the streets","sewer", "\\sewer.png");
        petshop = new Room ("You are in the Petshop","petshop","\\petshop.png");
        //harbor = new Room ("are on the city's harbor", "harbor","harbor");
        theGreatDescent = new Room ("You are going deep down under water","theGreatDescent","\\underwater.png");
        dory = new Room ("You are with Dory the great fish","dory","\\seareef.png");
        theFishPalace = new Room ("You are in the Fish Palace","theFishPalace","\\fishpalace.png");
        tavernSanRicardo = new Room ("You are in the magnificient Tavern Of San Ricardo","tavernSanRicardo","\\artworkTavern.png");
        starWars = new Room ("You are in a Galaxy far far away...","starWars","\\starwars.png");
        theCloset = new Room ("You are ready to fight with lions","theCloset","\\narnia.png");
        theEnd = new Room ("You did it, you did it, Yeah!","theEnd","\\nyancat.png");
        
        //Declare doors and key
        Door doorKLr = new Door(livingRoom,kitchen); kitchen.addExit("east", doorKLr); livingRoom.addExit("west",doorKLr); 
        Door doorBLr = new Door (bedroom, livingRoom); livingRoom.addExit("east",doorBLr); bedroom.addExit("west",doorBLr);
        Item keyLivingStreet = new Item("home key", "this key opens the door to exit the master's house",0);
        LockedDoor doorS1Lr = new LockedDoor (keyLivingStreet, street1, livingRoom); livingRoom.addExit("south",doorS1Lr);street1.addExit("north",doorS1Lr);
        Door doorS2S1 = new Door (street2, street1);street1.addExit("east",doorS2S1); street2.addExit("west",doorS2S1);
        Door doorSS1 = new Door (sewer, street1);street1.addExit("down",doorSS1);sewer.addExit("up",doorSS1);
        Door doorPS2 = new Door (petshop, street2);street2.addExit("south",doorPS2);petshop.addExit("north",doorPS2);
        Door doorSS2 = new Door (sewer, street2);street2.addExit("down",doorSS2);sewer.addExit("up",doorSS2);
        Door doorGdP = new Door (theGreatDescent, petshop);petshop.addExit("down", doorGdP);theGreatDescent.addExit("up",doorGdP);
        //Door door HP = new Door (harbor, petshop);petshop.addExit("down", doorHP);harbor.addExit("up", doorHP);
        Door doorDGd = new Door (dory, theGreatDescent);theGreatDescent.addExit("west",doorDGd); dory.addExit("east",doorDGd);
        Door doorFpGd = new Door (theFishPalace, theGreatDescent);theGreatDescent.addExit("down",doorFpGd);theFishPalace.addExit("up",doorFpGd);
        Item keyFishTavern = new Item ("blue key","This key opens the door between the fish palace and the San Ricardo tavern",0);
        LockedDoor doorFpTsr = new LockedDoor (keyFishTavern, theFishPalace, tavernSanRicardo);tavernSanRicardo.addExit("north", doorFpTsr); theFishPalace.addExit("south", doorFpTsr);
        Door doorSwTsr = new Door (starWars, tavernSanRicardo);tavernSanRicardo.addExit("up", doorSwTsr); starWars.addExit("down",doorSwTsr);
        Door doorCSw = new Door (theCloset,starWars);starWars.addExit("east",doorCSw);theCloset.addExit("west",doorCSw);
        Door doorEC = new Door (theEnd, theCloset);theCloset.addExit("south", doorEC);
        
        currentRoom = livingRoom;  // start game in master's house
    }

    /*
     * Create all the items in the game
     */
    private void createItems()
    {
        //Declare item
        Item potionCareMin = new Item ("potionCareMin","This potion heals you for a small amount of your health",5);
        Item potionCareMax = new Item ("potionCareMax","This potion heals you for a big amount of your health",25);
        Item potionCareMean = new Item("potionCareMean","This potion heals you for a medium amount of your health",20);
        Item algea = new Item ("algea", "This algae has revitalizing properties. It can heal wounds and restore a medium amount of your health.", 10); //A COMPLETER
        Item potionBonus = new Item("potionBonus", "This potion heals you for a big amount of your health", 25); //A COMPLETER
        Item superBite = new Item ("superBite","It's sharp and ready to rip your opponents' heads off",10);
        Item superPiss = new Item ("superPiss","Wow it's dirty",8);
        Item puppyEyes = new Item ("puppyEyes", "Use this look to charm anyone", 13);
        Item laserTail = new Item ("laserTail", "May the catnip be with you, young Catawan.", 20);
        Item artefactOfTrueVision = new Item ("Artefact Of True Vision","With this mask you'll be able to see everything! In green tho... but that's cool!",10);
        
        //Add item in the list of items
        items.add(artefactOfTrueVision);
        items.add(potionCareMin);
        items.add(potionCareMax);
        items.add(potionCareMean);
        items.add(algea);
        items.add(potionBonus);
        items.add(superBite);
        items.add(superPiss);
        items.add(puppyEyes);
        items.add(laserTail);
        Item keyLivingStreet = new Item("home key", "this key opens the door to exit the master's house",0);
        items.add(keyLivingStreet);
        Item keyFishTavern = new Item ("blue key","This key opens the door between the fish palace and the San Ricardo tavern",0);
        items.add(keyFishTavern);
    }
    
    /**
     * Create all characters in the game
     */
    public void createCharacters() {
        //Declare character
        Characters goldFish = new Characters("Gold Fish", 10, 3,"Blub blub blub blob. Please don't kill me.", "livingRoom");
        Characters garfield = new Characters("Garfield", 30, 5,"...", "street1");
        Characters strayCat = new Characters("strayCat", 20, 5,"...", "street2");
        Characters splinter = new Characters("Splinter", 25, 15,"niark niark niark", "sewer");
        Characters dory = new Characters("Dory", 25, 5,"Blablablabla", "dory");//A COMPLETER
        Characters ratatouille = new Characters("Ratatouille", 20, 5,"...", "petshop");
        Characters mrRobot = new Characters("Mr.Robot", 40, 25,"", "petshop");
        Characters shark = new Characters("Sharks", 20, 10,"...", "theGreatDescent");//A COMPLETER;;;
        Characters darkMoule = new Characters("Dark Moule", 35, 20, "...", "theFishPalace");
        Characters pussInBoots = new Characters("Puss in boots", 25, 15,"...", "tavernSanRicardo");
        Characters darkVador = new Characters("Dark Vador", 40, 25,"Shhhh...Shhhh...Are you a rebel? You look like a strange Ewok..."
                + "Anyway, no one can enter a colonized planet like this! I will execute you!", "star wars");//A COMPLETER
        Characters brother = new Characters("Brother", 50, 30,"...", "theEnd");
        
        //Add character in the list of character
        characters = new ArrayList<Characters>();
        characters.add(goldFish);
        characters.add(garfield);
        characters.add(strayCat);
        characters.add(splinter);
        characters.add(dory);
        characters.add(ratatouille);
        characters.add(mrRobot);
        characters.add(shark);
        characters.add(darkMoule);
        characters.add(pussInBoots);
        characters.add(darkVador);
        characters.add(brother);
    }
    
    /**
     *  Main play routine.  Loops until end of play.
     */
    public void play() 
    {            
        printWelcome();

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.
        boolean finished = false;
        while (! finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Thank you for playing.  Good bye.");
    }
    
    /**
     * Print out the opening message for the player.
     */
    private void printWelcome()
    {
        System.out.println();
        System.out.println("Welcome to the World of Zuul!");
        System.out.println("World of Zuul is a new, incredibly boring adventure game.");
        System.out.println("Type 'help' if you need help.");
        System.out.println();
        System.out.println("You are " + currentRoom.getDescription());
        currentRoom.printExits();
    }

    /**
     * Given a command, process (that is: execute) the command.
     * @param command The command to be processed.
     * @return true If the command ends the game, false otherwise.
     */
    private boolean processCommand(Command command) 
    {
        boolean wantToQuit = false;

        if(command.isUnknown()) {
            System.out.println("I don't know what you mean...");
            return false;
        }

        String commandWord = command.getCommandWord();
        if(commandWord.equals("help")){
            printHelp();
        }    
        else if(commandWord.equals("go")){
            goRoom(command);
        }    
        else if(commandWord.equals("quit")){
            wantToQuit = quit(command);
        }
        else if(commandWord.equals("look")){
            lookRoom(command);
        }
        else if(commandWord.equals("fight")){
            fightPeople();
        }
        else if(commandWord.equals("talk")){
            talkRoomPeople();
        }
        else if(commandWord.equals("explore")){
            exploreRoom();
        }
        else if(commandWord.equals("inventory")){
            //inventory();
        }
        return wantToQuit;
    }

    // implementations of user commands:

    /**
     * Print out some help information.
     * Here we print some stupid, cryptic message and a list of the 
     * command words.
     */
    protected String printHelp() 
    {
        String help = ("You are lost. You are alone. You wander around\n"
                + "\n Your command words are:"
                + "\n explore -- explore the room and realize actions"
                + "\n items   -- it's your inventory"
                + "\n look    -- identify your location");
        return help;
        /*System.out.println("You are lost. You are alone. You wander");
        System.out.println("around.");
        System.out.println();
        System.out.println("Your command words are:");
        System.out.println("   go quit fight talk explore inventory help  ");
        System.out.println("go + direction -- deplace in the map");
        System.out.println("quit -- quit the game");
        System.out.println("talk -- speak with a characters");
        System.out.println("fight -- fight a characters");
        System.out.println("explore -- explore the room and realize actions");
        System.out.println("inventory -- print your inventory of item");*/
    }
    
    /** 
     * Try to go to one direction. If there is an exit, enter
     * the new room, otherwise print an error message.
     */
    protected void goRoom(Command command) 
    {
        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Go where?");
            return;
        }

        String direction = command.getSecondWord();
        
        // Try to leave current room.
        Door nextDoor = currentRoom.getNextRoom(direction);
        //If the door is locked
        if (nextDoor instanceof LockedDoor){
            LockedDoor l = (LockedDoor)nextDoor;
            currentRoom = l.openLockedDoor(MrKitten.getInventory(),currentRoom);
            System.out.println("You "+currentRoom.getDescription());
            currentRoom.printExits();
        }
        else{
        try{
            Room nextRoom = nextDoor.getRoom(currentRoom);
            currentRoom = nextRoom;
            System.out.println("You " + currentRoom.getDescription());
            currentRoom.printExits();
        }
        catch (Exception e){
            System.out.println("Wrong direction!");
            System.out.println("You " + currentRoom.getDescription());
            System.out.println("You can go :");
            currentRoom.printExits();
        }
    }
    }

    /** 
     * "Quit" was entered. Check the rest of the command to see
     * whether we really quit the game.
     * @return true, if this command quits the game, false otherwise.
     */
    private boolean quit(Command command) 
    {
        if(command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        }
        else {
            return true;  // signal that we want to quit
        }
    }
    
    /**
     * Get the current room of the game
     * @return 
     */
    public Room getCurrentRoom()
    {
        return currentRoom;
    }
    
    /*
     * You can look into the room to see the description of the room or to describe an item
     */
    private void lookRoom(Command command)
    {
        if(!command.hasSecondWord()) {
            // if there is no second word, we describe the current room 
            System.out.println(currentRoom.getDescription());
            currentRoom.printExits();
        }
        else {
            String itemName = command.getSecondWord();
            Players.getItemDescription(itemName);
        }
    }
  
    private String giveChoice (){
        String choice = ("What would you like?");
        return choice;   
    }
    private String printPiss (){
        String piss = ("a - superPiss");
        return piss;
    }
    private String printBite(){
        String bite = (" b - superBite");
        return bite;
    }
    private String printEyes(){
        String eyes = (" c- puppyEyes");
        return eyes;
    }
    private String printTail(){
        String tail = (" d - laserTail");
        return tail;
    }
    private String wantChoice(){
        String charac = ("Enter the character please");
        return charac;
    }
    private String madeTypo(){
        String typo = ("What the hell did you just say? You are fighting, you take damage");
        return typo;
    }
    private String noPower(){
        String no = ("You do not have any special attack");
        return no;
    }
    private String noCharac(){
        String nobody = ("There is no character in this room");
        return nobody;
    }
    private String infoKitten(){
        String HPKitten =("    *********   \n"
                + "Mr.Kitten's HP =");
        return HPKitten;
    }
    private String infoEnnemi(){
        String HPEnnemi=("\nEnnemi's HP=");
        return HPEnnemi;
    }
    private int giveMrKittenHP(){
        int HP = MrKitten.getPlayerHP();
        return HP;
    }
    private int giveEnnemiHP(){
        int eHP = Characters.getEnnemiHP();
        return eHP;
    }
    private String choiceAttack(){
        String whatatt = ("    *********   \n"
                + " What would you like ? \n"
                + " a - attack \n"
                + " b - special attack \n"
                + " c - items");
        return whatatt;
    }
    private String winMsg(){
        String win = ("You win! Your HP are now ");
        return win;
    }
    private String msgLoose(){
        String loose = ("You loose !! GAME OVER !!");
        return loose;
    }
    private String noItem(){
        String nothing = ("You do not have any healing item");
        return nothing;
    }
    private String poMin(){
        String poMin = (" a - potionCareMin (+30 HP)");
        return poMin;
    }
    private String poMax(){
        String poMax = (" b - potionCareMax (+120 HP)");
        return poMax;
    }
    private String poMean(){
        String poMean = (" c - potionCareMean (+60 HP)");
        return poMean;
    }
    private String alg(){
        String algae = (" d - algae (+35 HP)");
        return algae;
    }
    private String poBonus(){
        String poBo = (" e - potionBonus (+100 HP)");
        return poBo;
    }
    private String whatItem(){
        String it = ("Which item do you want to use?");
        return it;
    }
    /*
     * You can fight peoples in the current room  
     */
    private void fightPeople()
    { 
        //Recup data
        String ennemi = "";
        int ennemiHP=0;
        int ennemiAD=0;
        boolean charactersFind = false;
        for (int i = 0;i<characters.size();i++){
            Characters currentChar = characters.get(i);
            if (currentChar.getRoom().equals(currentRoom.getName())) {
                ennemi = currentChar.getName();
                ennemiHP = currentChar.getEnnemiHP();
                ennemiAD = currentChar.getEnnemiAD();
                charactersFind = true;
                break;
            }
        }  
        //Check if there is a character in the current room
        if (charactersFind == false) {
            noCharac();
        }
        else {
            //Start the figth
            if (ennemi.equals("mrRobot")){
                Actors.mrRobotDialog();
            }
            int MrKittenHP = MrKitten.getPlayerHP();
            System.out.println("Mr Kitten VS "+ ennemi);
            while (MrKittenHP>0 && ennemiHP>0){
                    infoKitten();
                    giveMrKittenHP();
                    infoEnnemi();
                    giveEnnemiHP();
                    choiceAttack();
                    wantChoice();
                    Scanner keyboard = new Scanner(System.in);
                    String answer = keyboard.nextLine();
                    //Choose a type of attack
                    switch (answer){
                        case "a": {
                            ennemiHP=attack(ennemiHP);
                            };break;
                        case "b": {
                            ennemiHP=specialAttack(ennemiHP);
                            };break;
                        case "c": {
                            MrKittenHP=itemsAttack(MrKittenHP);
                            };break;
                        default:  madeTypo(); break;
                    }
                //Ennemi attack the player
                if(ennemiHP >0){
                    Random nbRd = new Random();
                    int nextnb = nbRd.nextInt(ennemiAD)+1;
                    MrKittenHP =  MrKittenHP - nextnb;
                }
            }
            //Check if there is a winner
            if (ennemiHP <= 0){
                winMsg();
                giveMrKittenHP();
                //Players.setPlayerHP(MrKittenHP);
            }else {
                msgLoose();
                System.exit(1);              
            }
        }
    }
    
    /**
     * Reduce ennemi HP by a normal attack
     */
    public int attack (int ennemiHP)
    {
        Random nbRd = new Random();
        int nextnb = nbRd.nextInt(7)+1;
        ennemiHP = ennemiHP - nextnb;
     
        return ennemiHP;
    }
   
    /**
     * Choose a special attack
     */
    private int specialAttack(int ennemiHP)
    {
        boolean specialAttack = false;
        giveChoice();
        //Print different attack
        for (int i = 0;i<MrKitten.getInventory().size();i++){
            Item currentItem = MrKitten.getInventory().get(i);
            if (currentItem.getName().equals("superPiss")){
                printPiss();
                specialAttack = true;
            }
            if (currentItem.getName().equals("superBite")){
                printBite();
                specialAttack = true;
            }
            if (currentItem.getName().equals("puppyEyes")){
                printEyes();
                specialAttack = true;
            }
            if (currentItem.getName().equals("laserTail")){
                printTail();
                specialAttack = true;
            }
        }
        if(specialAttack == true){
            //Choose the special attack
            wantChoice();
            Scanner keyboard = new Scanner(System.in);
            String answer = keyboard.nextLine();
            switch (answer){
                case "a": {
                    ennemiHP=ennemiHP-15;
                };break;
                case "b": {
                    ennemiHP=ennemiHP-20;
                };break;
                case "c": {
                    ennemiHP=ennemiHP-25;
                };break;
                case "d": {
                    ennemiHP=ennemiHP-30;
                };break;
                default:  madeTypo(); break;
            }
        }else {
            noPower();
        }
        return ennemiHP;
    }
    
    /**
     * Chosse an items in your inventory
     */
    private int itemsAttack(int playerHP)
    {
        boolean itemsAttack = false;
        whatItem();
        //Print items
        for (int i = 0;i<MrKitten.getInventory().size();i++){
            Item currentItem = MrKitten.getInventory().get(i);
            if (currentItem.getName().equals("potionCareMin")){
                poMin();
                itemsAttack = true;
            }
            if (currentItem.getName().equals("potionCareMax")){
                poMax();
                itemsAttack = true;
            }
            if (currentItem.getName().equals("potionCareMean")){
                poMean();
                itemsAttack = true;
            }
            if (currentItem.getName().equals("algea")){
                alg();
                itemsAttack = true;
            }
            if (currentItem.getName().equals("potionBonus")){
                poBonus();
                itemsAttack = true;
            }
        }
        if(itemsAttack == true){
            //Choose items
            wantChoice();
            Scanner keyboard = new Scanner(System.in);
            String answer = keyboard.nextLine();
            switch (answer){
                case "a": {
                    playerHP=playerHP+30;
                    MrKitten.useItem("potionCareMin");
                };break;
                case "b": {
                    playerHP=playerHP+120;
                    MrKitten.useItem("potionCareMax");
                };break;
                case "c": {
                    playerHP=playerHP+60;
                    MrKitten.useItem("potionCareMean");
                };break;
                case "d": {
                    playerHP=playerHP+35;
                    MrKitten.useItem("algea");
                };break;
                case "e": {
                    playerHP=playerHP+100;
                    MrKitten.useItem("potionBonus");
                };break;
                default:  madeTypo(); break;
            }
            //PlayerHP max = 120 
            if(playerHP >120){
                playerHP = 120;
            }
        }else{
            System.out.println("You have no items to care...");
        }
        return playerHP;
    }
   
    /*
     * You can fight peoples in the current room in SWING interface 
     */
    public void recupDataPeople(Interface in){
        //Recup data of ennemi in the curent room
        for (int i = 0;i<characters.size();i++){
            Characters currentChar = characters.get(i);
            if (currentChar.getRoom().equals(currentRoom.getName())) {
                setEnnemi(currentChar.getName());
                setEnnemiHP(currentChar.getEnnemiHP());
                setEnnemiAD(currentChar.getEnnemiAD());
                break;
            }
        }  
    }
    public void fightPeopleIN(Interface in) 
    { 
            //Start the figth
            if (ennemi.equals("mrRobot")){
                sewer=Actors.mrRobotDialog()+" \n";
            }
            sewer=sewer+("\n Mr Kitten VS "+ ennemi+" \n");
            in.jTextArea1.setText(sewer);
            //while (MrKitten.getPlayerHP()>0 && ennemiHP>0){
                    //Choose type of attack
                    sewer=sewer+("\n    *********   \n"
                            +"\n Mr.Kitten's HP = "+MrKitten.getPlayerHP()+" \n"
                            +"\n "+ennemi+"'s HP = "+ennemiHP+" \n"
                            +"\n    *********   \n"
                            +"\n What would you like ? \n"
                            +"\n    a - attack \n"
                            +"\n    b - special attack \n"
                            +"\n    c - items \n"
                            +"\n Choose the character please :");
                    in.jTextArea1.setText(sewer);
                    in.jButtonA.setVisible(true);
                    in.jButtonB.setVisible(true);
                    in.jButtonC.setVisible(true);
    }               
     
    /**
     * Talk people
     */
    private void talkRoomPeople(){
        if (currentRoom.getName().equals("dory")){
            System.out.println("DORY :");
            Actors.doryDialog_intro();return;
        }
        else if (currentRoom.getName().equals("petshop")){
            System.out.println("RED FISH :");
            Actors.redFishDialog();return;
        }
        else {
            for (int i=0;i < characters.size();i++){
                Characters currentChar = characters.get(i);
                if (currentChar.getRoom().equals(currentRoom.getName())){
                    System.out.println(currentChar.getName()+":");
                    System.out.println(currentChar.getTalk());return;
                }
            }
        }
    }
    
    /**
     * Explore different room with interface
     * @param in 
     */
    public void exploreRoomTest(Interface in){
        int MrKittenHP = MrKitten.getPlayerHP();
        switch(currentRoom.getName()){
            //quest from living room
            case "livingRoom" :
                in.jTextArea1.setText(ExpInfo.printlivingRoom_intro());
                in.jButtonA.setVisible(true);
                in.jButtonB.setVisible(true);
                break;
            //quest from kitchen
            case "kitchen" :
                in.jTextArea1.setText(ExpInfo.printKitchen_intro());
                in.jButtonA.setVisible(true);
                in.jButtonB.setVisible(true);
                break;
            //quest from bedroom
            case "bedroom" : 
                in.jTextArea1.setText(ExpInfo.printbedroom_intro());
                in.jButtonA.setVisible(true);
                in.jButtonB.setVisible(true);
                in.jButtonC.setVisible(true);
                in.jButtonD.setVisible(true);
                break;
            //quest from street1
            case "street1" :
                in.jTextArea1.setText(ExpInfo.printStreet1_intro());
                in.jButtonA.setVisible(true);
                in.jButtonB.setVisible(true);
                break;
            //quest from street 2
            case "street2" :
                in.jTextArea1.setText(ExpInfo.printStreet2_intro());
                in.jButtonA.setVisible(true);
                in.jButtonB.setVisible(true);
                break;
            //quest from sewer
            case "sewer" :
                //in.jTextArea1.setText(ExpInfo.printSewer_intro());
                recupDataPeople(in);
                fightPeopleIN(in);
                in.Explore.setVisible(false);
                in.Help.setVisible(false);
                in.Look.setVisible(false);
                in.Items.setVisible(false);
                //in.next.setVisible(true);
                //Se battre contre le rat, si victoire lancer la suite
                //in.jTextArea1.setText(ExpInfo.printSewer_conclu());//ça c'est la suite
                //ajout de l'item super piss
                //MrKitten.grabItem("superPiss");
                break;
            //quest from petshop
            case "petshop" :
                in.jTextArea1.setText(ExpInfo.printPetshop_intro());
                in.jButtonA.setVisible(true);
                in.jButtonB.setVisible(true);
                break;
            //quest from the Great descent    
            case "theGreatDescent" :
                in.jTextArea1.setText(ExpInfo.printgreatdescent_intro());
                break;
            //quest dory
            case "dory" : 
                in.jTextArea1.setText(ExpInfo.printdory_intro());
                in.jButtonA.setVisible(true);
                in.jButtonB.setVisible(true);
                in.jButtonC.setVisible(true);
                in.jButtonD.setVisible(true);
                break;
            //quest from the Fish palace
            case "theFishPalace" : //manque la partie end après le combat
                in.jTextArea1.setText(ExpInfo.printfishpalace_intro());
                in.jButtonA.setVisible(true);
                in.jButtonB.setVisible(true);
                break;
            //quest from tavern san ricardo
            case "tavernSanRicardo" : //manque la partie end après le combat
                in.jTextArea1.setText(ExpInfo.printtavern_intro());
                MrKitten.grabItem("puppyEyes");
                break;
            //quest from star wars
            case "starWars" : 
                in.jTextArea1.setText(ExpInfo.printvador_intro());
                in.jButtonA.setVisible(true);
                in.jButtonB.setVisible(true);
                break;
            //quest from the closet
            case "theCloset" : 
                in.jTextArea1.setText(ExpInfo.printcloset_intro());
                break;
            //quest from the end
            case "theEnd" : 
                in.jTextArea1.setText(ExpInfo.printend_intro());
                in.jButtonA.setVisible(true);
                in.jButtonB.setVisible(true);
                break;
            default : in.jTextArea1.setText("Just... how??"); 
            break;
        }
    }
    
    /**
     * Explore room with console game
     * @return 
     */
    public String exploreRoom(){
        String answer;
        int MrKittenHP = MrKitten.getPlayerHP();
        Scanner keyboard = new Scanner(System.in);
        switch(currentRoom.getName()){
            case "livingRoom" :
                return ExpInfo.printlivingRoom_intro();
//                System.out.println("This couch is where the master always crashes... Let's do something!");
//                System.out.println("Destroy the couch?");
//                System.out.println("    a - Yes he deserves it!");
//                System.out.println("    b - No! I may be a little dizzy but I won't turn crazy today!");
//                System.out.println("Enter the character please :");
                /*  answer = keyboard.nextLine();
                if (answer.equals("a")){
                    ExpInfo.printlivingRoom_answerA();
//                    System.out.println("You totaly nailed it! But you noticed that a key droped on the floor... What could it be?!");
                    MrKitten.grabItem("home key");
                }
                else {
                    ExpInfo.printlivingRoom_answerB();
//                    System.out.println("Pussycat! Without some balls you won't go to any places!");
                }
               // try {
              //      Thread.sleep(2000);
              //  }
             //   catch (Exception e) {
              //      ExpInfo.printanswerError();
//                    System.out.println("Bizarre que ça marche pas...");
              //  }
//                System.out.println("Need to do something else...");
//                System.out.println("Oh! A goldfish! Seems tasty...");
//                System.out.println("Eat it?");
//                System.out.println("    a - Yes!");
//                System.out.println("    b - With a bit of mayonnaise... What could happen?");
//                System.out.println("Enter the character: ");
               ExpInfo.printlivingRoom_conclu();
                answer = keyboard.nextLine();//Not usefull since he doesn't really have any choice
//                System.out.println("Hum... Yum!");*/
                   //break;
            case "kitchen" :
                ExpInfo.printKitchen_intro();
                /*System.out.println ("Best place of the world for all cordon bleu. Their is always something to eat.");
                System.out.println("It's smelling cooking food ! The kitchen table is probably full of food.");
                System.out.println("Do you want jump on the kitchen table ?");
                System.out.println("    a - Oh god YES ! I'm hungry guys !");
                System.out.println("    b - No, it's better on the kitchen cupboard");
                System.out.println("Enter the character please :");*/
                String answer_kitchen = keyboard.nextLine();
                if (answer_kitchen.equals("a")){
                    ExpInfo.printKitchen_answerA();
                    //System.out.println("Oohh, you're sad :( Their is only the half salt butter but it work. You eat it and gain 25 hp !");
                    MrKittenHP =MrKittenHP +25;  
                    //Players.setPlayerHP(MrKittenHP);
                }
                else {
                    ExpInfo.printKitchen_answerB();
                    //System.out.println("Jackpot ! A cooked fish is on this cupboard. You eat it and gain 50 hp !");
                     MrKittenHP =MrKittenHP +50;
                    //Players.setPlayerHP(MrKittenHP);
                }
                if(MrKittenHP >120){
                    MrKittenHP = 120;
                    //Players.setPlayerHP(MrKittenHP);
                }
                break;
                
            case "bedroom" : 
                ExpInfo.printbedroom_intro();
//                System.out.println ("The master isn't here. It's a great opportunity to discover this unknow room."
//                        +nLine+"Their is soo many things to play with, you can't wait to act with :"
//                        +nLine+"a - The bed: A nice castle for a super cat like me and a beautifull pillow with feathers;"
//                        +nLine+"b - The chest of drawers: I will improve my climbing skill and i could roll out some ball;"
//                        +nLine+"c - The library: So many books well ordered, a great slalom to improve my dexterity;"
//                        +nLine+"d - The new chair: I could mad my claws and relax myself. ");
//                System.out.println("Enter the character please :");
                String answer_bedroom = keyboard.nextLine();
                if (answer_bedroom.equals("a")){
                    ExpInfo.printbedroom_answerA();
//                    System.out.println("Oohh, you're so exited to play in your castle and after ripped the pillow you eat accidently a feather. You loose 5 hp.");
                    MrKittenHP =MrKittenHP -5;  
                    //Players.setPlayerHP(MrKittenHP);
                }
                else if (answer_bedroom.equals("b")){
                    ExpInfo.printbedroom_answerB();
//                    System.out.println("It's not easy to reach the chest. You're on the top but drawers are locked with a key. Nothing else !");
                }
                else if (answer_bedroom.equals("c")){
                    ExpInfo.printbedroom_answerC();
//                    System.out.println("You're climbing the library unfortunately you're falling but a pillow soften this fall. Are you enought brave to retry ?"
//                           +nLine+"     a- No thanks, it's too dangerous !"
//                           +nLine+"     b- YES !! I can prove my bravery. I'm not a defeatist ! (The Game company isn't responsable if a accidental death occur !)");
//                    System.out.println("Enter the character please :");
                    String answer_bedroom_library = keyboard.nextLine();
                    if (answer_bedroom_library.equals("a")){
                        ExpInfo.printbedroom_answerCa();
//                        System.out.println("It's a choice like a other. Go explore new universe !!!");
                    }
                    else {
                        ExpInfo.printbedroom_answerCb();
//                        System.out.println("It's so incredible fantastical unbelievable AMAZING!!! You successfuly perform to climb the librairy but at the last shelf you dropped a book."
//                            +nLine+"This book doesn't look like a common book. Its covered in dust. The front cover represent a head's cat. You decid to back down."
//                            +nLine+"The mysterious book is opening in front of you. Its is surprinsing what you find inside ... "
//                            +nLine+"All words, sentences and pictures are understandable. And you're discovering amazing story about cats."
//                            +nLine+"<< Once upon a time, from down the Marianne's Abysses to the top of Mt Everest, the ancient Cat race was known to be wise and powerful."
//                            +nLine+"   Theirs radiance used to spread on the whole world. [...]"
//                            +nLine+"   One day a young kitten will come and will be the new leader of a new age. His mission is to bring back the Cat empire at this optimal expansion !"
//                            +nLine+"   But a essential artefact is necessary to do that : the legendary guillotine. Its bring back the power to all cats !!! >>"
//                            +nLine+"At the end of this book you notice a old post-it which make reference to a fat cat with lot of knowledge. This post-it is signed by a cat paw and a little sentence :"
//                            +nLine+"<< I will destroy the world as promice dad ! >>"
//                            +nLine+" "
//                            +nLine+"Are you enought honnest and nice to be this little kitten ?"
//                            +nLine+"However this ! You must defend and re-establish the cat world and protect his again his destruction by this mysterious cat !!!"); 
                    }
                }
                else if (answer_bedroom.equals("d")){
                    ExpInfo.printbedroom_answerD();
//                    System.out.println("You're taking a snap. Nothing else happen. Let's go explore news horizons !");
                }
                    if(MrKittenHP <0){
                        ExpInfo.printdeathMessage();
//                        System.out.println("You loose !! GAME OVER !!");
                        System.exit(1); 
                    }  
            break;
            case "street1" :
                ExpInfo.printStreet1_intro();
                /*System.out.println("You look around you and see a big old cat on the street, coming toward you.");
                System.out.println("He looks friendly and comes near you.");
                System.out.println("You may want to talk to him");
                System.out.println("There is also a garbage can over here, it smells delicious...");
                System.out.println("What do you want to do?");
                System.out.println("    a - talk to the cat");
                System.out.println("    b - explore the garbage can");
                System.out.println("Enter the character please :");*/
                answer = keyboard.nextLine();
                if (answer.equals("a")){
                    //Actors.garfieldDialog();  
                    ExpInfo.printStreet1_answerA();
                }
                else if (answer.equals("b")){
                    //System.out.println("You found a healing potion! That might be useful...");
                    ExpInfo.printStreet1_answerB();
                    MrKitten.grabItem("potionCareMin");
                }
                break;
            case "street2" :
                ExpInfo.printStreet2_intro();
                /*System.out.println("Here you are! Back in the light!");
                System.out.println("There is another garbage can! Sounds like you are going to make a good deal again!");
                System.out.println("Do you want to explore the garbage can?");
                System.out.println("    a - yes");
                System.out.println("    b - no");
                System.out.println("Enter the character please :");*/
                answer = keyboard.nextLine();
                if (answer.equals("a")){
                    ExpInfo.printStreet2_answerA();
                    /*System.out.println("Uh-Oh! There is already someone in this garbage can!");
                    System.out.println("This stray cat doesn't look soft!");*/
                    fightPeople();
                }
                else if (answer.equals("b")){
                    ExpInfo.printStreet2_answerB();
                    //System.out.println("Let us hope you will not regret it...");
                }
                break;
            case "sewer" : 
                /*System.out.println("Look! A wild rat is coming toward you!");
                System.out.println("It seems you have entered his territory");*/
                ExpInfo.printSewer_intro();
                fightPeople();
                MrKitten.grabItem("superPiss");
                ExpInfo.printSewer_conclu();
                /*System.out.println("Congratulations! You have learned a new ability : SuperPiss");
                System.out.println("You are now able to pee on people in a...deadly way...");*/
                break;
            case "petshop" : 
                ExpInfo.printPetshop_intro();
                
                /*System.out.println("A red fish appears! He looks stern...");*/
                //Actors.redFishDialog();
                /*System.out.println("There is a rat in one of the cages. He looks different from the other rats...wise.");
                System.out.println("Do you want to talk to him?");
                System.out.println("    a - yes");
                System.out.println("    b - no");
                System.out.println("Enter the character please :");*/
                answer = keyboard.nextLine();
                if (answer.equals("a")){
                    ExpInfo.printPetshop_answerA();
//                    Actors.ratatouilleDialog();
//                    System.out.println("Congratulations! You just learned Alchemy! You are now able to craft objects using this principle.");
                }
                else if (answer.equals("b")){
                    ExpInfo.printPetshop_answerB();
//                    System.out.println("Let us hope you will not regret it...");
                }
                ExpInfo.printPetshop_fight();
//                System.out.println("Sheeiiiiiit! You woke up the tyran of the petshop, the robot cleaner!");
//                Actors.mrRobotDialog();
                fightPeople();
                MrKitten.grabItem("potionCareMean");
                ExpInfo.printPetshop_end();
//                System.out.println("The robot has dropped a potion. Will you make good use of it?");
                break;                
            case "theGreatDescent" :
                ExpInfo.printgreatdescent_intro();
//                System.out.println("A group of dangerous looking sharks is swimming toward you!");
//                Actors.sharkDialog();
                fightPeople();
//                System.out.println("You just hit this shark so hard that its jaw just got torn apart from the rest of its body!");
                MrKitten.grabItem("superBite");
                ExpInfo.printgreatdescent_end();
//                System.out.println("Congratulations! You can now bite your ennemies with this super jaw!");
                break;
            case "dory" :
                ExpInfo.printdory_intro();
//                System.out.println("Who dat, who dat? How could you do dat, do dat? There's a surgeon fish over there, how could you know that, know that?");
//                
//                System.out.println("You got a problem buddy?! Wait, did I just said that? Oh, I just met you,");
//                System.out.println("and this is crazy, but here's my number. Hey how is it going mate?");
//                System.out.println("Oh I might need your help! Do you know where Marin is going?");
//                System.out.println("    a - P. Sherman Wallaby Way in Sydney Bitch!");
//                System.out.println("    b - Somewhere only we know <3");
//                System.out.println("    c - I heard something that my cousin told me about a women he was seeing in some places"
//                    +nLine+"and that she was sometimes refering to someone as Marin, but i don't know if that's him because my dad also told me she was"
//                    +nLine+"pretty crazy but as my mom said, never trust a man that can't even scratch a butterfly.");
//                System.out.println("    d - answer d");
//                System.out.println("Enter the character please :");
                String answer_dory = keyboard.nextLine();
                boolean good = false;
                switch (answer_dory){
                    case "a": if (answer_dory.equals("a")){
                        ExpInfo.printdory_answerA();
//                            System.out.println("Oh I remember now!! Thank you big guy!");
                        };good = true;
                        break;
                    case "b": if (answer_dory.equals("b")){
                        ExpInfo.printdory_answerB();
//                        System.out.println("How romantic is this, give a kiss to Keane for me!");
                        };break;
                    case "c": if (answer_dory.equals("c")){
                        ExpInfo.printdory_answerC();
//                        System.out.println("You lost me there man...");
                        };break;
                    case "d": if (answer_dory.equals("d")){
                        ExpInfo.printdory_answerD();
//                        System.out.println("You gotta love panckakes...");
                        };break;    
                default:  
//                    System.out.println("what the hell did you just say?"); break;
                    ExpInfo.printanswerError();
                }
                if (good){
                    good = false;
                    //ExpInfo.printdory_good();
//                        System.out.println("I also remember that I have a History test tomorrow!");
//                        System.out.println("You gotta help me! Just remember me which animal is");
//                        System.out.println("the great defender of the world!");
//                        System.out.println("    a - Superman! Have you seen his underwear? So much red!");
//                        System.out.println("    b - Magicarpe! Obviously this magesterial fish! And he is red too!");
//                        System.out.println("    c - Etalon du cul! What a french name for a true hero! ");
//                        System.out.println("    d - Do you really want the D?");
//                        System.out.println("Enter the character please :");
                        answer = keyboard.nextLine();
                switch (answer){
                case "a": {
                    ExpInfo.printdory_goodanswerA();
//                        System.out.println("Never trust somebody that has his underwear on top of his pants!");
                    };break;
                case "b": {
                    ExpInfo.printdory_goodanswerB();
//                            System.out.println("His attack dealt too much damage to handle...");
                        };break;
                case "c": {
                    ExpInfo.printdory_goodanswerC();
//                            System.out.println("Soooooo good! You are a true scientist!");
                        };good = true;break;
                case "d": {
                    ExpInfo.printdory_goodanswerD();
//                            System.out.println("That hardrive doesn't have anything special...");
                        };break;    
                    default : 
//                        System.out.println("How can you do that you witch!");break;
                        ExpInfo.printanswerError();
                }
                if (good){
                    //ExpInfo.printdory_end();
//                    System.out.println("Good job! You just won an ancient artefact!");
//                    System.out.println("You recieved: Artefact of true vision");
                    MrKitten.grabItem("artefactOfTrueVision");
                }
        }
                break;
            case "theFishPalace" :
                ExpInfo.printfishpalace_intro();
               // ExpInfo.printfishpalace_question();
//                System.out.println("You just entered the fish palace. It is magnificent and amazing.");
//                System.out.println("The court is waiting for you");
//                System.out.println("It seems you have been fooled! You are late, and the court has declared you guilty.");
//                System.out.println("The King of the Waterworld, Dark Moule, is standing on a high chair, looking at you with utter contempt.");
//                System.out.println("People are coming! There is no way you are going to let them take your life!");
//                System.out.println("You demand a trial by combat!");
//                System.out.println("Against...the King!");
//                Actors.darkMouleDialog();
//                System.out.println("Quick! Before the fight begins, you see an algae laying on the ground");
//                System.out.println("That may be useful! Do you want to pick it?");
//                System.out.println("    a - yes");
//                System.out.println("    b - no");
//                System.out.println("Enter the character please :");
                answer = keyboard.nextLine();
                if (answer.equals("a")){
                    ExpInfo.printfishpalace_answerA();
                    MrKitten.grabItem("algea");
                }
                else if (answer.equals("b")){
                    ExpInfo.printfishpalace_answerB();
//                    System.out.println("Let us hope you will not regret it...");
                }
                fightPeople();
                ExpInfo.printfishpalace_end();
//                System.out.println("When dying, dark Moule has dropped a blue key. You grab it.");
                MrKitten.grabItem("bluekey");
                break;
            case "tavernSanRicardo" : 
                ExpInfo.printtavern_intro();
//                System.out.println("You see a gorgeous looking cat with red-orange fur.");
//                System.out.println("This badass looking guy looks at you with a surprised look.");
//                Actors.pussInBootsDialog();
                MrKitten.grabItem("puppyEyes");
                //ExpInfo.printtavern_end();
//                System.out.println("Congratulations! You learned the puppyEyes technique! What a great way to soften your ennemies heart, to then deadly strike him!");
                break;
            case "starWars" : 
                ExpInfo.printvador_intro();
//                System.out.println("Nice neon lights illuminate a dark desk. Its looks like the Charlie's pub of the 7th street where the disco is on the floor but that's not relate to this story."
//                    +nLine+"You 're walking in direction of this desk ... suddendly the lights out and the office chair turn over. A black man appear !");
//                Actors.vadorDialog_a();
//                System.out.println("**************"
//                    +nLine+"Would you join this incredible profession ?"
//                    +nLine+"a - Yes, it appears to be a stable situation for my personnal projects."
//                    +nLine+"b - NO !! I've no time for this bumf !");
                String answer_starwars = keyboard.nextLine();
                if (answer_starwars.equals("a")){
                    ExpInfo.printvador_answerA();
//                System.out.println(" After many years of hard work and after encounter your wife and produced lot of baby ... You died of old age :( R.I.P  ");
//                System.out.println("You loose !! GAME OVER !!");
                System.exit(1);
                }
                else if (answer_starwars.equals("b")){
                    ExpInfo.printvador_answerB();
//                Actors.vadorDialog_b();
                fightPeople();
                //ExpInfo.printvador_end();
//                System.out.println("That's was a critical hit for this madness. He was not very bright !"
//                    +nLine+"Congratulations! Vador dropped a potion care and his laser saber become a beautiful lasertail for you !");
                MrKitten.grabItem("potionCareMax");
                MrKitten.grabItem("laserTail");
                }
                break;
            case "theCloset" : 
                ExpInfo.printcloset_intro();
//                System.out.println("There is big wooden cupboard in front of you.");
//                System.out.println("You approach an feel a fresh gust of wind. What is this?");
//                System.out.println("You decide to enter the cupboard.");
//                System.out.println("There is a cat here...");
//                System.out.println("He looks stern.");
//                System.out.println("He is covered in scars and has a nasty look, but apart from that, you two are perfect lookalikes...");
//                Actors.brotherDialog();
                fightPeople();
                //ExpInfo.printcloset_end();
//                System.out.println("Wow! You won!");
//                System.out.println("This was a really serious opponent, you almost died.");
//                System.out.println("Still, it always hurts to have to kill your own brother...");
//                System.out.println("But the gy deserved it, you could jot let him live. He is too dangerous.");
//                System.out.println("You notice a small door in a corner. What could be hiding in it?");
                break;
            case "theEnd" : 
                ExpInfo.printend_intro();
//                System.out.println("What is this?! Oh my God...");
//                System.out.println("The magic guillotine!");
//                System.out.println("Do you want to use it?");
//                System.out.println("    a - yes");
//                System.out.println("    b - no");
//                System.out.println("Enter the character please:");
                answer = keyboard.nextLine();
                if (answer.equals("a")){
                    ExpInfo.printend_answerA();
//                    System.out.println("Wow! The power of the magic guillotine is real! You just turned into a Nyan Cat!");
//                    System.out.println("Infinite powers aheeeeeaaaaaad!!! Yay!");
                }
                else if (answer.equals("b")){
                    ExpInfo.printend_answerB();
//                    System.out.println("Let us hope you will not regret it...");
                }
                break;
            default : 
                ExpInfo.printanswerError();
//                System.out.println("Just... how??"); 
                break;
        }
        return ("Coucou");
}

    /**
     * Print the inventory with interface
     * @param in 
     */
    public void inventory(Interface in){
        MrKitten.printInventoryIN(in);
    }
}
