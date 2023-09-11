import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class 供货管理 {
    public void 供货管理(){
        JFrame jFrame = new JFrame("供货管理");
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

        goback.addActionListener((e -> {
            if (goback.getText().equals("返回")) {
                jFrame.setVisible(false);//将登录界面设定为不可见
                new 功能总界面().SaleMainInterface();
            }
        }));

        JButton firm = new JButton("厂商");
        firm.setBounds(300, 30, 80, 30);
        firm.setFont(new Font("宋体", Font.PLAIN, 15));
        jFrame.add(firm);

        JButton display = new JButton("显示所有");
        display.setBounds(80, 80, 80, 30);
        display.setFont(new Font("宋体", Font.PLAIN, 10));
        jFrame.add(display);

        display.addActionListener((e -> {
            if (display.getText().equals("显示所有")) {
                String[] tableHead;
                String[][] content;
                JTable table;
                Query findRecord = new Query();
                findRecord.setDatabaseName("Loan_Management2");
                findRecord.setSQL("select * from firm ");
                content = findRecord.getRecord(); //返回二维数组，即查询的全部记录
                tableHead = findRecord.getColumnName();//返回全部字段（列）名
                table = new JTable(content, tableHead);
                JScrollPane jsp = new JScrollPane(table);
                jsp.setBounds(80, 280, 520, 300);
                jFrame.add(jsp);
            }
        }));

        JButton add = new JButton("添加");
        add.setBounds(80, 130, 80, 30);
        add.setFont(new Font("宋体", Font.PLAIN, 10));
        jFrame.add(add);

        add.addActionListener((e -> {
            if (add.getText().equals("添加")) {
                new 添加厂商().添加厂商();
            }
        }));

        JButton modify = new JButton("修改");
        modify.setBounds(80, 180, 80, 30);
        modify.setFont(new Font("宋体", Font.PLAIN, 10));
        jFrame.add(modify);

        modify.addActionListener((e -> {
            if (modify.getText().equals("修改")) {
                new 修改厂商().修改厂商();
            }
        }));

        JButton delete = new JButton("删除");
        delete.setBounds(80, 230, 80, 30);
        delete.setFont(new Font("宋体", Font.PLAIN, 10));
        jFrame.add(delete);


        JButton jb1 = new JButton("按厂商ID查询");
        jb1 .setBounds(220,80,120,30);
        jb1 .setFont(new Font("宋体",Font.PLAIN,10));
        jFrame.add(jb1 );

        JTextField jf1 = new JTextField(20);
        jf1.setBounds(360,80,130,30);
        jf1.setFont(new Font("宋体",Font.PLAIN,15));
        jFrame.add(jf1);

        jb1.addActionListener((e -> {
            if (jb1.getText().equals("按厂商ID查询")) {
                String[] tableHead1;
                String[][] content1;
                JTable table1;
                Query findRecord1 = new Query();
                findRecord1.setDatabaseName("Loan_Management2");
                String s = "'"+jf1.getText()+"'";
                String s1 = "select * from firm where firm_id =" + s;
                findRecord1.setSQL(s1);
                content1 = findRecord1.getRecord(); //返回二维数组，即查询的全部记录
                tableHead1 = findRecord1.getColumnName();//返回全部字段（列）名
                table1 = new JTable(content1, tableHead1);
                JScrollPane jsp3 = new JScrollPane(table1);
                jsp3.setBounds(80, 280, 520, 300);
                jFrame.add(jsp3);

            }
        }));

        JButton jb2 = new JButton("按厂商名称查询");
        jb2.setBounds(220,130,120,30);
        jb2.setFont(new Font("宋体",Font.PLAIN,10));
        jFrame.add(jb2);

        JTextField jf2 = new JTextField(20);
        jf2.setBounds(360,130,130,30);
        jf2.setFont(new Font("宋体",Font.PLAIN,15));
        jFrame.add(jf2);

        jb2.addActionListener((e -> {
            if (jb2.getText().equals("按厂商名称查询")) {
                String[] tableHead1;
                String[][] content1;
                JTable table1;
                Query findRecord1 = new Query();
                findRecord1.setDatabaseName("Loan_Management2");
                String s = "'"+jf2.getText()+"'";
                String s1 = "select * from firm where firm_name =" + s;
                findRecord1.setSQL(s1);
                content1 = findRecord1.getRecord(); //返回二维数组，即查询的全部记录
                tableHead1 = findRecord1.getColumnName();//返回全部字段（列）名
                table1 = new JTable(content1, tableHead1);
                JScrollPane jsp3 = new JScrollPane(table1);
                jsp3.setBounds(80, 280, 520, 300);
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
        JButton jb = new JButton("关闭");
        jb.setBounds(110,70,60,20);
        jb.setFont(new Font("宋体", Font.PLAIN, 10));
        jfram.add(jb);

        delete.addActionListener((e -> {
            if ( delete.getText().equals("删除")) {
                try {
                    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                    String url = "jdbc:sqlserver://127.0.0.1:1433;databaseName=Loan_Management2;user=test;password=123456";
                    Connection con = DriverManager.getConnection(url);
                    Statement statement = con.createStatement();
                    String s = "'"+jf2.getText()+"'";
                    String SQL = "delete from firm where firm_name=" + s;;
                    int result =statement.executeUpdate(SQL);
                    if (result == 1) {
                        System.out.println("yes");
                    } else {
                        System.out.println("no");
                    }
                    jfram.add(jl);
                    jfram.setVisible(true);
                    jb.addActionListener((a -> {
                        if (jb.getText().equals("关闭")) {
                            jfram.setVisible(false);
                        }
                    }));
                }catch (Exception a){
                    a.printStackTrace();
                }
            }
        }));

        JButton jb3 = new JButton("按负责人姓名查询");
        jb3.setBounds(220,180,120,30);
        jb3.setFont(new Font("宋体",Font.PLAIN,10));
        jFrame.add(jb3);

        JTextField jf3 = new JTextField(20);
        jf3.setBounds(360,180,130,30);
        jf3.setFont(new Font("宋体",Font.PLAIN,15));
        jFrame.add(jf3);

        jb3.addActionListener((e -> {
            if (jb3.getText().equals("按负责人姓名查询")) {
                String[] tableHead1;
                String[][] content1;
                JTable table1;
                Query findRecord1 = new Query();
                findRecord1.setDatabaseName("Loan_Management2");
                String s = "'"+jf3.getText()+"'";
                String s1 = "select * from firm where head_name =" + s;
                findRecord1.setSQL(s1);
                content1 = findRecord1.getRecord(); //返回二维数组，即查询的全部记录
                tableHead1 = findRecord1.getColumnName();//返回全部字段（列）名
                table1 = new JTable(content1, tableHead1);
                JScrollPane jsp3 = new JScrollPane(table1);
                jsp3.setBounds(80, 280, 520, 300);
                jFrame.add(jsp3);

            }
        }));

        JButton jb4 = new JButton("按厂商地址查询");
        jb4.setBounds(220,230,120,30);
        jb4.setFont(new Font("宋体",Font.PLAIN,10));
        jFrame.add(jb4);

        JTextField jf4 = new JTextField(20);
        jf4.setBounds(360,230,130,30);
        jf4.setFont(new Font("宋体",Font.PLAIN,15));
        jFrame.add(jf4);

        jb4.addActionListener((e -> {
            if (jb4.getText().equals("按厂商地址查询")) {
                String[] tableHead1;
                String[][] content1;
                JTable table1;
                Query findRecord1 = new Query();
                findRecord1.setDatabaseName("Loan_Management2");
                String s = "'"+jf4.getText()+"'";
                String s1 = "select * from firm where firm_address =" + s;
                findRecord1.setSQL(s1);
                content1 = findRecord1.getRecord(); //返回二维数组，即查询的全部记录
                tableHead1 = findRecord1.getColumnName();//返回全部字段（列）名
                table1 = new JTable(content1, tableHead1);
                JScrollPane jsp3 = new JScrollPane(table1);
                jsp3.setBounds(80, 280, 520, 300);
                jFrame.add(jsp3);

            }
        }));

        JButton reset = new JButton("重置");
        reset.setBounds(520, 230, 80, 30);
        reset.setFont(new Font("宋体", Font.PLAIN, 10));
        jFrame.add(reset);

        reset.addActionListener((e -> {
            if (reset.getText().equals("重置")) {
                jf1.setText("");
                jf2.setText("");
                jf3.setText("");
                jf4.setText("");
            }
        }));

        JScrollPane jsp1 = new JScrollPane();
        jsp1.setBounds(80, 280, 520, 300);
        jFrame.add(jsp1);

        JButton stock = new JButton("进货");
        stock.setBounds(880, 30, 80, 30);
        stock.setFont(new Font("宋体", Font.PLAIN, 15));
        jFrame.add(stock);

        JButton display2 = new JButton("显示所有");
        display2.setBounds(680, 80, 80, 30);
        display2.setFont(new Font("宋体", Font.PLAIN, 10));
        jFrame.add(display2);

        display2.addActionListener((e -> {
            if (display2.getText().equals("显示所有")) {
                String[] tableHead;
                String[][] content;
                JTable table;
                Query findRecord = new Query();
                findRecord.setDatabaseName("Loan_Management2");
                findRecord.setSQL("select * from book_firm ");
                content = findRecord.getRecord(); //返回二维数组，即查询的全部记录
                tableHead = findRecord.getColumnName();//返回全部字段（列）名
                table = new JTable(content, tableHead);
                JScrollPane jsp = new JScrollPane(table);
                jsp.setBounds(680, 280, 520, 300);
                jFrame.add(jsp);
            }
        }));

        JButton add2 = new JButton("添加");
        add2.setBounds(680, 130, 80, 30);
        add2.setFont(new Font("宋体", Font.PLAIN, 10));
        jFrame.add(add2);

        add2.addActionListener((e -> {
            if (add2.getText().equals("添加")) {
                new 添加进货().添加进货();
            }
        }));

        JButton modify2 = new JButton("修改");
        modify2.setBounds(680, 180, 80, 30);
        modify2.setFont(new Font("宋体", Font.PLAIN, 10));
        jFrame.add(modify2);

        modify2.addActionListener((e -> {
            if (modify2.getText().equals("修改")) {
                new 修改进货().修改进货();
            }
        }));



        JButton jb5 = new JButton("按书名查询");
        jb5 .setBounds(820,80,120,30);
        jb5 .setFont(new Font("宋体",Font.PLAIN,10));
        jFrame.add(jb5 );

        JTextField jf5 = new JTextField(20);
        jf5.setBounds(960,80,130,30);
        jf5.setFont(new Font("宋体",Font.PLAIN,15));
        jFrame.add(jf5);

        jb5.addActionListener((e -> {
            if (jb5.getText().equals("按书名查询")) {
                String[] tableHead1;
                String[][] content1;
                JTable table1;
                Query findRecord1 = new Query();
                findRecord1.setDatabaseName("Loan_Management2");
                String s = "'"+jf5.getText()+"'";
                String s1 = "select * from book_firm where book_name =" + s;
                findRecord1.setSQL(s1);
                content1 = findRecord1.getRecord(); //返回二维数组，即查询的全部记录
                tableHead1 = findRecord1.getColumnName();//返回全部字段（列）名
                table1 = new JTable(content1, tableHead1);
                JScrollPane jsp3 = new JScrollPane(table1);
                jsp3.setBounds(680, 280, 520, 300);
                jFrame.add(jsp3);

            }
        }));

        JButton jb6 = new JButton("按厂商ID查询");
        jb6.setBounds(820,130,120,30);
        jb6.setFont(new Font("宋体",Font.PLAIN,10));
        jFrame.add(jb6);

        JTextField jf6 = new JTextField(20);
        jf6.setBounds(960,130,130,30);
        jf6.setFont(new Font("宋体",Font.PLAIN,15));
        jFrame.add(jf6);

        jb6.addActionListener((e -> {
            if (jb6.getText().equals("按厂商ID查询")) {
                String[] tableHead1;
                String[][] content1;
                JTable table1;
                Query findRecord1 = new Query();
                findRecord1.setDatabaseName("Loan_Management2");
                String s = "'"+jf6.getText()+"'";
                String s1 = "select * from book_firm where firm_id =" + s;
                findRecord1.setSQL(s1);
                content1 = findRecord1.getRecord(); //返回二维数组，即查询的全部记录
                tableHead1 = findRecord1.getColumnName();//返回全部字段（列）名
                table1 = new JTable(content1, tableHead1);
                JScrollPane jsp3 = new JScrollPane(table1);
                jsp3.setBounds(680, 280, 520, 300);
                jFrame.add(jsp3);

            }
        }));

        JButton jb7 = new JButton("按进货时间查询");
        jb7.setBounds(820,180,120,30);
        jb7.setFont(new Font("宋体",Font.PLAIN,10));
        jFrame.add(jb7);

        JTextField jf7 = new JTextField(20);
        jf7.setBounds(960,180,130,30);
        jf7.setFont(new Font("宋体",Font.PLAIN,15));
        jFrame.add(jf7);

        jb7.addActionListener((e -> {
            if (jb7.getText().equals("按进货时间查询")) {
                String[] tableHead1;
                String[][] content1;
                JTable table1;
                Query findRecord1 = new Query();
                findRecord1.setDatabaseName("Loan_Management2");
                String s = "'"+jf7.getText()+"'";
                String s1 = "select * from book_firm where purchase_time =" + s;
                findRecord1.setSQL(s1);
                content1 = findRecord1.getRecord(); //返回二维数组，即查询的全部记录
                tableHead1 = findRecord1.getColumnName();//返回全部字段（列）名
                table1 = new JTable(content1, tableHead1);
                JScrollPane jsp3 = new JScrollPane(table1);
                jsp3.setBounds(680, 280, 520, 300);
                jFrame.add(jsp3);

            }
        }));


        JButton jb8 = new JButton("按出版社查询");
        jb8.setBounds(820,230,120,30);
        jb8.setFont(new Font("宋体",Font.PLAIN,10));
        jFrame.add(jb8);

        JTextField jf8 = new JTextField(20);
        jf8.setBounds(960,230,130,30);
        jf8.setFont(new Font("宋体",Font.PLAIN,15));
        jFrame.add(jf8);

        jb8.addActionListener((e -> {
            if (jb8.getText().equals("按出版社查询")) {
                String[] tableHead1;
                String[][] content1;
                JTable table1;
                Query findRecord1 = new Query();
                findRecord1.setDatabaseName("Loan_Management2");
                String s = "'"+jf8.getText()+"'";
                String s1 = "select * from book_firm where publish =" + s;
                findRecord1.setSQL(s1);
                content1 = findRecord1.getRecord(); //返回二维数组，即查询的全部记录
                tableHead1 = findRecord1.getColumnName();//返回全部字段（列）名
                table1 = new JTable(content1, tableHead1);
                JScrollPane jsp3 = new JScrollPane(table1);
                jsp3.setBounds(680, 280, 520, 300);
                jFrame.add(jsp3);

            }
        }));

        JButton reset2 = new JButton("重置");
        reset2.setBounds(1120, 230, 80, 30);
        reset2.setFont(new Font("宋体", Font.PLAIN, 10));
        jFrame.add(reset2);

        reset2.addActionListener((e -> {
            if (reset2.getText().equals("重置")) {
                jf5.setText("");
                jf6.setText("");
                jf7.setText("");
                jf8.setText("");
            }
        }));

        JScrollPane jsp2 = new JScrollPane();
        jsp2.setBounds(680, 280, 520, 300);
        jFrame.add(jsp2);
    }
    public static void main(String args[]){
        供货管理 g = new 供货管理();
        g.供货管理();
    }
}
