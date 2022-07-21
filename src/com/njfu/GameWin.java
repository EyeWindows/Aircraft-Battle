package com.njfu;

import com.njfu.obj.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GameWin extends JFrame {
    //游戏状态：0未开始，1游戏中，2暂停，3通关失败，4通关成功
    public static int state = 0;

    Image offScreenImage = null;
    int width = 600;
    int height = 600;
    //游戏的重绘次数
    int count = 1;
    //定义分数的变量
    public static int score = 0;
    //敌方飞机的数量
    int enemyCount = 0;
    //背景类对象
    BgObj bgObj = new BgObj(GameUtils.bgImg,0,-2000,2);
    //我方飞机的对象
    public PloneObj ploneObj = new PloneObj(GameUtils.planeImg,290,550,20,30,0,this);
    //敌方boss飞机的对象
    public BossObj bossObj = null;


    //ShellObj shellObj = new ShellObj(GameUtils.shellImg,ploneObj.getX()+3,ploneObj.getY()-1,14,29,5,this);
    //设置启动方法
    public void launch(){
        //设置窗口可见
        this.setVisible(true);
        //设置窗口大小
        this.setSize(width,height);
        //设置窗口位置
        this.setLocationRelativeTo(null);
        //设置窗口标题
        this.setTitle("飞机大战游戏");
        //设置关闭按钮
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        GameUtils.gameObjList.add(bgObj);
        GameUtils.gameObjList.add(ploneObj);
        //添加鼠标点击事件
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getButton() == 1&& state ==0){
                    state = 1;
                    repaint();
                }
            }
        });
        while (true){
            if(state == 1){
                createObj();
                repaint();
            }
            try {
                Thread.sleep(25);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public void paint(Graphics g){
        if(offScreenImage == null){
            offScreenImage = createImage(width,height);
        }
        Graphics gImage = offScreenImage.getGraphics();
        gImage.fillRect(0,0,width,height);
        if(state == 0){
            gImage.drawImage(GameUtils.bgImg,0,0,null);
            gImage.drawImage(GameUtils.bossImg,220,120,null);
            gImage.drawImage(GameUtils.explodeImg,270,350,null);
            GameUtils.drawWord(gImage,"点击开始游戏",Color.YELLOW,40,180,300);
        }
        if(state == 1){
            GameUtils.gameObjList.addAll(GameUtils.explodeObjList);
            //运行中
            for (int i = 0; i < GameUtils.gameObjList.size(); i++) {
                GameUtils.gameObjList.get(i).paintSelf(gImage);
            }
            GameUtils.gameObjList.removeAll(GameUtils.removeObjList);
        }
        if(state == 3){
            //失败
            gImage.drawImage(GameUtils.explodeImg,ploneObj.getX()-35,ploneObj.getY()-50,null);
            GameUtils.drawWord(gImage,"游戏失败",Color.RED,50,180,300);
        }
        if(state == 4){
            //游戏通关
            gImage.drawImage(GameUtils.explodeImg,bossObj.getX()+30,bossObj.getY(),null);
            GameUtils.drawWord(gImage,"游戏通关",Color.RED,50,190,300);
        }
        GameUtils.drawWord(gImage,score+"分",Color.GREEN,40,30,100);
        g.drawImage(offScreenImage,0,0,null);
        count++;
        System.out.println(GameUtils.gameObjList.size());
    }
    public void motion(){
        this.setSize(this.getWidth()+1,this.getHeight()+1);
        this.setSize(this.getWidth()-1,this.getHeight()-1);
    }
    //延迟一秒在执行
    public void delay(){
        try {
            Thread.sleep(150);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    void createObj(){
        if(count % 15 ==0){
            //子弹的对象
            GameUtils.shellObjList.add(new ShellObj(GameUtils.shellImg,ploneObj.getX()+3,ploneObj.getY()-1,14,29,5,this));
            GameUtils.gameObjList.add(GameUtils.shellObjList.get(GameUtils.shellObjList.size() - 1));
        }
        if(count % 15 ==0){
            GameUtils.enemyObjList.add(new EnemyObj(GameUtils.enemyImg,(int)(Math.random()*12)*50,0,49,36,5,this));
            GameUtils.gameObjList.add(GameUtils.enemyObjList.get(GameUtils.enemyObjList.size() - 1));
            enemyCount++;
        }
        if(count % 15 ==0 && bossObj != null){
            //敌机子弹的对象
            GameUtils.bulletObjList.add(new BulletObj(GameUtils.bulletImg,bossObj.getX()+76,bossObj.getY()+85,15,25,5,this));
            GameUtils.gameObjList.add(GameUtils.bulletObjList.get(GameUtils.bulletObjList.size() - 1));
        }
        if(enemyCount > 50 && bossObj == null){
            bossObj = new BossObj(GameUtils.bossImg,250,35,155,100,5,this);
            GameUtils.gameObjList.add(bossObj);
        }
    }





    public static void main(String[] args) {
        GameWin gameWin = new GameWin();
        gameWin.launch();
        gameWin.delay();
        gameWin.motion();
    }
}
