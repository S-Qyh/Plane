package cn.QYH.obj;

import cn.QYH.main.GameWin;
import cn.QYH.util.GameUtils;

import java.awt.*;

public class BulletObj extends GameObj{
    public BulletObj() {
        super();
    }

    public BulletObj(Image image, int x, int y, double speed) {
        super(image, x, y, speed);
    }

    public BulletObj(Image image, int x, int y, int w, int h, double speed, GameWin gameWin) {
        super(image, x, y, w, h, speed, gameWin);
    }

    @Override
    public void paintSelf(Graphics g) {
        super.paintSelf(g);
        y += speed;
        // 敌方子弹和我方飞机的碰撞检测
        if (this.getRec().intersects(this.gameWin.planeObj.getRec())){
            GameWin.state = 3;
        }

        // 敌方子弹越界处理
        if (y > 960){
            this.x = -3;
            this.y = -3;
            GameUtils.removeList.add(this);
        }
    }

    @Override
    public Rectangle getRec() {
        return super.getRec();
    }

    @Override
    public Image getImage() {
        return super.getImage();
    }
}
