package net.guz.flowersmanagerapi.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import net.guz.flowersmanagerapi.dto.FloristDto;

public interface TerminalService {
    FloristDto getFloristName(Jws<Claims> claims);
}
