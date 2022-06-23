package cn.QYH.util;

import cn.QYH.main.GameWin;
import cn.QYH.obj.*;

import javax.sound.sampled.*;
import javax.swing.*;
import javax.swing.plaf.SplitPaneUI;
import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;

import static cn.QYH.jf.Login.userName;


public class GameUtils {
    static Test1Demo db = new Test1Demo();

    public static Image bgimg = new ImageIcon(Objects.requireNonNull(GameWin.class.getResource("../imgs/space.jpg"))).getImage();
    public static Image heroimg = new ImageIcon(Objects.requireNonNull(GameWin.class.getResource("../imgs/hero.png"))).getImage();
    public static Image bossimg = new ImageIcon(Objects.requireNonNull(GameWin.class.getResource("../imgs/boss2.png"))).getImage();

    public static Image enemyPlane = new ImageIcon(Objects.requireNonNull(GameWin.class.getResource("../imgs/ep01.png"))).getImage();

    public static Image explodeImg = new ImageIcon(Objects.requireNonNull(GameWin.class.getResource("../imgs/explode/e7.gif"))).getImage();
    // 我方子弹
    public static Image bullet = new ImageIcon(Objects.requireNonNull(GameWin.class.getResource("../imgs/shell.png"))).getImage();
    // 敌方子弹
    public static Image enemyBullet = new ImageIcon(Objects.requireNonNull(GameWin.class.getResource("../imgs/bullet.png"))).getImage();

    // 暂停
    public static Image scoreImg = new ImageIcon(Objects.requireNonNull(GameWin.class.getResource("../imgs/score.png"))).getImage();


    public static Image doubleFire = new ImageIcon(Objects.requireNonNull(GameWin.class.getResource("../imgs/doubleFire.png"))).getImage();

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

    public static MusicPlay musicStart = new MusicPlay("src/cn/QYH/Music/start.wav");// 开始音效

//    public static MusicPlay musicBackground = new MusicPlay("Music/backMusic.wav");// 背景音效

    public static MusicPlay musicFire = new MusicPlay("src/cn/QYH/Music/fire.wav");// 发射子弹音效

    public static MusicPlay musicEnemyBoom = new MusicPlay("src/cn/QYH/Music/enemyBoom.wav");// 敌机死亡音效

    public static MusicPlay musicGameOver = new MusicPlay("src/cn/QYH/Music/gameover.wav");// 结束音效

    public static MusicPlay musicHeroBomm = new MusicPlay("src/cn/QYH/music/myBoom.wav");// 英雄机爆炸音效


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
    // 音响
    public static void sound(String str) throws FileNotFoundException {
        FileInputStream in = new FileInputStream(str);
        AudioInputStream as = new AudioInputStream((TargetDataLine) in);

    }

    public static String BGM = "src/cn/QYH/imgs/Bg1.wav";

    public static void playMusic(String path) throws LineUnavailableException, UnsupportedAudioFileException, IOException {
        //1 获取你要播放的音乐文件
        File file = new File(BGM);
        //2、定义一个AudioInputStream用于接收输入的音频数据
        AudioInputStream am;
        //3、使用AudioSystem来获取音频的音频输入流(处理（抛出）异常)
        am = AudioSystem.getAudioInputStream(file);
        //4、使用AudioFormat来获取AudioInputStream的格式
        AudioFormat af = am.getFormat();
        //5、一个源数据行
        SourceDataLine sd ;
        //6、获取受数据行支持的音频格式DataLine.info
        //DataLine.Info dl = new DataLine.Info(SourceDataLine.class, af);
        //7、获取与上面类型相匹配的行 写到源数据行里 二选一
        sd = AudioSystem.getSourceDataLine(af);//便捷写法
        //sd = (SourceDataLine) AudioSystem.getLine(dl);
        //8、打开具有指定格式的行，这样可以使行获得资源并进行操作
        sd.open();
        //9、允许某个数据行执行数据i/o
        sd.start();
        //10、写数据
        int sumByteRead = 0; //读取的总字节数
        byte [] b = new byte[320];//设置字节数组大小
        //11、从音频流读取指定的最大数量的数据字节，并将其放入给定的字节数组中。
        while (sumByteRead != -1) {//-1代表没有 不等于-1时就无限读取
            sumByteRead = am.read(b, 0, b.length);//12、读取哪个数组
            if(sumByteRead >= 0 ) {//13、读取了之后将数据写入混频器,开始播放
                sd.write(b, 0, b.length);
            }
        }
        //关闭
        sd.drain();
        sd.close();

    }

    public static void main(String[] args) throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        playMusic(BGM);
    }

    public static int heightScore;
    public static int search() throws SQLException {
        String sql = "SELECT max(score) FROM mark WHERE user = '"+userName+"'";
        heightScore = db.query(sql).getInt(1);
        System.out.println(heightScore);
        return heightScore;
    }
}
