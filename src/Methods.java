import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Methods extends JFrame {
    public ArrayList<Clause> clauses = new ArrayList<>();
    public int q1 = 0, q2 = 0, q3 = 0, index;
    Rules rules = new Rules();
    JComboBox cbo1, cbo2, cbo3;  //combo box
    JTextField txtS1, txtS2, txtP1, txtP2, txtS3, txtP3; //lưu dữ liệu người dùng nhập
    String[] arrayClause = {"Tất cả S là P", "Tất cả S không là P", "Gần như tất cả S là P",
            "Gần như tất cả S không là P", "Hầu hết S là P", "Hầu hết S không là P"
            , "Nhiều S là P", "Nhiều S không là P", "Một vài S là P", "Một vài S không là P"} ;

    public void initUI(){
        addData(clauses);
        JTabbedPane myTable = new JTabbedPane();
        JPanel checkPn = new JPanel();
        JPanel showPn = new JPanel();
        createClause1(checkPn, "Chọn loại tiền đề 1: ");
        createClause2(checkPn, "Chọn loại tiền đề 2: ");
        createClause3(checkPn, "Chọn loại mệnh đề: ");
        createButton(checkPn);
        myTable.add(checkPn,"Kiểm tra");
        myTable.add(showPn,"Xem kết quả");

        Container con = getContentPane();
        con.add(myTable);

    }

    public void createClause1(JPanel jPanel, String s){
        jPanel.setLayout(null);

        JLabel lblclause = new JLabel(s);
        lblclause.setBounds(20,50,120,25);
        jPanel.add(lblclause);

        cbo1 = new JComboBox();
        addToCbo(cbo1, arrayClause);
        cbo1.setBounds(140,50,190,25);
        jPanel.add(cbo1);

        JLabel lblS = new JLabel("Nhập S: ");
        lblS.setBounds(340,50,50,25);
        jPanel.add(lblS);

        txtS1 = new JTextField();
        txtS1.setBounds(400,50,200,25);
        jPanel.add(txtS1);

        JLabel lblP = new JLabel("Nhập P: ");
        lblP.setBounds(610,50,50,25);
        jPanel.add(lblP);

        txtP1 = new JTextField();
        txtP1.setBounds(670,50,200,25);
        jPanel.add(txtP1);
    }

    public void createClause2(JPanel jPanel, String s){
        jPanel.setLayout(null);

        JLabel lblclause = new JLabel(s);
        lblclause.setBounds(20,100,120,25);
        jPanel.add(lblclause);

        cbo2 = new JComboBox();
        addToCbo(cbo2, arrayClause);
        cbo2.setBounds(140,100,190,25);
        jPanel.add(cbo2);

        JLabel lblS = new JLabel("Nhập S: ");
        lblS.setBounds(340,100,50,25);
        jPanel.add(lblS);

        txtS2 = new JTextField();
        txtS2.setBounds(400,100,200,25);
        jPanel.add(txtS2);

        JLabel lblP = new JLabel("Nhập P: ");
        lblP.setBounds(610,100,50,25);
        jPanel.add(lblP);

        txtP2 = new JTextField();
        txtP2.setBounds(670,100,200,25);
        jPanel.add(txtP2);
    }

    public void createClause3(JPanel jPanel, String s){
        jPanel.setLayout(null);

        JLabel lblclause = new JLabel(s);
        lblclause.setBounds(20,150,120,25);
        jPanel.add(lblclause);

        cbo3 = new JComboBox();
        addToCbo(cbo3, arrayClause);
        cbo3.setBounds(140,150,190,25);
        jPanel.add(cbo3);

        JLabel lblS = new JLabel("Nhập S: ");
        lblS.setBounds(340,150,50,25);
        jPanel.add(lblS);

        txtS3 = new JTextField();
        txtS3.setBounds(400,150,200,25);
        jPanel.add(txtS3);

        JLabel lblP = new JLabel("Nhập P: ");
        lblP.setBounds(610,150,50,25);
        jPanel.add(lblP);

        txtP3 = new JTextField();
        txtP3.setBounds(670,150,200,25);
        jPanel.add(txtP3);
    }


    public void addToCbo(JComboBox cbo, String[] s){
        for (int i = 0; i < 10; i++) {
            cbo.addItem(s[i]);
        }
    }

    public void createButton(JPanel jPanel){
        JButton okBtn = new JButton("Kiểm tra");
        okBtn.setBounds(300,250,100,40);
        okBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showConfirmDialog(null,checkResult(),"Kết quả",0);

            }
        });
        jPanel.add(okBtn);

        JButton exitBtn = new JButton("Thoát");
        exitBtn.setBounds(500,250,100,40);
        exitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        jPanel.add(exitBtn);
    }

    public int checkFigure(){
        if (txtS1.getText().length() != 0 && txtS2.getText().length() != 0 &&
                txtP1.getText().length() != 0 && txtP2.getText().length() != 0){
            if (txtS1.getText().compareTo(txtP2.getText()) == 0){
                return 1;
            }else {
                if (txtS1.getText().compareTo(txtS2.getText()) == 0){
                    return 3;
                }
                if (txtP1.getText().compareTo(txtP2.getText()) == 0){
                    return 2;
                }
                if (txtP1.getText().compareTo(txtS2.getText()) == 0){
                    return 4;
                }
            }
        }
        return -1;
    }

    public String checkResult(){
        String s = "";
        q1 = cbo1.getSelectedIndex();
        q2 = cbo2.getSelectedIndex();
        q3 = cbo3.getSelectedIndex();
        index = checkFigure();

        if (index == -1){
            s = "Vui lòng nhập đầy đủ thông tin!";
        }else {
            s = rules.rule1(clauses.get(q1),
                clauses.get(q2), clauses.get(q3), index) +"-"+
                rules.rule2(clauses.get(q1),
                        clauses.get(q2), clauses.get(q3), index) +"-"+
                rules.rule3(clauses.get(q1),
                        clauses.get(q2), clauses.get(q3)) +"-"+
                rules.rule4(clauses.get(q1),
                        clauses.get(q2), clauses.get(q3));
        }
        return s;
    }

    public ArrayList<Clause> addData(ArrayList<Clause> quantifiers){
        clauses.add(new Clause("A", "universal", true, 5, 1));
        clauses.add(new Clause("E", "universal", false, 5, 5));
        clauses.add(new Clause("P", "predominant", true, 4, 1));
        clauses.add(new Clause("B", "predominant", false, 4, 5));
        clauses.add(new Clause("T", "majority", true, 3, 1));
        clauses.add(new Clause("D", "majority", false, 3, 5));
        clauses.add(new Clause("K", "common", true, 2, 1));
        clauses.add(new Clause("G", "common", false, 2, 5));
        clauses.add(new Clause("I", "particular", true, 1, 1));
        clauses.add(new Clause("O", "particular", false, 1, 5));

        return clauses;
    }

//        System.out.println("Kết quả của bạn là:");
//        System.out.println(rules.rule1(clauses.get(q1),
//                clauses.get(q2), clauses.get(q3), index) +"-"+
//                rules.rule2(clauses.get(q1),
//                        clauses.get(q2), clauses.get(q3), index) +"-"+
//                rules.rule3(clauses.get(q1),
//                        clauses.get(q2), clauses.get(q3)) +"-"+
//                rules.rule4(clauses.get(q1),
//                        clauses.get(q2), clauses.get(q3)));
//    }




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

}
