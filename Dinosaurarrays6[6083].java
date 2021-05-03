package dinoarrays;

import java.util.Random;
import java.util.Scanner;
public class Dinoarrays {
    //Main Method
    public static void main(String[] p) {
        //Start of records
        pets P = new pets();
        //used for the dice roll 
        int randomroll = 0;
        //used for the loop  
        //Used to store the information of the dinosaurs
        String dinosaurinfo[] = new String[4];
        //Used to attain the information of the dinosaur
        questions(P, dinosaurinfo);
        //Evaluates the state of mind of the dinosaur
        stateofmind(P, randomroll, dinosaurinfo);
        System.exit(0);

    } // END main

    // This method calulates the anger level, and contains a if statement which informs the user of the state of the dinosaur
    public static void questions(pets P, String[] dinosaurinfo) {

        //declaring array variables
        String[] n = new String[4];
        String[] specie = new String[4];
        //Start of loops
        for (int d = 1; d < 4; d++) {
            //gathers the name of the dinosaur
            System.out.println("What's dinosaurs " + d + " name?");
            //scanner variable
            Scanner scanner = new Scanner(System.in);
            //is able to retreive both of the dinosaurs name
            n[d] = scanner.nextLine();
            //both array variables, stores dinosaurs name
            P = setName(P, (n));
            //gathers the species of the dinosaur
            System.out.println("what species is your dinosaur ");
            //is able to retreive both of the dinosaurs specie
            specie[d] = scanner.nextLine();
            //both array variables, stores dinosaurs specie
            P = setSpecies(P, (specie));
            //prints text including the information previously received
            System.out.println("Happy Birthday " + getName(P)[d] + " The " + getSpecies(P)[d]);
            //Anger variable declared as int, used to calculate the anger sum
            int anger;
            //The variables of the levels are being transferred over to the getter method and anger level being calculated 
            P = setIrritablelevel(P, (answerirritablelevel()));
            P = setHungerlevel(P, (answerhungerlevel()));
            P = setThirstlevel(P, (answerthirstlevel()));
            anger = getHungerlevel(P) + getThirstlevel(P) + getIrritablelevel(P);
            P = setAngerlevel(P, (anger));
            //transferring the getter methods holding the values of the level to an array format
            P.alevel[d] = (getAngerlevel(P));
            P.hlevel[d] = (getHungerlevel(P));
            P.ilevel[d] = (getIrritablelevel(P));
            P.tlevel[d] = (getThirstlevel(P));
            //displaying anger level of dinosaur
            System.out.println("Your Dinosuars anger level is " + P.alevel[d]);
            //start of if statement
            if (getAngerlevel(P) <= 12) {
                System.out.println(getName(P)[d] + " is looking serene, which is good");

            } else if (getAngerlevel(P) <= 24) {
                System.out.println(getName(P)[d] + " is looking grouchy we gotta do feed it or give it some water ");

            } else if (getAngerlevel(P) <= 40) {
                System.out.println(getName(P)[d] + " is looking dangerous RUN!!! ITS COMING AFTER US, HURRY DO SOMETHING ");
            } else {
                System.out.println("sorry that is not his anger level");
            }
            //Information about each dinosaur is stored in the array dinosaurinfo
            dinosaurinfo[1] = (getName(P)[d] + "\n"
                    + " Anger level is: " + P.alevel[d] + "\n"
                    + " Hunger level is: " + P.hlevel[d] + "\n"
                    + " Thirst level is:" + P.tlevel[d] + "\n"
                    + " Irritability level is:" + P.ilevel[d]);
            dinosaurinfo[2] = (getName(P)[d] + "\n"
                    + " Anger level is: " + P.alevel[d] + "\n"
                    + " Hunger level is: " + P.hlevel[d] + "\n"
                    + " Thirst level is:" + P.tlevel[d] + "\n"
                    + " Irritability level is:" + P.ilevel[d]);
            dinosaurinfo[2] = (getName(P)[d] + "\n"
                    + " Anger level is: " + P.alevel[d] + "\n"
                    + " Hunger level is: " + P.hlevel[d] + "\n"
                    + " Thirst level is:" + P.tlevel[d] + "\n"
                    + " Irritability level is:" + P.ilevel[d]);
            //prints out the information stored in the array
            System.out.println(dinosaurinfo[d]);
        }//END FOR LOOP
        return;
    }
    //method used to gather the thirst level

    public static int answerthirstlevel() {
        int t;
        // create a scanner vairable 
        Scanner scanner = new Scanner(System.in);
        // ask for the person's thirst level
        System.out.println("What's your dinosaurs thrist level out of 10 ( 1 being good and 10 being bad ) ?");
        // get their thirst level and store as int
        t = Integer.parseInt(scanner.nextLine());
        return t;
    }
    //method used to gather the hunger level

    public static int answerhungerlevel() {
        int h;
        // create a scanner variable
        Scanner scanner = new Scanner(System.in);
        // ask for the person's hunger level
        System.out.println("What's your dinosaurs hunger level out of 20 ( 1 being good and 20 being bad )?");
        // get their hunger level and store as int
        h = Integer.parseInt(scanner.nextLine());
        return h;
    }
    //method used to gather the irritable level

    public static int answerirritablelevel() {
        int i;
        // create a scanner variable
        Scanner scanner = new Scanner(System.in);
        // ask for the person's irritable level
        System.out.println("What's your dinosaurs irritable level out of 10 ( 1 being good and 10 being bad )?");
        // get their irriable level and store as int
        i = Integer.parseInt(scanner.nextLine());
        return i;
    }
    //This method used to generate the random dice value      

