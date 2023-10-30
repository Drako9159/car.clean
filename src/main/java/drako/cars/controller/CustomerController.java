package drako.cars.controller;

import drako.cars.domain.dto.CustomerDto;
import drako.cars.domain.service.ICustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/customers")
public class CustomerController {

    private final ICustomerService iCustomerService;


    @GetMapping
    public ResponseEntity<List<CustomerDto>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(iCustomerService.getAll());
    }
}
