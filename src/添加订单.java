/*import javax.swing.*;
import java.awt.*;
import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
public class 添加订单 {


        public void 添加订单() {
            JFrame  jF2 = new JFrame("添加订单");
            jF2.setSize(600, 500);
            jF2.setLocationRelativeTo(null);
            jF2.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            jF2.setResizable(false);
            jF2.setVisible(true);
            jF2.setLayout(null);

            JLabel jl1 = new JLabel("书籍ID：");
            jl1.setBounds(50, 30, 80, 30);
            jl1.setFont(new Font("宋体", Font.PLAIN, 15));
            jF2.add(jl1);

            JTextField jf1 = new JTextField(20);
            jf1.setBounds(120, 30, 130, 30);
            jf1.setFont(new Font("宋体", Font.PLAIN, 15));
            jF2.add(jf1);

            JLabel jl2 = new JLabel("会员ID：");
            jl2.setBounds(50, 80, 80, 30);
            jl2.setFont(new Font("宋体", Font.PLAIN, 15));
            jF2.add(jl2);

            JTextField jf2 = new JTextField(20);
            jf2.setBounds(120, 80, 130, 30);
            jf2.setFont(new Font("宋体", Font.PLAIN, 15));
            jF2.add(jf2);

            JLabel jl3 = new JLabel("姓名：");
            jl3.setBounds(50, 130, 80, 30);
            jl3.setFont(new Font("宋体", Font.PLAIN, 15));
            jF2.add(jl3);

            JTextField jf3 = new JTextField(20);
            jf3.setBounds(120, 130, 130, 30);
            jf3.setFont(new Font("宋体", Font.PLAIN, 15));
            jF2.add(jf3);

            JLabel jl4 = new JLabel("购买数量：");
            jl4.setBounds(50, 180, 80, 30);
            jl4.setFont(new Font("宋体", Font.PLAIN, 15));
            jF2.add(jl4);

            JTextField jf4 = new JTextField(20);
            jf4.setBounds(120, 180, 130, 30);
            jf4.setFont(new Font("宋体", Font.PLAIN, 15));
            jF2.add(jf4);

            JLabel jl5 = new JLabel("购买日期：");
            jl5.setBounds(50, 230, 80, 30);
            jl5.setFont(new Font("宋体", Font.PLAIN, 15));
            jF2.add(jl5);

            JTextField jf5 = new JTextField(20);
            jf5.setBounds(120, 230, 130, 30);
            jf5.setFont(new Font("宋体", Font.PLAIN, 15));
            jF2.add(jf5);

            JLabel jl6 = new JLabel("售价：");
            jl6.setBounds(50, 280, 80, 30);
            jl6.setFont(new Font("宋体", Font.PLAIN, 15));
            jF2.add(jl6);

            JTextField jf6 = new JTextField(20);
            jf6.setBounds(120, 280, 130, 30);
            jf6.setFont(new Font("宋体", Font.PLAIN, 15));
            jF2.add(jf6);

            JLabel jl7 = new JLabel("折扣：");
            jl7.setBounds(290, 30, 80, 30);
            jl7.setFont(new Font("宋体", Font.PLAIN, 15));
            jF2.add(jl7);

            JTextField jf7 = new JTextField(20);
            jf7.setBounds(360, 30, 130, 30);
            jf7.setFont(new Font("宋体", Font.PLAIN, 15));
            jF2.add(jf7);

            JLabel jl8 = new JLabel("书名：");
            jl8.setBounds(290, 80, 80, 30);
            jl8.setFont(new Font("宋体", Font.PLAIN, 15));
            jF2.add(jl8);

            JTextField jf8 = new JTextField(20);
            jf8.setBounds(360, 80, 130, 30);
            jf8.setFont(new Font("宋体", Font.PLAIN, 15));
            jF2.add(jf8);



            JButton define = new JButton("确定");
            define.setBounds(200, 350, 80, 30);
            define.setFont(new Font("宋体", Font.PLAIN, 10));
            //define.addMouseListener(this);
            jF2.add(define);


            JButton reset = new JButton("重置");
            reset.setBounds(300, 350, 80, 30);
            reset.setFont(new Font("宋体", Font.PLAIN, 10));
            //reset.addMouseListener(this);
            jF2.add(reset);

            JButton close = new JButton("关闭");
            close.setBounds(250, 400, 80, 30);
            close.setFont(new Font("宋体", Font.PLAIN, 10));
            //close.addMouseListener(this);
            jF2.add(close);

            close.addActionListener((e -> {
                if (close.getText().equals("关闭")) {
                    jF2.setVisible(false);//将登录界面设定为不可见
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
                    jf7.setText("");
                    jf8.setText("");


                }
            }));

            JFrame jfram = new JFrame();
            jfram.setSize(300, 200);
            jfram.setLocationRelativeTo(null);
            jfram.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            jfram.setResizable(false);
            jfram.setVisible(false);
            jfram.setLayout(null);
            JLabel jl = new JLabel("添加成功");
            jl.setBounds(100,20,80,30);
            jl.setFont(new Font("宋体", Font.PLAIN, 20));
            JButton jb1 = new JButton("关闭");
            jb1.setBounds(110,70,60,20);
            jb1.setFont(new Font("宋体", Font.PLAIN, 10));
            jfram.add(jb1);

            define.addActionListener((e -> {
                if (define.getText().equals("确定")){
                    if((e.getSource().equals(define))){

                        try {
                            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                            String url = "jdbc:sqlserver://127.0.0.1:1433;databaseName=from1;user=test;password=123456";
                            Connection con = DriverManager.getConnection(url);
                            Statement statement = con.createStatement();
                            int r=statement.executeUpdate("insert into customer_book values('"+jf1.getText()+"','"+jf2.getText()+"','" +jf3.getText()+"',"+jf4.getText()+",'" +jf5.getText()+"',"+jf6.getText()+","+jf7.getText()+",'"+jf8.getText()+"')");
                            int k=statement.executeUpdate("update book set book_sign='y' where book_id ="+"'"+jf1.getText()+"'");
                            //int m=statement.executeUpdate("update customer set total_amount= total_amount +"+jf6.getText()+"*"+jf7.getText()"+"where book_id ="+"'"+jf1.getText()+"'");
                            //int m=statement.executeUpdate("update  customer set total_amount =total_amount+"+Double.valueOf(jf6.getText()) +"*"+Double.valueOf(jf7.getText()) + "where name ="+"'"+jf2.getText()+"'") ;
                            int m=statement.executeUpdate("update  customer set total_amount =total_amount+"+Double.valueOf(jf6.getText()) +"*discount" + "where name ="+"'"+jf2.getText()+"'") ;
                            int n=statement.executeUpdate("update  customer set  discount=0.8 where total_amount>=200");

                            jfram.add(jl);
                            jfram.setVisible(true);
                            jb1.addActionListener((a -> {
                                if (jb1.getText().equals("关闭")) {
                                    jfram.setVisible(false);
                                }
                            }));

                            con.close();
                        }
                        catch(Exception exception){
                            exception.toString();
                        }

                    }
                }
            }));
        }
    public static void main(String[] args){
        添加订单 t = new 添加订单();
        t.添加订单();
    }
}
*/
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.sql.Connection;
import java.util.Date;
public class 添加订单 {


