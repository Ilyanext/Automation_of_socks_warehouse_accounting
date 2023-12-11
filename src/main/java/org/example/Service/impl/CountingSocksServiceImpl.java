package org.example.Service.impl;

import org.example.Dto.Operation;
import org.example.Dto.SocksDTO;
import org.example.Exception.*;
import org.example.Model.Socks;
import org.example.Repository.SocksRepository;
import org.example.Service.CountingSocksService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountingSocksServiceImpl implements CountingSocksService {
    private final SocksRepository socksRepository;

    public CountingSocksServiceImpl(SocksRepository socksRepository) {
        this.socksRepository = socksRepository;
    }

    @Override
    public void incomeSocks(Socks socks) {
        if (socks.getQuantity() < 0) {
            throw new ValidExceptionPlus();
        }
        socksRepository.save(socks);

    }

    @Override
    public void outcomeSocks(Socks socks) {
        if (socks.getQuantity() >= 0) {
            throw new ValidExceptionMinus();
        }
        socksRepository.save(socks);
    }


    @Override
    public Integer getSocks(SocksDTO socksDTO, Operation operation) {
            if (operation == Operation.moreThen) {
                return socksRepository.getCountWhenCottonPartMoreThen(socksDTO.getColor(), socksDTO.getCottonPart()).orElseThrow(NotFoundException::new);
            } else if (operation == Operation.lessThen) {
                return socksRepository.getCountWhenCottonPartLessThen(socksDTO.getColor(), socksDTO.getCottonPart()).orElseThrow(NotFoundException::new);
            } else if (operation == Operation.equal) {
                return socksRepository.getCountWhenCottonPartEqual(socksDTO.getColor(), socksDTO.getCottonPart()).orElseThrow(NotFoundException::new);
            }
            return null;
    }
}

