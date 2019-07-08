
public class HopfieldModel {

	 //Calculate Total Weight Matrix
    public static int[][] totalWeightMatrix(int patterns[][]) {

        int[][] totalWeightMatrix = new int[patterns[0].length][patterns[0].length];
        int[][][] tempArray = new int[patterns.length][patterns[0].length][patterns[0].length];

        for (int i = 0; i < patterns.length; i++) {

            tempArray[i] = weightMatrix(patterns[i]);

            for (int a = 0; a < tempArray[0].length; a++) {
                for (int b = 0; b < tempArray[0][0].length; b++) {

                    totalWeightMatrix[a][b] = totalWeightMatrix[a][b] + tempArray[i][a][b];

                }
            }

        }

        return totalWeightMatrix;
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

    //Print weight Matrix
    public static void printWeightMatrix(int array[][]) {

        for (int a = 0; a < array.length; a++) {
            for (int b = 0; b < array[0].length; b++) {
                System.out.print(array[a][b] + " ");
            }
            System.out.println("");
        }

    }

    public static void main(String[] args) {

        int[][] patterns = {{0, 0, 0, 0, 0, 0, 0, 0}, {0, 1, 0, 1, 0, 1, 0, 1}, {0, 0, 1, 1, 0, 0, 1, 1,}, {0, 0, 0, 0, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1, 1}};

        for (int i = 0; i < patterns.length; i++) {

            int[][] w = weightMatrix(patterns[i]);
            System.out.println("----------   weight Matrix for patter " + (i + 1) + "  ----------");
            printWeightMatrix(w);
            System.out.println("---------------------------------------------------");

        }

        int[][] t_w_matrix = totalWeightMatrix(patterns);
        System.out.println("+++++++++++++++++++++++++++++++++++++");
        printWeightMatrix(t_w_matrix);
        System.out.println("+++++++++++++++++++++++++++++++++++++");

    }

}
