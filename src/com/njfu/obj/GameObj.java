package com.njfu.obj;

import com.njfu.GameWin;

import java.awt.*;

public class GameObj {
    //定义物体的图片
    Image img;
    //定义物体的坐标
    int x;
    int y;
    //定义物体的宽高
    int width;
    int height;
    //定义移动速度
    double speed;
    //窗口的引用
    GameWin frame;

    //get 和 set 方法

    public Image getImg() {
        return img;
    }

    public void setImg(Image img) {
        this.img = img;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public GameWin getFrame() {
        return frame;
    }

    public void setFrame(GameWin frame) {
        this.frame = frame;
    }
    //构造函数

    public GameObj() {
    }

    public GameObj(Image img, int x, int y, double speed) {
        this.img = img;
        this.x = x;
        this.y = y;
        this.speed = speed;
    }

    public GameObj(Image img, int x, int y, int width, int height, double speed, GameWin frame) {
        this.img = img;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.speed = speed;
        this.frame = frame;
    }
    //绘制自身的方法
    public void paintSelf(Graphics gImage){
        gImage.drawImage(img,x,y,null);
    }

    //编写获取自身矩形的方法,用于碰撞检测
    public Rectangle getRec(){
        return new Rectangle(x,y,width,height);
    }

    public GameObj(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
