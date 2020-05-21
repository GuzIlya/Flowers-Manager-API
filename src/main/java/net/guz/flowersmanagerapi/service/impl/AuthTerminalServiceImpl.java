package net.guz.flowersmanagerapi.service.impl;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import net.guz.flowersmanagerapi.dto.TerminalLoginDto;
import net.guz.flowersmanagerapi.dto.TerminalTokenDto;
import net.guz.flowersmanagerapi.entity.Florist;
import net.guz.flowersmanagerapi.entity.Terminal;
import net.guz.flowersmanagerapi.form.terminal.LoginForm;
import net.guz.flowersmanagerapi.form.terminal.TerminalForm;
import net.guz.flowersmanagerapi.repository.FloristRepository;
import net.guz.flowersmanagerapi.repository.TerminalRepository;
import net.guz.flowersmanagerapi.security.awt.JwtTerminalTokenProvider;
import net.guz.flowersmanagerapi.security.awt.exception.JwtValidationException;
import net.guz.flowersmanagerapi.service.AuthTerminalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthTerminalServiceImpl implements AuthTerminalService {

    @Autowired
    private FloristRepository floristRepository;

    @Autowired
    private TerminalRepository terminalRepository;

    @Autowired
    private JwtTerminalTokenProvider jwtTerminalTokenProvider;

    @Override
    public TerminalTokenDto authentication(LoginForm loginForm) {
        // нужно позже допилить проверку на соответвие флориста магазину!
        Optional<Terminal> terminalCandidate = terminalRepository.findOneByLogin(loginForm.getTerminalLogin());
        Optional<Florist> floristCandidate = floristRepository.findOneByPassword(loginForm.getFloristPassword());

        if (terminalCandidate.isPresent() && floristCandidate.isPresent()) {
            Terminal terminal = terminalCandidate.get();
            Florist florist = floristCandidate.get();

            if ((terminal.getPassword().equals(loginForm.getTerminalPassword()))) {
                String token = jwtTerminalTokenProvider.createToken(florist, terminal);
                return TerminalTokenDto.from(token);
            }
        } throw new IllegalArgumentException("Terminal or Florist not found");
    }

    @Override
    public TerminalLoginDto preAuthentication(TerminalForm terminalForm) {
        Optional<Terminal> terminalCandidate = terminalRepository.findOneByLogin(terminalForm.getLogin());

        if (terminalCandidate.isPresent()) {
            Terminal terminal = terminalCandidate.get();
            return new TerminalLoginDto(terminal.getLogin(), terminal.getPassword());
        } throw new IllegalArgumentException("Terminal not found");
    }

    @Override
    public Jws<Claims> authorization(String bearerToken) throws JwtValidationException {
        String token = jwtTerminalTokenProvider.resolveToken(bearerToken);

        jwtTerminalTokenProvider.validateToken(token);

        Jws<Claims> claims = jwtTerminalTokenProvider.getClaims(token);
        return claims;
    }
}
