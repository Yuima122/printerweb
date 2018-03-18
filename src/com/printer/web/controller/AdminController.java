package com.printer.web.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.printer.config.UpdateConfig;
import com.printer.pojo.Order;
import com.printer.service.OrderService;

@RequestMapping("bg")
@Controller
public class AdminController {
	@Autowired
	OrderService orderService;

	@RequestMapping("index")
	public String start(HttpServletRequest request, HttpServletResponse response) {

		UpdateConfig.isUpdate = false;
		List<Order> orderList = new ArrayList<>();
		// Order order = new Order();
		// order.setOrderid("11111111");
		// order.setPay(0);
		// order.setDone(0);
		// order.setTele("12334485566");
		// order.setOther("江安校区");
		// order.setTime(new Date());

		// arrayList.add(order);
		
		
		orderList = orderService.getOrders();
		System.out.println(orderList.size());
		System.out.println(orderList.get(0).getOrderid().toString());
		request.setAttribute("orders", orderList);
		return "adminlte/product/home.jsp";
	}

	@ResponseBody
	@RequestMapping("adminComplete")
	public String adminComplete(String id) {
		orderService.setComplete(id);
		return null;
	}

	@RequestMapping("adminGetPath")
	public void adminGetPath(String id, HttpServletResponse response) {
		try {
			response.sendRedirect("http://www.baidu.com");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@ResponseBody
	@RequestMapping("update")
	public String update(int num) {

		if (UpdateConfig.isUpdate)
			return "{\"flag\":\"1\"}";
		return "{\"flag\":\"0\"}";
	}
}
