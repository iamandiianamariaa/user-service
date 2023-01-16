package com.example.user.controller;

import com.example.user.dto.OrderRequestDto;
import com.example.user.mapper.OrderMapper;
import lombok.RequiredArgsConstructor;
import com.example.user.dto.OrderDto;
import com.example.user.service.OrderServiceProxy;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.logging.Logger;

@Controller
@RequestMapping(value = "/users")
@Validated
@RequiredArgsConstructor
public class UserController {
    private final OrderServiceProxy orderServiceProxy;
    private final OrderMapper orderMapper;
    static Logger logger = Logger.getLogger(UserController.class.getName());

    @GetMapping("/submit-form")
    public String createForm(Model model) {

        model.addAttribute("formSubmit", new OrderRequestDto());
        return "submit-form";
    }

    @PostMapping("/createOrder")
    public String createFormSubmission(@ModelAttribute OrderRequestDto formSubmit, RedirectAttributes redirectAttributes)
    {
        formSubmit.setUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        if(orderServiceProxy.createOrder(formSubmit).isEmpty()){
            redirectAttributes.addFlashAttribute("errorMessage", "No courier available in your region.");
            return "redirect:/users/submit-form";
        }

        return "order-confirmation";
    }
    @GetMapping("/getOrder/{orderId}")
    public OrderDto getOrderById(@PathVariable Long orderId){
        return orderServiceProxy.getOrderById(orderId);
    }

    @GetMapping("/updateOrder/{orderId}")
    public String updateForm(Model model, @PathVariable String orderId) {
        logger.info(orderId);
        OrderDto order = orderServiceProxy.getOrderById(Long.valueOf(orderId));

        model.addAttribute("formSubmit", order);
        return "submit-form-update";
    }

    @PutMapping("/update")
    public String updateOrder(@ModelAttribute OrderDto orderDto){
        logger.info(orderDto.getReceiverAddress());
        logger.info("ceva " + orderDto.getId());
        orderServiceProxy.updateOrder(orderDto.getId(),orderMapper.maptoRequestDto(orderDto));

        return "redirect:/users/myOrders";
    }

    @GetMapping("/myOrders")
    public String getOrders(Model model){
        model.addAttribute("orders", orderServiceProxy.getAllOrders(SecurityContextHolder.getContext().getAuthentication().getName()));
        return "orders";
    }

    @GetMapping("/deleteOrder/{orderId}")
    public String deleteOrderById(@PathVariable Long orderId){
        logger.info("lala " + orderId);
        orderServiceProxy.deleteOrder(orderId);
        return "redirect:/users/myOrders";
    }

}
