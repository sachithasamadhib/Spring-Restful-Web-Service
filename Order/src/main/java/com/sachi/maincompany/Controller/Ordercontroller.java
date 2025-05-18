package com.sachi.maincompany.Controller;

import com.sachi.maincompany.Dto.OrderDTO;
import com.sachi.maincompany.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin
@RequestMapping("api/v1/")
public class Ordercontroller {

    @Autowired
    private OrderService orderService;

    @GetMapping("/getallOrder")
    public List<OrderDTO> getallOrder() {
        return orderService.getAllOrders();
    }

    @GetMapping("/getOrder/{Orderid}")
    public OrderDTO getOrderid(@PathVariable int Orderid) {
        return orderService.getOrderbyid(Orderid);
    }

    @GetMapping("/hi")
    public String hi() {
        return "Hi";
    }

    @PostMapping("/addOrder")
    public OrderDTO addOrder(@RequestBody OrderDTO Order) {
        return orderService.saveOrder(Order);

    }

    @PutMapping("/updateOrder")
    public OrderDTO updateOrder(@RequestBody OrderDTO Order) {
        return orderService.updateOrder(Order);
    }

    @DeleteMapping("/deleteOrder/{id}")
    public String deleteOrder (@PathVariable int id) {
        return orderService.deleteOrder(id);
    }

}
