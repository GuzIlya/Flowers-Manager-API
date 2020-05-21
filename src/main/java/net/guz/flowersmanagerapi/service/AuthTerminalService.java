package net.guz.flowersmanagerapi.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import net.guz.flowersmanagerapi.dto.TerminalLoginDto;
import net.guz.flowersmanagerapi.dto.TerminalTokenDto;
import net.guz.flowersmanagerapi.form.terminal.LoginForm;
import net.guz.flowersmanagerapi.form.terminal.TerminalForm;
import net.guz.flowersmanagerapi.security.awt.exception.JwtValidationException;

public interface AuthTerminalService {
    TerminalTokenDto authentication(LoginForm loginForm);
    TerminalLoginDto preAuthentication(TerminalForm terminalForm);
    Jws<Claims> authorization(String bearerToken) throws JwtValidationException;
}
