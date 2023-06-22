package sg.edu.nus.iss.day23workshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import sg.edu.nus.iss.day23workshop.model.FullOrder;
import sg.edu.nus.iss.day23workshop.repo.FullOrderRepo;

@RestController
@RequestMapping("/order")
public class FullOrderRestController {

    @Autowired
    FullOrderRepo repository;

    @GetMapping(path = "/total")
    public ResponseEntity<?> returnFullOrderList(@RequestParam("orderID") int orderID) {
        List<FullOrder> fullOrdersList = repository.findAll(orderID);

        if (fullOrdersList.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\": \"" + "No orders found with ID: " + orderID + "\"}");
        }

        return new ResponseEntity<>(fullOrdersList, HttpStatus.OK);
    }

}
