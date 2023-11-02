package drako.cars.domain.service;

import drako.cars.domain.dto.CustomerDto;
import drako.cars.domain.dto.CustomerResponseDto;
import drako.cars.domain.repository.ICustomerRepository;
import drako.cars.domain.usecase.ICustomerUseCase;
import drako.cars.exception.CustomerExistsException;
import drako.cars.exception.EmailValidationException;
import drako.cars.security.Roles;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.List;
import java.util.Optional;

/**
 * Service Customer
 */
@Service
@RequiredArgsConstructor
public class CustomerService implements ICustomerUseCase {

    private final ICustomerRepository iCustomerRepository;

    private final PasswordEncoder passwordEncoder;

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
    public CustomerResponseDto save(CustomerDto customerDto) {
        String regexEmail = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
                + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";

        if (!customerDto.getEmail().matches(regexEmail)) {
            throw new EmailValidationException();
        }

        if (getCustomerByCardId(customerDto.getCardId()).isPresent() || getCustomerByEmail(customerDto.getEmail()).isPresent()) {
            throw new CustomerExistsException();
        }

        String passwordGenerated = generateRandomPassword(12);
        customerDto.setPassword(passwordEncoder.encode(passwordGenerated));
        customerDto.setActive(1);
        customerDto.setRol(Roles.CUSTOMER);
        iCustomerRepository.save(customerDto);
        return new CustomerResponseDto(passwordGenerated);
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
