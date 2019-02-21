package com.face.java;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FaceController {
	
	public static void main(String[] args) {
		//人脸注册H5页面
		//https://ai.baidu.com/facekit/page/form/61CF7123E2F948148C6FD3D764D9BD09
	}

	@ResponseBody
	@RequestMapping(value="face",method=RequestMethod.POST,produces= {"application/json"})
	public String face(HttpServletRequest request,String name,String telephone,String faceimage) {
		//token=6F487B320B8B496798A4DB36E1DDD3EC
		//http://ai.baidu.com/docs#/FaceAttendance/top -- 文档
		
		System.out.println("接受百度人脸注册数据回传："+request.getParameter("name"));
		System.out.println("姓名="+name+"--手机="+telephone+"--faceimage="+faceimage);
		Map<String, String[]> parameterMap = request.getParameterMap();
		for (String key : parameterMap.keySet()) {
			System.out.println("key="+key+"--value="+parameterMap.get(key));
		}
		return faceimage;
}
	}