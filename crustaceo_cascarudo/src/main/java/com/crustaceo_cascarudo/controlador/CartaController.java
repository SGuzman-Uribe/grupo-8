package com.crustaceo_cascarudo.controlador;
import java.util.List;
import com.crustaceo_cascarudo.modelo.Carta;
import com.crustaceo_cascarudo.servicio.CartaService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/carta")

public class CartaController {
    private CartaService service;
    // Constructor
    public CartaController(){ 
        service = new CartaService();
    }

    @GetMapping
    public List<Carta> getPlatos(){
        return service.getPlatos();
    }

    @GetMapping("/{categoria}")
    public List<Carta> getXCategoria(@PathVariable(name = "categoria") String categoria){
        return service.getXCategoria(categoria);
    }

    @PostMapping    
    public String create(@RequestBody Carta plato){
        return service.create(plato);
    }  

}
