package com.example.user.controller;

import com.example.user.dto.OrderRequestDto;
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

    @PutMapping("/updateOrder/{orderId}")
    public OrderDto updateOrder(@RequestBody @Valid OrderRequestDto dto, @PathVariable Long orderId){return orderServiceProxy.updateOrder(orderId, dto);}

    @GetMapping("/myOrders")
    public String getOrders(Model model){
        model.addAttribute("orders", orderServiceProxy.getAllOrders(SecurityContextHolder.getContext().getAuthentication().getName()));
        return "orders";
    }

    @DeleteMapping("/deleteOrder/{orderId}")
    public ResponseEntity<?> deleteOrderById(@PathVariable Long orderId){ return orderServiceProxy.deleteOrder(orderId);}

}
