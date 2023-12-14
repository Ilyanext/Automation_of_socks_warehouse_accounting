package org.example.Mapper;

import org.example.Dto.SocksDTO;
import org.example.Model.Socks;

public class SocksMapper {
    public static SocksDTO toSocksDTO(Socks socks) {
        SocksDTO socksDTO = new SocksDTO();
        socksDTO.setColor(socks.getColor());
        socksDTO.setCottonPart(socks.getCottonPart());
        return socksDTO;
    }

    public static Socks toSocks(SocksDTO socksDTO) {
        Socks socks = new Socks();
        socks.setColor(socksDTO.getColor());
        socks.setCottonPart(socksDTO.getCottonPart());
        return socks;
    }



}
