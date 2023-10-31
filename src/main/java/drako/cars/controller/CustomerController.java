package drako.cars.controller;

import drako.cars.domain.dto.CustomerDto;
import drako.cars.domain.dto.CustomerResponseDto;
import drako.cars.domain.service.usecase.ICustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping(path = "/{cardId}")
    public ResponseEntity<CustomerDto> getCustomerByCardId(@PathVariable String cardId) {
        return ResponseEntity.of(iCustomerService.getCustomerByCardId(cardId));
    }

    @GetMapping(path = "/email/{email}")
    public ResponseEntity<CustomerDto> getCustomerByCardByEmail(@PathVariable String email) {
        return ResponseEntity.of(iCustomerService.getCustomerByEmail(email));
    }

    @PostMapping
    public ResponseEntity<CustomerResponseDto> save(@RequestBody CustomerDto customerDto) {
        //try {
        return ResponseEntity.status(HttpStatus.CREATED).body(iCustomerService.save(customerDto));
        /*} catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }*/
    }

    @PutMapping
    public ResponseEntity<CustomerDto> update(@RequestBody CustomerDto customerDto) {
        return ResponseEntity.of(iCustomerService.update(customerDto));
    }

    @DeleteMapping(path = "/{cardID}")
    public ResponseEntity<Boolean> delete(@PathVariable String cardID) {
        return ResponseEntity.status(iCustomerService.delete(cardID) ? HttpStatus.OK : HttpStatus.NOT_FOUND).body(null);
    }


}
