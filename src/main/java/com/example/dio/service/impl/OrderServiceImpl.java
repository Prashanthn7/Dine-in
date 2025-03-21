package com.example.dio.service.impl;

import com.example.dio.dto.response.OrderResponse;
import com.example.dio.enums.OrderStatus;
import com.example.dio.enums.TableStatus;
import com.example.dio.exception.NoCartItemFoundException;
import com.example.dio.exception.TableNotFoundByIdException;
import com.example.dio.mapper.OrderMapper;
import com.example.dio.model.CartItem;
import com.example.dio.model.Order;
import com.example.dio.model.Table;
import com.example.dio.repository.CartItemRepository;
import com.example.dio.repository.OrderRepository;
import com.example.dio.repository.TableRepository;
import com.example.dio.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final TableRepository tableRepository;
    private final CartItemRepository cartItemRepository;
    private final OrderMapper orderMapper;

    @Override
    public OrderResponse createOrder(long tableId) {
       Table table= tableRepository.findById(tableId)
                .orElseThrow(()-> new TableNotFoundByIdException("Table Not Found By Id"));


      List<CartItem> cartItems = cartItemRepository.findByTable(table);

      Order order = null;
      if(cartItems.isEmpty()){
          throw new NoCartItemFoundException("Cart Item Not Found");
      }

      else{
          order = new Order();
          order.setStatus(OrderStatus.CONFIRMED);
          order.setCartItems(cartItems);
          order.setTable(table);
          order.setTotalAmount(cartItems.stream()
                  .mapToDouble(CartItem :: getTotalPrice).sum());
          orderRepository.save(order);
      }

      table.setStatus(TableStatus.OCCUPIED);
      tableRepository.save(table);

      cartItems.forEach(item -> item.setOrdered(true));
      cartItemRepository.saveAll(cartItems);

      return orderMapper.mapToOrderResponse(order);


    }
}
