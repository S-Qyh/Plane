package cn.QYH.obj;

import cn.QYH.main.GameWin;

import java.awt.*;

public class EnemyObj extends GameObj{
    @Override
    public void paintSelf(Graphics g) {
        super.paintSelf(g);
        y = (int) (y + speed);
    }

    @Override
    public Rectangle getRec() {
        return super.getRec();
    }

    @Override
    public Image getImage() {
        return super.getImage();
    }

    public EnemyObj() {
        super();
    }

    public EnemyObj(Image image, int x, int y, double speed) {
        super(image,x,y,speed);
    }

    public EnemyObj(Image image, int x, int y, int w, int h, double speed, GameWin gameWin) {
        super(image,x,y,w,h,speed,gameWin);
    }

}
