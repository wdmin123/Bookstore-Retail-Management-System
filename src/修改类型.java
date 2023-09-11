import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class 修改类型 {
    public void 修改类型(){
        JFrame jF2 = new JFrame("修改类型");
        jF2.setSize(600,240);
        jF2.setLocationRelativeTo(null);
        jF2.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jF2.setResizable(false);
        jF2.setVisible(true);
        jF2.setLayout(null);

        JLabel jl1 = new JLabel("类型ID：");
        jl1.setBounds(50,30,80,30);
        jl1.setFont(new Font("宋体",Font.PLAIN,15));
        jF2.add(jl1);

        JTextField jf1 = new JTextField(20);
        jf1.setBounds(120,30,130,30);
        jf1.setFont(new Font("宋体",Font.PLAIN,15));
        jF2.add(jf1);

        JLabel jl2 = new JLabel("类型名称：");
        jl2.setBounds(290,30,80,30);
        jl2.setFont(new Font("宋体",Font.PLAIN,15));
        jF2.add(jl2);

        JTextField jf2 = new JTextField(20);
        jf2.setBounds(360,30,130,30);
        jf2.setFont(new Font("宋体",Font.PLAIN,15));
        jF2.add(jf2);

        JButton query = new JButton("查询");
        query.setBounds(200,90,80,30);
        query.setFont(new Font("宋体",Font.PLAIN,10));
        jF2.add(query);

        JButton define = new JButton("确定");
        define.setBounds(300,90,80,30);
        define.setFont(new Font("宋体",Font.PLAIN,10));
        jF2.add(define);

        JButton close = new JButton("关闭");
        close.setBounds(250,140,80,30);
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
                    rs= sql.executeQuery("select * from typ");
                    while(rs.next())
                        if(jf1.getText().equals(rs.getString("typ_id")))
                        {
                            jf2.setText(rs.getString("typ_name"));
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
                    int r= sql.executeUpdate("update typ set typ_name ="+"'"+jf2.getText()+"'"+" where typ_id ="+"'"+jf1.getText()+"'");
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
        修改类型 x = new 修改类型();
        x.修改类型();
    }
}
