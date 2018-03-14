package com.jxliu.springmvc.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jxliu.springmvc.pojo.Items;
@Controller//Controller标识该类是一个控制层面的类
public class ItemController {

	//.action可以省略
	@RequestMapping("/itemList.action")//RequestMapping注解指定请求的url
	public ModelAndView itemList() {
		//查询商品列表
		List<Items> itemList = new ArrayList<>();
		itemList.add(new Items(1, "iphone6", 6000, new Date(), "苹果很贵"));
		itemList.add(new Items(2, "imac", 20000, new Date(), "苹果本很贵"));
		itemList.add(new Items(3, "苹果", 20, new Date(), "苹果不贵"));
		itemList.add(new Items(4, "冰箱", 50000, new Date(), "能装很多苹果"));
		itemList.add(new Items(5, "碗", 2, new Date(), "可以装一个苹果"));
		//把商品列表传递给jsp
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("itemList", itemList);
		//设置展示数据的jsp
		//modelAndView.setViewName("/WEB-INF/jsp/itemList.jsp");
		//配置完视图解析器后只需要返回jsp的名称即可，即springmvc.xml中如果配置了处理器映射器和处理器适配器或者注解驱动以后，就只需要返回jsp页面的名字
		modelAndView.setViewName("itemList");
		//返回结果
		return modelAndView;
	}
}
