package cn.QYH.obj;

import cn.QYH.main.GameWin;
import cn.QYH.util.GameUtils;

import java.awt.*;

import static cn.QYH.obj.PlaneObj.life;

public class EnemyObj extends GameObj{
    @Override
    public void paintSelf(Graphics g) {
        super.paintSelf(g);
        y = (int) (y + speed);
        // 敌方飞机的越界
        if (y > 960){
            this.x = -200;
            this.y = -100;
            GameUtils.removeList.add(this);
        }
        // 敌我飞机碰撞检测
        if (this.getRec().intersects(this.gameWin.planeObj.getRec())){
            --life;
            if (life <= 0)
                GameWin.state = 3;


            ExplodeObj explodeObj = new ExplodeObj(x,y);
            GameUtils.explodeObjList.add(explodeObj);

            GameUtils.removeList.add(explodeObj);
            this.x = -400;
            this.y = -400;
            GameUtils.removeList.add(this);
            ++GameWin.score;
        }
        // 碰撞检测  敌机消失 移动到（-100，-100）  子弹消失移动到 （-100，-100）
        for (FireObj fireObj:GameUtils.fireList){
            // 当前敌机的obj 和 每一个子弹对象进行碰撞检测
            if (this.getRec().intersects(fireObj.getRec())){

                GameUtils.musicEnemyBoom.play(1);
                ExplodeObj explodeObj = new ExplodeObj(x,y);
                GameUtils.explodeObjList.add(explodeObj);

                GameUtils.removeList.add(explodeObj);
                fireObj.setX(-900);
                fireObj.setY(-900);
                this.x = -400;
                this.y = -400;
                GameUtils.removeList.add(fireObj);
                GameUtils.removeList.add(this);
                ++GameWin.score;
            }
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
