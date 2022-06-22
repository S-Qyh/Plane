package cn.QYH.main;

import cn.QYH.obj.*;
import cn.QYH.util.GameUtils;


import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.plaf.synth.SynthOptionPaneUI;

import static cn.QYH.util.GameUtils.*;
import static java.awt.Color.decode;
import static java.awt.Color.red;

public class GameWin extends JFrame implements Runnable {
    // 记录游戏状态  0 游戏未开始  1 游戏中 2 游戏暂停 3 通关成功 4 通关失败
    public static int state = 0;
    // 得分
    public static int score = 0;
    static int w = 384;
    static int h = 960;
    int count = 1;

    // 敌机数量
    int enemyCount = 0;

    BgObj bgObj = new BgObj(GameUtils.bgimg, 0, -1706, 2);

    Image offScreenImage = null;

    //英雄机
    public PlaneObj planeObj = new PlaneObj(heroimg, 125, 580, 50, 41, 0, this);

    // 子弹对象
//    FireObj fireObj = new FireObj(bullet, planeObj.getX(), planeObj.getY(), 50, 52, 5, this);

    //敌方飞机
    EnemyObj enemyPlane = new EnemyObj(GameUtils.enemyPlane, 0, 0, 5);

    // 敌方boss对象
    public BossObj bossObj = null;

    @Override
    public void paint(Graphics g) {
        //初始化图片
        if (offScreenImage == null) {
            offScreenImage = createImage(w, h);
        }
        //获取当前图像的画板对象
        Graphics gImage = offScreenImage.getGraphics();
        //使用画板对象填充一个具有高度和宽度的区域
        gImage.drawRect(0, 0, w, h);

        if (state == 0) {
            gImage.drawImage(bgimg, 0, 0, null);
            gImage.drawImage(heroimg, 125, 580, 100, 80, null);
            gImage.drawImage(bossimg, 100, 100, null);
            GameUtils.drawWord(gImage, "点击游戏开始", 40, 120, 480);
        }
        if (state == 1) {
            gameObjList.addAll(explodeObjList);
            for (GameObj gameObj : gameObjList) {
                gameObj.paintSelf(gImage);
            }
            gameObjList.removeAll(removeList);
            GameUtils.drawWord(gImage, score + "分数", Color.green, 40, 30, 100);
        }
        if (state == 3) {
            gImage.drawImage(explodeImg, planeObj.getX() - 35, planeObj.getY() - 50, null);
            GameUtils.drawWord(gImage, "失败", red, 50, 150, 480);
        }
        if (state == 4) {
            gImage.drawImage(explodeImg, bossObj.getX() + 30, bossObj.getY(), null);
            GameUtils.drawWord(gImage, "游戏通关", red, 50, 150, 480);
        }
        g.drawImage(offScreenImage, 0, 0, null);
        count++;
    }

    // 批量创建子弹
    public void createdObj() {
        if (count % 20 == 0) {
            // 添加子弹到集合
            fireList.add(new FireObj(bullet, planeObj.getX(), planeObj.getY() - 50, 50, 52, 5, this));
            // 每添加一个炮弹就把该 炮弹 放入 游戏物体的集合
            gameObjList.add(fireList.get(fireList.size() - 1));
        }
        if (count % 20 == 0) {
            // 添加飞机到游戏物体集合
            enemyObjList.add(new EnemyObj(GameUtils.enemyPlane, (int) ((Math.random() * 5) * 70), 0, 71, 48, 5, this));
            gameObjList.add(enemyObjList.get(enemyObjList.size() - 1));
            ++enemyCount;
        }
        if (count % 20 == 0 && bossObj != null) {
            // 添加子弹到集合
            bulletObjList.add(new BulletObj(enemyBullet, bossObj.getX() + 76, bossObj.getY() + 150, 15, 25, 5, this));
            // 每添加一个炮弹就把该 炮弹 放入 游戏物体的集合
            gameObjList.add(bulletObjList.get(bulletObjList.size() - 1));
        }

        // 测试的时候出现一架就出现boos
        if (enemyCount > 50 && bossObj == null) {
            bossObj = new BossObj(bossimg, 0, 35, 157, 109, 5, this);
            gameObjList.add(bossObj);
        }
    }

    public static void main(String[] args) {
        GameWin gameWin = new GameWin();
        gameWin.lunch();
    }

    public void lunch() {
        this.setVisible(true);

        this.setSize(w, h);

        this.setResizable(false);

        this.setLocationRelativeTo(null);

        this.setTitle("飞机大战");

        Image im = (new ImageIcon("../imgs/qq.jpeg")).getImage();
        this.setIconImage(im);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
//	    		System.out.println(e.getButton());
                if (state == 0 && e.getButton() == 1) {
                    //改变游戏状态
                    state = 1;
                    //重绘组件
                    repaint();
                }

            }
        });
        // 游戏暂停
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == 32) {
                    switch (state) {
                        case 1:
                            state = 2;
                            break;
                        case 2:
                            state = 1;
                            break;
                        default:
                    }
                }
            }
        });
        // 将游戏物体加入到 gameobj的集合中
        gameObjList.add(bgObj);
        gameObjList.add(planeObj);


        while (true) {
            createdObj();
            if (state == 0 || state == 1)
                repaint();
            try {
                //每三十毫秒重绘组件
                Thread.sleep(30);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }

        }
    }


    @Override
    public void run() {
        GameWin gameWin = new GameWin();
        gameWin.lunch();
    }
}
