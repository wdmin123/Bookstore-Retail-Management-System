import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class 添加职员信息{
    public void 添加职员信息(){
        JFrame jF2 = new JFrame("添加");
        jF2.setSize(600,500);
        jF2.setLocationRelativeTo(null);
        jF2.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jF2.setResizable(false);
        jF2.setVisible(true);
        jF2.setLayout(null);

        JLabel jl1 = new JLabel("职员ID：");
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

        JLabel jl3 = new JLabel("电话：");
        jl3.setBounds(50,130,80,30);
        jl3.setFont(new Font("宋体",Font.PLAIN,15));
        jF2.add(jl3);

        JTextField jf3 = new JTextField(20);
        jf3.setBounds(120,130,130,30);
        jf3.setFont(new Font("宋体",Font.PLAIN,15));
        jF2.add(jf3);

        JLabel jl4 = new JLabel("职位：");
        jl4.setBounds(50,180,80,30);
        jl4.setFont(new Font("宋体",Font.PLAIN,15));
        jF2.add(jl4);

        JTextField jf4 = new JTextField(20);
        jf4.setBounds(120,180,130,30);
        jf4.setFont(new Font("宋体",Font.PLAIN,15));
        jF2.add(jf4);


        JButton define = new JButton("确定");
        define.setBounds(200,350,80,30);
        define.setFont(new Font("宋体",Font.PLAIN,10));
        jF2.add(define);

        JButton reset = new JButton("重置");
        reset.setBounds(300,350,80,30);
        reset.setFont(new Font("宋体",Font.PLAIN,10));
        jF2.add(reset);

        JButton close = new JButton("关闭");
        close.setBounds(250,400,80,30);
        close.setFont(new Font("宋体",Font.PLAIN,10));
        jF2.add(close);

        close.addActionListener((e -> {
            if (close.getText().equals("关闭")) {
                jF2.setVisible(false);//将登录界面设定为不可见
            }
        }));


        reset.addActionListener((e -> {
            if (reset.getText().equals("重置")){
                jf1.setText("");
                jf2.setText("");
                jf3.setText("");
                jf4.setText("");



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
                        String url = "jdbc:sqlserver://127.0.0.1:1433;databaseName=Loan_Management2;user=test;password=123456";
                        Connection con = DriverManager.getConnection(url);
                        Statement statement = con.createStatement();
                        int r=statement.executeUpdate("insert into manager values('"+jf1.getText()+"','"+jf2.getText()+"','" +jf3.getText()+"','"+jf4.getText()+"')");

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
    public static void main(String args[]){
        添加职员信息 t = new 添加职员信息();
        t.添加职员信息();
    }
}
