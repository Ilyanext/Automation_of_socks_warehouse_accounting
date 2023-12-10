package org.example.Controller;

import lombok.RequiredArgsConstructor;
import org.example.Dto.Operation;
import org.example.Dto.Quantity;
import org.example.Dto.SocksDTO;
import org.example.Model.Socks;
import org.example.Service.impl.CountingSocksServiceImpl;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/socks")
@RequiredArgsConstructor
public class SocksController {
    private final CountingSocksServiceImpl socksService;

    @GetMapping()
    public int getCountSocks(@Param("socks") SocksDTO socksDTO, @Param("operation") Operation operation) {
        return socksService.getSocks(socksDTO, operation);
    }

    @PostMapping("/income")
    public Socks numberOfSocksIncome(@RequestBody Socks socks) {
        return socksService.incomeSocks(socks);
    }

    @PostMapping("/outcome")
    public Socks numberOfSocksOutcome(@RequestBody Socks socks) {
        return socksService.outcomeSocks(socks);
    }

}
