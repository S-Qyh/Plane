package cn.QYH.util;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class MusicPlay {
    private Clip clip;
    private File wavFile;// 源头
    private AudioInputStream ais;// 流

    public MusicPlay(String filepath) {
        try {
            clip = AudioSystem.getClip();
            wavFile = new File(filepath);
            ais = AudioSystem.getAudioInputStream(wavFile);
            clip.open(ais);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // n循环标记，0=循环播放，1=单次播放，n=播放n次
    public MusicPlay play(int loopTimes) {
        if (loopTimes == 0) {
            clip.loop(Clip.LOOP_CONTINUOUSLY);// 永远循环播放
        } else {
            clip.setMicrosecondPosition(0);// 每次重复播放前设置剪辑播放位置为0
            clip.loop(loopTimes - 1);// 播放n次
        }
        /*说明：loop函数很特别，参数0播放1次，参数1表示播放完毕再重复播放1次*/
        return this;
    }

    // stop具备暂停效果，再次调用play方法会继续播放下去
    public void stop() {
        clip.stop();
    }

    // 返回播放的状态
    public boolean playingStatus() {
        return clip.isRunning();
    }
}


