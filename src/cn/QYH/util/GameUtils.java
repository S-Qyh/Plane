package cn.QYH.util;

import cn.QYH.main.GameWin;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class GameUtils {
    public static Image bgimg = new ImageIcon(Objects.requireNonNull(GameWin.class.getResource("../imgs/space.jpg"))).getImage();
    public static Image heroimg = new ImageIcon(Objects.requireNonNull(GameWin.class.getResource("../imgs/hero.png"))).getImage();
    public static Image bossimg = new ImageIcon(Objects.requireNonNull(GameWin.class.getResource("../imgs/boss2.png"))).getImage();
}
