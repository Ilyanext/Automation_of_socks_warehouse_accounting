package org.example.Service;

import org.example.Dto.Operation;
import org.example.Dto.SocksDTO;
import org.example.Model.Socks;

public interface CountingSocksService {
    void incomeSocks(Socks socks);
    void outcomeSocks(Socks socks);
    Integer getSocks(SocksDTO socksDTO, Operation operation);
}
