import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.*;

public class satisfactoryAlgorithm {
    public static void main(String[] args) {
        generateArrays();
        fillArrays();

        String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        letters = letters.substring(0, numOfCompanies);

        System.out.println("Companies");
        for (int i = 0; i < numOfPeople; i++) {
            System.out.println("Company " + Character.toString(letters.charAt((i))) + ": " + Arrays.toString(companies[i]));
        }

        System.out.println("\n" + "Programmer" + "\n");
        for (int i = 0; i < numOfPeople; i++) {
            System.out.println("Programmer " + (i+1) + ": " + Arrays.toString(people[i]));
        }

        //do not enter more than our max runs in the code or it might crash your computer.
        //if num of people is greater than 9, an error is also created, so this protects against that.
        if(maxruns>10000 || numOfPeople > 9){
            System.out.println("\u001B[31m" + "Incorrect inputs could cause a long runtime, please lower them and try again. Aborting Program");
            System.exit(1);
        }
        ArrayList<String> initPairing = createRandomPairings();

        ArrayList<String> bestPairing = evolve(initPairing, calculatePointValues(initPairing));
        System.out.println(bestPairing);
        System.out.println(calculatePointValues(bestPairing));



    }

private static ArrayList<String> evolve(ArrayList<String> pairing, int points){
        ArrayList<String> bestPairing = pairing;
        int bestPointValue = points;
        for(int i = 0; i<maxruns; i++){
            ArrayList<String> tempPairing = createRandomPairings();
            int tempPoints =calculatePointValues(tempPairing);
            if(tempPoints<bestPointValue) {
            bestPairing=tempPairing;
            bestPointValue=tempPoints;
            }
        }
        return bestPairing;
}


        private static int maxruns = 10000;



        private static int numOfPeople = 5;
        private static int numOfCompanies = numOfPeople;

        private static String[][] people = new String[numOfCompanies][numOfCompanies];
        private static int[][] companies= new int[numOfPeople][numOfPeople];

        public static void generateArrays () {
            for (int i = 0; i < numOfPeople; i++) {
                companies[i] = new int[numOfCompanies];
                people[i] = new String[numOfPeople];
            }
        }

public static int calculatePointValues(ArrayList<String> randomPairing){
            int points = 0;
            for(int i = 0; i < numOfPeople; i++){
                String letter = (randomPairing.get(i)).substring(0,1);
                for(int h = 0; h <numOfPeople; h++) {
                    if(letter.equals(people[i][h])) {
                        points = (points +h);
                        break;
                    }
                }
            }

    for(int i = 0; i < numOfCompanies; i++){
        int number = Integer.parseInt((randomPairing.get(i)).substring(1,2));
        for(int h = 0; h <numOfCompanies; h++) {
            if(number ==(companies[i][h])) {
                points = (points + h);
                break;
            }
        }
    }


            return points;
        }

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