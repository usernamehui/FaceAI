package com.face.java;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;

import com.baidu.aip.face.AipFace;

public class FaceAI {
    //设置APPID/AK/SK
    public static final String APP_ID = "15596980";
    public static final String API_KEY = "Q9y4RaNVHRS2qASyOOnVAWvl";
    public static final String SECRET_KEY = "Em6UmDtsBGFm1fvkBe1Nc9P0cg32oyxE";

    public static void main(String[] args) {
        // 初始化一个AipFace
        AipFace client = new AipFace(APP_ID, API_KEY, SECRET_KEY);

        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);
        

        // 可选：设置代理服务器地址, http和socket二选一，或者均不设置
//        client.setHttpProxy("proxy_host", proxy_port);  // 设置http代理
//        client.setSocketProxy("proxy_host", proxy_port);  // 设置socket代理

        // 可选：设置log4j日志输出格式，若不设置，则使用默认配置
        // 也可以直接通过jvm启动参数设置此环境变量
//        System.setProperty("aip.log4j.conf", "path/to/your/log4j.properties");

        
        //人脸注册
        //faceRegister(client);
        
        //人脸搜索
        search(client);

    }
    
    public static void faceRegister(AipFace client) {
    	 // 传入可选参数调用接口
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("user_info", "user's info");
        options.put("quality_control", "NORMAL");
        options.put("liveness_control", "NONE");

        String image = "https://rde-image.bj.bcebos.com/OpenAPI/OpenAPI/image/201709/1f54ba978c034ef8abe96cf64efdf952.png";
        String imageType = "URL";
        String groupId = "group1";
        String userId = "user1";

        // 人脸注册
        JSONObject res = client.addUser(image, imageType, groupId, userId, options);
        System.out.println(res.toString(2));
    }
    
    
    public static void search(AipFace client) {
    	// 传入可选参数调用接口
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("quality_control", "NORMAL");
        options.put("liveness_control", "NONE");
        options.put("max_user_num", "1");
        
        //原始图片对比返回100分
        //String image = "https://rde-image.bj.bcebos.com/OpenAPI/OpenAPI/image/201709/1f54ba978c034ef8abe96cf64efdf952.png";
        //相似证件照返回93.539855957031分
        String image ="https://bj.bcebos.com/v1/rde-image/OpenAPI/OpenAPI/user/201711/3c6ae4537e0d41a9a3db4c3ad4d9490d.png";
        String imageType = "URL";
        String groupIdList = "group1";

        // 人脸搜索
        JSONObject res = client.search(image, imageType, groupIdList, options);
        System.out.println(res.toString(2));

    }
}