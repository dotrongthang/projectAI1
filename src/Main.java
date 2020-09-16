import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {

        Methods methods = new Methods();
        Scanner scanner = new Scanner(System.in);
        boolean check = false;
        String s;
        int choose;
        do {
            methods.showMenu();
            s = scanner.nextLine();
            choose = checkNum(s);
            switch (choose){
                case 1: methods.case1();
                check = true;
                    break;
                case 2: methods.showResult();
                    check = true;
                    break;
                case 3:
                    System.out.println("Thoát");
                    check = false;
                    break;
                default:check = true;
                    System.out.println("Bạn chọn chưa đúng !");
            }
        }while (check);


    }

    public static int checkNum(String s){
        String regex = "^[1-3]$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(s);
        if (matcher.find()){
            return Integer.parseInt(s);
        }else {
            return -1;
        }
    }

}
