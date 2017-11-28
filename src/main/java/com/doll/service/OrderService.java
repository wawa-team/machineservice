package com.doll.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.doll.util.ApiContents;
import com.doll.util.Results;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * <p>Copyright: All Rights Reserved</p>
 * <p>Company: 指点无限(北京)科技有限公司   http://www.zhidianwuxian.cn</p>
 * <p>Description:  </p>
 * <p>Author:hexu/方和煦, 2017/9/30</p>
 */

@Service("orderService")
public class OrderService {

    @Value("${machine.id}")
    private Long machineId;

    @Value("${doll.server.ip}")
    private String serverIp;

    private final static Logger logger = LoggerFactory.getLogger(OrderService.class);

    public Results callBack(String token, String orderId, Integer result) {
        logger.info("========================发起游戏回调========================="+orderId+"++"+result.toString());
        String url = serverIp + "/order/callBack" + "?machineId=" + machineId.toString() + "&orderId=" + orderId.toString() + "&result=" + result.toString() + "&token=" + token;
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet httppost = new HttpGet(url);
        try {
            CloseableHttpResponse response = httpclient.execute(httppost);
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                String responseText = EntityUtils.toString(entity, "UTF-8");
                JSONObject dataObject = JSON.parseObject(responseText);
                if (!dataObject.get("code").equals("200")) {
                    return new Results(ApiContents.BACK_ORDER_ERROR.value(), ApiContents.BACK_ORDER_ERROR.desc());
                }
            }
        } catch (IOException y) {
            y.printStackTrace();
        }
        return new Results(ApiContents.NORMAL.value(), ApiContents.NORMAL.desc());
    }

}
