package com.cl.duocuc;


import java.util.List;

import static com.cl.duocuc.Constants.*;

public class Utils {

    public static void mostrarOpciones(String[] lista) {
        for (int i = 0; i < lista.length; i++) {
            System.out.println("- " + (i + 1) + ": " + lista[i]);
        }
        System.out.println(CONTINUAR);
    }

    public static void bienvenida() {
        System.out.println(BIENVENIDA);
        System.out.println(SALTO_DE_LINEA);
        System.out.println(MENU);
    }

    public static void despedida() {
        System.out.println(GRACIAS);
        System.out.println(HYPHEN_CLOSE);
    }

    public static boolean validaOpcion() {
        System.out.println(OPCION_INCORRECTA);
        System.out.println(SALTO_DE_LINEA);
        return true;
    }

    public static boolean deseaContinuar(String opcion) {
        return opcion.equals(SI);
    }

    public static void calcularDescuento(int entrada, Cliente cliente, EntradaComprada entradaComprada) {
        int descuento;
        String descuentoAplicado;
        int edad = cliente.getEdad();
        if (cliente.getGenero().equals("M")) {
            if (edad < 18) {
                descuento = (entrada * 10) / 100;
                descuentoAplicado = "10%";
            } else if (edad >= 60) {
                descuentoAplicado = "25%";
                descuento = (entrada * 25) / 100;
            } else {
                descuentoAplicado = "0%";
                descuento = 0;
            }
        } else {
            descuentoAplicado = "20%";
            descuento = (entrada * 20) / 100;
        }
        entradaComprada.setDescuento(descuento);
        entradaComprada.setDescuentoAplicado(descuentoAplicado);
        entradaComprada.setPrecioFinal(entrada - descuento);
    }

    public static boolean validaLista(List<EntradaComprada> lista) {
        return !lista.isEmpty();
    }

    public static void mostrarBoleta(EntradaComprada entrada) {
        System.out.println("* Boleta de compra *");
        System.out.println(HYPHEN_CLOSE);
        System.out.println("Codigo de pago : " + entrada.getiDCompra());
        System.out.println("Ubicacion Comprada : " + entrada.getTipoEntrada());
        System.out.println("Asiento : " + entrada.getUbicacionReservada());
        System.out.println("Precio Unitario Sin Descuento : $ " + (entrada.getPrecioFinal() + entrada.getDescuento()));
        System.out.println("Descuento : " + entrada.getDescuentoAplicado());
        System.out.println("Valor Descuento : " +  " - $ " + entrada.getDescuento());
        System.out.println("Valor Final : $ " + entrada.getPrecioFinal());
        System.out.println(HYPHEN_CLOSE);
        System.out.println(SALTO_DE_LINEA);
    }

    public static void mostrarEntradasID(List<EntradaComprada> lista) {
        for(EntradaComprada entrada: lista) {
            System.out.print(" [" + entrada.getiDCompra() + "]");
        }
        System.out.println(SALTO_DE_LINEA);
    }

    public static EntradaComprada seleccionarEntradaAnulada(int opcion , List<EntradaComprada> lista) {
        for(EntradaComprada entrada : lista) {
            if(entrada.getiDCompra() == opcion) {
                return entrada;
            }
        }
        return null;
    }

    public static void actualizarListaConEntrada(int entrada, String[] lista) {
        if (entrada >= 1 && entrada <= lista.length) {
            lista[entrada - 1] = String.valueOf(entrada);
        } else {
            System.out.println("Entrada fuera de rango.");
        }
    }

    public static void iniciarTimerCompra() {
        System.out.println("Realizando compra ...");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Se ha realizado la compra exitosamente");
        System.out.println(SALTO_DE_LINEA);
    }

    public static void iniciarTimerVolver() {
        System.out.println("Será dirigido al menu principal ...");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(SALTO_DE_LINEA);
    }
}
