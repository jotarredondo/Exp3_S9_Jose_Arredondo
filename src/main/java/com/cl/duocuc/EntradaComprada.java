package com.cl.duocuc;

public class EntradaComprada {

    private int iDCompra;
    private String codigoLista;
    private String ubicacionReservada;
    private int descuento;
    private int precioFinal;
    private String tipoEntrada;
    private String descuentoAplicado;
    private boolean comprada;


    public EntradaComprada() {
    }

    public String getTipoEntrada() {
        return tipoEntrada;
    }

    public String getDescuentoAplicado() {
        return descuentoAplicado;
    }

    public void setDescuentoAplicado(String descuentoAplicado) {
        this.descuentoAplicado = descuentoAplicado;
    }

    public void setTipoEntrada(String tipoEntrada) {
        this.tipoEntrada = tipoEntrada;
    }

    public int getDescuento() {
        return descuento;
    }

    public void setDescuento(int descuento) {
        this.descuento = descuento;
    }

    public int getPrecioFinal() {
        return precioFinal;
    }

    public void setPrecioFinal(int precioFinal) {
        this.precioFinal = precioFinal;
    }

    public String getCodigoLista() {
        return codigoLista;
    }

    public void setCodigoLista(String codigoLista) {
        this.codigoLista = codigoLista;
    }

    public String getUbicacionReservada() {
        return ubicacionReservada;
    }

    public void setUbicacionReservada(String ubicacionReservada) {
        this.ubicacionReservada = ubicacionReservada;
    }

    public boolean isComprada() {
        return comprada;
    }

    public void setComprada(boolean comprada) {
        this.comprada = comprada;
    }

    public int getiDCompra() {
        return iDCompra;
    }

    public void setiDCompra(int iDCompra) {
        this.iDCompra = iDCompra;
    }
}
