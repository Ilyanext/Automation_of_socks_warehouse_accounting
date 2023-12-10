package org.example.Service.impl;

import org.example.Dto.Operation;
import org.example.Dto.Quantity;
import org.example.Dto.SocksDTO;
import org.example.Mapper.SocksMapper;
import org.example.Model.Socks;
import org.example.Repository.SocksRepository;
import org.example.Service.CountingSocksService;
import org.springframework.stereotype.Service;

@Service
public class CountingSocksServiceImpl implements CountingSocksService {
    private final SocksRepository socksRepository;

    public CountingSocksServiceImpl(SocksRepository socksRepository) {
        this.socksRepository = socksRepository;
    }

    @Override
    public Socks incomeSocks(Socks socks) {
        socksRepository.save(socks);
        return socks;
    }

    @Override
    public Socks outcomeSocks(Socks socks) {
        Socks socks1 = socksRepository.findSocksByColor("red");
        socks1.setQuantity(socks1.getQuantity() - 1);

//        Socks socks1 = (Socks) socksRepository.findAll();
//        if(socks1.getColor() == socks.getColor() && socks1.getCottonPart() == socks.getCottonPart()){
//            socks.setQuantity(socks1.getQuantity() - socks.getQuantity());
//        }
        socksRepository.save(socks1);
        return socks1;
    }

    @Override
    public Integer getSocks(SocksDTO socksDTO, Operation operation) {

        if (operation == Operation.moreThen) {
            return socksRepository.getCountWhenCottonPartMoreThen(socksDTO.getColor(), socksDTO.getCottonPart());
        } else if (operation == Operation.lessThen) {
            return socksRepository.getCountWhenCottonPartLessThen(socksDTO.getColor(), socksDTO.getCottonPart());
        } else if (operation == Operation.equal) {
            return socksRepository.getCountWhenCottonPartEqual(socksDTO.getColor(), socksDTO.getCottonPart());
        }
        return null;
    }
}
