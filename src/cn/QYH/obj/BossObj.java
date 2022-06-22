package cn.QYH.obj;

import cn.QYH.main.GameWin;
import cn.QYH.util.GameUtils;

import java.awt.*;

public class BossObj extends GameObj{
    int life = 10;
    public BossObj() {
        super();
    }

    public BossObj(Image image, int x, int y, double speed) {
        super(image, x, y, speed);
    }

    public BossObj(Image image, int x, int y, int w, int h, double speed, GameWin gameWin) {
        super(image, x, y, w, h, speed, gameWin);
    }

    @Override
    public void paintSelf(Graphics g) {
        super.paintSelf(g);
        if(x > 300 || x < -50) {
            speed = -speed;
        }
        x += speed;
        // 与我方子弹碰撞的检测
        for (FireObj fireObj: GameUtils.fireList){
            if (this.getRec().intersects(fireObj.getRec())){
                fireObj.setX(-200);
                fireObj.setY(-200);
                GameUtils.removeList.add(fireObj);
                --life;
            }
            if (life <= 0){
                GameWin.state = 4;
            }
        }
        // 血条的白色背景
        g.setColor(Color.WHITE);
        g.fillRect(20,40,100,10);
        // 血条的绘制
        g.setColor(Color.red);
        g.fillRect(20,40,life*100/10,10);
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
