package cn.QYH.obj;

import java.awt.Graphics;
import java.awt.Image;

public class BgObj extends GameObj{
	
	@Override
	public void paintSelf(Graphics g) {
		super.paintSelf(g);
		//Y轴移动
		y+=speed;
		if (y>=0){
			y = -1706;
		}
	}
	
	public BgObj() {
		super();
	}
	
	public BgObj(Image image, int x, int y, double speed) {
		super(image,x,y,speed);
	}

}