package com.doll.util;

import com.doll.service.OrderService;
import com.pi4j.io.gpio.*;
import com.pi4j.io.gpio.event.GpioPinDigitalStateChangeEvent;
import com.pi4j.io.gpio.event.GpioPinListenerDigital;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by hexu on 2017/9/2.
 */
@Component("api")
public class RaspberryApi {

    @Autowired
    private OrderService orderService;

    private String token;

    private String orderId;

    private Integer result = 1;


    final GpioController gpio = GpioFactory.getInstance();
    final GpioPinDigitalOutput pinUp = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_02, "pinUp", PinState.LOW);
    final GpioPinDigitalOutput pinCoin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_00, "pinCoin", PinState.LOW);
    final GpioPinDigitalOutput pinDown = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_03, "pinDown", PinState.LOW);
    final GpioPinDigitalOutput pinLeft = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_04, "pinLeft", PinState.LOW);
    final GpioPinDigitalOutput pinRight = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_05, "pinRight", PinState.LOW);
    final GpioPinDigitalOutput pinGrab = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_06, "pinGrab", PinState.LOW);
    final GpioPinDigitalInput pinDoll = gpio.provisionDigitalInputPin(RaspiPin.GPIO_27, PinPullResistance.PULL_DOWN);


    public RaspberryApi() {
        pinDoll.setShutdownOptions(true);

        pinDoll.addListener(new GpioPinListenerDigital() {
            @Override
            public void handleGpioPinDigitalStateChangeEvent(GpioPinDigitalStateChangeEvent event) {
                // display pin state on console
                System.out.println(" --> GPIO PIN STATE CHANGE: " + event.getPin() + " = " + event.getState());
                if (event.getState() == PinState.HIGH) {
                    result = 3;
                    orderService.callBack(token, orderId, 3);
                }
            }

        });
    }


    public void action(ActionStatus actionStatus) {
        if (actionStatus.getUp().equals(1)) {
            pinUp.high();
        } else if (actionStatus.getUp().equals(0)) {
            pinUp.low();
        }
        if (actionStatus.getDown().equals(1)) {
            pinDown.high();
        } else if (actionStatus.getDown().equals(0)) {
            pinDown.low();
        }
        if (actionStatus.getLeft().equals(1)) {
            pinLeft.high();
        } else if (actionStatus.getLeft().equals(0)) {
            pinLeft.low();
        }
        if (actionStatus.getRight().equals(1)) {
            pinRight.high();
        } else if (actionStatus.getRight().equals(0)) {
            pinRight.low();
        }
        if (actionStatus.getGrab().equals(1)) {
            pinGrab.high();
            //这里通知服务器
            new Thread() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(5000);
                        orderService.callBack(token, orderId, 2);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }.start();

        } else if (actionStatus.getGrab().equals(0)) {
            pinGrab.low();
        }
    }

    public void coin() {
        pinCoin.high();
        try {
            Thread.sleep(100L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        pinCoin.low();
    }

    public Integer action(ActionStatus actionStatus, Long time) {
        action(actionStatus);
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        actionStatus.stop();
        resetStatus(orderId, token);
        return 0;
    }

    public void resetStatus(String orderId, String token) {
        pinUp.low();
        pinDown.low();
        pinLeft.low();
        pinRight.low();
        pinGrab.low();
        this.orderId = orderId;
        this.token = token;
    }


}
