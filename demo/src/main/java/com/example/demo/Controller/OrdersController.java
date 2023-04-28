package com.example.demo.Controller;

import com.example.demo.Entity.Orders;
import com.example.demo.Service.OrdersService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RestController
@RequestMapping("/orders")
@AllArgsConstructor
public class OrdersController {
    private final OrdersService ordersService;

    /**
     * them order vao db
     * @param orders
     * @return
     */
    @PostMapping("/add")
    public ResponseEntity<Object> addOrder(@RequestBody Orders orders) {
        return ResponseEntity.ok(ordersService.createOrders(orders));
    }

    /**
     * lay het orders tu db
     * @return
     */
    @GetMapping("/showList")
    public ResponseEntity<Object> showOrders() {
        return ResponseEntity.ok(ordersService.getallOrder());
    }

    /**
     * lay orders tu customer
     * @param id
     * @return
     */
    @GetMapping("/showList/address/{id}")
    public ResponseEntity<Object> showOrdersfromAddress(@PathVariable("id") Integer id) {
        try {
            return ResponseEntity.ok(ordersService.findOrdersByAddressId(id));
        }
        catch (Exception e) {
            return new ResponseEntity<>("Cannot find customer", HttpStatus.BAD_REQUEST);
        }
    }


}
