package cn.QYH.obj;

import cn.QYH.main.GameWin;
import cn.QYH.util.GameUtils;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

//英雄机的类
public class PlaneObj extends GameObj{
    public static int life = 10;
    @Override
    public void paintSelf(Graphics g) {
        super.paintSelf(g);
        //添加鼠标事件，飞机跟随鼠标移动
        //对鼠标的移动和拖放，另外再加鼠标运动的监听器
        this.gameWin.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                // 让飞机的横纵坐标 = 鼠标光标的横坐标
                PlaneObj.super.x = (e.getX() - w/2) ;
                PlaneObj.super.y = (e.getY() - h/2) ;
            }
        });
        // 检测我方飞机和敌方飞机的碰撞
        if (this.gameWin.bossObj != null && this.getRec().intersects(this.gameWin.bossObj.getRec())){
            --life;
            if (life <= 0){
                GameWin.state = 3;
            }
        }

        // 血条的白色背景
        g.setColor(Color.WHITE);
        g.fillRect(20,900,100,10);
        // 血条的绘制
        g.setColor(Color.red);
        g.fillRect(20,900,life*10,10);
    }

    @Override
    public Rectangle getRec() {
        return super.getRec();
    }

    @Override
    public Image getImage() {
        return super.getImage();
    }

    @Override
    public int getX() {
        return super.getX();
    }

    @Override
    public int getY() {
        return super.getY();
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
