package com.njfu.obj;

import com.njfu.GameUtils;
import com.njfu.GameWin;

import java.awt.*;

public class BulletObj extends GameObj{
    public BulletObj() {
        super();
    }

    public BulletObj(Image img, int x, int y, int width, int height, double speed, GameWin frame) {
        super(img, x, y, width, height, speed, frame);
    }

    @Override
    public void paintSelf(Graphics gImage) {
        super.paintSelf(gImage);
        y += speed;
        if(y > 600){
            this.x = -300;
            this.y = 300;
            GameUtils.removeObjList.add(this);
        }
        if(this.getRec().intersects(this.frame.ploneObj.getRec())){
            GameWin.state = 3;
        }
    }

    @Override
    public Rectangle getRec() {
        return super.getRec();
    }
}
