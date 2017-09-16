package com.doll.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by hexu on 2017/9/2.
 */
//@Component("actionStatus")
public class ActionStatus {

    private final static Logger logger = LoggerFactory.getLogger(ActionStatus.class);

    //0==未使用  1==使用中
    private Integer status = 0;

    private Integer up = 0;

    private Integer down = 0;

    private Integer left = 0;

    private Integer right = 0;

    private Integer stop = 1;

    private Integer grab = 0;

    public Integer getStop() {
        return stop;
    }

    public void setStop(Integer stop) {
        this.stop = stop;
    }

    public Integer getGrab() {
        return grab;
    }

    public void setGrab(Integer grab) {
        this.grab = grab;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getUp() {
        return up;
    }

    public void setUp(Integer up) {
        this.up = up;
    }

    public Integer getDown() {
        return down;
    }

    public void setDown(Integer down) {
        this.down = down;
    }

    public Integer getLeft() {
        return left;
    }

    public void setLeft(Integer left) {
        this.left = left;
    }

    public Integer getRight() {
        return right;
    }

    public void setRight(Integer right) {
        this.right = right;
    }

    public void start() {
        this.status = 1;
    }

    public void end() {
        this.status = 0;
        stop();
    }

    public void stop() {
        this.up = 0;
        this.down = 0;
        this.left = 0;
        this.right = 0;
        this.stop = 1;
        this.grab = 0;
    }

    public void action(Integer action) {
        if (action.equals(ActionContents.UP.value())) {
            logger.info("上");
            this.up = 1;
            this.down = 0;
            this.left = 0;
            this.right = 0;
            this.stop = 0;
            this.grab = 0;
        } else if (action.equals(ActionContents.DOWN.value())) {
            logger.info("下");
            this.up = 0;
            this.down = 1;
            this.left = 0;
            this.right = 0;
            this.stop = 0;
            this.grab = 0;
        } else if (action.equals(ActionContents.LEFT.value())) {
            logger.info("左");
            this.up = 0;
            this.down = 0;
            this.left = 1;
            this.right = 0;
            this.stop = 0;
            this.grab = 0;
        } else if (action.equals(ActionContents.RIGHT.value())) {
            logger.info("右");
            this.up = 0;
            this.down = 0;
            this.left = 0;
            this.right = 1;
            this.stop = 0;
            this.grab = 0;
        } else if (action.equals(ActionContents.STOP.value())) {
            logger.info("停");
            stop();
        } else if (action.equals(ActionContents.GRAB.value())) {
            this.up = 0;
            this.down = 0;
            this.left = 0;
            this.right = 0;
            this.stop = 1;
            this.grab = 1;
        }
    }

}
