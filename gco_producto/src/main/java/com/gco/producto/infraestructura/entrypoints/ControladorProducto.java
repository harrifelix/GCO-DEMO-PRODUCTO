package com.gco.producto.infraestructura.entrypoints;

import com.gco.producto.aplicacion.manejadores.libro.ManejadorCrearProducto;
import org.springframework.web.bind.annotation.*;
import com.gco.producto.aplicacion.manejadores.libro.*;
import com.gco.producto.dominio.*;
import java.util.Date;
import java.util.List;
import com.gco.producto.aplicacion.comando.*;
import org.springframework.http.ResponseEntity;


@RestController
@RequestMapping("/producto")
public class ControladorProducto {
    private final ManejadorObtenerProductos
            manejadorObtenerProductosa;

    private final ManejadorCrearProducto manejadorCrearProducto;

    private final ManejadorEliminarProducto manejadorEliminarProducto;

    private final ManejadorActualizarProducto manejadorActualizarProducto;

    private final ManejadorObtenerProductoByCategoria manejadorObtenerByCategoriaProducto;


    private final ManejadorObtenerProductoByCodigo manejadorObtenerByCodigoProducto;


    private final ManejadorObtenerProductoByNombre manejadorObtenerByNombreProducto;

    public static final String FEHCA_CON_FORMATO = "dd-MM-yyyy";
    public static final String TIME_ZONE = "America/Bogota";

    public ControladorProducto(ManejadorObtenerProductos
                                       manejadorObtenerProductosa, ManejadorCrearProducto manejadorCrearProducto
            , ManejadorEliminarProducto manejadorEliminarProducto
            , ManejadorActualizarProducto manejadorActualizarProducto
            , ManejadorObtenerProductoByCategoria manejadorObtenerByCategoriaProducto
            , ManejadorObtenerProductoByCodigo manejadorObtenerByCodigoProducto
            , ManejadorObtenerProductoByNombre manejadorObtenerByNombreProducto) {
        this.manejadorCrearProducto = manejadorCrearProducto;
        this.manejadorObtenerProductosa = manejadorObtenerProductosa;
        this.manejadorEliminarProducto = manejadorEliminarProducto;
        this.manejadorActualizarProducto = manejadorActualizarProducto;
        this.manejadorObtenerByCategoriaProducto = manejadorObtenerByCategoriaProducto;
        this.manejadorObtenerByCodigoProducto = manejadorObtenerByCodigoProducto;
        this.manejadorObtenerByNombreProducto = manejadorObtenerByNombreProducto;
    }

    @GetMapping()
    public List<Producto> obtenerProductoPrestadoById() {
        return this.manejadorObtenerProductosa.ejecutar ();
    }

    @GetMapping("byNombre/{nombre}")
    public Producto getByNombre(@PathVariable(name = "nombre") String nombre) {
        return this.manejadorObtenerByNombreProducto.ejecutar(nombre);
    }

    @GetMapping("byCategoria/{categoria}")
    public Producto getByCategoria(@PathVariable(name = "categoria") String categoria) {
        return this.manejadorObtenerByCategoriaProducto.ejecutar(categoria);
    }

    @GetMapping("byCodigo/{codigo}")
    public Producto getByCodigo(@PathVariable(name = "codigo") String codigo) {
        return this.manejadorObtenerByCodigoProducto.ejecutar(codigo);
    }

    @DeleteMapping()
    public void Eliminar(@RequestBody ComandoProducto comandoProducto) {
        this.manejadorEliminarProducto.ejecutar(comandoProducto);
    }

    @PutMapping()
    public void actualizar(@RequestBody ComandoProducto comandoProducto) {
        this.manejadorActualizarProducto.ejecutar(comandoProducto);
    }

    @PostMapping
    public ResponseEntity agregar(@RequestBody ComandoProducto comandoProducto) {

        this.agregarProducto(comandoProducto.getId(), comandoProducto.getNombre(),
                comandoProducto.getDescripcion(),
                comandoProducto.getPrecio()
                , comandoProducto.getStock()
                , comandoProducto.getCategoria()
                , comandoProducto.getCodigo()
                , comandoProducto.getFechaCreacion());

        //Si todo va Ok  se retorna el body con su datos
        return ResponseEntity.ok(comandoProducto);
    }

    private void agregarProducto(int id, String nombre, String descripcion, double precio, int stock, String categoría, String codigo, Date fechaCreacion) {
        ComandoProducto comandoProducto = new ComandoProducto(id
                , nombre, descripcion, precio, stock, categoría, codigo, fechaCreacion);
        this.manejadorCrearProducto.ejecutar(comandoProducto);

       /* Producto producto=new Producto(id ,nombre,descripcion,precio,stock,categoría,codigo,fechaCreacion);

        agregarMovimiento(producto,0, TipoMovimientoEnum.ENTRADA
        ,descripcion , 1, fechaCreacion);*/
    }

   /* private void agregarMovimiento(Producto producto, int id, TipoMovimientoEnum tipo, String descripcion, int cantidad, Date fechaCreación) {
        ComandoMovimiento comandoMovimiento = new ComandoMovimiento(id,producto,tipo,cantidad,fechaCreación,descripcion);
        this.manejadorCrearMovimiento.ejecutar(comandoMovimiento);
    }}*/
}
