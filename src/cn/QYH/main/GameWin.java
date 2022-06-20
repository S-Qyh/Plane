package cn.QYH.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.util.Objects;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class GameWin extends JFrame {
    // 记录游戏状态  0 游戏未开始  1 游戏中 2 游戏暂停 3 通关成功 4 通关失败
    static int state = 0;
    static int w = 350;
    static int h = 600;


    @Override
    public void paint(Graphics g) {
        if (state == 0){
            g.drawImage(new ImageIcon(Objects.requireNonNull(GameWin.class.getResource("..//imgs//bg.jpg"))).getImage(),
                    0,0,w,h,null);
            g.setColor(Color.yellow);
            g.setFont(new Font("微软雅黑", Font.BOLD, 20));
            g.drawString("单击游戏开始",100,300);
        }
    }

    public static void main(String[] args) {
        GameWin gameWin = new GameWin();
        gameWin.lunch();

    }
    public void lunch(){
        this.setVisible(true);

        this.setSize(w,h);

        this.setResizable(false);

        this.setLocationRelativeTo(null);

        this.setTitle("飞机大战");

        Image im = (new ImageIcon("/imgs/qq.jpeg")).getImage();
        this.setIconImage(im);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


}
