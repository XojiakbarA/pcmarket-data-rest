package uz.pdp.pcmarketdatarest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import uz.pdp.pcmarketdatarest.Response;
import uz.pdp.pcmarketdatarest.dto.OrderDTO;
import uz.pdp.pcmarketdatarest.entity.Order;
import uz.pdp.pcmarketdatarest.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity<Response> create(@Valid @RequestBody OrderDTO dto) {
        Order order = orderService.create(dto);

        Response response = new Response(HttpStatus.CREATED.name(), order);

        return new ResponseEntity<Response>(response, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Response> update(@Valid @RequestBody OrderDTO dto, @PathVariable Long id) {
        Order order = orderService.update(dto, id);

        Response response = new Response(HttpStatus.OK.name(), order);

        return new ResponseEntity<Response>(response, HttpStatus.OK);
    }

    @PutMapping("/{id}/cancel")
    public ResponseEntity<Response> cancel(@PathVariable Long id) {
        orderService.cancel(id);

        Response response = new Response(HttpStatus.ACCEPTED.name());

        return new ResponseEntity<Response>(response, HttpStatus.ACCEPTED);
    }

    @PutMapping("/{id}/delivered")
    public ResponseEntity<Response> delivered(@PathVariable Long id) {
        orderService.delivered(id);

        Response response = new Response(HttpStatus.ACCEPTED.name());

        return new ResponseEntity<Response>(response, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response> delete(@PathVariable Long id) {
        orderService.deleteById(id);

        Response response = new Response(HttpStatus.ACCEPTED.name());

        return new ResponseEntity<Response>(response, HttpStatus.ACCEPTED);
    }
}
