package drako.cars.domain.service;

import drako.cars.domain.dto.CarBrandDto;
import drako.cars.domain.repository.ICarBrandRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


/**
 * Service CarBrand
 */
@Service
@RequiredArgsConstructor
public class CarBrandService implements ICarBrandService {

    /**
     * Repository CarBrand
     */
    private final ICarBrandRepository iCarBrandRepository;


    /**
     * Return all CarBrand
     *
     * @return List of CarBrand
     */
    @Override
    public List<CarBrandDto> getAll() {
        return iCarBrandRepository.getAll();
    }

    /**
     * Return a CarBrand by id
     *
     * @param id
     * @return CarBrand
     */
    @Override
    public Optional<CarBrandDto> getCarBrand(Integer id) {
        return iCarBrandRepository.getCarBrand(id);
    }

    /**
     * Save a CarBrand
     *
     * @param newCarBrand CarBrand to save
     * @return CarBrand created
     */
    @Override
    public CarBrandDto save(CarBrandDto newCarBrand) {
        return iCarBrandRepository.save(newCarBrand);
    }

    /**
     * Update a CarBrand
     *
     * @param updateCarBrand CarBrand to update
     * @return CarBrand updated if exists, return not found if not exists
     */
    @Override
    public Optional<CarBrandDto> update(CarBrandDto updateCarBrand) {
        if (iCarBrandRepository.getCarBrand(updateCarBrand.getId()).isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(iCarBrandRepository.save(updateCarBrand));
    }

    /**
     * Delete a CarBrand by id
     *
     * @param idCarBrand CarBrand to delete
     * @return true if successfully or false if fail
     */
    @Override
    public boolean delete(Integer idCarBrand) {
        if (iCarBrandRepository.getCarBrand(idCarBrand).isEmpty()) {
            return false;
        }
        iCarBrandRepository.delete(idCarBrand);
        return true;
    }
}
