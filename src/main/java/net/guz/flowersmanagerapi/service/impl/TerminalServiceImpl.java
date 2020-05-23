package net.guz.flowersmanagerapi.service.impl;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import net.guz.flowersmanagerapi.dto.FloristDto;
import net.guz.flowersmanagerapi.entity.Florist;
import net.guz.flowersmanagerapi.entity.Terminal;
import net.guz.flowersmanagerapi.repository.FloristRepository;
import net.guz.flowersmanagerapi.repository.TerminalRepository;
import net.guz.flowersmanagerapi.service.TerminalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TerminalServiceImpl implements TerminalService {

    @Autowired
    private TerminalRepository terminalRepository;

    @Autowired
    private FloristRepository floristRepository;


    @Override
    public FloristDto getFloristName(Jws<Claims> claims) {
        Optional<Florist> florist =  floristRepository.findById(Long.parseLong(claims.getBody().get("florist_id").toString()));

        return new FloristDto(florist.get().getName());
    }
}
