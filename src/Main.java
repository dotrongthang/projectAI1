import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Methods methods = new Methods();
        Scanner scanner = new Scanner(System.in);
        int choose;
        do {
            methods.showMenu();
            choose = scanner.nextInt();
            switch (choose){
                case 1: methods.case1();
                    break;
                case 2: methods.showResult();
                    break;
                case 3:
                    System.out.println("Thoát");
                    break;
            }
        }while (choose != 3);

    }

}
