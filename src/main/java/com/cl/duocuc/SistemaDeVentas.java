package com.cl.duocuc;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.cl.duocuc.Constants.*;
import static com.cl.duocuc.Utils.*;

public class SistemaDeVentas {
    public static void main(String[] args) {

        // Inicializacion de variable scanner
        Scanner scanner = new Scanner(System.in);

        // Inicializacion Variables Clase Main
        boolean bienvenida = false;
        boolean generoValido;
        int opcionBienvenida, opcionUbicacion, opcionEntrada, edad, precioEntrada, opcionAnular;
        String opcionGenero, continua;
        Ubicacion ubicacion = new Ubicacion();
        List<EntradaComprada> listaCompradaFinal = new ArrayList<>();
        Cliente cliente;
        EntradaComprada entradaComprada;
        EntradaComprada entradaAnulada;
        int iDCompra = 100;

        String[] listaOpciones = {COMPRAR, INGRESOS, ANULAR, SALIR};

        do {
            bienvenida();
            mostrarOpciones(listaOpciones);
            try {
                opcionBienvenida = scanner.nextInt();
                if (opcionBienvenida > 0 && opcionBienvenida <= listaOpciones.length) {
                    switch (opcionBienvenida) {
                        case 1:
                            try {
                                ubicacion.mostrarTotalUbicaciones();
                                opcionUbicacion = scanner.nextInt();
                                if (opcionUbicacion > LISTA_NOMBRES.length) {
                                    bienvenida = validaOpcion();
                                } else {
                                    ubicacion.mostrarListaUbicaciones(opcionUbicacion);
                                    opcionEntrada = scanner.nextInt();
                                    if (opcionEntrada > ubicacion.getListaVip().length || opcionEntrada < 1) {
                                        bienvenida = validaOpcion();
                                    } else {
                                        iDCompra++;
                                        entradaComprada = ubicacion.seleccionarEntrada(opcionEntrada, opcionUbicacion);
                                        if (entradaComprada.isComprada()) {
                                            System.out.println(INGRESE_EDAD);
                                            edad = scanner.nextInt();
                                            scanner.nextLine();
                                            do {
                                                System.out.print(INGRESE_GENERO);
                                                opcionGenero = scanner.nextLine().trim().toUpperCase();
                                                if (opcionGenero.equals("M") || opcionGenero.equals("F")) {
                                                    generoValido = true;
                                                } else {
                                                    System.out.println(GENERO_EQUIVOCADO);
                                                    generoValido = false;
                                                }
                                            } while (!generoValido);
                                            cliente = new Cliente();
                                            cliente.setGenero(opcionGenero);
                                            cliente.setEdad(edad);
                                            precioEntrada = ubicacion.obtenerPrecioPorCodigo(opcionUbicacion);
                                            calcularDescuento(precioEntrada, cliente, entradaComprada);
                                            entradaComprada.setTipoEntrada(LISTA_NOMBRES[(opcionUbicacion - 1)]);
                                            entradaComprada.setiDCompra(iDCompra);
                                            iniciarTimerCompra();
                                            listaCompradaFinal.add(entradaComprada);
                                            mostrarBoleta(entradaComprada);
                                            System.out.println(DESEA_CONTINUAR);
                                            continua = scanner.next().toUpperCase();
                                            bienvenida = deseaContinuar(continua);
                                        } else {
                                            bienvenida = validaOpcion();
                                        }
                                    }
                                }
                                break;
                            } catch (RuntimeException e) {
                                throw new RuntimeException(e);
                            }
                        case 2:
                            try {
                                if (validaLista(listaCompradaFinal)) {
                                    System.out.println(SE_HAN_VENDIDO + listaCompradaFinal.size() + " entradas");
                                    int ingresoTotal = 0;
                                    for(EntradaComprada entrada : listaCompradaFinal) {
                                        ingresoTotal += entrada.getPrecioFinal();
                                    }
                                    System.out.println(EL_INGRESO + ingresoTotal);
                                } else {
                                    System.out.println(NO_TIENE);
                                    System.out.println(SALTO_DE_LINEA);
                                }
                                iniciarTimerVolver();
                                bienvenida = true;

                            } catch (RuntimeException e) {
                                throw new RuntimeException(e);
                            }
                            break;
                        case 3:
                            try {
                                if (validaLista(listaCompradaFinal)) {
                                    System.out.println(ID_COMPRAS);
                                    mostrarEntradasID(listaCompradaFinal);
                                    do {
                                        System.out.println(INGRESE_ID);
                                        opcionAnular = scanner.nextInt();
                                        entradaAnulada = seleccionarEntradaAnulada(opcionAnular, listaCompradaFinal);
                                    } while(entradaAnulada == null);
                                    System.out.println(DESEA_ANULAR);
                                    System.out.println(SI_NO);
                                    continua = scanner.next().toUpperCase();
                                    if (deseaContinuar(continua)) {
                                        actualizarListaConEntrada(Integer.parseInt(entradaAnulada.getUbicacionReservada()),
                                        ubicacion.obtenerListaPorCodigo(Integer.parseInt(entradaAnulada.getCodigoLista())));
                                        listaCompradaFinal.remove(entradaAnulada);
                                        System.out.println(ANULACION_CORRECTA);
                                        iniciarTimerVolver();
                                    } else {
                                        System.out.println(SIN_ANULACION);
                                    }
                                    bienvenida = true;
                                } else {
                                    System.out.println(NO_TIENE);
                                    System.out.println(SALTO_DE_LINEA);
                                    iniciarTimerVolver();
                                    bienvenida = true;
                                }
                            } catch (RuntimeException e) {
                                throw new RuntimeException(e);
                            }
                            break;
                        case 4:
                            bienvenida = false;
                            break;
                    }
                } else {
                    bienvenida = validaOpcion();
                }

            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        } while (bienvenida);
        scanner.close();
        despedida();
    }
}