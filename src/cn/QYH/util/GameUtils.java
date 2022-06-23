package cn.QYH.util;

import cn.QYH.main.GameWin;
import cn.QYH.obj.*;

import javax.swing.*;
import javax.swing.plaf.SplitPaneUI;
import java.awt.*;
import java.util.ArrayList;
import java.util.Objects;

public class GameUtils {
    public static Image bgimg = new ImageIcon(Objects.requireNonNull(GameWin.class.getResource("../imgs/space.jpg"))).getImage();
    public static Image heroimg = new ImageIcon(Objects.requireNonNull(GameWin.class.getResource("../imgs/hero.png"))).getImage();
    public static Image bossimg = new ImageIcon(Objects.requireNonNull(GameWin.class.getResource("../imgs/boss2.png"))).getImage();

    public static Image enemyPlane = new ImageIcon(Objects.requireNonNull(GameWin.class.getResource("../imgs/ep01.png"))).getImage();

    public static Image explodeImg = new ImageIcon(Objects.requireNonNull(GameWin.class.getResource("../imgs/explode/e7.gif"))).getImage();
    // 我方子弹
    public static Image bullet = new ImageIcon(Objects.requireNonNull(GameWin.class.getResource("../imgs/fire.png"))).getImage();
    // 敌方子弹
    public static Image enemyBullet = new ImageIcon(Objects.requireNonNull(GameWin.class.getResource("../imgs/bullet.png"))).getImage();

    // 暂停
    public static Image scoreImg = new ImageIcon(Objects.requireNonNull(GameWin.class.getResource("../imgs/score.png"))).getImage();


    //存放子弹的集合
    public static ArrayList<FireObj> fireList = new ArrayList<FireObj>();

    //所有游戏物体的集合
    public static ArrayList<GameObj> gameObjList = new ArrayList<GameObj>();

    // 敌机的集合
    public static ArrayList<EnemyObj> enemyObjList = new ArrayList<>();

    // 删除敌机
    public static ArrayList<GameObj> removeList = new ArrayList<>();

    // 添加敌方子弹类的集合
    public static ArrayList<BulletObj> bulletObjList = new ArrayList<>();

    // 爆炸类的集合
    public static ArrayList<ExplodeObj> explodeObjList = new ArrayList<>();

    // 绘制字符串的工具类
    public static void drawWord(Graphics gImage,String str,int size,int x,int y){
        gImage.setColor(Color.GREEN);
        gImage.setFont(new Font("仿宋",-1,size));
        gImage.drawString(str,x,y);
    }
    public static void drawWord(Graphics gImage,String str,Color color,int size,int x,int y){
        gImage.setColor(color);
        gImage.setFont(new Font("仿宋",-1,size));
        gImage.drawString(str,x,y);
    }
}
