package cn.QYH.util;

import cn.QYH.main.GameWin;
import cn.QYH.obj.FireObj;
import cn.QYH.obj.GameObj;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Objects;

public class GameUtils {
    public static Image bgimg = new ImageIcon(Objects.requireNonNull(GameWin.class.getResource("../imgs/space.jpg"))).getImage();
    public static Image heroimg = new ImageIcon(Objects.requireNonNull(GameWin.class.getResource("../imgs/hero.png"))).getImage();
    public static Image bossimg = new ImageIcon(Objects.requireNonNull(GameWin.class.getResource("../imgs/boss2.png"))).getImage();

    public static Image enemyPlane = new ImageIcon(Objects.requireNonNull(GameWin.class.getResource("../imgs/ep01.png"))).getImage();

    // 我方子弹
    public static Image bullet = new ImageIcon(Objects.requireNonNull(GameWin.class.getResource("../imgs/fire.png"))).getImage();

    //存放子弹的集合
    public static ArrayList<FireObj> fireList = new ArrayList<FireObj>();

    //所有游戏物体的集合
    public static ArrayList<GameObj> gameObj = new ArrayList<GameObj>();
}
