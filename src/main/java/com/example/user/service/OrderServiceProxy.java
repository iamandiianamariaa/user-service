package com.example.user.service;

import com.example.user.dto.OrderRequestDto;
import com.example.user.dto.OrderDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@FeignClient(value = "order-service", url = "http://order:8080/orders")
public interface OrderServiceProxy {
    @GetMapping(value = "{orderId}")
    OrderDto getOrderById(@PathVariable Long orderId);

    @GetMapping
    List<OrderDto> getAllOrders();

    @PostMapping
    OrderDto createOrder(@RequestBody @Valid OrderRequestDto dto);

    @PutMapping(value = "/{orderId}")
    OrderDto updateOrder(@PathVariable Long orderId, @RequestBody @Valid OrderRequestDto dto);

    @DeleteMapping(value = "/{orderId}")
    ResponseEntity<?> deleteOrder(@PathVariable Long orderId);
}
