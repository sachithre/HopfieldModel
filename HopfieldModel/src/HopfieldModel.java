import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;

public class HopfieldModel {

	 public static void correctNewPattern(double Matrix[][], int pattern[], double threshould) {

	        double[] tempArray = new double[Matrix.length];
	        int[] newPattern = new int[Matrix.length];
	        boolean r = true;

	        for (int a = 0; a < Matrix.length; a++) {

	            for (int b = 0; b < Matrix.length; b++) {

	                tempArray[a] = tempArray[a] + (pattern[b] * Matrix[a][b]);

	            }

	            if (tempArray[a] >= threshould) {
	                newPattern[a] = 1;
	            } else {
	                newPattern[a] = 0;
	                r = false;
	            }

	        }

	        if (Arrays.equals(pattern, newPattern)) {
	            System.out.println("Correct Pattern");
	            printArray(newPattern);
	        } else {
	           // printWeightMatrix(tempArray);
	            System.out.println("New Pattern");
	            printArray(newPattern);
	            correctNewPattern(Matrix, newPattern, threshould);
	        }

	    }

	    //Calculate Total Weight Matrix
	    public static double[][] totalWeightMatrix(int patterns[][], double alpha) {

	        int[][] totalWeightMatrix = new int[patterns[0].length][patterns[0].length];
	        double[][] totalWeightMatrixDouble = new double[patterns[0].length][patterns[0].length];
	        int[][][] tempArray = new int[patterns.length][patterns[0].length][patterns[0].length];

	        for (int i = 0; i < patterns.length; i++) {

	            tempArray[i] = weightMatrix(patterns[i]);

	            for (int a = 0; a < tempArray[0].length; a++) {
	                for (int b = 0; b < tempArray[0][0].length; b++) {

	                    totalWeightMatrix[a][b] = totalWeightMatrix[a][b] + tempArray[i][a][b];

	                }
	            }

	            for (int a = 0; a < tempArray[0].length; a++) {
	                for (int b = 0; b < tempArray[0][0].length; b++) {
	                    if (a != b) {
	                        totalWeightMatrixDouble[a][b] = totalWeightMatrix[a][b] * alpha;
	                    } else {
	                        totalWeightMatrixDouble[a][b] = 0;
	                    }
	                }
	            }

	        }

	        return totalWeightMatrixDouble;
	    }

	    //calculate Weight Matrix
	    public static int[][] weightMatrix(int array[]) {

	        int[][] wMatrix = new int[array.length][array.length];

	        for (int a = 0; a < array.length; a++) {
	            for (int b = 0; b < array.length; b++) {
	                wMatrix[a][b] = array[a] * array[b];
	            }
	        }

	        return wMatrix;

	    }

	    //Print 1D Double array
	    public static void printArray(String[] stringArray) {

	        for (int a = 0; a < stringArray.length; a++) {

	            System.out.print(stringArray[a] + "  ");

	        }
	        System.out.println("");

	    }

	    //Print 1D Integer array
	    public static void printArray(int array[]) {

	        for (int a = 0; a < array.length; a++) {

	            System.out.print(array[a] + "  ");

	        }

	        System.out.println("");
	    }

	    //Print weight Matrix
	    public static void printArray(int array[][]) {

	        for (int a = 0; a < array.length; a++) {
	            for (int b = 0; b < array[0].length; b++) {
	                System.out.print(array[a][b] + "      ");
	            }
	            System.out.println("");
	        }
	        System.out.println("");
	    }

	    //Print weight Matrix Double
	    public static void printArray(double array[][]) {

	        for (int a = 0; a < array.length; a++) {
	            for (int b = 0; b < array[0].length; b++) {
	                System.out.print(df2.format(array[a][b]) + "      ");
	            }
	            System.out.println("");
	        }
	        System.out.println("");
	    }

	    private static DecimalFormat df2 = new DecimalFormat("#.##");

	    public static void main(String[] args) {

	        //Input Pattern set
	        int[][] patterns = {{0, 0, 0, 0, 0, 0, 0, 0}, {0, 1, 0, 1, 0, 1, 0, 1}, {0, 0, 1, 1, 0, 0, 1, 1,}, {0, 0, 0, 0, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1, 1}};
	        int[][] patterns2 = {{1, 1, 0, 1, 0, 1}, {0, 1, 0, 1, 0, 1}, {1, 1, 1, 0, 0, 1}, {1, 0, 1, 1, 1, 0}, {1, 1, 0, 1, 1, 0}};
	        double alpha = 0.6;
	        int[] new_pattern = {1, 0, 1, 1, 0, 1};
	        double threshould = 3.0;

	        //Calculating weight matrix for each pattern
	        for (int i = 0; i < patterns2.length; i++) {

	            int[][] w = weightMatrix(patterns2[i]);
	            System.out.println("----------   weight Matrix for patter " + (i + 1) + "  ------------");
	            printArray(w);
	            System.out.println("-----------------------------------------------------");

	        }

	        //Calculating Total Weight Matrix
	        double[][] t_w_matrix = totalWeightMatrix(patterns2, alpha);
	        System.out.println("++++++++++++++++ Total Weight Matrix ++++++++++++++++");
	        printArray(t_w_matrix);
	        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
	        
	        
	        //Getting new Pattern
	        Scanner scnr = new Scanner(System.in);
	        String[] stringArray = new String[patterns2[0].length];
	        int[] new_pattern2 = new int[patterns2[0].length];

	        System.out.print("Enter new pattern seperated by spaces: ");
	        String new_pattern_string2 = scnr.nextLine();
	        stringArray = new_pattern_string2.split(" ");
	       
	        
		    for(int i =0; i < stringArray.length; i++){
		        new_pattern2[i]=Integer.parseInt(stringArray[i]);
		        
		    }
	    
	        System.out.println("User Input");
	        printArray(new_pattern2);

	        
	       
	         
	        
	        //Correct the new pattern
	        correctNewPattern(t_w_matrix, new_pattern, threshould);
	    }

}