    public void 添加订单() {
        JFrame  jF2 = new JFrame("添加订单");
        jF2.setSize(600, 500);
        jF2.setLocationRelativeTo(null);
        jF2.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jF2.setResizable(false);
        jF2.setVisible(true);
        jF2.setLayout(null);

        JLabel jl1 = new JLabel("书籍ID：");
        jl1.setBounds(50, 30, 80, 30);
        jl1.setFont(new Font("宋体", Font.PLAIN, 15));
        jF2.add(jl1);

        JTextField jf1 = new JTextField(20);
        jf1.setBounds(120, 30, 130, 30);
        jf1.setFont(new Font("宋体", Font.PLAIN, 15));
        jF2.add(jf1);

        JLabel jl2 = new JLabel("会员ID：");
        jl2.setBounds(50, 80, 80, 30);
        jl2.setFont(new Font("宋体", Font.PLAIN, 15));
        jF2.add(jl2);

        JTextField jf2 = new JTextField(20);
        jf2.setBounds(120, 80, 130, 30);
        jf2.setFont(new Font("宋体", Font.PLAIN, 15));
        jF2.add(jf2);

        JLabel jl3 = new JLabel("姓名：");
        jl3.setBounds(50, 130, 80, 30);
        jl3.setFont(new Font("宋体", Font.PLAIN, 15));
        jF2.add(jl3);

        JTextField jf3 = new JTextField(20);
        jf3.setBounds(120, 130, 130, 30);
        jf3.setFont(new Font("宋体", Font.PLAIN, 15));
        jF2.add(jf3);

        JLabel jl4 = new JLabel("购买数量：");
        jl4.setBounds(50, 180, 80, 30);
        jl4.setFont(new Font("宋体", Font.PLAIN, 15));
        jF2.add(jl4);

        JTextField jf4 = new JTextField(20);
        jf4.setBounds(120, 180, 130, 30);
        jf4.setFont(new Font("宋体", Font.PLAIN, 15));
        jF2.add(jf4);

        JLabel jl5 = new JLabel("购买日期：");
        jl5.setBounds(50, 230, 80, 30);
        jl5.setFont(new Font("宋体", Font.PLAIN, 15));
        jF2.add(jl5);

        JTextField jf5 = new JTextField(20);
        jf5.setBounds(120, 230, 130, 30);
        jf5.setFont(new Font("宋体", Font.PLAIN, 15));
        jF2.add(jf5);

        JLabel jl6 = new JLabel("售价：");
        jl6.setBounds(50, 280, 80, 30);
        jl6.setFont(new Font("宋体", Font.PLAIN, 15));
        jF2.add(jl6);

        JTextField jf6 = new JTextField(20);
        jf6.setBounds(120, 280, 130, 30);
        jf6.setFont(new Font("宋体", Font.PLAIN, 15));
        jF2.add(jf6);

        JLabel jl7 = new JLabel("折扣：");
        jl7.setBounds(290, 30, 80, 30);
        jl7.setFont(new Font("宋体", Font.PLAIN, 15));
        jF2.add(jl7);

        JTextField jf7 = new JTextField(20);
        jf7.setBounds(360, 30, 130, 30);
        jf7.setFont(new Font("宋体", Font.PLAIN, 15));
        jF2.add(jf7);

        JLabel jl8 = new JLabel("书名：");
        jl8.setBounds(290, 80, 80, 30);
        jl8.setFont(new Font("宋体", Font.PLAIN, 15));
        jF2.add(jl8);

        JTextField jf8 = new JTextField(20);
        jf8.setBounds(360, 80, 130, 30);
        jf8.setFont(new Font("宋体", Font.PLAIN, 15));
        jF2.add(jf8);

        JButton define = new JButton("确定");
        define.setBounds(200, 350, 80, 30);
        define.setFont(new Font("宋体", Font.PLAIN, 10));
        jF2.add(define);


        JButton reset = new JButton("重置");
        reset.setBounds(300, 350, 80, 30);
        reset.setFont(new Font("宋体", Font.PLAIN, 10));
        jF2.add(reset);

        JButton produce= new JButton("生成");
        produce.setBounds(100, 350, 80, 30);
        produce.setFont(new Font("宋体", Font.PLAIN, 10));
        jF2.add(produce);

        JButton close = new JButton("关闭");
        close.setBounds(250, 400, 80, 30);
        close.setFont(new Font("宋体", Font.PLAIN, 10));
        jF2.add(close);

        close.addActionListener((e -> {
            if (close.getText().equals("关闭")) {
                jF2.setVisible(false);//将登录界面设定为不可见
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
                jf7.setText("");
                jf8.setText("");


            }
        }));

        JFrame jfram = new JFrame();
        jfram.setSize(300, 200);
        jfram.setLocationRelativeTo(null);
        jfram.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jfram.setResizable(false);
        jfram.setVisible(false);
        jfram.setLayout(null);
        JLabel jl = new JLabel("添加成功");
        jl.setBounds(100,20,80,30);
        jl.setFont(new Font("宋体", Font.PLAIN, 20));
        JButton jb1 = new JButton("关闭");
        jb1.setBounds(110,70,60,20);
        jb1.setFont(new Font("宋体", Font.PLAIN, 10));
        jfram.add(jb1);

        produce.addActionListener((e -> {
            if (produce.getText().equals("生成")) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                java.util.Date date = new Date();

                String date1 = simpleDateFormat.format(date);
                jf5.setText(date1);
                jf4.setText("1");
                Statement sql;
                ResultSet rs;
                ResultSet rs1;
                ResultSet rs2;
                try
                {
                    Connection con= GetDBConnection.connectDB("Loan_Management2","test","123456");
                    sql=con.createStatement();
                    rs= sql.executeQuery("select * from sj1");
                    while(rs.next())
                        if (jf1.getText().equals(rs.getString("book_id"))) {
                            jf8.setText(rs.getString("book_name"));
                        }
                    rs1 = sql.executeQuery("select * from customer");
                    while(rs1.next())
                        if(jf2.getText().equals(rs1.getString("member_id"))) {
                            jf3.setText(rs1.getString("name"));
                            jf7.setText(rs1.getString("discount"));
                        }
                    rs2 = sql.executeQuery("select * from sj1");
                    while(rs2.next())
                        if(jf1.getText().equals(rs2.getString("book_id"))) {
                            jf6.setText(rs2.getString("selling_price"));
                        }
                } catch (SQLException ex)
                {
                    throw new RuntimeException(ex);
                }
            }
            define.addActionListener((w -> {
                if (define.getText().equals("确定")){
                        try {
                            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                            String url = "jdbc:sqlserver://127.0.0.1:1433;databaseName=Loan_Management2;user=test;password=123456";
                            Connection con = DriverManager.getConnection(url);
                            Statement statement = con.createStatement();
                            int r=statement.executeUpdate("insert into customer_book values('"+jf1.getText()+"','"+jf2.getText()+"','" +jf3.getText()+"',"+jf4.getText()+",'" +jf5.getText()+"',"+jf6.getText()+","+jf7.getText()+",'"+jf8.getText()+"')");
                            int k=statement.executeUpdate("update sj1 set book_sign='y' where book_id ="+"'"+jf1.getText()+"'");

                            int m=statement.executeUpdate("update  customer set total_amount = total_amount + (select selling_price from sj1 where book_id = "+"'"+jf1.getText()+"')"+ " * discount");
                            int n=statement.executeUpdate("update  customer set  discount=0.85 where total_amount>=200");

                            jfram.add(jl);
                            jfram.setVisible(true);
                            jb1.addActionListener((a -> {
                                if (jb1.getText().equals("关闭")) {
                                    jfram.setVisible(false);
                                }
                            }));

                            con.close();
                        }
                        catch(Exception exception){
                            exception.toString();
                        }

                    }
            }));

        }));
    }
    public static void main(String[] args){
        添加订单 t = new 添加订单();
        t.添加订单();
    }
}
