package com.sachi.maincompany.Service;

import com.sachi.maincompany.Dto.OrderDTO;
import com.sachi.maincompany.Model.Order;
import com.sachi.maincompany.Repo.OrderRepo;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Transactional
public class OrderService {

    @Autowired
    private OrderRepo orderRepo;

    @Autowired
    private ModelMapper modelMapper;

    public List<OrderDTO> getAllOrders(){
        List<Order> OrdersList = orderRepo.findAll();
        return modelMapper.map(OrdersList, new TypeToken<List<OrderDTO>>() {}.getType());
    }

    public OrderDTO saveOrder(OrderDTO Order) {
        orderRepo.save(modelMapper.map(Order, Order.class));
        return Order;
    }

    public OrderDTO updateOrder(OrderDTO Order) {
        orderRepo.save(modelMapper.map(Order, Order.class));
        return Order;
    }

    public String deleteOrder(int id){
        try {
            if(orderRepo.existsById(id)){
                orderRepo.deleteById(id);
                return "Deleted Successfully";
            } else {
                return "Order with ID " + id + " not found";
            }
        } catch (Exception e) {
            return "Error deleting Order: " + e.getMessage();
        }
    }
    public OrderDTO getOrderbyid(int id) {
        Order order = orderRepo.getOrderbyid(id);
        return modelMapper.map(order, OrderDTO.class);
    }

}
