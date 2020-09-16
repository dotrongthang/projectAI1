import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Methods {
    public ArrayList<Clause> clauses = new ArrayList<>();
    public int q1 = 0, q2 = 0, q3 = 0, index;
    public Scanner scanner = new Scanner(System.in);
    Rules rules = new Rules();

    public ArrayList<Clause> addData(ArrayList<Clause> quantifiers){
        Clause q1 = new Clause("A", "universal", true, 5, 1);
        Clause q2 = new Clause("E", "universal", false, 5, 5);
        Clause q3 = new Clause("P", "predominant", true, 4, 1);
        Clause q4 = new Clause("B", "predominant", false, 4, 5);
        Clause q5 = new Clause("T", "majority", true, 3, 1);
        Clause q6 = new Clause("D", "majority", false, 3, 5);
        Clause q7 = new Clause("K", "common", true, 2, 1);
        Clause q8 = new Clause("G", "common", false, 2, 5);
        Clause q9 = new Clause("I", "particular", true, 1, 1);
        Clause q10 = new Clause("O", "particular", false, 1, 5);

        clauses.add(q1);
        clauses.add(q2);
        clauses.add(q3);
        clauses.add(q4);
        clauses.add(q5);
        clauses.add(q6);
        clauses.add(q7);
        clauses.add(q8);
        clauses.add(q9);
        clauses.add(q10);

        return clauses;
    }

    public void case1(){
        String s;
        boolean b;

        do {
            System.out.println("------------------");
            System.out.println("Mời bạn nhập tam đoạn luận bất kì dạng xxx-y:" + "\n"
                    + "(Trong đó x thuộc {A,E,P,B,T,D,K,G,I,O}, y thuộc [1,4]");
            s = scanner.nextLine();
            b = checkString(s);
            if (!b){
                System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++");
                System.out.println("Bạn nhập không đúng định dạng, vui lòng nhập lại!");
                System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++");
            }
        }while (!b);

        char[] c = s.toCharArray();
        if (convert(String.valueOf(c[0])) >= 0){
            q1 = convert(String.valueOf(c[0]));
        }
        if (convert(String.valueOf(c[1])) >= 0){
            q2 = convert(String.valueOf(c[1]));
        }
        if (convert(String.valueOf(c[2])) >= 0){
            q3 = convert(String.valueOf(c[2]));
        }
        index = Integer.parseInt(String.valueOf(c[4]));

//        System.out.println("Lựa chọn của bạn là: " + clauses.get(q1).getSign() +
//                clauses.get(q2).getSign() + clauses.get(q3).getSign() + "-" + index);

        System.out.println("Kết quả của bạn là:");
        System.out.println(rules.rule1(clauses.get(q1),
                clauses.get(q2), clauses.get(q3), index) +"-"+
                rules.rule2(clauses.get(q1),
                        clauses.get(q2), clauses.get(q3), index) +"-"+
                rules.rule3(clauses.get(q1),
                        clauses.get(q2), clauses.get(q3)) +"-"+
                rules.rule4(clauses.get(q1),
                        clauses.get(q2), clauses.get(q3)));
    }

    public boolean checkString(String s){ // kiểm tra chuỗi người dùng nhập vào
        String regex = "^[AEPBTDKGIO][AEPBTDKGIO][AEPBTDKGIO]-[1-4]$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(s);
        if (matcher.find()){
            return true;
        }else {
            return false;
        }
    }

    public int convert(String s){
        if (s.compareTo("A") == 0) {
            return 0;
        }
        if (s.compareTo("E") == 0) {
            return 1;
        }
        if (s.compareTo("P") == 0) {
            return 2;
        }
        if (s.compareTo("B") == 0) {
            return 3;
        }
        if (s.compareTo("T") == 0) {
            return 4;
        }
        if (s.compareTo("D") == 0) {
            return 5;
        }
        if (s.compareTo("K") == 0) {
            return 6;
        }
        if (s.compareTo("G") == 0) {
            return 7;
        }
        if (s.compareTo("I") == 0) {
            return 8;
        }
        if (s.compareTo("O") == 0) {
            return 9;
        }
       return -1;
    }

    public boolean checkResult(Clause q1, Clause q2, Clause q3, int figure){
        if (rules.rule1(q1,q2,q3,figure) && rules.rule2(q1,q2,q3,figure) &&
                rules.rule3(q1,q2,q3) && rules.rule4(q1,q2,q3)){
            return true;
        }else {
            return false;
        }

    }

    public void showResult(){
        int index = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < 10; k++) {
                    for (int l = 1; l <= 4; l++) {
                        if (checkResult(clauses.get(i), clauses.get(j), clauses.get(k), l)){
                            if (index % 5 == 0){
                                System.out.println();
                            }
                            System.out.print(clauses.get(i).getSign() + clauses.get(j).getSign() +
                                    clauses.get(k).getSign() + "-" + l +  ":" + "TTTT" + "\t");
                            index++;
                        }
                    }
                }
            }
        }
        System.out.println();
        System.out.println("---------------------------------");
        System.out.println("Có " + index + " kết quả phù hợp");
    }

    public void showMenu(){
        addData(clauses);
        Main main = new Main();

        System.out.println("----------MENU----------");
        System.out.println("1. Kiểm tra tam đoạn luận bất kỳ.");
        System.out.println("2. Xem tất cả kết quả thỏa mãn.");
        System.out.println("3. Thoát.");
        System.out.println("------------------------");
        System.out.println("Mời bạn chọn !");
        }

}
