import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class 订单管理 {

    public void 订单管理() {
        JFrame jFrame = new JFrame("订单管理");
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
        display.setBounds(100, 30, 80, 30);
        display.setFont(new Font("宋体", Font.PLAIN, 10));
        jFrame.add(display);


        JButton add = new JButton("添加");
        add.setBounds(100, 80, 80, 30);
        add.setFont(new Font("宋体", Font.PLAIN, 10));
        jFrame.add(add);

        JButton refund = new JButton("退货");
        refund.setBounds(220, 180, 100, 30);
        refund.setFont(new Font("宋体", Font.PLAIN, 10));
        jFrame.add(refund);

        JTextField jf4 = new JTextField(20);
        jf4.setBounds(350, 180, 130, 30);
        jf4.setFont(new Font("宋体", Font.PLAIN, 15));
        jFrame.add(jf4);

        JButton profit = new JButton("统计利润");
        profit.setBounds(780, 30, 100, 30);
        profit.setFont(new Font("宋体", Font.PLAIN, 10));
        jFrame.add(profit);

        JTextField jf5 = new JTextField(20);
        jf5.setBounds(900, 30, 130, 30);
        jf5.setFont(new Font("宋体", Font.PLAIN, 15));
        jFrame.add(jf5);

        JButton total = new JButton("统计销售量");
        total.setBounds(780, 80, 100, 30);
        total.setFont(new Font("宋体", Font.PLAIN, 10));
        jFrame.add(total);

        JTextField jf6 = new JTextField(20);
        jf6.setBounds(900, 80, 130, 30);
        jf6.setFont(new Font("宋体", Font.PLAIN, 15));
        jFrame.add(jf6);

        JButton bestsellers = new JButton("统计热销书");
        bestsellers.setBounds(780, 130, 100, 30);
        bestsellers.setFont(new Font("宋体", Font.PLAIN, 10));
        jFrame.add(bestsellers);

        JScrollPane jsp2 = new JScrollPane();
        jsp2.setBounds(780, 240, 300, 300);
        jFrame.add(jsp2);


        bestsellers.addActionListener((e -> {
            if (bestsellers.getText().equals("统计热销书")) {
                String[] tableHead;
                String[][] content;
                JTable table;
                Query findRecord = new Query();
                findRecord.setDatabaseName("Loan_Management2");

                findRecord.setSQL("select top (3) book_name ,COUNT(*) as Num from customer_book group by book_name  order by Num desc");
                content = findRecord.getRecord(); //返回二维数组，即查询的全部记录
                tableHead = findRecord.getColumnName();//返回全部字段（列）名
                table = new JTable(content, tableHead);
                JScrollPane jsp = new JScrollPane(table);
                jsp.setBounds(780, 240, 300, 300);
                jFrame.add(jsp);
            }
        }));

        JButton reset = new JButton("重置");
        reset.setBounds(100, 130, 80, 30);
        reset.setFont(new Font("宋体", Font.PLAIN, 10));
        jFrame.add(reset);


        JButton jb1 = new JButton("按会员ID查询");
        jb1.setBounds(220, 30, 100, 30);
        jb1.setFont(new Font("宋体", Font.PLAIN, 10));
        jFrame.add(jb1);

        JTextField jf1 = new JTextField(20);
        jf1.setBounds(350, 30, 130, 30);
        jf1.setFont(new Font("宋体", Font.PLAIN, 15));
        jFrame.add(jf1);

        JButton jb2 = new JButton("按书名查询");
        jb2.setBounds(220, 80, 100, 30);
        jb2.setFont(new Font("宋体", Font.PLAIN, 10));
        jFrame.add(jb2);

        JTextField jf2 = new JTextField(20);
        jf2.setBounds(350, 80, 130, 30);
        jf2.setFont(new Font("宋体", Font.PLAIN, 15));
        jFrame.add(jf2);


        JButton jb3 = new JButton("按书籍ID查询");
        jb3.setBounds(220, 130, 100, 30);
        jb3.setFont(new Font("宋体", Font.PLAIN, 10));
        jFrame.add(jb3);

        JTextField jf3 = new JTextField(20);
        jf3.setBounds(350, 130, 130, 30);
        jf3.setFont(new Font("宋体", Font.PLAIN, 15));
        jFrame.add(jf3);



        JScrollPane jsp1 = new JScrollPane();
        jsp1.setBounds(100, 240, 640, 300);
        jFrame.add(jsp1);


        display.addActionListener((e -> {
            if (display.getText().equals("显示所有")) {
                String[] tableHead;
                String[][] content;
                JTable table;
                Query findRecord = new Query();
                findRecord.setDatabaseName("Loan_Management2");
                findRecord.setSQL("select * from customer_book ");
                content = findRecord.getRecord(); //返回二维数组，即查询的全部记录
                tableHead = findRecord.getColumnName();//返回全部字段（列）名
                table = new JTable(content, tableHead);
                JScrollPane jsp = new JScrollPane(table);
                jsp.setBounds(100, 240, 640, 300);
                jFrame.add(jsp);
            }
        }));

        //统计利润
        profit.addActionListener((e -> {
            if (profit.getText().equals("统计利润")) {
                Statement sql;
                ResultSet rs;
                try {
                    Connection con = GetDBConnection.connectDB("Loan_Management2", "test", "123456");
                    sql = con.createStatement();
                   // rs = sql.executeQuery("select (select SUM(total_amount) from customer) - (select SUM(purchase_price) from book_firm join book on book.book_id=book_firm.book_id where book_sign='y') from book_firm) as profit");
                    rs = sql.executeQuery("select (select SUM(total_amount) from customer) - (select SUM(purchase_price) from book_firm join sj1 on sj1.book_id=book_firm.book_id where book_sign='y') as profit");
                    while (rs.next())


                        jf5.setText(rs.getString("profit"));


                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }

        }));


        //统计数量
        total.addActionListener((e -> {
            if (total.getText().equals("统计销售量")) {
                Statement sql;
                ResultSet rs;
                try {
                    Connection con = GetDBConnection.connectDB("Loan_Management2", "test", "123456");
                    sql = con.createStatement();
                    //select COUNT(*) as Num from customer_book
                    rs = sql.executeQuery("select COUNT(*) as Num from customer_book ");
                    while (rs.next())

                        jf6.setText(rs.getString("Num"));


                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }


            }
        }));



        //退货

        JFrame jfram = new JFrame();
        jfram.setSize(300, 200);
        jfram.setLocationRelativeTo(null);
        jfram.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jfram.setResizable(false);
        jfram.setVisible(false);
        jfram.setLayout(null);
        JLabel jl = new JLabel("退货成功");
        jl.setBounds(100, 20, 80, 30);
        jl.setFont(new Font("宋体", Font.PLAIN, 20));
        JButton jb11 = new JButton("关闭");
        jb11.setBounds(110, 70, 60, 20);
        jb11.setFont(new Font("宋体", Font.PLAIN, 10));
        jfram.add(jb11);


        refund.addActionListener((e -> {
            if (refund.getText().equals("退货")) {
                try {
                    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                    String url = "jdbc:sqlserver://127.0.0.1:1433;databaseName=Loan_Management2;user=test;password=123456";
                    Connection con = DriverManager.getConnection(url);
                    Statement statement = con.createStatement();
                    String s = "'" + jf4.getText() + "'";
                    String SQL = "delete from customer_book where book_id=" + s;
                    ;
                    int result = statement.executeUpdate(SQL);
                    int k = statement.executeUpdate("update sj1 set book_sign='n' where book_id =" + "'" + jf4.getText() + "'");
                    //int m=statement.executeUpdate("update  customer set total_amount =total_amount+"+jf6.getText() +"*"+jf7.getText() + "where name ="+"'"+jf2.getText()+"'") ;
                    jfram.add(jl);
                    jfram.setVisible(true);
                    jb11.addActionListener((a -> {
                        if (jb11.getText().equals("关闭")) {
                            jfram.setVisible(false);
                        }
                    }));

                    con.close();
                } catch (Exception a) {
                    a.printStackTrace();
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
                String s = "'" + jf2.getText() + "'";
                String s1 = "select * from customer_book where book_name =" + s;
                findRecord1.setSQL(s1);
                content1 = findRecord1.getRecord(); //返回二维数组，即查询的全部记录
                tableHead1 = findRecord1.getColumnName();//返回全部字段（列）名
                table1 = new JTable(content1, tableHead1);
                JScrollPane jsp3 = new JScrollPane(table1);
                jsp3.setBounds(100, 240, 640, 300);
                jFrame.add(jsp3);

            }
        }));

        jb1.addActionListener((e -> {
            if (jb1.getText().equals("按会员ID查询")) {
                String[] tableHead1;
                String[][] content1;
                JTable table1;
                Query findRecord1 = new Query();
                findRecord1.setDatabaseName("Loan_Management2");
                String s = "'" + jf1.getText() + "'";
                String s1 = "select * from customer_book where member_id =" + s;
                findRecord1.setSQL(s1);
                content1 = findRecord1.getRecord(); //返回二维数组，即查询的全部记录
                tableHead1 = findRecord1.getColumnName();//返回全部字段（列）名
                table1 = new JTable(content1, tableHead1);
                JScrollPane jsp3 = new JScrollPane(table1);
                jsp3.setBounds(100, 240, 640, 300);
                jFrame.add(jsp3);

            }
        }));


        jb3.addActionListener((e -> {
            if (jb3.getText().equals("按书籍ID查询")) {
                String[] tableHead1;
                String[][] content1;
                JTable table1;
                Query findRecord1 = new Query();
                findRecord1.setDatabaseName("Loan_Management2");
                String s = "'" + jf3.getText() + "'";
                String s1 = "select * from customer_book where book_id =" + s;
                findRecord1.setSQL(s1);
                content1 = findRecord1.getRecord(); //返回二维数组，即查询的全部记录
                tableHead1 = findRecord1.getColumnName();//返回全部字段（列）名
                table1 = new JTable(content1, tableHead1);
                JScrollPane jsp3 = new JScrollPane(table1);
                jsp3.setBounds(100, 240, 640, 300);
                jFrame.add(jsp3);

            }
        }));


        reset.addActionListener((e -> {
            if (reset.getText().equals("重置")) {
                jf1.setText("");
                jf2.setText("");
                jf3.setText("");
                jf4.setText("");
                jf5.setText("");
                jf6.setText("");
            }
        }));

        add.addActionListener((e -> {
            if (add.getText().equals("添加")) {
                new 添加订单().添加订单();
            }
        }));

    }

    public static void main(String args[]){
        订单管理 t = new 订单管理();
        t.订单管理();
    }
}
