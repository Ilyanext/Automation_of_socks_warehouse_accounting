package org.example.Model;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;


@Entity
@Data
@NoArgsConstructor
@Table(name = "socks")
public class Socks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "color")
    private String color;
    @Column(name = "cotton_Part")
    private int cottonPart;
    @Column(name = "quantity")
    private int quantity;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Socks socks = (Socks) o;
        return id == socks.id && cottonPart == socks.cottonPart && quantity == socks.quantity && Objects.equals(color, socks.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, color, cottonPart, quantity);
    }
}
