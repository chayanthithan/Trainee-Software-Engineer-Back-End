package com.example.order_service.service;

import aj.org.objectweb.asm.commons.Remapper;
import com.example.order_service.dto.OrderResponseDto;
import com.example.order_service.dto.ProductDto;
import com.example.order_service.entity.Order;
import com.example.order_service.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final WebClient.Builder webClientBuilder;

    public Mono<OrderResponseDto> placeOrder(Order order) {
        return webClientBuilder.build()
                .get()
                .uri("http://localhost:8081/product/" + order.getProductId())
                .retrieve()
                .bodyToMono(ProductDto.class)
                .map(productDto -> {
                    // Build Response DTO
                    OrderResponseDto responseDto = OrderResponseDto.builder()
                            .orderId(order.getId())
                            .productId(order.getProductId())
                            .quantity(order.getQuantity())
                            .productName(productDto.getName())
                            .productPrice(productDto.getPrice())
                            .totalPrice(order.getQuantity() * productDto.getPrice())
                            .build();

                    // Save order details in the database
                    orderRepository.save(order);
                    return responseDto;
                });
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
}
