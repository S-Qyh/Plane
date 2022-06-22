package cn.QYH.obj;

import cn.QYH.main.GameWin;
import cn.QYH.util.GameUtils;

import java.awt.*;

public class FireObj extends GameObj{
    @Override
    public void paintSelf(Graphics g) {
        super.paintSelf(g);
        //子弹移动
        y = (int) (y-speed);

        // 我方子弹越界消失 y < 0 改变坐标 -1 -1
        if (y < 0){
            this.x = -50;
            this.y = -50;
            GameUtils.removeList.add(this);
        }
    }


    public FireObj() {
        super();
    }

    public FireObj(Image image, int x, int y, double speed) {
        super(image,x,y,speed);
    }

    public FireObj(Image image, int x, int y, int w, int h, double speed, GameWin gameWin) {
        super(image,x,y,w,h,speed,gameWin);
    }

}
