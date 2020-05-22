package net.guz.flowersmanagerapi.controller.terminal;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.swagger.annotations.Api;
import net.guz.flowersmanagerapi.dto.*;
import net.guz.flowersmanagerapi.entity.Order;
import net.guz.flowersmanagerapi.security.awt.exception.JwtValidationException;
import net.guz.flowersmanagerapi.service.AuthTerminalService;
import net.guz.flowersmanagerapi.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.Comparator;
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
    public ResponseEntity<List<OrderDto>> getOrders(HttpServletRequest request) throws JwtValidationException {
        Jws<Claims> claims = authTerminalService.authorization(request.getHeader(authHeaderName));

        return ResponseEntity.ok(orderService.getOrdersByFloristAndTerminalByIdAsc(claims));
    }

    @GetMapping("/getOrderById")
    public ResponseEntity<List<OrderDto>> findById(@RequestParam("value") Long id, HttpServletRequest request) throws JwtValidationException{
        Jws<Claims> claims = authTerminalService.authorization(request.getHeader(authHeaderName));

        return ResponseEntity.ok(orderService.getOrderById(claims, id));
    }

    @GetMapping("/findByDate")
    public ResponseEntity<List<OrderDto>> findByDate(@RequestParam("value") String date, HttpServletRequest request) throws JwtValidationException{
        Jws<Claims> claims = authTerminalService.authorization(request.getHeader(authHeaderName));

        return ResponseEntity.ok(orderService.getOrdersByDate(claims, date));
    }

    @GetMapping("/findByTime")
    public ResponseEntity<List<OrderDto>> findByTime(@RequestParam("value") String time, HttpServletRequest request) throws JwtValidationException{
        Jws<Claims> claims = authTerminalService.authorization(request.getHeader(authHeaderName));

        return ResponseEntity.ok(orderService.getOrdersByTime(claims, time));
    }

    @GetMapping("/findByCustomer")
    public ResponseEntity<List<OrderDto>> findByCustomer(@RequestParam("value") String customer, HttpServletRequest request) throws JwtValidationException{
        Jws<Claims> claims = authTerminalService.authorization(request.getHeader(authHeaderName));

        return ResponseEntity.ok(orderService.getOrdersByCustomer(claims, customer));
    }

    @GetMapping("/findByPrice")
    public ResponseEntity<List<OrderDto>> findByPrice(@RequestParam("value") String price, HttpServletRequest request) throws JwtValidationException{
        Jws<Claims> claims = authTerminalService.authorization(request.getHeader(authHeaderName));

        return ResponseEntity.ok(orderService.getOrdersByPrice(claims, price));
    }

    @GetMapping("/sortByPriceDesc")
    public ResponseEntity<List<OrderDto>> sortByPriceDesc(HttpServletRequest request) throws JwtValidationException{
        Jws<Claims> claims = authTerminalService.authorization(request.getHeader(authHeaderName));

        List<Order> orders = orderService.getOrdersByFloristAndTerminal(claims);
        Collections.sort(orders, Comparator.comparing(Order::getPrice));

        return ResponseEntity.ok(OrderDto.from(orders));
    }

    @GetMapping("/sortByPriceAsc")
    public ResponseEntity<List<OrderDto>> sortByPriceAsc(HttpServletRequest request) throws JwtValidationException{
        Jws<Claims> claims = authTerminalService.authorization(request.getHeader(authHeaderName));

        List<Order> orders = orderService.getOrdersByFloristAndTerminal(claims);
        Collections.sort(orders, Comparator.comparing(Order::getPrice).reversed());

        return ResponseEntity.ok(OrderDto.from(orders));
    }

    @GetMapping("/sortByDateAndTimeAsc")
    public ResponseEntity<List<OrderDto>> sortByDateAndTimeAsc(HttpServletRequest request) throws JwtValidationException{
        Jws<Claims> claims = authTerminalService.authorization(request.getHeader(authHeaderName));

        List<Order> orders = orderService.getOrdersByFloristAndTerminal(claims);
        Collections.sort(orders, Comparator.comparing(Order::getDate).reversed().thenComparing(Order::getTime).reversed());

        return ResponseEntity.ok(OrderDto.from(orders));
    }

    @GetMapping("/sortByDateAndTimeDesc")
    public ResponseEntity<List<OrderDto>> sortByDateAndTimeDesc(HttpServletRequest request) throws JwtValidationException{
        Jws<Claims> claims = authTerminalService.authorization(request.getHeader(authHeaderName));

        List<Order> orders = orderService.getOrdersByFloristAndTerminal(claims);
        Collections.sort(orders, Comparator.comparing(Order::getDate).thenComparing(Order::getTime));

        return ResponseEntity.ok(OrderDto.from(orders));
    }

    @GetMapping("/getSorts")
    public ResponseEntity<List<SortDto>> getSorts(){
         return ResponseEntity.ok(orderService.getSorts());
    }

    @GetMapping("/getSearches")
    public ResponseEntity<List<SearchDto>> getSearches(){
        return ResponseEntity.ok(orderService.getSearches());
    }

    @GetMapping("/getCategories")
    public ResponseEntity<List<CategoryDto>> getCategories(HttpServletRequest request) throws JwtValidationException{
        Jws<Claims> claims = authTerminalService.authorization(request.getHeader(authHeaderName));

        return ResponseEntity.ok(orderService.getCategories(claims));
    }

    @GetMapping("/getProducts")
    public ResponseEntity<List<ProductDto>> getProducts(@RequestParam("value") Long categoryId, HttpServletRequest request) throws JwtValidationException{
        Jws<Claims> claims = authTerminalService.authorization(request.getHeader(authHeaderName));

        return ResponseEntity.ok(orderService.getProducts(claims, categoryId));
    }
}
