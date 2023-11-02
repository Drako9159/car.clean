package drako.cars.controller;

import drako.cars.domain.dto.AuthCustomerDto;
import drako.cars.domain.dto.CustomerDto;
import drako.cars.domain.dto.CustomerResponseDto;
import drako.cars.domain.dto.JwtResponseDto;
import drako.cars.domain.usecase.IAuthUseCase;
import drako.cars.domain.usecase.ICustomerUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/auth")
public class AuthController {
    private final IAuthUseCase iAuthUseCase;

    private final ICustomerUseCase iCustomerUseCase;


    @PostMapping(path = "/register")
    public ResponseEntity<CustomerResponseDto> save(@RequestBody CustomerDto customerDtoNew) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(iCustomerUseCase.save(customerDtoNew));
    }

    @PostMapping(path = "/sign-in")
    public ResponseEntity<JwtResponseDto> signIn(@RequestBody AuthCustomerDto authCustomerDto) {
        return ResponseEntity.ok(iAuthUseCase.signIn(authCustomerDto));
    }

    @PostMapping(path = "/sign-out")
    public ResponseEntity<JwtResponseDto> signOut(@RequestHeader(name = HttpHeaders.AUTHORIZATION) String jwt) {
        return ResponseEntity.ok(iAuthUseCase.signOut(jwt));
    }
}
