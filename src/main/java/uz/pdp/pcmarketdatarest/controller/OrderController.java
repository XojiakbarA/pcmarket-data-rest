package uz.pdp.pcmarketdatarest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import uz.pdp.pcmarketdatarest.Response;
import uz.pdp.pcmarketdatarest.dto.request.OrderDTO;
import uz.pdp.pcmarketdatarest.dto.view.OrderViewDTO;
import uz.pdp.pcmarketdatarest.entity.Order;
import uz.pdp.pcmarketdatarest.marker.OnCreate;
import uz.pdp.pcmarketdatarest.service.OrderService;

import java.util.List;

@Validated
@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping
    public ResponseEntity<Response> getAll() {
        List<OrderViewDTO> orders = orderService.findAll();

        Response response = new Response(HttpStatus.OK.name(), orders);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Validated(OnCreate.class)
    @PostMapping
    public ResponseEntity<Response> create(@Valid @RequestBody OrderDTO dto) {
        OrderViewDTO order = orderService.create(dto);

        Response response = new Response(HttpStatus.CREATED.name(), order);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Response> update(@Valid @RequestBody OrderDTO dto, @PathVariable Long id) {
        OrderViewDTO order = orderService.update(dto, id);

        Response response = new Response(HttpStatus.OK.name(), order);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/{id}/cancel")
    public ResponseEntity<Response> cancel(@PathVariable Long id) {
        orderService.cancel(id);

        Response response = new Response(HttpStatus.ACCEPTED.name());

        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

    @PutMapping("/{id}/delivered")
    public ResponseEntity<Response> delivered(@PathVariable Long id) {
        orderService.delivered(id);

        Response response = new Response(HttpStatus.ACCEPTED.name());

        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response> delete(@PathVariable Long id) {
        orderService.deleteById(id);

        Response response = new Response(HttpStatus.ACCEPTED.name());

        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }
}
