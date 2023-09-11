/*
    登录之后进入的页面【书店零售管理系统】
 */

import javax.swing.*;
import java.awt.*;

public class 功能总界面 {


    public void SaleMainInterface(){

        //创建一个窗口,并设置窗口名称为”书店零售管理系统”
        JFrame jFrame = new JFrame("书店零售管理系统");

        //设置窗口大小
        jFrame.setSize(1400,900);

        jFrame.setLayout(null);


        //添加按钮【图书管理】

        JButton jButton1 = new JButton("图书管理");
        jButton1.setFont(new Font("黑体", Font.PLAIN,20));
        jButton1.setBorderPainted(false);
        jButton1.setBounds(100,250,150,50);
        jFrame.add(jButton1);

        //添加按钮【订单管理】
        JButton jButton2 = new JButton("订单管理");
        jButton2.setFont(new Font("黑体", Font.PLAIN,20));
        jButton2.setBorderPainted(false);
        jButton2.setBounds(300,250,150,50);
        jFrame.add(jButton2);

        //添加按钮【会员管理】
        JButton jButton3 = new JButton("会员管理");
        jButton3.setFont(new Font("黑体", Font.PLAIN,20));
        jButton3.setBorderPainted(false);
        jButton3.setBounds(500,250,150,50);
        jFrame.add(jButton3);


        //添加按钮【供货管理】
        JButton jButton4 = new JButton("供货管理");
        jButton4.setFont(new Font("黑体", Font.PLAIN,20));
        jButton4.setBorderPainted(false);
        jButton4.setBounds(700,250,150,50);
        jFrame.add(jButton4);

        //添加按钮【职员管理】
        JButton jButton5 = new JButton("职员管理");
        jButton5.setFont(new Font("黑体", Font.PLAIN,20));
        jButton5.setBorderPainted(false);
        jButton5.setBounds(900,250,150,50);
        jFrame.add(jButton5);


        //添加按钮【返回】
        JButton jButton6 = new JButton("返回");
        jButton6.setFont(new Font("黑体", Font.PLAIN,20));
        jButton6.setBorderPainted(false);
        jButton6.setBounds(520,450,150,50);
        jFrame.add(jButton6);




        jButton6.addActionListener((e -> {

            /*
                账号：admin
                密码：123456
             */

            //设定条件

            if(jButton6.getText().equals("返回")){

                jFrame.setVisible(false);//将功能总界面设定为不可见
                new 登录();
            }}));

        jButton1.addActionListener((e -> {


            if(jButton1.getText().equals("图书管理")){

                jFrame.setVisible(false);//将功能总界面设定为不可见
                new 图书管理().图书管理();
            }}));

        jButton2.addActionListener((e -> {


            if(jButton2.getText().equals("订单管理")){

                jFrame.setVisible(false);//将功能总界面设定为不可见
                new 订单管理().订单管理();
            }}));

        jButton3.addActionListener((e -> {


            if(jButton3.getText().equals("会员管理")){

                jFrame.setVisible(false);//将功能总界面设定为不可见
                new 会员管理().会员管理();
            }}));

        jButton4.addActionListener((e -> {


            if(jButton4.getText().equals("供货管理")){

                jFrame.setVisible(false);//将功能总界面设定为不可见
                new 供货管理().供货管理();
            }}));


        jButton5.addActionListener((e -> {


            if(jButton5.getText().equals("职员管理")){

                jFrame.setVisible(false);//将功能总界面设定为不可见
                new 职员管理().职员管理();
            }}));






        //设置相对位置：屏幕中间
        jFrame.setLocationRelativeTo(null);

        //确保使用窗口关闭按钮，能够正常退出，结束进程！
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //禁止对窗口大小进行缩放处理
        jFrame.setResizable(false);

        //设置可见
        jFrame.setVisible(true);

    }
    public static void main(String args[]){
        new 功能总界面().SaleMainInterface();
    }

}
