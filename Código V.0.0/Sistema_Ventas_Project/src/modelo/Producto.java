package modelo;

import java.util.Date;

/**
 *
 * @author Jairo Smith Bonilla Hidalgo
 */
public class Producto {

    private String id;
    private String nombre;
    private int cantidad;
    private double precio;
    private Date fecha_caducidad;
    private int iva;
    private Categoria categoria;
    private String porcentajeDescuento;
    private double descuento;
    private String nombreCat;
    private double totalCancelarProducto;

    public Producto(String id, String nombre, int cantidad, double precio, Date fecha_caducidad, int iva, Categoria categoria) {
        this.id = id;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
        this.fecha_caducidad = fecha_caducidad;
        this.iva = iva;
        this.categoria = categoria;
    }

    public Producto(String nombre, int cantidad, double precio, Date fecha_caducidad, int iva, Categoria categoria) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
        this.fecha_caducidad = fecha_caducidad;
        this.iva = iva;
        this.categoria = categoria;
    }

    public Producto(String id, String nombre, int cantidad, double precio, Date fecha_caducidad, int iva, Categoria categoria, double descuento) {
        this.id = id;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
        this.fecha_caducidad = fecha_caducidad;
        this.iva = iva;
        this.categoria = categoria;
        this.descuento = descuento;
    }

    public Producto(String nombre, int cantidad, double precio, Date fecha_caducidad, int iva, String nombreCat) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
        this.fecha_caducidad = fecha_caducidad;
        this.iva = iva;
        this.nombreCat = nombreCat;
    }

    public Date getFecha_caducidad() {
        return fecha_caducidad;
    }

    public void setFecha_caducidad(Date fecha_caducidad) {
        this.fecha_caducidad = fecha_caducidad;
    }

    public String getPorcentajeDescuento() {
        return porcentajeDescuento;
    }

    public void setPorcentajeDescuento(String porcentajeDescuento) {
        this.porcentajeDescuento = porcentajeDescuento;
    }
    

    public double getTotalCancelarProducto() {
        return totalCancelarProducto;
    }

    public void setTotalCancelarProducto(double totalCancelarProducto) {
        this.totalCancelarProducto = totalCancelarProducto;
    }

    public String getNombreCat() {
        return nombreCat;
    }

    public void setNombreCat(String nombreCat) {
        this.nombreCat = nombreCat;
    }

    public Producto() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Date getFechaCaducidad() {
        return fecha_caducidad;
    }

    public void setFechaCaducidad(Date fecha_caducidad) {
        this.fecha_caducidad = fecha_caducidad;
    }

    public int getIva() {
        return iva;
    }

    public void setIva(int iva) {
        this.iva = iva;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    @Override
    public String toString() {
        return "Producto{" + "id=" + id + ", nombre=" + nombre + ", cantidad=" + cantidad + ", precio=" + precio + ", fecha_caducidad=" + fecha_caducidad + ", iva=" + iva + ", categoria=" + categoria + ", descuento=" + descuento + ", nombreCat=" + nombreCat + ", totalCancelarProducto=" + totalCancelarProducto + '}';
    }

}