    public static int diceroll(int randomroll) {	        //generates a random value to use
        Random rand = new Random();
        //the value is between 1 - 10
        randomroll = rand.nextInt(10) + 1;
        return randomroll;
    }
    //This method contains a loop to pass time and to reduce the anger value of the dinosaur

    public static void stateofmind(pets P, int randomroll, String[] dinosaurinfo) {
        //start of loop
        for (int k = 1; k < 4; k++) {
            //Variable declared        
            String action;
            //Giving the rules of the game, has an array presenting the different dinosaurs information
            System.out.println(dinosaurinfo[k] + "\n" + "To lower your dinosaurs anger level you're going to have to either 'Sing', Give 'Food', Give 'Water', Do Nothing (Choose One)");
            //Scanner variable declared and allows the inputted information to be sotred in the variable
            Scanner scanner = new Scanner(System.in);
            action = scanner.nextLine();

            //if statement for the actions that will be taken and the dice roll either adds or minuses the anger level
            if (action.equals("food")) {
                P.Angerlevel = P.alevel[k] - diceroll(randomroll);
            } else if (action.equals("water")) {
                P.Angerlevel = P.alevel[k] - diceroll(randomroll);
            } else if (action.equals("sing")) {
                P.Angerlevel = P.alevel[k] - diceroll(randomroll);
            } else {
                P.Angerlevel = P.alevel[k] + diceroll(randomroll);
            }
            //update of the anger level
            System.out.println(k);
            System.out.println("Your Dinosuars anger level now is " + P.alevel[k]);

            //if statement for the update of state of mind for each round
            if (getAngerlevel(P) <= 12) {
                System.out.println(getName(P)[k] + " is looking serene, which is good " + getName(P)[k] + " is calm everything is fine ");

            } else if (getAngerlevel(P) <= 24) {
                System.out.println(getName(P)[k] + " is looking grouchy we gotta do feed it or give it some water ");

            } else if (getAngerlevel(P) <= 40) {
                System.out.println(getName(P)[k] + " is looking dangerous RUN!!! ITS COMING AFTER US, HURRY DO SOMETHING ");

            } else if (getAngerlevel(P) <= 52) {
                System.out.println("Theres no hope for " + getName(P)[k] + " Put him down " + getName(P)[k] + " Is unfortunately dead, sorry for your loss");
            }
        }//end of loop
        return;
    }

    //start of getter methods
    public static String[] getName(pets P) {
        return P.Name;
    }

    public static String[] getSpecies(pets P) {
        return P.Species;
    }

    public static int getHungerlevel(pets P) {
        return P.Hungerlevel;
    }

    public static int getThirstlevel(pets P) {
        return P.Thirstlevel;
    }

    public static int getAngerlevel(pets P) {
        return P.Angerlevel;
    }

    public static int getIrritablelevel(pets P) {
        return P.Irritablelevel;
    }

    public static int[] getalevel(pets P) {
        return P.alevel;
    }

    public static int[] gethlevel(pets P) {
        return P.hlevel;
    }

    public static int[] getilevel(pets P) {
        return P.ilevel;
    }

    public static int[] gettlevel(pets P) {
        return P.tlevel;
    }
    //start of setter methods

    public static pets setName(pets P, String[] petsName) {
        P.Name = petsName;
        return P;
    }

    public static pets setSpecies(pets P, String[] petsSpecies) {
        P.Species = petsSpecies;
        return P;
    }

    public static pets setHungerlevel(pets P, int petsHungerlevel) {
        P.Hungerlevel = petsHungerlevel;
        return P;
    }

    public static pets setThirstlevel(pets P, int petsThirstlevel) {
        P.Thirstlevel = petsThirstlevel;
        return P;
    }

    public static pets setAngerlevel(pets P, int petsAngerlevel) {
        P.Angerlevel = petsAngerlevel;
        return P;
    }

    public static pets setIrritablelevel(pets P, int petsIrritablelevel) {
        P.Irritablelevel = petsIrritablelevel;
        return P;
    }

    public static pets setalevel(pets P, int[] alevel) {
        P.alevel = alevel;
        return P;
    }

    public static pets sethlevel(pets P, int[] hlevel) {
        P.hlevel = hlevel;
        return P;
    }

    public static pets setilevel(pets P, int[] ilevel) {
        P.ilevel = ilevel;
        return P;
    }

    public static pets settlevel(pets P, int[] tlevel) {
        P.tlevel = tlevel;
        return P;
    }

}// END CLASS
//the class for the records

class pets {

    String[] Name = new String[4]; //Used to store name of dinosaurs
    String[] Species = new String[4];//Used to store species of dinosaurs
    int Hungerlevel; //used to store the hunger level of dinosaur
    int Thirstlevel; //used to store the thirst level of dinosaur
    int Angerlevel;  //used to store the anger level of dinosaur
    int Irritablelevel; //used to store the irritability level of dinosaur
    int[] alevel = new int[4]; //used to store the anger level of dinosaurS
    int[] hlevel = new int[4]; //used to store the hunger level of dinosaurS
    int[] ilevel = new int[4];//used to store the irritability level of dinosaurS
    int[] tlevel = new int[4];//used to store the thirst level of dinosaurS
}//end of Class for records
