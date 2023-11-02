package drako.cars.domain.usecase;

import drako.cars.domain.dto.AuthCustomerDto;
import drako.cars.domain.dto.JwtResponseDto;

public interface IAuthUseCase {
    JwtResponseDto signIn(AuthCustomerDto authCustomerDto);

    JwtResponseDto signOut(String jwt);
}
