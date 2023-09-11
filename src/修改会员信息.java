import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class 修改会员信息 {
    public void 修改会员信息(){
        JFrame jF2 = new JFrame("修改");
        jF2.setSize(600,500);
        jF2.setLocationRelativeTo(null);
        jF2.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jF2.setResizable(false);
        jF2.setVisible(true);
        jF2.setLayout(null);

        JLabel jl1 = new JLabel("会员ID：");
        jl1.setBounds(50,30,80,30);
        jl1.setFont(new Font("宋体",Font.PLAIN,15));
        jF2.add(jl1);

        JTextField jf1 = new JTextField(20);
        jf1.setBounds(120,30,130,30);
        jf1.setFont(new Font("宋体",Font.PLAIN,15));
        jF2.add(jf1);

        JLabel jl2 = new JLabel("姓名：");
        jl2.setBounds(50,80,80,30);
        jl2.setFont(new Font("宋体",Font.PLAIN,15));
        jF2.add(jl2);

        JTextField jf2 = new JTextField(20);
        jf2.setBounds(120,80,130,30);
        jf2.setFont(new Font("宋体",Font.PLAIN,15));
        jF2.add(jf2);

        JLabel jl3 = new JLabel("性别：");
        jl3.setBounds(50,130,80,30);
        jl3.setFont(new Font("宋体",Font.PLAIN,15));
        jF2.add(jl3);

        JTextField jf3 = new JTextField(20);
        jf3.setBounds(120,130,130,30);
        jf3.setFont(new Font("宋体",Font.PLAIN,15));
        jF2.add(jf3);

        JLabel jl4 = new JLabel("出生年月：");
        jl4.setBounds(50,180,80,30);
        jl4.setFont(new Font("宋体",Font.PLAIN,15));
        jF2.add(jl4);

        JTextField jf4 = new JTextField(20);
        jf4.setBounds(120,180,130,30);
        jf4.setFont(new Font("宋体",Font.PLAIN,15));
        jF2.add(jf4);

        JLabel jl5 = new JLabel("电话：");
        jl5.setBounds(50,230,80,30);
        jl5.setFont(new Font("宋体",Font.PLAIN,15));
        jF2.add(jl5);

        JTextField jf5 = new JTextField(20);
        jf5.setBounds(120,230,130,30);
        jf5.setFont(new Font("宋体",Font.PLAIN,15));
        jF2.add(jf5);

        JLabel jl6 = new JLabel("累计消费金额：");
        jl6.setBounds(50,280,80,30);
        jl6.setFont(new Font("宋体",Font.PLAIN,15));
        jF2.add(jl6);

        JTextField jf6 = new JTextField(20);
        jf6.setBounds(120,280,130,30);
        jf6.setFont(new Font("宋体",Font.PLAIN,15));
        jF2.add(jf6);

        JLabel jl7 = new JLabel("折扣：");
        jl7.setBounds(290,30,80,30);
        jl7.setFont(new Font("宋体",Font.PLAIN,15));
        jF2.add(jl7);

        JTextField jf7 = new JTextField(20);
        jf7.setBounds(360,30,130,30);
        jf7.setFont(new Font("宋体",Font.PLAIN,15));
        jF2.add(jf7);


        JButton query = new JButton("查询");
        query.setBounds(200,350,80,30);
        query.setFont(new Font("宋体",Font.PLAIN,10));
        jF2.add(query);

        JButton define = new JButton("确定");
        define.setBounds(300,350,80,30);
        define.setFont(new Font("宋体",Font.PLAIN,10));
        jF2.add(define);

        JButton close = new JButton("关闭");
        close.setBounds(250,400,80,30);
        close.setFont(new Font("宋体",Font.PLAIN,10));
        jF2.add(close);

        close.addActionListener((e -> {
            if (close.getText().equals("关闭")) {
                jF2.setVisible(false);//将登录界面设定为不可见
            }
        }));

        query.addActionListener((e -> {
            if (query.getText().equals("查询")) {
                Statement sql;
                ResultSet rs;
                try
                {
                    Connection con= GetDBConnection.connectDB("Loan_Management2","test","123456");
                    sql=con.createStatement();
                    rs= sql.executeQuery("select * from customer");
                    while(rs.next())
                        if(jf1.getText().equals(rs.getString("member_id")))
                        {
                            jf2.setText(rs.getString("name"));
                            jf3.setText(rs.getString("sexuality"));
                            jf4.setText(rs.getString("birth"));
                            jf5.setText(rs.getString("customer_telephone"));
                            jf6.setText(rs.getString("total_amount"));
                            jf7.setText(rs.getString("discount"));
                        }
                } catch (SQLException ex)
                {
                    throw new RuntimeException(ex);
                }
            }

        }));

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
                    int r= sql.executeUpdate("update customer set name ="+"'"+jf2.getText()+"'"+" where member_id ="+"'"+jf1.getText()+"'"+
                            "update customer set sexuality ="+"'"+jf3.getText()+"'"+" where member_id ="+"'"+jf1.getText()+"'"+
                            "update customer set birth ="+"'"+jf4.getText()+"'"+" where member_id ="+"'"+jf1.getText()+"'"+
                            "update customer set customer_telephone ="+"'"+jf5.getText()+"'"+" where member_id ="+"'"+jf1.getText()+"'"+
                            "update customer set total_amount ="+"'"+jf6.getText()+"'"+" where member_id ="+"'"+jf1.getText()+"'"+
                            "update customer set discount ="+"'"+jf7.getText()+"'"+" where member_id ="+"'"+jf1.getText()+"'");
                    jfram.add(jl);

                    jfram.setVisible(true);
                    jb1.addActionListener((a -> {
                        if (jb1.getText().equals("关闭")) {
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

    }
    public static void main(String args[]){
        修改会员信息 x = new 修改会员信息();
        x.修改会员信息();
    }
}
