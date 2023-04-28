package com.example.demo.Controller;

import com.example.demo.Exception.Exception;
import com.example.demo.Entity.Customer;
import com.example.demo.Service.CustomerService;
import com.example.demo.dto.CustomerDto;
import com.example.demo.dto.ResultDto;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RestController
@RequestMapping("/customer")
@AllArgsConstructor
public class CustomerController {


    private final CustomerService customerService;

    /**
     * them customer
     * @param customer
     * @return
     */
    @PostMapping("/add")
    public ResponseEntity<ResultDto> createCustomer(@RequestBody Customer customer) {
        return ResponseEntity.ok(customerService.createCustomer(customer));
    }

    /**
     * lay customer tu DB
     * @return
     */
    @GetMapping("/showList")
    public ResponseEntity<List<CustomerDto>> getCustomers() {  //lay ra list customer tu DB
        return ResponseEntity.ok(customerService.getallCustomer());
    }

    /**
     * lay customer dua voa id
     * @param id
     * @return
     */
    @GetMapping("/showCustomer/{id}")
    public ResponseEntity<Object> getCustomerbyID(@PathVariable("id") Integer id) {
        try{
            return ResponseEntity.ok(customerService.findCustomerbyId(id));
        }
        catch (Exception e){
            return new ResponseEntity<>("Customer doesn't exist", HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * lay customer dua vao address
     * @param id
     * @return
     */
    @GetMapping("/showCustomerfromAddress/{id}")
    public ResponseEntity<Object> getCustomerbyAddressID(@PathVariable("id") Integer id) {
        try{
            return ResponseEntity.ok(customerService.findCustomerbyAddressId(id));
        }
        catch (Exception e){
            return new ResponseEntity<>("Customer cannot be found from addressID "+id, HttpStatus.BAD_REQUEST);
        }
    }


    /**
     * xoa customer tu DB
     * @param id
     * @return
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteCustomer(@PathVariable("id") Integer id) {
        try{
            customerService.deleteCustomerbyId(id);
            return new ResponseEntity<>("Customer deleted", HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
}
