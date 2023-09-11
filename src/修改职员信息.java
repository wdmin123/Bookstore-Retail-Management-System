import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class 修改职员信息 {
    public void 修改职员信息(){
        JFrame jF2 = new JFrame("修改");
        jF2.setSize(600,500);
        jF2.setLocationRelativeTo(null);
        jF2.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jF2.setResizable(false);
        jF2.setVisible(true);
        jF2.setLayout(null);

        JLabel jl1 = new JLabel("职员ID：");
        jl1.setBounds(150,30,80,30);
        jl1.setFont(new Font("宋体",Font.PLAIN,15));
        jF2.add(jl1);

        JTextField jf1 = new JTextField(20);
        jf1.setBounds(220,30,130,30);
        jf1.setFont(new Font("宋体",Font.PLAIN,15));
        jF2.add(jf1);

        JLabel jl2 = new JLabel("姓名：");
        jl2.setBounds(150,80,80,30);
        jl2.setFont(new Font("宋体",Font.PLAIN,15));
        jF2.add(jl2);

        JTextField jf2 = new JTextField(20);
        jf2.setBounds(220,80,130,30);
        jf2.setFont(new Font("宋体",Font.PLAIN,15));
        jF2.add(jf2);

        JLabel jl3 = new JLabel("电话：");
        jl3.setBounds(150,130,80,30);
        jl3.setFont(new Font("宋体",Font.PLAIN,15));
        jF2.add(jl3);

        JTextField jf3 = new JTextField(20);
        jf3.setBounds(220,130,130,30);
        jf3.setFont(new Font("宋体",Font.PLAIN,15));
        jF2.add(jf3);

        JLabel jl4 = new JLabel("职位：");
        jl4.setBounds(150,180,80,30);
        jl4.setFont(new Font("宋体",Font.PLAIN,15));
        jF2.add(jl4);

        JTextField jf4 = new JTextField(20);
        jf4.setBounds(220,180,130,30);
        jf4.setFont(new Font("宋体",Font.PLAIN,15));
        jF2.add(jf4);

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
                    rs= sql.executeQuery("select * from manager");
                    while(rs.next())
                        if(jf1.getText().equals(rs.getString("manager_id")))
                        {
                            jf2.setText(rs.getString("manager_name"));
                            jf3.setText(rs.getString("manager_telephone"));
                            jf4.setText(rs.getString("title"));
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
                    int r= sql.executeUpdate("update manager set manager_name ="+"'"+jf2.getText()+"'"+" where manager_id ="+"'"+jf1.getText()+"'"+
                            "update manager set manager_telephone ="+"'"+jf3.getText()+"'"+" where manager_id ="+"'"+jf1.getText()+"'"+
                            "update manager set title ="+"'"+jf4.getText()+"'"+" where manager_id ="+"'"+jf1.getText()+"'");
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
        修改职员信息 x = new 修改职员信息();
        x.修改职员信息();
    }
}
