import javax.sound.midi.Soundbank;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Stack;

public class Main
{
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("Podaj ilość miast: ");
        City.cityQuantity = scan.nextInt();
        City city = new City();

        System.out.println("Podaj współrzędne miast: ");
        for(int i = 0; i< City.cityQuantity; i++){
            System.out.print(city.names[i]+": ");
            city.cityN.add(city.names[i]);
            city.cityX.add(scan.nextDouble());
            city.cityY.add(scan.nextDouble());
        }

        for(int i=0;i<City.cityQuantity;i++){
            System.out.print(city.cityN.get(i)+": ");
            System.out.println(city.cityX.get(i)+" "+city.cityY.get(i));
        }

        System.out.println("Od którego miasta chcesz zacząć drogę: ");
        City.firstCity = scan.next();


        int cityQuantity = City.cityQuantity;
        for(int i=1;i<cityQuantity;i++){
            city.swapCity();
            if(City.cityQuantity==0 || City.cityQuantity==1)  break;
            city.findShortestWay();
        }

        for(String cities : city.cityOrder){
            System.out.print(cities);
        }

    }
}