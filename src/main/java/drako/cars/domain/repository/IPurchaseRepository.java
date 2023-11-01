package drako.cars.domain.repository;

import drako.cars.domain.dto.PurchaseBillResponseDto;
import drako.cars.domain.dto.PurchaseRequestDto;
import drako.cars.domain.dto.PurchaseResponseDto;

import java.util.List;

public interface IPurchaseRepository {
    List<PurchaseResponseDto> getAll();

    List<PurchaseResponseDto> getByIdCustomer(String idCustomer);

    PurchaseResponseDto getByNumberBill(Integer numberBill);

    PurchaseBillResponseDto save(PurchaseRequestDto purchaseRequestDto);
}
