import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.Math.pow;
import static java.lang.StrictMath.sqrt;

public class City {
    static String firstCity;
    static int cityQuantity;
    int cityOrderIndex = 0;
    String shortestCityName = "";
    int indexSmallestWay = 0;
    double lengthSmallestWay;

    List<String> cityN;
    String[] names;
    List<Double> cityX;
    List<Double> cityY;
    List<String> cityOrder;

    City(){
       names = new String[]{"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","R","S","T","U","W","V","Y","Z"};
       cityX = new ArrayList<Double>();
       cityY = new ArrayList<Double>();
       cityN = new ArrayList<String>();
       cityOrder = new ArrayList();
    }

    void swapCity(){
        int index = findIndexCity(cityQuantity, firstCity);
        String tmpN = cityN.get(index); double tmpX = cityX.get(index); double tmpY = cityY.get(index);
        cityN.set(index, cityN.get(0)); cityX.set(index, cityX.get(0)); cityY.set(index, cityY.get(0));
        cityN.set(0,tmpN); cityX.set(0,tmpX); cityY.set(0,tmpY);
    }

    int findIndexCity(int cityQuantity, String firstCity){
        for(int i=0;i<cityQuantity;i++){
            if(cityN.get(i).equals(firstCity)) return i;
        }
        return -1;
    }



    void findShortestWay(){
        lengthSmallestWay = Integer.MAX_VALUE;

        for(int i=1;i<cityQuantity;i++){
            double way;
            //if(cityX.get(0)<cityX.get(i)) {
                 way = sqrt(pow((cityX.get(0) - cityX.get(i)), 2) + pow((cityY.get(0) - cityY.get(i)), 2));
           // }else{
             //    way = sqrt(pow((cityX.get(i) - cityX.get(0)), 2) + pow((cityY.get(i) - cityY.get(0)), 2));
           // }
                if(way<lengthSmallestWay) {
                    lengthSmallestWay = way;
                    shortestCityName = cityN.get(i);
                    indexSmallestWay = i;
                }
        }

        if(cityQuantity>1){
            firstCity = cityN.get(indexSmallestWay);
        }

        cityOrder.add(" ["+cityN.get(0)+" - "+cityN.get(indexSmallestWay)+"] ");

        cityN.remove(0);cityX.remove(0);cityY.remove(0);
        cityQuantity--;
        indexSmallestWay--;


    }


}





//    private int numberOfNodes;
//    private Stack<Integer> stack;
//
//    public Main()
//    {
//
//        stack = new Stack<Integer>();
//    }
//
//    public void tsp(int adjacencyMatrix[][])
//    {
//        numberOfNodes = adjacencyMatrix[1].length - 1;
//        int[] visited = new int[numberOfNodes + 1];
//        visited[1] = 1;
//        stack.push(1);
//        int element, dst = 0, i;
//        int min = Integer.MAX_VALUE;
//        boolean minFlag = false;
//        System.out.print(1 + "\t");
//
//        while (!stack.isEmpty())
//        {
//            element = stack.peek();
//            i = 1;
//            min = Integer.MAX_VALUE;
//            while (i <= numberOfNodes)
//            {
//                if (adjacencyMatrix[element][i] > 1 && visited[i] == 0)
//                {
//                    if (min > adjacencyMatrix[element][i])
//                    {
//                        min = adjacencyMatrix[element][i];
//                        dst = i;
//                        minFlag = true;
//                    }
//                }
//                i++;
//            }
//            if (minFlag)
//            {
//                visited[dst] = 1;
//                stack.push(dst);
//                System.out.print(dst + "\t");
//                minFlag = false;
//                continue;
//            }
//            stack.pop();
//        }
//    }
//
//    public double[][] coordinatesToAdjatencyMatrix(){
//        double citys[];
//        double matrixOut[][];
//        int nodes = 0;
//        System.out.println("Podaj ilość miast");
//        Scanner scanner = null;
//        scanner = new Scanner(System.in);
//        nodes = scanner.nextInt();
//        matrixOut = new double[nodes][nodes];
//
//
//        for (int i = 1; i <= nodes; i++)
//        {
//            for (int j = 1; j <= nodes; j++)
//            {
//
//            }
//        }
//
//
//        return matrixOut;
//    }
//
//    public static void main(String... arg)
//    {
//        int number_of_nodes;
//        Scanner scanner = null;
//        try
//        {
//            System.out.println("Enter the number of nodes in the graph");
//            scanner = new Scanner(System.in);
//            number_of_nodes = scanner.nextInt();
//            int adjacency_matrix[][] = new int[number_of_nodes + 1][number_of_nodes + 1];
//            System.out.println("Enter the adjacency matrix");
//            for (int i = 1; i <= number_of_nodes; i++)
//            {
//                for (int j = 1; j <= number_of_nodes; j++)
//                {
//                    adjacency_matrix[i][j] = scanner.nextInt();
//                }
//            }
//            for (int i = 1; i <= number_of_nodes; i++)
//            {
//                for (int j = 1; j <= number_of_nodes; j++)
//                {
//                    if (adjacency_matrix[i][j] == 1 && adjacency_matrix[j][i] == 0)
//                    {
//                        adjacency_matrix[j][i] = 1;
//                    }
//                }
//            }
//            System.out.println("the citys are visited as follows");
//            Main tspNearestNeighbour = new Main();
//            tspNearestNeighbour.tsp(adjacency_matrix);
//        } catch (InputMismatchException inputMismatch)
//        {
//            System.out.println("Wrong Input format");
//        }
//        scanner.close();
//    }
