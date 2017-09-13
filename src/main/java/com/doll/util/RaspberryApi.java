package com.doll.util;

import com.pi4j.io.gpio.*;

/**
 * Created by hexu on 2017/9/2.
 */

public class RaspberryApi {

//    final GpioController gpio = GpioFactory.getInstance();
//    final GpioPinDigitalOutput pinCoin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_01, "pinCoin", PinState.LOW);
//    final GpioPinDigitalOutput pinUp = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_02, "pinUp", PinState.LOW);
//    final GpioPinDigitalOutput pinDown = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_03, "pinDown", PinState.LOW);
//    final GpioPinDigitalOutput pinLeft = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_04, "pinLeft", PinState.LOW);
//    final GpioPinDigitalOutput pinRight = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_05, "pinRight", PinState.LOW);
//    final GpioPinDigitalOutput pinGrab = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_06, "pinGrab", PinState.LOW);
//    final GpioPinDigitalInput pinDoll = gpio.provisionDigitalInputPin(RaspiPin.GPIO_27, PinPullResistance.PULL_DOWN);

    public void action(ActionStatus actionStatus) {
//        if (actionStatus.getUp().equals(1)) {
//            pinUp.high();
//        } else if (actionStatus.getUp().equals(0)) {
//            pinUp.low();
//        }
//        if (actionStatus.getDown().equals(1)) {
//            pinDown.high();
//        } else if (actionStatus.getDown().equals(0)) {
//            pinDown.low();
//        }
//        if (actionStatus.getLeft().equals(1)) {
//            pinLeft.high();
//        } else if (actionStatus.getLeft().equals(0)) {
//            pinLeft.low();
//        }
//        if (actionStatus.getRight().equals(1)) {
//            pinRight.high();
//        } else if (actionStatus.getRight().equals(0)) {
//            pinRight.low();
//        }
//        if (actionStatus.getGrab().equals(1)) {
//            pinGrab.high();
//        } else if (actionStatus.getGrab().equals(0)) {
//            pinGrab.low();
//        }
    }

    public void action(ActionStatus actionStatus, Long time) {
        action(actionStatus);
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        actionStatus.stop();
        resetStatus();
    }

    public boolean getDoll() {
//        if (pinDoll.getState().equals(PinPullResistance.PULL_DOWN)) {
//            return false;
//        } else if (pinDoll.getState().equals(PinPullResistance.PULL_UP)) {
//            return true;
//        }
        return false;
    }

    public void resetStatus() {
//        pinUp.low();
//        pinDown.low();
//        pinLeft.low();
//        pinRight.low();
//        pinGrab.low();
    }

    public void start(){
//        pinCoin.high();
    }

//    public static void main(String[] ss){
//        final GpioController gpio = GpioFactory.getInstance();
//    final GpioPinDigitalOutput pinUp = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_02, "pinUp", PinState.LOW);
//    final GpioPinDigitalOutput pinDown = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_03, "pinDown", PinState.LOW);
//    final GpioPinDigitalOutput pinLeft = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_04, "pinLeft", PinState.LOW);
//    final GpioPinDigitalOutput pinRight = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_05, "pinRight", PinState.LOW);
//    final GpioPinDigitalOutput pinGrab = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_06, "pinGrab", PinState.LOW);
//    final GpioPinDigitalInput pinDoll = gpio.provisionDigitalInputPin(RaspiPin.GPIO_27, PinPullResistance.PULL_DOWN);
//    }


}
