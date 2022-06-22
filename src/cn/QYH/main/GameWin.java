package cn.QYH.main;

import cn.QYH.obj.BgObj;
import cn.QYH.obj.PlaneObj;
import cn.QYH.util.GameUtils;


import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


import javax.swing.ImageIcon;
import javax.swing.JFrame;

import static cn.QYH.util.GameUtils.*;

public class GameWin extends JFrame {
    // 记录游戏状态  0 游戏未开始  1 游戏中 2 游戏暂停 3 通关成功 4 通关失败
    static int state = 0;
    static int w = 384;
    static int h = 960;
    BgObj bgObj = new BgObj(GameUtils.bgimg,0,-1706,2);

    Image offScreenImage = null;

    //英雄机
    PlaneObj planeObj = new PlaneObj(heroimg,125,580,100,80,0,this);

    @Override
    public void paint(Graphics g) {
        //初始化图片
        if(offScreenImage == null){
            offScreenImage = createImage(w,h);
        }
        //获取当前图像的画板对象
        Graphics gImage = offScreenImage.getGraphics();
        //使用画板对象填充一个具有高度和宽度的区域
        gImage.drawRect(0,0,w,h);

        if(state == 0) {
            gImage.drawImage(bgimg, 0, 0, null);
            gImage.drawImage(heroimg, 125, 580, 100, 80, null);
            gImage.drawImage(bossimg, 100, 100, null);
            gImage.setColor(Color.WHITE);
            gImage.setFont(new Font("楷体", Font.BOLD, 20));
            gImage.drawString("单机游戏开始", 120, 480);
            g.drawImage(offScreenImage,0,0,null);
        }if(state==1) {
            bgObj.paintSelf(g);
            planeObj.paintSelf(g);
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

        Image im = (new ImageIcon("../imgs/qq.jpeg")).getImage();
        this.setIconImage(im);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
//	    		System.out.println(e.getButton());
                if(state==0 && e.getButton()==1){
                    //改变游戏状态
                    state = 1;
                    //重绘组件
                    repaint();
                }

            }
        });

        while(true) {
            repaint();
            try {
                //每三十毫秒重绘组件
                Thread.sleep(30);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }

        }
    }



}
