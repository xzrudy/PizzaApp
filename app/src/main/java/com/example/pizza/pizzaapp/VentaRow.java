package com.example.pizza.pizzaapp;

public class VentaRow {
    private String idVenta;
    private String idUSer;
    private String ingredientes;
    private String size;
    private String cantidad;
    private String direccion;
    private String tipoPago;
    private String total;
    private String fechaVenta;

    public VentaRow(String _idVenta, String _idUser, String _ingredientes, String _size, String _cantidad, String _direccion, String _tipoPago, String _total, String _fechaVenta) {
        idVenta = _idVenta;
        idUSer = _idUser;
        ingredientes = _ingredientes;
        size = _size;
        cantidad = _cantidad;
        direccion = _direccion;
        tipoPago = _tipoPago;
        total = _total;
        fechaVenta = _fechaVenta;
    }

    public String getIdVenta() {
        return idVenta;
    }

    public String getIdUSer() {
        return idUSer;
    }

    public String getIngredientes() {
        return ingredientes;
    }

    public String getSize() {
        return size;
    }

    public String getCantidad() {
        return cantidad;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTipoPago() {
        return tipoPago;
    }

    public String getTotal() {
        return total;
    }

    public String getFechaVenta() {
        return fechaVenta;
    }
}
