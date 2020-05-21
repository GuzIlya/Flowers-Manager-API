package net.guz.flowersmanagerapi.controller.terminal;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.swagger.annotations.Api;
import net.guz.flowersmanagerapi.entity.Order;
import net.guz.flowersmanagerapi.security.awt.exception.JwtValidationException;
import net.guz.flowersmanagerapi.service.AuthTerminalService;
import net.guz.flowersmanagerapi.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping(value = "/api/terminal/")
@Api(value = "Terminal", description = "Запросы для терминала")
public class OrderController {

    @Value("${jwt.token.terminal.headername}")
    private String authHeaderName;

    @Autowired
    private OrderService orderService;

    @Autowired
    private AuthTerminalService authTerminalService;

    @GetMapping("/getOrders")
    public ResponseEntity<List<Order>> getOrders(HttpServletRequest request) throws JwtValidationException {
        Jws<Claims> claims = authTerminalService.authorization(request.getHeader(authHeaderName));
        return ResponseEntity.ok(orderService.getOrders());
    }
}
