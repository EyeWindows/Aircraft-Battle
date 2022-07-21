package com.njfu.obj;

import com.njfu.GameWin;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PloneObj extends GameObj{
    @Override
    public Image getImg() {
        return super.getImg();
    }

    public PloneObj() {
        super();
    }

    public PloneObj(Image img, int x, int y, int width, int height, double speed, GameWin frame) {
        super(img, x, y, width, height, speed, frame);
        this.frame.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                PloneObj.super.x = e.getX() - 11;
                PloneObj.super.y = e.getY() - 16;
            }
        });
    }

    @Override
    public void paintSelf(Graphics gImage) {
        super.paintSelf(gImage);
        //我方飞机与敌方boss进行碰撞检测
        if(this.frame.bossObj != null && this.getRec().intersects(this.frame.bossObj.getRec())){
            GameWin.state = 3;
        }
    }
}
