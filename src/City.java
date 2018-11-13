import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.pow;
import static java.lang.StrictMath.sqrt;

public class City {
    private static City instance = null;
    public static City getInstance(){
        if(instance==null){
            instance = new City();
        }
        return instance;
    }
    static String firstCity;
    static String nextCity;
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
       names = new String[]{"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","R","S","T","U","W","V","Y","Z","X"};
       cityX = new ArrayList<Double>();
       cityY = new ArrayList<Double>();
       cityN = new ArrayList<String>();
       cityOrder = new ArrayList();
    }

    void findShortestWay(){
        lengthSmallestWay = Integer.MAX_VALUE;

        for(int i=1;i<cityQuantity;i++){
            double way;
            way = sqrt(pow((cityX.get(0) - cityX.get(i)), 2) + pow((cityY.get(0) - cityY.get(i)), 2));

            if(way<lengthSmallestWay) {
                lengthSmallestWay = way;
                shortestCityName = cityN.get(i);
                indexSmallestWay = i;
            }
        }

        if(cityQuantity>1){
            nextCity = cityN.get(indexSmallestWay);
        }

        cityOrder.add(toString());

        cityN.remove(0);cityX.remove(0);cityY.remove(0);

        cityQuantity--;indexSmallestWay--;
    }

    void swapCity(){
        int index = findIndexCity(cityQuantity, nextCity);
        String tmpN = cityN.get(index); double tmpX = cityX.get(index); double tmpY = cityY.get(index);
        cityN.set(index, cityN.get(0)); cityX.set(index, cityX.get(0)); cityY.set(index, cityY.get(0));
        cityN.set(0,tmpN); cityX.set(0,tmpX); cityY.set(0,tmpY);
    }

    int findIndexCity(int cityQuantity, String nextCity){
        for(int i=0;i<cityQuantity;i++){
            if(cityN.get(i).equals(nextCity)) return i;
        }
        return -1;
    }

    public String toString(){
        if(cityQuantity == 2){
            return " ["+cityN.get(0)+" - "+cityN.get(indexSmallestWay)+"] --> ["+cityN.get(indexSmallestWay)+" - "+firstCity+"] ";
        }
        return " ["+cityN.get(0)+" - "+cityN.get(indexSmallestWay)+"] -->";
    }
}
