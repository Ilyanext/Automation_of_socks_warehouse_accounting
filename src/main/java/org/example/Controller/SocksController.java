package org.example.Controller;

import org.example.Model.Socks;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/socks")
public class SocksController {
    @GetMapping()
    public String getCountSocks() {
        return ("Возвращает общее количество носков на складе, " +
                "соответствующих переданным в параметрах критериям запроса.");
    }
    @PostMapping("/income")
    public String numberOfSocksIncome(@RequestBody Socks socks){
        return "Регистрирует приход носков на склад.\n" +
                "\n" +
                "Параметры запроса передаются в " +
                "теле запроса в виде JSON-объекта";
    }
    @PostMapping("/outcome")
    public String numberOfSocksOutcome(@RequestBody Socks socks){
        return "Регистрирует отпуск носков со склада. Здесь параметры и " +
                "результаты аналогичные, но общее количество носков указанного" +
                " цвета и состава не увеличивается, а уменьшается.";
    }

}
