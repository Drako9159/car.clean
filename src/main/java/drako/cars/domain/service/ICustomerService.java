package drako.cars.domain.service;

import drako.cars.domain.dto.CustomerDto;

import java.util.List;
import java.util.Optional;

/**
 * Interface for Customer service
 */
public interface ICustomerService {

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
    CustomerDto save(CustomerDto customerDto);

    /**
     * Delete a Customer by id
     *
     * @param cardId Customer to delete
     */
    void delete(String cardId);

}
