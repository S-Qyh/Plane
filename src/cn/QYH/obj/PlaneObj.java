package cn.QYH.obj;

import cn.QYH.main.GameWin;

import java.awt.*;

//英雄机的类
public class PlaneObj extends GameObj{
    @Override
    public void paintSelf(Graphics g) {
        super.paintSelf(g);
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
