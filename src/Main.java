

public class Main
{
    public static void main(String[] args) {
        UserInterface ui = new UserInterface();
        City city = City.getInstance();

        ui.init();

        int cityQuantity = City.cityQuantity;
        for(int i=1;i<cityQuantity;i++){
            city.swapCity();
            if(City.flag ==0){
                City.firstCityX = city.cityX.get(0);
                City.firstCityY = city.cityY.get(0);
            }
            city.findShortestWay();
        }
        System.out.print("droga: ");
        for(String cities : city.cityOrder){
            System.out.print(cities);

        }
        System.out.println(City.entirelengthWay);
    }
}