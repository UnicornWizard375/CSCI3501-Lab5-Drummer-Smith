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
            System.out.println("Company " + Character.toString(letters.charAt((i))) + ": " + Arrays.toString(people[i]));
        }

        System.out.println("\n" + "Programmer" + "\n");
        for (int i = 0; i < numOfPeople; i++) {
            System.out.println("Programmer " + (i+1) + ": " + Arrays.toString(companies[i]));
        }

    }

        private static int numOfPeople = 5;
        private static int numOfCompanies = numOfPeople;

        private static String[][] companies = new String[numOfCompanies][numOfCompanies];
        private static int[][] people = new int[numOfPeople][numOfPeople];

        public static void generateArrays () {
            for (int i = 0; i < numOfPeople; i++) {
                people[i] = new int[numOfPeople];
                companies[i] = new String[numOfCompanies];
            }
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
                companies[i][j] = letter;
                letters = letters.replace(letter,"");
            }
        }

        //this fills our arrays of people with integers
            for (int i = 0; i < numOfPeople; i++) {
                ArrayList<Integer> numbers = new ArrayList<>(numOfPeople);
              for(int k = 0; k<numOfPeople; k++){
                  numbers.add(k, k+1);
              }
              System.out.println(numbers);
                for (int j = 0; j <numOfPeople; j++){
                    int lengthy =  numbers.size();
                    System.out.println("lentgth" + lengthy);
                    int temp = randletters.nextInt(lengthy);
                    System.out.println("temp" + temp);
                    int var = numbers.get(temp);
                    System.out.println("var" + var);
                    people[i][j] = var;
                    numbers.remove(temp);
                }
            }

    }



    }