package com.example.user.service;

import com.example.user.dto.OrderRequestDto;
import com.example.user.dto.OrderDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

@FeignClient(value = "order-service", url = "http://order:8080")
public interface OrderServiceProxy {
    @GetMapping(value = "/orders/{orderId}", consumes = "application/json")
    OrderDto getOrderById(@PathVariable Long orderId);

    @PostMapping(value = "/orders")
    OrderDto createOrder(@RequestBody @Valid OrderRequestDto dto);
}
