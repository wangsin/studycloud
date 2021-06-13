package cn.sinblog.studycloud.controller;


import cn.sinblog.studycloud.mybatis.entity.MVCMybatisDemoUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.sinblog.studycloud.GetUserInfoService;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @author paida 派哒 zeyu.pzy@alibaba-inc.com
 */
@Controller
public class GreetingController {

	@Autowired
	private GetUserInfoService getUserInfoService;

	@GetMapping("/greeting")
	public String greeting(@RequestParam(name="name", required=false, defaultValue="1") String name, Model model) {

		getUserInfoService.getUserInfoById(name, model);
		//这里返回的数据类型是String，但实际上更多的数据通过本函数中Model model传给了前端。返回值String也会被SpringMVC整合为一个ModelAndView，以供前端使用。（Controller可以返回多种数值，比如void、String、ModelAndView。同学们可以自行搜索学习）
		return "greeting";
	}

	@PostMapping("/greetingPost")
	@ResponseBody
	public String greetingPost(@RequestParam(name="name") String name) {

		MVCMybatisDemoUser result = new MVCMybatisDemoUser();
		result.setId(name);
		return result.getId();
	}
}
