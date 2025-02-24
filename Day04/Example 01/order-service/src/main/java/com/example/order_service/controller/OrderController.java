package com.example.order_service.controller;

import com.example.order_service.dto.OrderResponseDto;
import com.example.order_service.dto.ProductDto;
import com.example.order_service.entity.Order;
import com.example.order_service.repository.OrderRepository;
import com.example.order_service.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;
    private final WebClient.Builder webClientBuilder;

    @PostMapping("/place-order")
    public Mono<ResponseEntity<OrderResponseDto>> placeOrder(@RequestBody Order order){
// fetch product details from product service
            return orderService.placeOrder(order)
                    .map(ResponseEntity::ok);
    }

    @GetMapping()
    public List<Order> getAllOrders(){
        return orderService.getAllOrders();
    }
}
