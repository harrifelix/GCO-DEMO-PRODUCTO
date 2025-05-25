package com.gco.producto.infraestructura.controllador;

import com.gco.producto.aplicacion.comando.ComandoLibro;
import com.gco.producto.aplicacion.manejadores.libro.ManejadorCrearLibro;
import com.gco.producto.aplicacion.manejadores.libro.ManejadorObtenerLibro;
import com.gco.producto.dominio.Libro;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/libros")
public class ControladorLibro {
    private final ManejadorCrearLibro manejadorCrearLibro;
    private final ManejadorObtenerLibro manejadorObtenerLibro;

    public ControladorLibro(ManejadorCrearLibro manejadorCrearLibro, ManejadorObtenerLibro manejadorObtenerLibro) {
        this.manejadorCrearLibro = manejadorCrearLibro;
        this.manejadorObtenerLibro = manejadorObtenerLibro;
    }

    @PostMapping
    public void agregar(@RequestBody ComandoLibro comandoLibro) {
        this.manejadorCrearLibro.ejecutar(comandoLibro);
    }

    @GetMapping("/{isbn}")
    public Libro buscar(@PathVariable(name = "isbn") String isbn) {
        return this.manejadorObtenerLibro.ejecutar(isbn);
    }
}
