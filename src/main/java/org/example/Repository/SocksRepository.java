package org.example.Repository;

import org.example.Dto.Operation;
import org.example.Dto.SocksDTO;
import org.example.Model.Socks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SocksRepository extends JpaRepository<Socks, Integer> {

   Optional<Socks> findByColorAndCottonPart(String color, int cottonPart);

    @Query(value = "select sum (quantity) from socks \n" +
            "where color= :color and cotton_part = :cotton_part", nativeQuery = true)
    int getCountWhenCottonPartEqual(@Param("color") String color, @Param("cotton_part") int cottonPart);

    @Query(value = "select sum (quantity) from socks \n" +
            "where color= :color and cotton_part > :cotton_part", nativeQuery = true)
    int getCountWhenCottonPartMoreThen(@Param("color") String color, @Param("cotton_part") int cottonPart);

    @Query(value = "select sum (quantity) from socks \n" +
            "where color= :color and cotton_part < :cotton_part", nativeQuery = true)
    int getCountWhenCottonPartLessThen(@Param("color") String color, @Param("cotton_part") int cottonPart);

}
