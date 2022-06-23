package cn.QYH.jf;

import cn.QYH.util.Test1Demo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

import static cn.QYH.jf.Login.userName;

public class Sign extends JFrame {
    static Sign that;
    public Sign(){
        that = this;
        JPanel jPanel = new JPanel();
        //添加面板布局
        jPanel.setLayout(null);

        //把面板添加到窗口里面  用getContentPane()方法获得JFrame的内容面板，再对其加入组件
        this.getContentPane().add(jPanel);
        Font font =  new Font("宋体",-1,20);

        // 注册标签
        JLabel signLab = new JLabel("注册");
        signLab.setBounds(185,20,50,30);
        signLab.setFont(font);
        signLab.setForeground(Color.red);
        jPanel.add(signLab);

        // 用户名提示标签
        JLabel userNameLab = new JLabel("用 户 名：");
        userNameLab.setBounds(80,80,100,30);
        userNameLab.setFont(font);
        userNameLab.setForeground(Color.BLACK);
        jPanel.add(userNameLab);

        // 密码提示标签
        JLabel pwdLab = new JLabel("密    码：");
        pwdLab.setBounds(80,120,100,30);
        pwdLab.setFont(font);
        pwdLab.setForeground(Color.BLACK);
        jPanel.add(pwdLab);

        // 密码确认提示标签
        JLabel pwd2Lab = new JLabel("确认密码：");
        pwd2Lab.setBounds(80,150,100,30);
        pwd2Lab.setFont(font);
        pwd2Lab.setForeground(Color.BLACK);
        jPanel.add(pwd2Lab);

        // 用户名输入框
        JTextField userNameText = new JTextField();
        userNameText.setBounds(180, 84, 100, 20);
        jPanel.add(userNameText);

        // 密码输入框
        JPasswordField jPasswordField1 = new JPasswordField();
        jPasswordField1.setBounds(180,124,100,20);
        jPanel.add(jPasswordField1);

        // 密码输入框
        JPasswordField jPasswordField2 = new JPasswordField();
        jPasswordField2.setBounds(180,155,100,20);
        jPanel.add(jPasswordField2);

        // 添加注册按钮
        JButton jButton = new JButton("注册");
        jButton.setBounds(180,200,80,20);
        jPanel.add(jButton);


        // 背景图片
        JLabel bgimg = new JLabel();
        Image img = new ImageIcon(Objects.requireNonNull(this.getClass().getResource("../imgs/signbg.png"))).getImage().getScaledInstance(400,300,Image.SCALE_DEFAULT);
        bgimg.setIcon(new ImageIcon(img));
        bgimg.setBounds(0,0,400,300);
        jPanel.add(bgimg);

        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userName = userNameText.getText();
                String pwdText = String.valueOf(jPasswordField1.getPassword());
                String pwdText1 = String.valueOf(jPasswordField2.getPassword());
                if (!userName.equals("")) {
                    if (pwdText1.equals(pwdText)) {
                        String sql = "insert into userInfo values(\" " + userName + "\",\"" + pwdText + "\")";
                        Test1Demo db = new Test1Demo();
                        db.insert(sql);
                        Login login = new Login();
                        login.loginJF();
                        that.setVisible(false);
                    }
                }else {
                    JOptionPane.showMessageDialog(null,"用户名为空！");
                }
            }
        });


    }

    public static void main(String[] args) {
        Sign sign = new Sign();
        sign.signJF();
    }

    public void signJF() {
        this.setVisible(true);
        //设置窗口大小
        this.setSize(400, 300);
        //设置窗口不能放大缩小
        this.setResizable(false);
        //设置窗口居中
        this.setLocationRelativeTo(null);
        //设置窗口标题
        this.setTitle("注册窗口");
        //获取窗口的图标
        Image im = (new ImageIcon("/imgs/qq.jpeg")).getImage();
        this.setIconImage(im);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
