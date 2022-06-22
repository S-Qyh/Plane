package cn.QYH.obj;

import cn.QYH.main.GameWin;

import java.awt.*;

public class ExplodeObj extends GameObj{
    static Image[] pic = new Image[16];

    int explodeCount = 0;


    static {
        for (int i = 0;i<pic.length;i++){
            pic[i] = Toolkit.getDefaultToolkit().getImage("src/cn/QYH/imgs/explode/e"+(i+1)+".gif");
        }
    }
    public ExplodeObj(int x, int y) {
        super(x, y);
    }

    @Override
    public void paintSelf(Graphics g) {
        if (explodeCount < 16){
            image = pic[explodeCount];
            super.paintSelf(g);
            ++explodeCount;
        }
    }
}
