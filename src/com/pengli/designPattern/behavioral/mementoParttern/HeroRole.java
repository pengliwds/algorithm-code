package com.pengli.designPattern.behavioral.mementoParttern;

public class HeroRole {


    private String name;
    private int level;
    private int exp;
    private int score;
    private int hp;
    private int mp;
    private int attack;
    private int defense;
    private int magic;
    private int speed;


    public HeroRole(String name, int level, int exp, int score, int hp, int mp, int attack, int defense, int magic, int speed) {
        this.name = name;
        this.level = level;
        this.exp = exp;
        this.score = score;
        this.hp = hp;
        this.mp = mp;
        this.attack = attack;
        this.defense = defense;
        this.magic = magic;
        this.speed = speed;
    }

    public HeroRole() {
        this.name = "Hero";
        this.level = 1;
        this.exp = 0;
        this.score = 0;
        this.hp = 100;
        this.mp = 100;
        this.attack = 10;
        this.defense = 10;
        this.magic = 10;
        this.speed = 10;
    }


    public GameMemento saveState() {
        return new GameMemento(level, hp, mp, score);
    }


    public void restoreState(GameMemento memento) {
        this.level = memento.getLevel();
        this.hp = memento.getLives();
        this.mp = memento.getBlue();
        this.score = memento.getScore();
    }

    public void levelUp() {
        level++;
        exp = 0;
        hp += 100;
    }

    public void addExp(int exp) {
        this.exp += exp;
    }


    public void currentState() {
        System.out.println("Hero: " + name + " level: " + level + " exp: " + exp + " score: " + score + " hp: " + hp
                + " mp: " + mp + " attack: " + attack + " defense: " + defense + " magic: " + magic + " speed: " + speed);
    }


}
