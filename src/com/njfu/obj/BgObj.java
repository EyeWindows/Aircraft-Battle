package com.njfu.obj;

import java.awt.*;

public class BgObj extends GameObj{
    public BgObj() {
        super();
    }

    public BgObj(Image img, int x, int y, double speed) {
        super(img, x, y, speed);
    }

    @Override
    public void paintSelf(Graphics gImage) {
        super.paintSelf(gImage);
        y += speed;
        //实现图片的循环，当图片移动到y坐标的0时，自动将图片的坐标变为-2000，相当于重新开始移动
        if(y >= 0){
            y = -2000;
        }
    }
}
