import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class 图书管理 {

    public void 图书管理() {
        JFrame jFrame = new JFrame("图书管理");
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
        display.setBounds(80, 30, 80, 30);
        display.setFont(new Font("宋体", Font.PLAIN, 10));
        jFrame.add(display);

        JButton special = new JButton("特价书");
        special.setBounds(80, 80, 80, 30);
        special.setFont(new Font("宋体", Font.PLAIN, 10));
        jFrame.add(special);

        JButton add = new JButton("添加");
        add.setBounds(80, 130, 80, 30);
        add.setFont(new Font("宋体", Font.PLAIN, 10));
        jFrame.add(add);

        JButton modify = new JButton("修改");
        modify.setBounds(80, 180, 80, 30);
        modify.setFont(new Font("宋体", Font.PLAIN, 10));
        jFrame.add(modify);

        JButton reset = new JButton("重置");
        reset.setBounds(520, 180, 80, 30);
        reset.setFont(new Font("宋体", Font.PLAIN, 10));
        jFrame.add(reset);

        JButton jb1 = new JButton("按类型查询");
        jb1 .setBounds(220,30,100,30);
        jb1 .setFont(new Font("宋体",Font.PLAIN,10));
        jFrame.add(jb1 );

        JTextField jf1 = new JTextField(20);
        jf1.setBounds(350,30,130,30);
        jf1.setFont(new Font("宋体",Font.PLAIN,15));
        jFrame.add(jf1);

        JButton jb2 = new JButton("按书名查询");
        jb2.setBounds(220,80,100,30);
        jb2.setFont(new Font("宋体",Font.PLAIN,10));
        jFrame.add(jb2);

        JTextField jf2 = new JTextField(20);
        jf2.setBounds(350,80,130,30);
        jf2.setFont(new Font("宋体",Font.PLAIN,15));
        jFrame.add(jf2);


        JButton jb3 = new JButton("按作者查询");
        jb3.setBounds(220,130,100,30);
        jb3.setFont(new Font("宋体",Font.PLAIN,10));
        jFrame.add(jb3);

        JTextField jf3 = new JTextField(20);
        jf3.setBounds(350,130,130,30);
        jf3.setFont(new Font("宋体",Font.PLAIN,15));
        jFrame.add(jf3);

        JButton jb4 = new JButton("按书籍ID查询");
        jb4.setBounds(220,180,100,30);
        jb4.setFont(new Font("宋体",Font.PLAIN,10));
        jFrame.add(jb4);

        JTextField jf4 = new JTextField(20);
        jf4.setBounds(350,180,130,30);
        jf4.setFont(new Font("宋体",Font.PLAIN,15));
        jFrame.add(jf4);

        JButton type = new JButton("书籍类型");
        type.setBounds(980, 30, 80, 30);
        type.setFont(new Font("宋体", Font.PLAIN, 10));
        jFrame.add(type);

        JButton display2 = new JButton("显示所有");
        display2.setBounds(820, 80, 80, 20);
        display2.setFont(new Font("宋体", Font.PLAIN, 10));
        jFrame.add(display2);

        JButton add2 = new JButton("添加");
        add2.setBounds(820, 110, 80, 20);
        add2.setFont(new Font("宋体", Font.PLAIN, 10));
        jFrame.add(add2);

        JButton modify2 = new JButton("修改");
        modify2.setBounds(820, 140, 80, 20);
        modify2.setFont(new Font("宋体", Font.PLAIN, 10));
        jFrame.add(modify2);

        JButton delete = new JButton("删除");
        delete.setBounds(820, 170, 80, 20);
        delete.setFont(new Font("宋体", Font.PLAIN, 10));
        jFrame.add(delete);

        JButton reset2 = new JButton("重置");
        reset2.setBounds(1040, 170, 80, 20);
        reset2.setFont(new Font("宋体", Font.PLAIN, 10));
        jFrame.add(reset2);

        JButton jb5 = new JButton("按类型ID查询");
        jb5 .setBounds(940,80,110,20);
        jb5 .setFont(new Font("宋体",Font.PLAIN,10));
        jFrame.add(jb5 );

        JTextField jf5 = new JTextField(20);
        jf5.setBounds(1060,80,100,20);
        jf5.setFont(new Font("宋体",Font.PLAIN,10));
        jFrame.add(jf5);

        JButton jb6= new JButton("按类型名称查询");
        jb6.setBounds(940,110,110,20);
        jb6.setFont(new Font("宋体",Font.PLAIN,10));
        jFrame.add(jb6);

        JTextField jf6 = new JTextField(20);
        jf6.setBounds(1060,110,100,20);
        jf6.setFont(new Font("宋体",Font.PLAIN,10));
        jFrame.add(jf6);

        JScrollPane jsp2 = new JScrollPane();
        jsp2.setBounds(820, 210, 300, 330);
        jFrame.add(jsp2);

        JScrollPane jsp1 = new JScrollPane();
        jsp1.setBounds(80, 240, 640, 300);
        jFrame.add(jsp1);

        //书籍
        display.addActionListener((e -> {
            if (display.getText().equals("显示所有")) {
                String[] tableHead;
                String[][] content;
                JTable table;
                Query findRecord = new Query();
                findRecord.setDatabaseName("Loan_Management2");
                findRecord.setSQL("select * from sj1 ");
                content = findRecord.getRecord(); //返回二维数组，即查询的全部记录
                tableHead = findRecord.getColumnName();//返回全部字段（列）名
                table = new JTable(content, tableHead);
                JScrollPane jsp = new JScrollPane(table);
                jsp.setBounds(80, 240, 640, 300);
                jFrame.add(jsp);
            }
        }));

        //书籍类型
        display2.addActionListener((e -> {
            if (display2.getText().equals("显示所有")) {
                String[] tableHead;
                String[][] content;
                JTable table;
                Query findRecord = new Query();
                findRecord.setDatabaseName("Loan_Management2");
                findRecord.setSQL("select * from typ ");
                content = findRecord.getRecord(); //返回二维数组，即查询的全部记录
                tableHead = findRecord.getColumnName();//返回全部字段（列）名
                table = new JTable(content, tableHead);
                JScrollPane jsp = new JScrollPane(table);
                jsp.setBounds(820, 210, 300, 330);
                jFrame.add(jsp);
            }
        }));

        //书籍
       special.addActionListener((e -> {
            if(special.getText().equals("特价书")) {

                String[] tableHead0;
                String[][] content0;
                JTable table0;
                Query findRecord0 = new Query();
                findRecord0.setDatabaseName("Loan_Management2");
                findRecord0.setSQL("select * from sj1  where DATEDIFF(year, shelf_time,GETDATE())>1");
                content0 = findRecord0.getRecord(); //返回二维数组，即查询的全部记录
                tableHead0 = findRecord0.getColumnName();//返回全部字段（列）名
                table0 = new JTable(content0, tableHead0);
                JScrollPane jsp4 = new JScrollPane(table0);
                jsp4.setBounds(80, 240, 640, 300);
                jFrame.add(jsp4);
            }
            }));

        JButton update= new JButton("更新");
        update.setBounds(520,130,80,30);
        update.setFont(new Font("宋体",Font.PLAIN,10));
        jFrame.add(update);

        JFrame jfram = new JFrame();
        jfram.setSize(300, 200);
        jfram.setLocationRelativeTo(null);
        jfram.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jfram.setResizable(false);
        jfram.setVisible(false);
        jfram.setLayout(null);
        JLabel jl = new JLabel("更新成功");
        jl.setBounds(100,20,80,30);
        jl.setFont(new Font("宋体", Font.PLAIN, 20));
        JButton jb = new JButton("关闭");
        jb.setBounds(110,70,60,20);
        jb.setFont(new Font("宋体", Font.PLAIN, 10));
        jfram.add(jb);

        update.addActionListener((e -> {
            if (update.getText().equals("更新")) {
                Statement sql;
                try
                {
                    Connection con= GetDBConnection.connectDB("Loan_Management2","test","123456");
                    sql=con.createStatement();
                    int r= sql.executeUpdate("update sj1 set selling_price = pricing * 1.5 * 0.85 where DATEDIFF(year, shelf_time,GETDATE())>1");
                    jfram.add(jl);

                    jfram.setVisible(true);
                    jb.addActionListener((a -> {
                        if (jb.getText().equals("关闭")) {
                            jfram.setVisible(false);
                        }
                    }));
                    con.close();
                } catch (SQLException ex)
                {
                    throw new RuntimeException(ex);
                }
            }
        }));

        goback.addActionListener((e -> {
            if (goback.getText().equals("返回")) {
                jFrame.setVisible(false);//将登录界面设定为不可见
                new 功能总界面().SaleMainInterface();
            }
        }));

        jb2.addActionListener((e -> {
            if (jb2.getText().equals("按书名查询")) {
                String[] tableHead1;
                String[][] content1;
                JTable table1;
                Query findRecord1 = new Query();
                findRecord1.setDatabaseName("Loan_Management2");
                String s = "'"+jf2.getText()+"'";
                String s1 = "select * from sj1 where book_name =" + s;
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
            if (jb1.getText().equals("按类型查询")) {
                String[] tableHead1;
                String[][] content1;
                JTable table1;
                Query findRecord1 = new Query();
                findRecord1.setDatabaseName("Loan_Management2");
                String s = "'"+jf1.getText()+"'";
                String s1 = "select * from sj1 where typ_name =" + s;
                findRecord1.setSQL(s1);
                content1 = findRecord1.getRecord(); //返回二维数组，即查询的全部记录
                tableHead1 = findRecord1.getColumnName();//返回全部字段（列）名
                table1 = new JTable(content1, tableHead1);
                JScrollPane jsp3 = new JScrollPane(table1);
                jsp3.setBounds(80, 240, 640, 300);
                jFrame.add(jsp3);

            }
        }));


        jb3.addActionListener((e -> {
            if (jb3.getText().equals("按作者查询")) {
                String[] tableHead1;
                String[][] content1;
                JTable table1;
                Query findRecord1 = new Query();
                findRecord1.setDatabaseName("Loan_Management2");
                String s = "'"+jf3.getText()+"'";
                String s1 = "select * from sj1 where author =" + s;
                findRecord1.setSQL(s1);
                content1 = findRecord1.getRecord(); //返回二维数组，即查询的全部记录
                tableHead1 = findRecord1.getColumnName();//返回全部字段（列）名
                table1 = new JTable(content1, tableHead1);
                JScrollPane jsp3 = new JScrollPane(table1);
                jsp3.setBounds(80, 240, 640, 300);
                jFrame.add(jsp3);

            }
        }));

        jb4.addActionListener((e -> {
            if (jb4.getText().equals("按书籍ID查询")) {
                String[] tableHead1;
                String[][] content1;
                JTable table1;
                Query findRecord1 = new Query();
                findRecord1.setDatabaseName("Loan_Management2");
                String s = "'"+jf4.getText()+"'";
                String s1 = "select * from sj1 where book_id =" + s;
                findRecord1.setSQL(s1);
                content1 = findRecord1.getRecord(); //返回二维数组，即查询的全部记录
                tableHead1 = findRecord1.getColumnName();//返回全部字段（列）名
                table1 = new JTable(content1, tableHead1);
                JScrollPane jsp3 = new JScrollPane(table1);
                jsp3.setBounds(80, 240, 640, 300);
                jFrame.add(jsp3);

            }
        }));

        modify.addActionListener((e -> {
            if (modify.getText().equals("修改")) {
                new 修改图书().修改图书();
            }
        }));

      reset.addActionListener((e -> {
            if (reset.getText().equals("重置")) {
                jf1.setText("");
                jf2.setText("");
                jf3.setText("");
                jf4.setText("");
            }
        }));

        add.addActionListener((e -> {
            if (add.getText().equals("添加")) {
                new 添加图书().添加图书();
            }
        }));

        //书籍类型

        jb5.addActionListener((e -> {
            if (jb5.getText().equals("按类型ID查询")) {
                String[] tableHead;
                String[][] content;
                JTable table;
                Query findRecord = new Query();
                findRecord.setDatabaseName("Loan_Management2");
                String s = "'"+jf5.getText()+"'";
                String s1 = "select * from typ where typ_id =" + s;
                findRecord.setSQL(s1);
                content = findRecord.getRecord(); //返回二维数组，即查询的全部记录
                tableHead = findRecord.getColumnName();//返回全部字段（列）名
                table = new JTable(content, tableHead);
                JScrollPane jsp = new JScrollPane(table);
                jsp.setBounds(820, 210, 300, 330);
                jFrame.add(jsp);
            }
        }));

        jb6.addActionListener((e -> {
            if (jb6.getText().equals("按类型名称查询")) {
                String[] tableHead;
                String[][] content;
                JTable table;
                Query findRecord = new Query();
                findRecord.setDatabaseName("Loan_Management2");
                String s = "'"+jf6.getText()+"'";
                String s1 = "select * from typ where typ_name =" + s;
                findRecord.setSQL(s1);
                content = findRecord.getRecord(); //返回二维数组，即查询的全部记录
                tableHead = findRecord.getColumnName();//返回全部字段（列）名
                table = new JTable(content, tableHead);
                JScrollPane jsp = new JScrollPane(table);
                jsp.setBounds(820, 210, 300, 330);
                jFrame.add(jsp);
            }
        }));

        JFrame jframm = new JFrame();
        jframm.setSize(300, 200);
        jframm.setLocationRelativeTo(null);
        jframm.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jframm.setResizable(false);
        jframm.setVisible(false);
        jframm.setLayout(null);
        JLabel jll = new JLabel("删除成功");
        jll.setBounds(100,20,80,30);
        jll.setFont(new Font("宋体", Font.PLAIN, 20));
        JButton jbb = new JButton("关闭");
        jbb.setBounds(110,70,60,20);
        jbb.setFont(new Font("宋体", Font.PLAIN, 10));
        jfram.add(jbb);

        delete.addActionListener((e -> {
            if ( delete.getText().equals("删除")) {
                try {
                    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                    String url = "jdbc:sqlserver://127.0.0.1:1433;databaseName=Loan_Management2;user=test;password=123456";
                    Connection con = DriverManager.getConnection(url);
                    Statement statement = con.createStatement();
                    String s = "'"+jf5.getText()+"'";
                    String SQL = "delete from typ where typ_id=" + s;;
                    int result =statement.executeUpdate(SQL);
                    if (result == 1) {
                        System.out.println("yes");
                    } else {
                        System.out.println("no");
                    }
                    jframm.add(jll);
                    jframm.setVisible(true);
                    jbb.addActionListener((a -> {
                        if (jbb.getText().equals("关闭")) {
                            jframm.setVisible(false);
                        }
                    }));
                }catch (Exception a){
                    a.printStackTrace();
                }
            }
        }));

        reset2.addActionListener((e -> {
            if (reset2.getText().equals("重置")) {
                jf5.setText("");
                jf6.setText("");
            }
        }));

        add2.addActionListener((e -> {
            if (add2.getText().equals("添加")) {
                new 添加类型().添加类型();
            }
        }));

        modify2.addActionListener((e -> {
            if (modify2.getText().equals("修改")) {
                new 修改类型().修改类型();
            }
        }));
    }

    public static void main(String args[]){
        图书管理 t = new 图书管理();
        t.图书管理();
    }
}
