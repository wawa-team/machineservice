package com.doll.controller;

import com.doll.util.ActionStatus;
import com.doll.util.ApiContents;
import com.doll.util.RaspberryApi;
import com.doll.util.Results;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by hexu on 2017/9/2.
 */

@RestController
//@RequestMapping("/action")
public class ActionController {

    private final static Logger logger = LoggerFactory.getLogger(ActionController.class);

    public static ActionStatus actionStatus = new ActionStatus();

    public static RaspberryApi api = new RaspberryApi();

    @RequestMapping("/status")
    public Results status() {
        return new Results(ApiContents.NORMAL.value(), ApiContents.NORMAL.desc(), actionStatus);
    }

    @RequestMapping("/start")
    public Results start() {
        actionStatus.start();
        api.resetStatus();
        return new Results(ApiContents.NORMAL.value(), ApiContents.NORMAL.desc());
    }

    @RequestMapping("/end")
    public Results end() {
        // FIXME: 2017/9/2   这里http通知服务器结算
        Map<String, Object> map = new HashMap<>();
        map.put("results",1);
        if (api.getDoll()) {

        }
        actionStatus.end();
        return new Results(ApiContents.NORMAL.value(), ApiContents.NORMAL.desc(), map);
    }

    @RequestMapping("/action")
    public Results front(HttpServletRequest request) {
        Integer action = request.getParameter("action") == null ? null : Integer.valueOf(request.getParameter("action"));
        Long time = request.getParameter("time") == null ? null : Long.valueOf(request.getParameter("time"));
        if (action == null || time == null)
            return new Results(ApiContents.PARAMS_ERROR.value(), ApiContents.PARAMS_ERROR.desc());
        actionStatus.action(action);
//        api.action(actionStatus);
        api.action(actionStatus, time);
        return new Results(ApiContents.NORMAL.value(), ApiContents.NORMAL.desc());
    }

}
