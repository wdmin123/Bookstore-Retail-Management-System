import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class 添加类型 {
    public void 添加类型(){
        JFrame jF3 = new JFrame("添加");
        jF3.setSize(380,280);
        jF3.setLocationRelativeTo(null);
        jF3.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jF3.setResizable(false);
        jF3.setVisible(true);
        jF3.setLayout(null);

        JLabel jl1 = new JLabel("类型ID：");
        jl1.setBounds(70,30,80,30);
        jl1.setFont(new Font("宋体",Font.PLAIN,15));
        jF3.add(jl1);

        JTextField jf1 = new JTextField(20);
        jf1.setBounds(140,30,130,30);
        jf1.setFont(new Font("宋体",Font.PLAIN,15));
        jF3.add(jf1);

        JLabel jl2 = new JLabel("类型名称：");
        jl2.setBounds(70,80,80,30);
        jl2.setFont(new Font("宋体",Font.PLAIN,15));
        jF3.add(jl2);

        JTextField jf2 = new JTextField(20);
        jf2.setBounds(140,80,130,30);
        jf2.setFont(new Font("宋体",Font.PLAIN,15));
        jF3.add(jf2);

        JButton define = new JButton("确定");
        define.setBounds(80,150,80,30);
        define.setFont(new Font("宋体",Font.PLAIN,10));
        jF3.add(define);

        JButton reset = new JButton("重置");
        reset.setBounds(200,150,80,30);
        reset.setFont(new Font("宋体",Font.PLAIN,10));
        jF3.add(reset);

        JButton close = new JButton("关闭");
        close.setBounds(140,200,80,30);
        close.setFont(new Font("宋体",Font.PLAIN,10));
        jF3.add(close);

        close.addActionListener((e -> {
            if (close.getText().equals("关闭")) {
                jF3.setVisible(false);//将登录界面设定为不可见
            }
        }));

        reset.addActionListener((e -> {
            if (reset.getText().equals("重置")){
                jf1.setText("");
                jf2.setText("");
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
                        int r=statement.executeUpdate("insert into typ values('"+jf1.getText()+"','"+jf2.getText()+"')");
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
        添加类型 t = new 添加类型();
        t.添加类型();
    }
}
