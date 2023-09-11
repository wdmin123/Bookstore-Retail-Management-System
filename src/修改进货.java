import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class 修改进货 {
    public void 修改进货(){
        JFrame jF2 = new JFrame("修改");
        jF2.setSize(600,380);
        jF2.setLocationRelativeTo(null);
        jF2.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jF2.setResizable(false);
        jF2.setVisible(true);
        jF2.setLayout(null);

        JLabel jl1 = new JLabel("厂商ID：");
        jl1.setBounds(50,30,80,30);
        jl1.setFont(new Font("宋体",Font.PLAIN,15));
        jF2.add(jl1);

        JTextField jf1 = new JTextField(20);
        jf1.setBounds(120,30,130,30);
        jf1.setFont(new Font("宋体",Font.PLAIN,15));
        jF2.add(jf1);

        JLabel jl2 = new JLabel("书籍ID：");
        jl2.setBounds(290,30,80,30);
        jl2.setFont(new Font("宋体",Font.PLAIN,15));
        jF2.add(jl2);

        JTextField jf2 = new JTextField(20);
        jf2.setBounds(380,30,130,30);
        jf2.setFont(new Font("宋体",Font.PLAIN,15));
        jF2.add(jf2);

        JLabel jl3 = new JLabel("书名：");
        jl3.setBounds(50,80,80,30);
        jl3.setFont(new Font("宋体",Font.PLAIN,15));
        jF2.add(jl3);

        JTextField jf3 = new JTextField(20);
        jf3.setBounds(120,80,130,30);
        jf3.setFont(new Font("宋体",Font.PLAIN,15));
        jF2.add(jf3);

        JLabel jl4 = new JLabel("进货时间：");
        jl4.setBounds(290,80,80,30);
        jl4.setFont(new Font("宋体",Font.PLAIN,15));
        jF2.add(jl4);

        JTextField jf4 = new JTextField(20);
        jf4.setBounds(380,80,130,30);
        jf4.setFont(new Font("宋体",Font.PLAIN,15));
        jF2.add(jf4);

        JLabel jl5 = new JLabel("数量：");
        jl5.setBounds(50,130,80,30);
        jl5.setFont(new Font("宋体",Font.PLAIN,15));
        jF2.add(jl5);

        JTextField jf5 = new JTextField(20);
        jf5.setBounds(120,130,130,30);
        jf5.setFont(new Font("宋体",Font.PLAIN,15));
        jF2.add(jf5);

        JLabel jl6 = new JLabel("进价：");
        jl6.setBounds(290,130,80,30);
        jl6.setFont(new Font("宋体",Font.PLAIN,15));
        jF2.add(jl6);

        JTextField jf6 = new JTextField(20);
        jf6.setBounds(380,130,130,30);
        jf6.setFont(new Font("宋体",Font.PLAIN,15));
        jF2.add(jf6);

        JLabel jl7 = new JLabel("ISBN：");
        jl7.setBounds(50,180,80,30);
        jl7.setFont(new Font("宋体",Font.PLAIN,15));
        jF2.add(jl7);

        JTextField jf7= new JTextField(20);
        jf7.setBounds(120,180,130,30);
        jf7.setFont(new Font("宋体",Font.PLAIN,15));
        jF2.add(jf7);

        JLabel jl8 = new JLabel("出版社：");
        jl8.setBounds(290,180,80,30);
        jl8.setFont(new Font("宋体",Font.PLAIN,15));
        jF2.add(jl8);

        JTextField jf8 = new JTextField(20);
        jf8.setBounds(380,180,130,30);
        jf8.setFont(new Font("宋体",Font.PLAIN,15));
        jF2.add(jf8);

        JButton query = new JButton("查询");
        query.setBounds(200,230,80,30);
        query.setFont(new Font("宋体",Font.PLAIN,10));
        jF2.add(query);

        query.addActionListener((e -> {
            if (query.getText().equals("查询")) {
                Statement sql;
                ResultSet rs;
                try
                {
                    Connection con= GetDBConnection.connectDB("Loan_Management2","test","123456");
                    sql=con.createStatement();
                    rs= sql.executeQuery("select * from book_firm");
                    while(rs.next())
                        if(jf2.getText().equals(rs.getString("book_id")))
                        {
                            jf1.setText(rs.getString("firm_id"));
                            jf3.setText(rs.getString("book_name"));
                            jf4.setText(rs.getString("purchase_time"));
                            jf5.setText(rs.getString("amount"));
                            jf6.setText(rs.getString("purchase_price"));
                            jf7.setText(rs.getString("ISBN"));
                            jf8.setText(rs.getString("publish"));
                        }
                } catch (SQLException ex)
                {
                    throw new RuntimeException(ex);
                }
            }

        }));

        JButton define = new JButton("确定");
        define.setBounds(300,230,80,30);
        define.setFont(new Font("宋体",Font.PLAIN,10));
        jF2.add(define);

        JFrame jfram = new JFrame();
        jfram.setSize(300, 200);
        jfram.setLocationRelativeTo(null);
        jfram.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jfram.setResizable(false);
        jfram.setVisible(false);
        jfram.setLayout(null);
        JLabel jl = new JLabel("修改成功");
        jl.setBounds(100,20,80,30);
        jl.setFont(new Font("宋体", Font.PLAIN, 20));
        JButton jb1 = new JButton("关闭");
        jb1.setBounds(110,70,60,20);
        jb1.setFont(new Font("宋体", Font.PLAIN, 10));
        jfram.add(jb1);

        define.addActionListener((e -> {
            if (define.getText().equals("确定")) {
                Statement sql;
                try
                {
                    Connection con= GetDBConnection.connectDB("Loan_Management2","test","123456");
                    sql=con.createStatement();
                    int r= sql.executeUpdate("update book_firm set firm_id ="+"'"+jf1.getText()+"'"+" where book_id ="+"'"+jf2.getText()+"'"+
                           "update book_firm set book_name ="+"'"+jf3.getText()+"'"+" where book_id ="+"'"+jf2.getText()+"'"+
                            "update book_firm set purchase_time ="+"'"+jf4.getText()+"'"+" where book_id ="+"'"+jf2.getText()+"'"+
                           "update book_firm set amount ="+jf5.getText()+" where book_id ="+"'"+jf2.getText()+"'"+
                            "update book_firm set purchase_price ="+jf6.getText()+" where book_id ="+"'"+jf2.getText()+"'"+
                            "update book_firm set ISBN ="+"'"+jf7.getText()+"'"+" where book_id ="+"'"+jf2.getText()+"'"+
                            "update book_firm set publish ="+"'"+jf8.getText()+"'"+" where book_id ="+"'"+jf2.getText()+"'");
                    jfram.add(jl);

                    jfram.setVisible(true);
                    jb1.addActionListener((a -> {
                        if (jb1.getText().equals("关闭")) {
                            jfram.setVisible(false);
                        }
                    }));
                    con.close();
                } catch (SQLException ex
                )
                {
                    throw new RuntimeException(ex);
                }
            }
        }));

        JButton close = new JButton("关闭");
        close.setBounds(250,280,80,30);
        close.setFont(new Font("宋体",Font.PLAIN,10));
        jF2.add(close);

        close.addActionListener((e -> {
            if (close.getText().equals("关闭")) {
                jF2.setVisible(false);//将登录界面设定为不可见
            }
        }));

    }
    public static void main(String args[]){
        修改进货 x = new 修改进货();
        x.修改进货();
    }
}
