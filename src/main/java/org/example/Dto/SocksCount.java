package org.example.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.example.Model.Socks;

import java.util.List;

@AllArgsConstructor
@Data
public class SocksCount {
    private int count;
    private List<Socks> results;

}
