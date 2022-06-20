package cn.QYH.jf;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class Login extends JFrame {
    static Login that;
    public Login() {
        that = this;
        //给登录窗口加入面板
        JPanel jPanel = new JPanel();
        //添加面板布局
        jPanel.setLayout(null);
        //设置面板的大小
//        jPanel.setBounds(0, 0, 400, 300);
//
//        jPanel.setBackground(Color.PINK);

        //把面板添加到窗口里面  用getContentPane()方法获得JFrame的内容面板，再对其加入组件
        this.getContentPane().add(jPanel);

        //设置用户名标签
        JLabel username = new JLabel("用户名");
        username.setBounds(110, 80, 100, 50);
        //设置字体
        username.setFont(new Font("微软雅黑", Font.BOLD, 15));
        //设置字体颜色
        username.setForeground(Color.cyan);
        jPanel.add(username);

        //设置用户密码标签
        JLabel userpwd = new JLabel("密   码");
        userpwd.setBounds(110, 120, 100, 50);
        //设置字体
        userpwd.setFont(new Font("微软雅黑", Font.BOLD, 15));
        //设置字体颜色
        userpwd.setForeground(Color.cyan);
        jPanel.add(userpwd);

        //设置用户名文本输入框
        JTextField usernameTf = new JTextField();
        usernameTf.setBounds(170, 97, 100, 20);
        jPanel.add(usernameTf);

        //设置用户名密码输入框
        JPasswordField userpwdF = new JPasswordField();
        userpwdF.setBounds(170, 135, 100, 20);
        jPanel.add(userpwdF);

        //设置登录，注册按钮
        JButton login = new JButton("登录");
        login.setBounds(210, 200, 80, 20);
        jPanel.add(login);

        JButton sign = new JButton("注册");
        sign.setBounds(110, 200, 80, 20);
        jPanel.add(sign);

        //存放背景图片
        JLabel bgimg = new JLabel();
        bgimg.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("../imgs/bg2.jpg"))));
        bgimg.setBounds(0, 0, 400, 300);
        jPanel.add(bgimg);

        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int NameFlag = 0;
                int PwdFlag = 0;
                String usernameText = usernameTf.getText();
                String userpassword = String.valueOf(userpwdF.getPassword());
//                System.out.println("用户名："+usernameText+"  密码："+userpassword);

                // 这里读取数据库里的数据 和 用户输入做比对
                if (usernameText.equals("user") && userpassword.equals("123")) {
                    JOptionPane.showMessageDialog(null, "账户密码正确！");
                    that.setVisible(false);
                } else {
                    if (!usernameText.equals("user")) {
                        NameFlag = 1;
                    }
                    if (!userpassword.equals("123")) {
                        PwdFlag = 1;
                    }
                    if (NameFlag == 1 && PwdFlag == 1) {
                        JOptionPane.showMessageDialog(null, "用户名和密码错误！");
                    } else if (NameFlag == 1) {
                        JOptionPane.showMessageDialog(null, "用户名错误！");
                    } else {
                        JOptionPane.showMessageDialog(null, "密码错误！");
                    }
                }
            }
        });

    }

    public static void main(String[] args) {
        Login login = new Login();
        login.loginJF();
    }

    public void loginJF() {
        this.setVisible(true);
        //设置窗口大小
        this.setSize(400, 300);
        //设置窗口不能放大缩小
        this.setResizable(false);
        //设置窗口居中
        this.setLocationRelativeTo(null);
        //设置窗口标题
        this.setTitle("登录窗口");
        //获取窗口的图标
        Image im = (new ImageIcon("/imgs/qq.jpeg")).getImage();
        this.setIconImage(im);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
