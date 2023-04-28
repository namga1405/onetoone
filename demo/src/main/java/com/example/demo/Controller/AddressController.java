package com.example.demo.Controller;

import com.example.demo.Service.AddressService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
@RequestMapping("/address")
@AllArgsConstructor
public class AddressController {

    private final AddressService addressService;


    /**
     * lay tat ca address tu DB
     * @return
     */
    @GetMapping("/showList")
    public ResponseEntity<Object> getAddress() {  //lay ra list customer tu DB
        return ResponseEntity.ok(addressService.getallAddress());
    }


}
