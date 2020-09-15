import java.util.ArrayList;
import java.util.Scanner;

public class Methods {
    public ArrayList<Quantifier> quantifiers = new ArrayList<>();
    public int q1 = 0, q2 = 0, q3 = 0, index;
    public Scanner scanner = new Scanner(System.in);
    Law law = new Law();

    public ArrayList<Quantifier> addData(ArrayList<Quantifier> quantifiers){
        Quantifier q1 = new Quantifier("A", "universal", true, 5, 1);
        Quantifier q2 = new Quantifier("E", "universal", false, 5, 5);
        Quantifier q3 = new Quantifier("P", "predominant", true, 4, 1);
        Quantifier q4 = new Quantifier("B", "predominant", false, 4, 5);
        Quantifier q5 = new Quantifier("T", "majority", true, 3, 1);
        Quantifier q6 = new Quantifier("D", "majority", false, 3, 5);
        Quantifier q7 = new Quantifier("K", "common", true, 2, 1);
        Quantifier q8 = new Quantifier("G", "common", false, 2, 5);
        Quantifier q9 = new Quantifier("I", "particular", true, 1, 1);
        Quantifier q10 = new Quantifier("O", "particular", false, 1, 5);

        quantifiers.add(q1);
        quantifiers.add(q2);
        quantifiers.add(q3);
        quantifiers.add(q4);
        quantifiers.add(q5);
        quantifiers.add(q6);
        quantifiers.add(q7);
        quantifiers.add(q8);
        quantifiers.add(q9);
        quantifiers.add(q10);

        return quantifiers;
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

        System.out.println("Lựa chọn của bạn là: " + quantifiers.get(q1-1).getSign() +
                quantifiers.get(q2-1).getSign() + quantifiers.get(q3-1).getSign() + "-" + index);

        System.out.println("Kết quả của bạn là:");
        System.out.println(law.law1(quantifiers.get(q1-1),
                quantifiers.get(q2-1), quantifiers.get(q3-1), index) +"-"+
                law.law2(quantifiers.get(q1-1),
                        quantifiers.get(q2-1), quantifiers.get(q3-1), index) +"-"+
                law.law3(quantifiers.get(q1-1),
                        quantifiers.get(q2-1), quantifiers.get(q3-1)) +"-"+
                law.law4(quantifiers.get(q1-1),
                        quantifiers.get(q2-1), quantifiers.get(q3-1)));
    }

    public boolean checkResult(Quantifier q1, Quantifier q2, Quantifier q3, int figure){
        if (law.law1(q1,q2,q3,figure) && law.law2(q1,q2,q3,figure) &&
                law.law3(q1,q2,q3) && law.law4(q1,q2,q3)){
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
                        if (checkResult(quantifiers.get(i), quantifiers.get(j), quantifiers.get(k), l)){
                            if (index % 5 == 0){
                                System.out.println();
                            }
                            System.out.print(quantifiers.get(i).getSign() + quantifiers.get(j).getSign() +
                                    quantifiers.get(k).getSign() + "-" + l +  ":" + "TTTT" + "\t");
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
        addData(quantifiers);
        Main main = new Main();

        System.out.println("----------MENU----------");
        System.out.println("1. Kiểm tra tam đoạn luận bất kỳ.");
        System.out.println("2. Xem tất cả kết quả thỏa mãn.");
        System.out.println("3. Thoát.");
        System.out.println("------------------------");
        System.out.println("Mời bạn chọn !");
        }

}
