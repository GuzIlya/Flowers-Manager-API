package net.guz.flowersmanagerapi.controller.terminal.auth;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.guz.flowersmanagerapi.dto.TerminalLoginDto;
import net.guz.flowersmanagerapi.dto.TerminalTokenDto;
import net.guz.flowersmanagerapi.entity.Florist;
import net.guz.flowersmanagerapi.entity.Terminal;
import net.guz.flowersmanagerapi.form.terminal.LoginForm;
import net.guz.flowersmanagerapi.form.terminal.TerminalForm;
import net.guz.flowersmanagerapi.repository.FloristRepository;
import net.guz.flowersmanagerapi.repository.TerminalRepository;
import net.guz.flowersmanagerapi.security.awt.exception.JwtValidationException;
import net.guz.flowersmanagerapi.service.AuthTerminalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/terminal/auth")
@Api(value = "Terminal Auth", description = "Авторизация для терминала")
public class TerminalAuthController {

    @Value("${jwt.token.terminal.headername}")
    private String authHeaderName;

    @Autowired
    private AuthTerminalService authTerminalService;
    @Autowired
    private FloristRepository floristRepository;
    @Autowired
    private TerminalRepository terminalRepository;

    @ApiOperation(value = "Проверка токена авторизации")
    @GetMapping(value = "checkAccess")
    public ResponseEntity<Object> checkAccess(HttpServletRequest request) throws JwtValidationException {
        authTerminalService.authorization(request.getHeader(authHeaderName));
        return ResponseEntity.ok().build();
    }

    @ApiOperation(value = "Первая ступень аутентификации")
    @PostMapping(value = "preLogin")
    public ResponseEntity<TerminalLoginDto> preLogin(@RequestBody TerminalForm terminalForm) {
        TerminalLoginDto terminalLoginDtor = authTerminalService.preAuthentication(terminalForm);
        return ResponseEntity.ok(terminalLoginDtor);
    }

    @ApiOperation(value = "Вторая ступень аутентификации")
    @PostMapping(value = "login")
    public ResponseEntity<TerminalTokenDto> login(@RequestBody LoginForm loginForm) {
        TerminalTokenDto terminalTokenDto = authTerminalService.authentication(loginForm);
        return ResponseEntity.ok(terminalTokenDto);
    }

    @ApiOperation(value = "Тестовый запрос, для проверки правильности работы авторизации")
    @GetMapping(value = "test")
    public ResponseEntity<String> getShopsTest(HttpServletRequest request) throws JwtValidationException{
        Jws<Claims> claims = authTerminalService.authorization(request.getHeader(authHeaderName));
        Optional<Florist> floristCandidate = floristRepository.findById(Long.parseLong(claims.getBody().get("florist_id").toString()));
        Optional<Terminal> terminalCandidate = terminalRepository.findById(Long.parseLong(claims.getBody().get("terminal_id").toString()));

        return ResponseEntity.ok(floristCandidate.get().getName() + terminalCandidate.get().getLogin());
    }

}
