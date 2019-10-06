import java.util.ArrayList;
import java.util.ArrayList.*;
import java.util.Arrays;
import java.util.Random;
import java.util.*;

//Recorded data is in the file answers.md



//This program generates random preferences for each programmer and company automatically, no need to input data manually


public class satisfactoryAlgorithm {

    //You may change the following two variables

    //this variable is just to make sure it does not crash your computer, do not increase past 100,000
    private static int maxruns = 10000;

    //you may change num of people to anywhere between 0 and 9 inclusive
    private static int numOfPeople = 9;
    private static int numOfCompanies = numOfPeople;

    //----------------------------------------------//

//initialize arrays
    private static String[][] people = new String[numOfCompanies][numOfCompanies];
    private static int[][] companies = new int[numOfPeople][numOfPeople];


    public static void main(String[] args) {
        generateArrays();
        fillArrays();

        String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        letters = letters.substring(0, numOfCompanies);

        //print out the arrays of each company and programmer preferences
        System.out.println("Companies");
        for (int i = 0; i < numOfPeople; i++) {
            System.out.println("Company " + Character.toString(letters.charAt((i))) + ": " + Arrays.toString(companies[i]));
        }

        System.out.println("\n" + "Programmers" + "\n");
        for (int i = 0; i < numOfPeople; i++) {
            System.out.println("Programmer " + (i + 1) + ": " + Arrays.toString(people[i]));
        }

        //do not enter more than our max runs in the code or it might crash your computer, this section protects against that happening.
        //if num of people is greater than 9, an error is also created, so this protects against that.
        if (maxruns > 100000 || numOfPeople > 9) {
            System.out.println("\u001B[31m" + "Incorrect inputs could cause a long runtime, please lower them and try again. Aborting Program");
            System.exit(1);
        }
        ArrayList<String> initPairing = createRandomPairings();

        ArrayList<String> bestPairing = evolve(initPairing, calculatePointValues(initPairing));
        System.out.println("Final pairing: " + bestPairing);
        System.out.println("is this satisfactory: " + isSatisfactory(bestPairing));


    }
//our function that returns the first satisfactory pairing it finds
    private static ArrayList<String> evolve(ArrayList<String> pairing, int points) {
        ArrayList<String> bestPairing = pairing;
        int bestPointValue = points;
        for (int i = 0; i < maxruns; i++) {
            ArrayList<String> tempPairing = createRandomPairings();
            int tempPoints = calculatePointValues(tempPairing);
            if (tempPoints < bestPointValue) {
                bestPairing = tempPairing;
                bestPointValue = tempPoints;
            }

            //you may comment out the following if statement in order to find the best possible pairing, rather than the first satisfactory one
            if(isSatisfactory(bestPairing)){
                System.out.println("generated " + i + " random pairs before reaching a satisfactory pairing");
                break;
            }
        }
        return bestPairing;
    }

//generate arrays that we will fill later
    public static void generateArrays() {
        for (int i = 0; i < numOfPeople; i++) {
            companies[i] = new int[numOfCompanies];
            people[i] = new String[numOfPeople];
        }
    }

    //we used point values for each preference where if programmer 1 had preferences [A, D, E, B, C], and was paired with B,
    // they would contribute 3 points to the total. Lower point values are better.
    //it then returns the point values for all the pairings
    public static int calculatePointValues(ArrayList<String> randomPairing) {
        int points = 0;
        for (int i = 0; i < numOfPeople; i++) {
            String letter = (randomPairing.get(i)).substring(0, 1);
            for (int h = 0; h < numOfPeople; h++) {
                if (letter.equals(people[i][h])) {
                    points = (points + h);
                    break;
                }
            }
        }

        for (int i = 0; i < numOfCompanies; i++) {
            int number = Integer.parseInt((randomPairing.get(i)).substring(1, 2));
            for (int h = 0; h < numOfCompanies; h++) {
                if (number == (companies[i][h])) {
                    points = (points + h);
                    break;
                }
            }
        }


        return points;
    }

