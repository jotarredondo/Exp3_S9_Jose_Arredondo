package com.cl.duocuc;

import static com.cl.duocuc.Constants.*;

public class Ubicacion {

    private int precioVip = 15000;
    private int precioPalco = 12000;
    private int precioPlateaBaja = 10000;
    private int precioPlateaAlta = 7000;
    private int precioGaleria = 5000;
    private String[] listaVip;
    private String[] listaPalco;
    private String[] listaPlateaBaja;
    private String[] listaPlateaAlta;
    private String[] listaGaleria;

    public Ubicacion() {
        this.listaVip = LISTA_ASIENTOS.clone();
        this.listaPalco = LISTA_ASIENTOS.clone();
        this.listaPlateaBaja = LISTA_ASIENTOS.clone();
        this.listaPlateaAlta = LISTA_ASIENTOS.clone();
        this.listaGaleria = LISTA_ASIENTOS.clone();
    }

    public String[] getListaVip() {
        return listaVip;
    }

    public void setListaVip(String[] listaVip) {
        this.listaVip = listaVip;
    }

    public String[] getListaPalco() {
        return listaPalco;
    }

    public void setListaPalco(String[] listaPalco) {
        this.listaPalco = listaPalco;
    }

    public String[] getListaPlateaBaja() {
        return listaPlateaBaja;
    }

    public void setListaPlateaBaja(String[] listaPlateaBaja) {
        this.listaPlateaBaja = listaPlateaBaja;
    }

    public String[] getListaPlateaAlta() {
        return listaPlateaAlta;
    }

    public void setListaPlateaAlta(String[] listaPlateaAlta) {
        this.listaPlateaAlta = listaPlateaAlta;
    }

    public String[] getListaGaleria() {
        return listaGaleria;
    }

    public void setListaGaleria(String[] listaGaleria) {
        this.listaGaleria = listaGaleria;
    }

    public int getPrecioVip() {
        return precioVip;
    }

    public void setPrecioVip(int precioVip) {
        this.precioVip = precioVip;
    }

    public int getPrecioPalco() {
        return precioPalco;
    }

    public void setPrecioPalco(int precioPalco) {
        this.precioPalco = precioPalco;
    }

    public int getPrecioPlateaBaja() {
        return precioPlateaBaja;
    }

    public void setPrecioPlateaBaja(int precioPlateaBaja) {
        this.precioPlateaBaja = precioPlateaBaja;
    }

    public int getPrecioGaleria() {
        return precioGaleria;
    }

    public void setPrecioGaleria(int precioGaleria) {
        this.precioGaleria = precioGaleria;
    }

    public int getPrecioPlateaAlta() {
        return precioPlateaAlta;
    }

    public void setPrecioPlateaAlta(int precioPlateaAlta) {
        this.precioPlateaAlta = precioPlateaAlta;
    }

    public static void mostrarUbicacion(String[] lista) {
        for (String item : lista) {
            System.out.print(" [" + item + "]");
        }
        System.out.println(SALTO_DE_LINEA);
    }

    public void mostrarTotalUbicaciones() {
        System.out.println(DISPONIBLES);
        System.out.println(EVENTO);
        System.out.println(SALTO_DE_LINEA);
        final int[] lista = {precioVip, precioPalco, precioPlateaBaja, precioPlateaAlta, precioGaleria};
        mostrarSector(lista);
        System.out.println(INGRESE_CODIGO);
    }

    private void mostrarSector(int[] lista) {
        for (int i = 0; i < lista.length; i++) {
            System.out.println("Código [" + (i + 1) + "]" + " - Entrada " + LISTA_NOMBRES[i] + ": $" + lista[i]);
        }
    }

    public void mostrarListaUbicaciones(int opcion) {
        String[][] listas = {listaVip, listaPalco, listaPlateaBaja, listaPlateaAlta, listaGaleria};
        if (opcion >= 1 && opcion <= listas.length) {
            System.out.println("Entradas " + LISTA_NOMBRES[opcion - 1] + " disponibles para: " + EVENTO);
            mostrarUbicacion(listas[opcion - 1]);
            System.out.println(INGRESE_ENTRADA);
        } else {
            System.out.println("Opción inválida.");
        }
    }

    public int obtenerPrecioPorCodigo(int codigo) {
        return switch (codigo) {
            case 1 -> precioVip;
            case 2 -> precioPalco;
            case 3 -> precioPlateaBaja;
            case 4 -> precioPlateaAlta;
            case 5 -> precioGaleria;
            default -> -1;
        };
    }

    public String[] obtenerListaPorCodigo(int codigo) {
        return switch (codigo) {
            case 1 -> listaVip;
            case 2 -> listaPalco;
            case 3 -> listaPlateaBaja;
            case 4 -> listaPlateaAlta;
            case 5 -> listaGaleria;
            default -> null;
        };
    }

    public EntradaComprada seleccionarEntrada(int entrada, int codigoUbicacion) {
        EntradaComprada entradaComprada = new EntradaComprada();
        String[] lista = obtenerListaPorCodigo(codigoUbicacion);

        if (lista == null) {
            System.out.println(UBICACION_INVALIDA);
            entradaComprada.setComprada(false);
            return entradaComprada;
        }

        if (entrada < 1 || entrada > lista.length) {
            System.out.println(FUERA_DE_RANGO);
            entradaComprada.setComprada(false);
            return entradaComprada;
        }

        if (!lista[entrada - 1].equals("X")) {
            lista[entrada - 1] = "X";
            System.out.println("Entrada " + entrada + " comprada");
            entradaComprada.setUbicacionReservada(String.valueOf(entrada));
            entradaComprada.setCodigoLista(String.valueOf(codigoUbicacion));
            entradaComprada.setComprada(true);
        } else {
            System.out.println(ENTRADA_NO_DISPONIBLE);
            entradaComprada.setComprada(false);
        }
        return entradaComprada;
    }

}
