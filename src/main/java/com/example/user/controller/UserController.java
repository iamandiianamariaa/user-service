package com.example.user.controller;

import com.example.user.dto.OrderRequestDto;
import lombok.RequiredArgsConstructor;
import com.example.user.dto.OrderDto;
import com.example.user.service.OrderServiceProxy;
import com.example.user.service.UserService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/users")
@Validated
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final OrderServiceProxy orderServiceProxy;

    @GetMapping("/orders/{orderId}")
    public OrderDto getOrderById(@PathVariable Long orderId){
        return orderServiceProxy.getOrderById(orderId);
    }

    @PostMapping
    public OrderDto createOrder(@RequestBody @Valid OrderRequestDto dto){
        return orderServiceProxy.createOrder(dto);
    }
}
