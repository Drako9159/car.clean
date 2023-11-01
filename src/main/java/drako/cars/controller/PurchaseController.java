package drako.cars.controller;

import drako.cars.domain.dto.PurchaseBillResponseDto;
import drako.cars.domain.dto.PurchaseRequestDto;
import drako.cars.domain.dto.PurchaseResponseDto;
import drako.cars.domain.usecase.IPurchaseUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/purchases")
public class PurchaseController {
    private final IPurchaseUseCase iPurchaseUseCase;

    @GetMapping()
    public ResponseEntity<List<PurchaseResponseDto>> getAll() {
        return ResponseEntity.ok(iPurchaseUseCase.getAll());
    }

    @GetMapping(path = "/customers/{cardId}")
    public ResponseEntity<List<PurchaseResponseDto>> getPurchasesByIdCustomer(@PathVariable String cardId) {
        return ResponseEntity.ok(iPurchaseUseCase.getByIdCustomer(cardId));
    }

    @GetMapping(path = "/{numberBill}")
    public ResponseEntity<PurchaseResponseDto> getPurchasesByNumberBill(@PathVariable Integer numberBill) {
        return ResponseEntity.ok(iPurchaseUseCase.getByNumberBill(numberBill));
    }

    @PostMapping()
    public ResponseEntity<PurchaseBillResponseDto> savePurchase(@RequestBody PurchaseRequestDto purchaseRequestDto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(iPurchaseUseCase.save(purchaseRequestDto));
    }

}
