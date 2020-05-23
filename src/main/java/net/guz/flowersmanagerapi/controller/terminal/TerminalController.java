package net.guz.flowersmanagerapi.controller.terminal;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.swagger.annotations.Api;
import net.guz.flowersmanagerapi.dto.FloristDto;
import net.guz.flowersmanagerapi.security.awt.exception.JwtValidationException;
import net.guz.flowersmanagerapi.service.AuthTerminalService;
import net.guz.flowersmanagerapi.service.OrderService;
import net.guz.flowersmanagerapi.service.TerminalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/api/terminal/")
@Api(value = "Terminal", description = "Запросы для терминала")
public class TerminalController {
    @Value("${jwt.token.terminal.headername}")
    private String authHeaderName;

    @Autowired
    private AuthTerminalService authTerminalService;

    @Autowired
    private TerminalService terminalService;

    @GetMapping("/getFloristData")
    public ResponseEntity<FloristDto> getFloristData(HttpServletRequest request) throws JwtValidationException {
        Jws<Claims> claims = authTerminalService.authorization(request.getHeader(authHeaderName));

        return ResponseEntity.ok(terminalService.getFloristName(claims));
    }

}