    //returns a boolean: true if the input pairing is satisfactory, false otherwise
    private static boolean isSatisfactory(ArrayList<String> bestPairing) {
        int curPairPoints = 0;
        int potentialPoints = 0;
        for (int h = 0; h < numOfCompanies; h++) {
            for (int k = 0; k < numOfCompanies; k++) {
                int programmerNumberh = Integer.parseInt(Character.toString(bestPairing.get(h).charAt(1))) -1;

                int programmerNumberk = (Integer.parseInt(Character.toString(bestPairing.get(k).charAt(1)))) -1;

                curPairPoints = calculatePointValues(bestPairing);

                ArrayList<String> potentialArray = new ArrayList<String>(numOfCompanies);

                for(int j = 0; j < numOfPeople; j++)
                {
                   potentialArray.add(j, bestPairing.get(j));
                }

                String tempvar = (Character.toString(bestPairing.get(h).charAt(0))).concat(Character.toString(bestPairing.get(k).charAt(1)));
                String tempvar2 = (Character.toString(bestPairing.get(k).charAt(0))).concat(Character.toString(bestPairing.get(h).charAt(1)));
                potentialArray.set(h, tempvar);
                potentialArray.set(k, tempvar2);

                potentialPoints = calculatePointValues(potentialArray);

                if (potentialPoints < curPairPoints) {
                    return false;
                }
            }
        }
        return true;
    }

    //The below function was originally to be used to calculate point values for just one combination of A1, or C6 or F 3 or whatever, but was incorrectly returning point values
    //im leaving it here because we literally spent 2 hours trying to fix it and it stays here as a reminder of the pain.
//        private static int getValueOfPair(int x, int y) {
//            int points = 0;
//            String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
//            String letter = Character.toString(letters.charAt(x));
//            //System.out.println("x: " + x);
//            //System.out.println("y: " + y);
//            for (int w = 0; w < numOfPeople; w++) {
//                if (y == (companies[x][w])) {
//                    points = (points + w);
//                    break;
//                }
//            }
//            for (int z = 0; z < numOfCompanies; z++) {
//                if (letter.equals(people[y][z])) {
//                    points = (points + z);
//                    break;
//                }
//            }
//            System.out.println("Points(getValueOfPair): " + points);
//            return points;
//        }


    //create a random pairing of preferences in a form such as: [A5, B4, C2, D1, E3] and return it
        private static ArrayList createRandomPairings(){
            String numbers = "123456789";
            numbers = numbers.substring(0, numOfCompanies);
            String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            letters = letters.substring(0, numOfCompanies);
            Random randletters = new Random();
            ArrayList pairings = new ArrayList<String>();
            for(int i = 0; i < numOfPeople; i++) {
                String chosenInt = Character.toString(numbers.charAt(randletters.nextInt(numbers.length())));
                numbers = numbers.replace(chosenInt, "");
                pairings.add(Character.toString(letters.charAt(i)) + chosenInt);
            }
            return pairings;
        }


        //fills our arrays of programmer preferences with random letters, and our company arrays with random numbers
        public static void fillArrays(){
            Random randletters = new Random();

            //this creates our array companies with random letters in each companies preference column
        for (int i = 0; i < numOfCompanies; i++) {

            String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            letters = letters.substring(0, numOfCompanies);
            for (int j = 0; j <numOfCompanies; j++){
                int temp = randletters.nextInt(letters.length());
                String letter = Character.toString(letters.charAt(temp));
                people[i][j] = letter;
                letters = letters.replace(letter,"");
            }
        }

        //this fills our arrays of people with integers
            for (int i = 0; i < numOfPeople; i++) {
                ArrayList<Integer> numbers = new ArrayList<>(numOfPeople);
              for(int k = 0; k<numOfPeople; k++){
                  numbers.add(k, k+1);
              }
              //System.out.println(numbers);
                for (int j = 0; j <numOfPeople; j++){
                    int lengthy =  numbers.size();
                    //System.out.println("lentgth" + lengthy);
                    int temp = randletters.nextInt(lengthy);
                    //System.out.println("temp" + temp);
                    int var = numbers.get(temp);
                    //System.out.println("var" + var);
                    companies[i][j] = var;
                    numbers.remove(temp);
                }
            }

    }

    }