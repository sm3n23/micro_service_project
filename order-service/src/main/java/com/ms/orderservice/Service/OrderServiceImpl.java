package com.ms.orderservice.Service;

import com.ms.orderservice.Entity.Order;
import com.ms.orderservice.Entity.OrderItems;
import com.ms.orderservice.Repository.OrderRepository;
import com.ms.orderservice.dto.OrderItemsDto;
import com.ms.orderservice.dto.OrderRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderServiceImpl implements OrderService{

    private final OrderRepository orderRepository;
    @Override
    public void placeOrder(OrderRequest orderRequest) {
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());

        List<OrderItems> orderItemsList = orderRequest.getOrderItemsDtos()
                .stream().map(this::mapToDto).toList();
        order.setOrderItems(orderItemsList);

        orderRepository.save(order);
    }

    private OrderItems mapToDto(OrderItemsDto orderItemsDto) {
        OrderItems orderItems = new OrderItems();
        orderItems.setPrice(orderItemsDto.getPrice());
        orderItems.setQuantity(orderItemsDto.getQuantity());
        orderItems.setSkuCode(orderItemsDto.getSkuCode());
        return orderItems;
    }
}
