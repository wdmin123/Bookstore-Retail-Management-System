import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.*;

public class 登录 extends JFrame{

    public static void main(String[] args) {
        new 登录();
    }

    public 登录(){
        setTitle("登录");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 900, 500);
        JPanel jPanel = new JPanel();
        jPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(jPanel);
        jPanel.setLayout(null);

        //添加标签【书店零售管理系统】
        JLabel saleManage = new JLabel("书店零售管理系统");//创建一个标签,并命名为“学生管理系统“
        saleManage.setForeground(new Color(0,0,0));//设置字体颜色
        saleManage.setFont(new Font("黑体", Font.PLAIN,50));//设置字体大小
        saleManage.setBounds(280,50,800,100);//设置标签的绝对位置
        jPanel.add(saleManage);//向框架中添加组件【标签(书店零售管理系统)】

        //添加标签【用户名】
        JLabel saleUser = new JLabel("用户名:");
        saleUser.setForeground(new Color(0,0,0));
        saleUser.setFont(new Font("黑体", Font.PLAIN,30));
        saleUser.setBounds(200,140,200,100);
        jPanel.add(saleUser);

        //添加输入框【用户名输入框】
        JTextField user = new JTextField(20);
        user.setFont(new Font("黑体", Font.PLAIN,18));
        user.setSelectedTextColor(new Color(0,0,0));
        user.setBounds(330,170,280,40);
        jPanel.add(user);

        //添加标签【密码】
        JLabel Password = new JLabel("密码  :");
        Password.setForeground(new Color(0,0,0));
        Password.setFont(new Font("黑体", Font.PLAIN,30));
        Password.setBounds(200,200,200,100);
        jPanel.add(Password);

        //添加密码输入框【密码】
        JPasswordField password2 = new JPasswordField(20);
        password2.setFont(new Font("黑体", Font.PLAIN,18));
        password2.setSelectedTextColor(new Color(0,0,0));
        password2.setBounds(330,230,280,40);
        jPanel.add(password2);


        //添加按钮【登录】
        JButton jButton = new JButton("登录");
        jButton.setForeground(new Color(0,0,0));
        jButton.setBackground(new Color(255,255,255));
        jButton.setFont(new Font("黑体", Font.PLAIN,20));
        jButton.setBorderPainted(false);
        jButton.setBounds(400,330,100,50);
        jPanel.add(jButton);

        jButton.addActionListener((e -> {
            Statement sql;
            ResultSet rs;
            try
            {
                Connection con= GetDBConnection.connectDB("Loan_Management2","test","123456");
                sql=con.createStatement();
                rs= sql.executeQuery("select * from manager1");
                while(rs.next()) {
                    if (user.getText().equals(rs.getString("manager_id"))) {
                        String s = new String(password2.getPassword());
                        if (s.equals(rs.getString("password1"))) {
                            jPanel.setVisible(false);//将登录界面设定为不可见
                            new 功能总界面().SaleMainInterface();
                        } else {
                            //密码不正确
                            JOptionPane.showMessageDialog(jPanel, "密码错误", "提示", JOptionPane.INFORMATION_MESSAGE);
                            //将密码框置空
                            password2.setText("");
                        }

                    } else {
                        JOptionPane.showMessageDialog(jPanel, "用户名错误", "提示", JOptionPane.INFORMATION_MESSAGE);
                        //将用户名和密码置空
                        user.setText("");
                        password2.setText("");
                    }
                }
            } catch (SQLException ex)
            {
                throw new RuntimeException(ex);
            }

        }));

        //设置相对位置：屏幕中间
        setLocationRelativeTo(null);

        //确保使用窗口关闭按钮，能够正常退出，结束进程！
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //禁止对窗口大小进行缩放处理
        setResizable(false);

        //设置可见
        setVisible(true);
        JLabel jlb_background = new JLabel(new ImageIcon("C:/chapt/Bookstore retail/src/an.jpeg"));
        jlb_background.setForeground(Color.DARK_GRAY);
        jlb_background.setBounds(0, 0, 900, 500);
        jPanel.add(jlb_background);
    }

}
