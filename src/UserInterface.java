import java.util.Scanner;

public class UserInterface {
    public void init(){
        Scanner scan = new Scanner(System.in);

        System.out.println("Podaj ilość miast: ");
        City.cityQuantity = scan.nextInt();
        City city = City.getInstance();

        System.out.println("Podaj współrzędne miast: ");
        for(int i = 0; i< City.cityQuantity; i++){
            System.out.print(city.names[i]+": ");
            city.cityN.add(city.names[i]);
            city.cityX.add(scan.nextDouble());
            city.cityY.add(scan.nextDouble());
        }
//        wyświetlanie współrzędnych
//        for(int i=0;i<City.cityQuantity;i++){
//            System.out.print(city.cityN.get(i)+": ");
//            System.out.println(city.cityX.get(i)+" "+city.cityY.get(i));
//        }

        System.out.println("Od którego miasta chcesz zacząć drogę: ");
        City.firstCity = scan.next();
    }
}
