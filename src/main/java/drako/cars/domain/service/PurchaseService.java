package drako.cars.domain.service;

import drako.cars.domain.dto.CarDto;
import drako.cars.domain.dto.PurchaseBillResponseDto;
import drako.cars.domain.dto.PurchaseRequestDto;
import drako.cars.domain.dto.PurchaseResponseDto;
import drako.cars.domain.repository.ICarRepository;
import drako.cars.domain.repository.IPurchaseRepository;
import drako.cars.domain.usecase.IPurchaseUseCase;
import drako.cars.exception.PurchaseNotExistException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PurchaseService implements IPurchaseUseCase {
    private final IPurchaseRepository iPurchaseRepository;

    private final ICarRepository iCarRepository;

    @Override
    public List<PurchaseResponseDto> getAll() {
        return iPurchaseRepository.getAll();
    }

    @Override
    public List<PurchaseResponseDto> getByIdCustomer(String idCustomer) {
        return iPurchaseRepository.getByIdCustomer(idCustomer);
    }

    @Override
    public PurchaseResponseDto getByNumberBill(Integer numberBill) {
        PurchaseResponseDto purchaseResponseDto = iPurchaseRepository.getByNumberBill(numberBill);
        if (purchaseResponseDto == null){
            throw new PurchaseNotExistException();
        }
        return purchaseResponseDto;
    }

    @Override
    public PurchaseBillResponseDto save(PurchaseRequestDto purchaseRequestDto) {
        PurchaseBillResponseDto billResponseDto = iPurchaseRepository.save(purchaseRequestDto);

        purchaseRequestDto.getCarsPurchase().forEach(carPurchase -> {
            CarDto carActual = iCarRepository.getCar(carPurchase.getCodeCar()).get();

            carActual.setStock(carActual.getStock() - carPurchase.getQuantity());

            iCarRepository.save(carActual);
        });

        return billResponseDto;
    }
}
