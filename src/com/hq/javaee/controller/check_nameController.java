package com.hq.javaee.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hq.javaee.pojo.Friend;
import com.hq.javaee.pojo.User;
import com.hq.javaee.service.FriendService;
import com.hq.javaee.service.UserService;

@RestController
public class check_nameController {
	@Autowired
	private UserService us;
	@Autowired  
	private FriendService  fs;
	
	@RequestMapping("/check")
	@ResponseBody
	public String  check(String username,Model  model){
		  System.out.println(username);
		String  result=us.find(username);
		System.out.println("����ǣ�"+result);
		if("success".equals(result)){
			model.addAttribute("message","success");
			System.out.println("�ɹ���");
			return result;
			}else{
				model.addAttribute("message","false");
				System.out.println("ʧ����");
				return result;
			
				
			}
		
	}
	@RequestMapping("insertmessage")
	@ResponseBody
	public String  insertmessage(User  user){
		String  res=us.updateuserid(user);
		if("ok".equals(res)){
			System.out.println("����ɹ��˰�");
		}else{
			System.out.println("����ʧ����");
		}
		return res;
		
	}

	
	@RequestMapping("check_friendname")
	@ResponseBody
	public String  checkfriendname(Friend friend,Model  model){
		
		Map<String,Object> map=fs.select(friend);
		System.out.println(friend.getFriendname()+"�ǳ�");
		if(map!=null&&!map.isEmpty()){
			String  res=map.get("result").toString();
			if("success".equals(res)){
					return res;
			}else{
				return res;
			}
		}else{
			return "network";
		}
		
	}
			
	

	
		
}
