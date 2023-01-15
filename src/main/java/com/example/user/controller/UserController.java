package com.example.user.controller;

import com.example.user.dto.OrderRequestDto;
import lombok.RequiredArgsConstructor;
import com.example.user.dto.OrderDto;
import com.example.user.service.OrderServiceProxy;
import com.example.user.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(value = "/users")
@Validated
@RequiredArgsConstructor
public class UserController {
    private final OrderServiceProxy orderServiceProxy;

    @GetMapping("/submit-form")
    public String createForm(Model model) {

        model.addAttribute("formSubmit", new OrderRequestDto());
        return "submit-form";
    }

    @PostMapping("/createOrder")
    public String createFormSubmission(@ModelAttribute OrderRequestDto formSubmit)
    {
        orderServiceProxy.createOrder(formSubmit);
        return "results";
    }
    @GetMapping("/getOrder/{orderId}")
    public OrderDto getOrderById(@PathVariable Long orderId){
        return orderServiceProxy.getOrderById(orderId);
    }

//    @PostMapping("/createOrder")
//    public OrderDto createOrder(@RequestBody @Valid OrderRequestDto dto){
//        return orderServiceProxy.createOrder(dto);
//    }

    @PutMapping("/updateOrder/{orderId}")
    public OrderDto updateOrder(@RequestBody @Valid OrderRequestDto dto, @PathVariable Long orderId){return orderServiceProxy.updateOrder(orderId, dto);}

    @GetMapping("/myOrders")
    public List<OrderDto> getOrders(){ return orderServiceProxy.getAllOrders();}

    @DeleteMapping("/deleteOrder/{orderId}")
    public ResponseEntity<?> deleteOrderById(@PathVariable Long orderId){ return orderServiceProxy.deleteOrder(orderId);}

}
