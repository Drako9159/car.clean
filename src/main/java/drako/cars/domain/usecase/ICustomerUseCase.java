package drako.cars.domain.usecase;

import drako.cars.domain.dto.CustomerDto;
import drako.cars.domain.dto.CustomerResponseDto;

import java.util.List;
import java.util.Optional;

/**
 * Interface for Customer service
 */
public interface ICustomerUseCase {

    /**
     * @return List of customer
     */
    List<CustomerDto> getAll();

    /**
     * Return a Customer by id
     *
     * @param cardId
     * @return Optional Customer found
     */
    Optional<CustomerDto> getCustomerByCardId(String cardId);

    /**
     * Return a Customer by email
     *
     * @param email
     * @return Optional Customer found
     */
    Optional<CustomerDto> getCustomerByEmail(String email);

    /**
     * Save new Customer
     *
     * @param customerDto Customer to save
     * @return Customer
     */
    CustomerResponseDto save(CustomerDto customerDto);

    /**
     * Update a Customer
     *
     * @param customerDto CarBrand to delete
     * @return CarBrand updated
     */
    Optional<CustomerDto> update(CustomerDto customerDto);

    /**
     * Delete a Customer by id
     *
     * @param cardId Customer to delete
     */
    boolean delete(String cardId);

}
