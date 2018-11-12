import javax.sound.midi.Soundbank;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Stack;

public class Main
{
    public static void main(String[] args) {
        UserInterface ui = new UserInterface();
        City city = City.getInstance();

        ui.init();

        int cityQuantity = City.cityQuantity;
        for(int i=1;i<cityQuantity;i++){
            city.swapCity();
            city.findShortestWay();
        }

        for(String cities : city.cityOrder){
            System.out.print(cities);
        }

    }
}