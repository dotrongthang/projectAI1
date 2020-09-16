import java.util.ArrayList;
import java.util.Scanner;

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
        System.out.println("A: 1");
        System.out.println("E: 2");
        System.out.println("P: 3");
        System.out.println("B: 4");
        System.out.println("T: 5");
        System.out.println("D: 6");
        System.out.println("K: 7");
        System.out.println("G: 8");
        System.out.println("I: 9");
        System.out.println("O: 10");
        System.out.println("------------------");
        System.out.println("Mời bạn nhập tiền đề 1:");
        q1 = scanner.nextInt();
        System.out.println("Mời bạn nhập tiền đề 2:");
        q2 = scanner.nextInt();
        System.out.println("Mời bạn nhập mệnh đề:");
        q3 = scanner.nextInt();
        System.out.println("Mời bạn nhập công thức diễn dịch (1 -4):");
        index = scanner.nextInt();

        System.out.println("Lựa chọn của bạn là: " + clauses.get(q1-1).getSign() +
                clauses.get(q2-1).getSign() + clauses.get(q3-1).getSign() + "-" + index);

        System.out.println("Kết quả của bạn là:");
        System.out.println(rules.rule1(clauses.get(q1-1),
                clauses.get(q2-1), clauses.get(q3-1), index) +"-"+
                rules.rule2(clauses.get(q1-1),
                        clauses.get(q2-1), clauses.get(q3-1), index) +"-"+
                rules.rule3(clauses.get(q1-1),
                        clauses.get(q2-1), clauses.get(q3-1)) +"-"+
                rules.rule4(clauses.get(q1-1),
                        clauses.get(q2-1), clauses.get(q3-1)));
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
