package com.pengli.designPattern.behavioral.mementoParttern;

import java.util.Date;

public class GameMemento {

    /**
     * 等级
     */
    private int level;
    /**
     * 生命值
     */
    private int lives;
    /**
     * 蓝量
     */
    private int blue;
    /**
     * 金币
     */
    private int score;
    /**
     * 存档时间
     */
    private Date timeStamp;

    public GameMemento(int level, int lives, int blue, int score) {
        this.level = level;
        this.lives = lives;
        this.blue = blue;
        this.score = score;
        this.timeStamp = new Date();
    }


    public int getLevel() {
        return level;
    }

    public int getLives() {
        return lives;
    }

    public int getBlue() {
        return blue;
    }

    public int getScore() {
        return score;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }


    @Override
    public String toString() {
        return "GameMemento{" +
                "level=" + level +
                ", lives=" + lives +
                ", blue=" + blue +
                ", score=" + score +
                ", timeStamp=" + timeStamp +
                '}';
    }
}
