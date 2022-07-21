package com.njfu.obj;

import com.njfu.GameUtils;
import com.njfu.GameWin;

import java.awt.*;

public class EnemyObj extends GameObj{
    public EnemyObj() {
        super();
    }

    public EnemyObj(Image img, int x, int y, int width, int height, double speed, GameWin frame) {
        super(img, x, y, width, height, speed, frame);
    }

    @Override
    public void paintSelf(Graphics gImage) {
        super.paintSelf(gImage);
        y += speed;
        if(this.getRec().intersects(this.frame.ploneObj.getRec())){
            GameWin.state = 3;
        }
        //敌机的越界，判断条件 y > 600
        if(y > 600){
            this.x = -200;
            this.y = 200;
            GameUtils.removeObjList.add(this);
        }
        for (ShellObj shellObj: GameUtils.shellObjList) {
            if(this.getRec().intersects(shellObj.getRec())){
                ExplodeObj explodeObj = new ExplodeObj(x,y);
                GameUtils.explodeObjList.add(explodeObj);
                GameUtils.removeObjList.add(explodeObj);
                shellObj.setX(-100);
                shellObj.setY(100);
                this.x = -200;
                this.y = 200;
                GameUtils.removeObjList.add(shellObj);
                GameUtils.enemyObjList.add(this);
                GameWin.score++;
            }
        }
    }

    @Override
    public Rectangle getRec() {
        return super.getRec();
    }
}
