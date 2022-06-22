package cn.QYH.obj;

import cn.QYH.main.GameWin;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

//英雄机的类
public class PlaneObj extends GameObj{
    @Override
    public void paintSelf(Graphics g) {
        super.paintSelf(g);
        //添加鼠标事件，飞机跟随鼠标移动
        //对鼠标的移动和拖放，另外再加鼠标运动的监听器
        this.gameWin.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                // 让飞机的横纵坐标 = 鼠标光标的横坐标
                x = (e.getX() - w/2) + 20;

                y = (e.getY() - h/2) + 10;
                System.out.println(x +" "+ y);
            }
        });
    }

    @Override
    public Rectangle getRec() {
        return super.getRec();
    }

    @Override
    public Image getImage() {
        return super.getImage();
    }

    public PlaneObj(){
        super();
    }
    public PlaneObj(Image image, int x, int y, int w, int h, double speed, GameWin gameWin) {
        super();
        this.image = image;
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.speed = speed;
        this.gameWin = gameWin;
    }
}
