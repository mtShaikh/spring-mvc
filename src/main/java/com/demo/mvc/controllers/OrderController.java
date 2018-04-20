package com.demo.mvc.controllers;

import java.util.List;
// import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.demo.mvc.entities.Order;
import com.demo.mvc.services.OrderService;

@Controller
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private OrderService orderService;

	@GetMapping("/list")
	public String list(Model model) {
		// get orders from dao
		List<Order> orders = orderService.getOrders();

		// add the orders to the model
		model.addAttribute("orders", orders);

		return "list-orders";
	}

	@GetMapping("/newOrder")
	public String newOrder(Model model) {
		model.addAttribute("order", new Order());
		return "order-form";
	}

	@PostMapping("/saveOrder")
	public String saveOrder(@ModelAttribute("order") Order order) {
		// create the order using the service
		orderService.saveOrder(order);

		return "redirect:/order/list";
	}

	@GetMapping("/viewOrder")
	public String viewOrder(@RequestParam("orderId") int orderId, Model model) {
		// get the order using the service
		Order order = orderService.getOrder(orderId);

		// set order as a model attribute to pre-populate the form
		model.addAttribute("order", order);

		return "order-form";
	}

	@GetMapping("/deleteOrder")
	public String deleteOrder(@RequestParam("orderId") int orderId, Model model) {
		orderService.deleteOrder(orderId);
		
		return "redirect:/order/list";
	}
}
