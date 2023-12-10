package org.example.Service;

import org.example.Dto.Operation;
import org.example.Dto.Quantity;
import org.example.Dto.SocksDTO;
import org.example.Model.Socks;

public interface CountingSocksService {
    Socks incomeSocks(Socks socks);
    Socks outcomeSocks(Socks socks);
    Integer getSocks(SocksDTO socksDTO, Operation operation);
}
