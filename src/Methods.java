import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Methods extends JFrame {
    public ArrayList<Clause> clauses = new ArrayList<>();
    public int q1 = 0, q2 = 0, q3 = 0, index;  //xác loại tam đoạn luận
    Rules rules = new Rules();
    boolean checkShow = true;
    ArrayList<String> listResult = new ArrayList<>();
    JComboBox cbo1, cbo2, cbo3;  //combo box
    JTextField txtS1, txtS2, txtP1, txtP2, txtS3, txtP3; //lưu dữ liệu người dùng nhập
    String[] arrayClause = {"All S are P", "No S are P", "Almost all S are P",
            "Almost all S are not P", "Most S are P", "Most S are not P"
            , "Many S are P", "Many S are not P", "Some S are P", "Some S are not P"} ;

    public void initUI(){
        addData(clauses);
        JTabbedPane myTable = new JTabbedPane();
        JPanel checkPn = new JPanel();  //layout kiểm tra
        JPanel showPn = new JPanel();   //layout danh sách
        createClause1(checkPn, "Choose type of clause 1: ");
        createClause2(checkPn, "Choose type of clause 2: ");
        createClause3(checkPn, "Choose type of clause 3: ");
        createExample(checkPn);
        createButton(checkPn);
        myTable.add(checkPn,"Check");

        createLayoutShow(showPn);
        myTable.add(showPn,"Show Result");

        Container con = getContentPane();
        con.add(myTable);

    }

    public void createClause1(JPanel jPanel, String s){ //tiền đề 1
        jPanel.setLayout(null);

        JLabel lblclause = new JLabel(s);
        lblclause.setBounds(20,50,150,25);
        jPanel.add(lblclause);

        cbo1 = new JComboBox();
        addToCbo(cbo1, arrayClause);
        cbo1.setBounds(170,50,190,25);
        jPanel.add(cbo1);

        JLabel lblS = new JLabel("Input S: ");
        lblS.setBounds(370,50,50,25);
        jPanel.add(lblS);

        txtS1 = new JTextField();
        txtS1.setBounds(430,50,200,25);
        jPanel.add(txtS1);

        JLabel lblP = new JLabel("Input P: ");
        lblP.setBounds(640,50,50,25);
        jPanel.add(lblP);

        txtP1 = new JTextField();
        txtP1.setBounds(700,50,200,25);
        jPanel.add(txtP1);
    }

    public void createClause2(JPanel jPanel, String s){
        jPanel.setLayout(null);

        JLabel lblclause = new JLabel(s);
        lblclause.setBounds(20,100,150,25);
        jPanel.add(lblclause);

        cbo2 = new JComboBox();
        addToCbo(cbo2, arrayClause);
        cbo2.setBounds(170,100,190,25);
        jPanel.add(cbo2);

        JLabel lblS = new JLabel("Input S: ");
        lblS.setBounds(370,100,50,25);
        jPanel.add(lblS);

        txtS2 = new JTextField();
        txtS2.setBounds(430,100,200,25);
        jPanel.add(txtS2);

        JLabel lblP = new JLabel("Input P: ");
        lblP.setBounds(640,100,50,25);
        jPanel.add(lblP);

        txtP2 = new JTextField();
        txtP2.setBounds(700,100,200,25);
        jPanel.add(txtP2);
    }

    public void createClause3(JPanel jPanel, String s){
        jPanel.setLayout(null);

        JLabel lblclause = new JLabel(s);
        lblclause.setBounds(20,150,150,25);
        jPanel.add(lblclause);

        cbo3 = new JComboBox();
        addToCbo(cbo3, arrayClause);
        cbo3.setBounds(170,150,190,25);
        jPanel.add(cbo3);

        JLabel lblS = new JLabel("Input S: ");
        lblS.setBounds(370,150,50,25);
        jPanel.add(lblS);

        txtS3 = new JTextField();
        txtS3.setBounds(430,150,200,25);
        jPanel.add(txtS3);

        JLabel lblP = new JLabel("Input P: ");
        lblP.setBounds(640,150,50,25);
        jPanel.add(lblP);

        txtP3 = new JTextField();
        txtP3.setBounds(700,150,200,25);
        jPanel.add(txtP3);
    }


    public void addToCbo(JComboBox cbo, String[] s){  //tạo combo box
        for (int i = 0; i < 10; i++) {
            cbo.addItem(s[i]);
        }
    }

    public void createExample(JPanel jPanel){
        JLabel jLabel = new JLabel("Example: All cats are animals");
        jLabel.setBounds(20,200,200,25);
        jLabel.setForeground(Color.RED);
        jPanel.add(jLabel);

        JLabel jLabel2 = new JLabel("Type: All S are P, input S: cats, input P: animals");
        jLabel2.setBounds(20,225,400,25);
        jLabel2.setForeground(Color.RED);
        jPanel.add(jLabel2);
    }

    public void createButton(JPanel jPanel){
        JButton okBtn = new JButton("Check");
        okBtn.setBounds(300,270,100,40);
        okBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,checkResult(),"Result",1);
                txtS1.setText("");txtS2.setText("");txtS3.setText("");
                txtP1.setText("");txtP2.setText("");txtP3.setText("");
            }
        });
        jPanel.add(okBtn);

        JButton exitBtn = new JButton("Exit");
        exitBtn.setBounds(500,270,100,40);
        exitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        jPanel.add(exitBtn);
    }

    public int checkFigure(){  //xác định loại công thức
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
            s = "Please enter enough information!";
        }else {
            s = "R1:" + rules.rule1(clauses.get(q1),
                clauses.get(q2), clauses.get(q3), index) +" - "+ "R2:" +
                rules.rule2(clauses.get(q1),
                        clauses.get(q2), clauses.get(q3), index) +" - " + "R3:" +
                rules.rule3(clauses.get(q1),
                        clauses.get(q2), clauses.get(q3)) +" - "+ "R4:" +
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

    public void createLayoutShow(JPanel jPanel){ //tạo layout danh sách kết quả
        jPanel.setLayout(null);
        JLabel jLabel = new JLabel("Show all the results satisfying the 4 rules R1, R2, R3, R4");
        jLabel.setBounds(300, 15, 500, 25);
        jLabel.setForeground(Color.RED);
        jPanel.add(jLabel);

        JButton showBtn = new JButton("Show");
        showBtn.setBounds(300,50,100,25);
        showBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (checkShow){
                    showResult(jPanel);
                    createJlabel(jPanel);
                    jPanel.setVisible(false);
                    checkShow = false;
                }
            }
        });
        jPanel.setVisible(true);
        jPanel.add(showBtn);

        JButton exitShow = new JButton("Exit");
        exitShow.setBounds(500,50,100,25);
        exitShow.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        jPanel.add(exitShow);
    }

    public void createJlabel(JPanel jPanel){ //in danh sách
        int x = -30, y = 90, w = 60, h = 20, count = 0;
        for (int i = 0; i < listResult.size(); i++) {
            if (count != 0 && count % 12 == 0){
                x = -30;
                y += 30;
            }
            x  += 70;
            JLabel jLabel = new JLabel(listResult.get(i));
            jLabel.setBounds(x, y, w, h);
            jPanel.add(jLabel);
            count++;
        }
        y += 50;
        JLabel jLabel = new JLabel("There are " + listResult.size() + " result");
        jLabel.setBounds(400,y,200,25);
        jPanel.add(jLabel);
    }

    public boolean checkResult(Clause q1, Clause q2, Clause q3, int figure){
        if (rules.rule1(q1,q2,q3,figure) && rules.rule2(q1,q2,q3,figure) &&
                rules.rule3(q1,q2,q3) && rules.rule4(q1,q2,q3)){
            return true;
        }else {
            return false;
        }

    }

    public void showResult(JPanel jPanel){
        int index12 = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < 10; k++) {
                    for (int l = 1; l <= 4; l++) {
                        if (checkResult(clauses.get(i), clauses.get(j), clauses.get(k), l)){
                            String string = (clauses.get(i).getSign() + clauses.get(j).getSign() +
                                    clauses.get(k).getSign() + "-" + l);
                            listResult.add(string);
                            index12++;
                        }
                    }
                }
            }
        }
    }

}
