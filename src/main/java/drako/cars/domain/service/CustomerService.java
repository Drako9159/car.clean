package drako.cars.domain.service;

import drako.cars.domain.dto.CustomerDto;
import drako.cars.domain.repository.ICustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.List;
import java.util.Optional;

/**
 * Service Customer
 */
@Service
@RequiredArgsConstructor
public class CustomerService implements ICustomerService {

    private final ICustomerRepository iCustomerRepository;

    @Override
    public List<CustomerDto> getAll() {
        return iCustomerRepository.getAll();
    }

    @Override
    public Optional<CustomerDto> getCustomerByCardId(String cardId) {
        return iCustomerRepository.getCustomerByCardId(cardId);
    }

    @Override
    public Optional<CustomerDto> getCustomerByEmail(String email) {
        return iCustomerRepository.getCustomerByEmail(email);
    }

    @Override
    public CustomerDto save(CustomerDto customerDto) {
        customerDto.setPassword(generateRandomPassword(12));
        return iCustomerRepository.save(customerDto);
    }

    @Override
    public Optional<CustomerDto> update(CustomerDto customerDto) {
        if (iCustomerRepository.getCustomerByCardId(customerDto.getCardId()).isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(iCustomerRepository.save(customerDto));
    }

    @Override
    public boolean delete(String cardId) {
        if (iCustomerRepository.getCustomerByCardId(cardId).isEmpty()) {
            return false;
        }
        iCustomerRepository.delete(cardId);
        return true;
    }

    private String generateRandomPassword(int len) {
        final String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~";
        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            int randomIndex = random.nextInt(chars.length());
            sb.append(chars.charAt(randomIndex));
        }
        return sb.toString();
    }
}
