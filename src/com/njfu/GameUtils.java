package com.njfu;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import com.njfu.obj.*;

public class GameUtils {
    //背景图片
    public static Image bgImg = Toolkit.getDefaultToolkit().getImage("imgs/bg.jpg");
    //飞机boss图片
    public static Image bossImg = Toolkit.getDefaultToolkit().getImage("imgs/boss.png");
    //爆炸图片
    public static Image explodeImg = Toolkit.getDefaultToolkit().getImage("imgs/explode/e6.gif");
    //我方飞机图片
    public static Image planeImg = Toolkit.getDefaultToolkit().getImage("imgs/plane.png");
    //我方子弹的图片
    public static Image shellImg = Toolkit.getDefaultToolkit().getImage("imgs/shell.png");
    //敌方战斗机的图片
    public static Image enemyImg = Toolkit.getDefaultToolkit().getImage("imgs/enemy.png");
    //敌方boss子弹的图片
    public static Image bulletImg = Toolkit.getDefaultToolkit().getImage("imgs/bullet.png");

    //所有物体的集合
    public static List<GameObj> gameObjList = new ArrayList<>();
    //我方子弹的集合
    public static List<ShellObj> shellObjList = new ArrayList<>();
    //添加敌方战斗机的集合
    public static List<EnemyObj> enemyObjList = new ArrayList<>();
    //要删除元素的集合
    public static List<GameObj> removeObjList = new ArrayList<>();
    //地方boss的子弹集合
    public static List<BulletObj> bulletObjList = new ArrayList<>();
    //爆炸类的集合
    public static List<ExplodeObj> explodeObjList = new ArrayList<>();

    //绘制文字的方法
    public static void drawWord(Graphics gImage,String str,Color color,int size,int x,int y){
        gImage.setColor(color);
        gImage.setFont(new Font("仿宋",Font.BOLD,size));
        gImage.drawString(str, x, y);
    }

}
