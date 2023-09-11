import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class 职员管理 {

    public void 职员管理() {
        JFrame jFrame = new JFrame("职员管理");
        jFrame.setSize(1400, 900);
        jFrame.setLocationRelativeTo(null);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setResizable(false);
        jFrame.setVisible(true);
        jFrame.setLayout(null);

        JButton goback = new JButton("返回");
        goback.setBounds(600, 600, 80, 30);
        goback.setFont(new Font("宋体", Font.PLAIN, 10));
        jFrame.add(goback);

        JButton display = new JButton("显示所有");
        display.setBounds(80, 30, 100, 30);
        display.setFont(new Font("宋体", Font.PLAIN, 10));
        jFrame.add(display);

        JButton add = new JButton("添加");
        add.setBounds(850, 30, 100, 30);
        add.setFont(new Font("宋体", Font.PLAIN, 10));
        jFrame.add(add);

        JButton modify = new JButton("修改");
        modify.setBounds(700, 30, 100, 30);
        modify.setFont(new Font("宋体", Font.PLAIN, 10));
        jFrame.add(modify);

        JButton delete = new JButton("职员ID删除");
        delete.setBounds(550, 30, 100, 30);
        delete.setFont(new Font("宋体", Font.PLAIN, 9));
        jFrame.add(delete);

        JButton reset = new JButton("重置");
        reset.setBounds(550, 80, 100, 30);
        reset.setFont(new Font("宋体", Font.PLAIN, 10));
        jFrame.add(reset);


        JButton jb1 = new JButton("职员ID查询");
        jb1.setBounds(220, 30, 100, 30);
        jb1.setFont(new Font("宋体", Font.PLAIN, 10));
        jFrame.add(jb1);

        JTextField jf1 = new JTextField(20);
        jf1.setBounds(350, 30, 130, 30);
        jf1.setFont(new Font("宋体", Font.PLAIN, 15));
        jFrame.add(jf1);

        JButton jb2 = new JButton("按姓名查询");
        jb2.setBounds(220, 80, 100, 30);
        jb2.setFont(new Font("宋体", Font.PLAIN, 10));
        jFrame.add(jb2);

        JTextField jf2 = new JTextField(20);
        jf2.setBounds(350, 80, 130, 30);
        jf2.setFont(new Font("宋体", Font.PLAIN, 15));
        jFrame.add(jf2);


        JTextField jf3= new JTextField(20);
        jf2.setBounds(350, 80, 130, 30);
        jf2.setFont(new Font("宋体", Font.PLAIN, 15));
        jFrame.add(jf2);




        //书籍
        display.addActionListener((e -> {
            if (display.getText().equals("显示所有")) {
                String[] tableHead;
                String[][] content;
                JTable table;
                Query findRecord = new Query();
                findRecord.setDatabaseName("Loan_Management2");
                findRecord.setSQL("select * from manager ");
                content = findRecord.getRecord(); //返回二维数组，即查询的全部记录
                tableHead = findRecord.getColumnName();//返回全部字段（列）名
                table = new JTable(content, tableHead);
                JScrollPane jsp = new JScrollPane(table);
                jsp.setBounds(80, 240, 640, 300);
                jFrame.add(jsp);
            }
        }));

        goback.addActionListener((e -> {
            if (goback.getText().equals("返回")) {
                jFrame.setVisible(false);//将登录界面设定为不可见
                new 功能总界面().SaleMainInterface();
            }
        }));

        jb2.addActionListener((e -> {
            if (jb2.getText().equals("按姓名查询")) {
                String[] tableHead1;
                String[][] content1;
                JTable table1;
                Query findRecord1 = new Query();
                findRecord1.setDatabaseName("Loan_Management2");
                String s = "'"+jf2.getText()+"'";
                String s1 = "select * from manager where manager_name =" + s;
                findRecord1.setSQL(s1);
                content1 = findRecord1.getRecord(); //返回二维数组，即查询的全部记录
                tableHead1 = findRecord1.getColumnName();//返回全部字段（列）名
                table1 = new JTable(content1, tableHead1);
                JScrollPane jsp3 = new JScrollPane(table1);
                jsp3.setBounds(80, 240, 640, 300);
                jFrame.add(jsp3);

            }
        }));

        jb1.addActionListener((e -> {
            if (jb1.getText().equals("职员ID查询")) {
                String[] tableHead1;
                String[][] content1;
                JTable table1;
                Query findRecord1 = new Query();
                findRecord1.setDatabaseName("Loan_Management2");
                String s = "'"+jf1.getText()+"'";
                String s1 = "select * from manager where manager_id =" + s;
                findRecord1.setSQL(s1);
                content1 = findRecord1.getRecord(); //返回二维数组，即查询的全部记录
                tableHead1 = findRecord1.getColumnName();//返回全部字段（列）名
                table1 = new JTable(content1, tableHead1);
                JScrollPane jsp3 = new JScrollPane(table1);
                jsp3.setBounds(80, 240, 640, 300);
                jFrame.add(jsp3);

            }
        }));

        JFrame jfram = new JFrame();
        jfram.setSize(300, 200);
        jfram.setLocationRelativeTo(null);
        jfram.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jfram.setResizable(false);
        jfram.setVisible(false);
        jfram.setLayout(null);
        JLabel jl = new JLabel("删除成功");
        jl.setBounds(100,20,80,30);
        jl.setFont(new Font("宋体", Font.PLAIN, 20));
        JButton jb11 = new JButton("关闭");
        jb11.setBounds(110,70,60,20);
        jb11.setFont(new Font("宋体", Font.PLAIN, 10));
        jfram.add(jb11);

        delete.addActionListener((e -> {
            if ( delete.getText().equals("职员ID删除")) {
                try {
                    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                    String url = "jdbc:sqlserver://127.0.0.1:1433;databaseName=Loan_Management2;user=test;password=123456";
                    Connection con = DriverManager.getConnection(url);
                    Statement statement = con.createStatement();
                    String s = "'"+jf1.getText()+"'";
                    String SQL = "delete from manager where manager_id=" + s;;
                    int result =statement.executeUpdate(SQL);
                    if (result == 1) {
                        System.out.println("yes");
                        jfram.add(jl);
                        jfram.setVisible(true);
                        jb11.addActionListener((a -> {
                            if (jb11.getText().equals("关闭")) {
                                jfram.setVisible(false);
                            }
                        }));
                    } else {
                        System.out.println("no");
                    }
                }catch (Exception a){
                    a.printStackTrace();
                }
            }


        }));

        add.addActionListener((e -> {
            if (add.getText().equals("添加")) {
                new 添加职员信息().添加职员信息();
            }
        }));

        modify.addActionListener((e -> {
            if (modify.getText().equals("修改")) {
                new 修改职员信息().修改职员信息();
            }
        }));

        reset.addActionListener((e -> {
            if (reset.getText().equals("重置")) {
                jf1.setText("");
                jf2.setText("");
            }
        }));


    }

    public static void main(String args[]){
        职员管理 t = new 职员管理();
        t.职员管理();
    }
}
