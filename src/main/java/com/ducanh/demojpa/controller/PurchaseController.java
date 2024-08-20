package com.ducanh.demojpa.controller;

import com.ducanh.demojpa.entity.OrderDetails;
import com.ducanh.demojpa.entity.Orders;
import com.ducanh.demojpa.entity.Products;
import com.ducanh.demojpa.entity.Users;
import com.ducanh.demojpa.service.IOrderService;
import com.ducanh.demojpa.service.IProductService;
import com.ducanh.demojpa.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@Controller
public class PurchaseController {

    @Autowired
    UsersService userService;

    //Demo nen dung truc tiep product repository
    @Autowired
    IProductService productService;

    @Autowired
    IOrderService ordersService;

    @GetMapping("/purchase/{productId}")
    public String purchase(@PathVariable Long productId, Model model) {
        Products product = productService.getProductById(productId);
        model.addAttribute("product", product);
        return "Purchase";
    }

    @PostMapping("/purchase")
    public String createOrder(@RequestParam Long productId, @RequestParam int quantity, Model model, Principal principal ) {
        Products product = productService.getProductById(productId);
        Orders order = new Orders();
        Users user = userService.getUserByUserName(principal.getName());
        order.setUser(userService.getUserById(user.getId()));
        order.setTotalQty(quantity);
        order.setTotalAmount(product.getPrice() * quantity);
        order.setStatus(true);

        OrderDetails orderDetails = new OrderDetails();
        orderDetails.setOrder(order);
        orderDetails.setProduct(product);
        orderDetails.setUnitPrice(product.getPrice());
        orderDetails.setQty(quantity);

        ordersService.createOrder(order, orderDetails);

        model.addAttribute("order", order);
        return "orderSuccess";
    }
}
