package com.company.OtrasClases;

import com.company.TipoCarta.Carta;
import com.company.TipoCarta.Enum.Area;
import com.company.TipoCarta.Enum.Efecto;
import com.company.TipoCarta.Estudio;
import com.company.TipoCarta.Evento;
import com.company.TipoCarta.Ramo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Juego {
    public static void main(String[] args) {
        Mazo mazoCarrera= new Mazo();
        Mazo mazoUniversitario= new Mazo();
        Integer aprobados;
        Integer reprobados;
        Mano mano;

        //MAZO UNIVERSITARIO

        //Humanistico
        Estudio H1 = new Estudio("Biblioteca", "Libros, libros y libros, que te salvaran", 2, 18, 26, Area.HUMANISTA);
        Estudio H2 = new Estudio("Sala pasta", "A veces se puede leer aqui", 2, 18, 26, Area.HUMANISTA);
        Estudio H3 = new Estudio("Humanisticos.usm.cl", "Info de todo el depto. Humanista", 2, 18, 26, Area.HUMANISTA);
        Estudio H4 = new Estudio("Mesitas Verdes", "Jugar (a veces) y leer a la vez, aprovechar tu tiempo", 3, 28, 40, Area.HUMANISTA);
        Estudio H5 = new Estudio("Casino", "Comer y leer y estudiar a la vez, lograble.", 3, 28, 40, Area.HUMANISTA);
        Estudio H6 = new Estudio("Cerrito", "Poderes sobrenaturales para estudiar cualquier Humanista ", 4, 20, 90, Area.HUMANISTA);

        //Matematico
        Estudio Mt1 = new Estudio("Wolfram", "Wolfram es tu salvador para Matematicas, cualquier Mate", 2, 18, 26, Area.MATEMATICA);
        Estudio Mt2 = new Estudio("CIAC", "Salvador previo a un certamen de Mate", 2, 18, 26, Area.MATEMATICA);
        Estudio Mt3 = new Estudio("Mario Mallea", "Best ayudante de todas las Mates", 2, 18, 26, Area.MATEMATICA);
        Estudio Mt4 = new Estudio("Ayudante Secreto", "La leyenda dice que te hace pasar automaticamente, pero nadie lo sabe", 3, 28, 40, Area.MATEMATICA);
        Estudio Mt5 = new Estudio("JulioProfe", "No te enseñan algo en la U?. No te preocupes, JulioProfe te salvara", 3, 28, 40, Area.MATEMATICA);
        Estudio Mt6 = new Estudio("SymboLab", "No haz pagado Wolfram? Symbolab is free!", 4, 20, 90, Area.MATEMATICA);

        //Informatico

        Estudio INF1 = new Estudio("SMOJ", "Lugar donde te hacen sufrir con  Python", 2, 18, 26, Area.INFORMATICA);
        Estudio INF2 = new Estudio("Trinket.io", "Figuras para programar, algo fácil para aprender", 2, 18, 26, Area.INFORMATICA);
        Estudio INF3 = new Estudio("Ayudantes Tareas LP", "Siempre se ponen la capa cuando unx necesita ayuda, dioses", 2, 18, 26, Area.INFORMATICA);
        Estudio INF4 = new Estudio("StackOverflow", "Todo lo que necesites, siempre estará aqui", 2, 18, 26, Area.INFORMATICA);
        Estudio INF5 = new Estudio("HackerRank", "Aprender a programar, facilito", 3, 28, 40, Area.INFORMATICA);
        Estudio INF6 = new Estudio("W3Schools", "Todo lo que necesitas, con tutorial incluido.", 3, 28, 40, Area.INFORMATICA);
        Estudio INF7 = new Estudio("GitHub", "Sé un programador profesional con GitHub, donde todos los programadores están.", 3, 28, 40, Area.INFORMATICA);
        Estudio INF8 = new Estudio("Minecraft", "Minecraft esta basado en java, so why not?", 4, 20, 90, Area.INFORMATICA);

        //Evento

        Evento e1 = new Evento("RAV", "Permite al jugador seleccionar un ramo y mezclarlo con el mazo de carrera", Efecto.RAV);
        Evento e2 = new Evento("Cambio de coordinacion", "Hay 50% de probabilidad que durante el turno actual los creditos de un ramo a eleccion del jugador aumenten en 3 y 50% de probabilidad de que\n" +
                "disminuyan en 3, pudiendo quedar un valor de creditos negativo.", Efecto.CAMBIO_DE_COORDINACION);
        Evento e3 = new Evento("Buff Matematico", "Aumenta el puntaje maximo que pueden entregar todas las cartas de estudio a un ramo de Matematica en el tablero en un 25% durante este turno.", Efecto.BUFF);
        Evento e4 = new Evento("Buff Humanistico", "Aumenta el puntaje maximo que pueden entregar todas las cartas de estudio a un ramo Humanista en el tablero en un 25% durante este turno.", Efecto.BUFF);
        Evento e5 = new Evento("Buff Informatico", "Aumenta el puntaje maximo que pueden entregar todas las cartas de estudio a un ramo de Informatica en el tablero en un 25% durante este turno.", Efecto.BUFF);

        //Meter las cartas al mazo y revolver las cartas

        mazoUniversitario.putBack(H1);
        mazoUniversitario.putBack(H2);
        mazoUniversitario.putBack(H3);
        mazoUniversitario.putBack(H4);
        mazoUniversitario.putBack(H5);
        mazoUniversitario.putBack(H6);

        mazoUniversitario.putBack(Mt1);
        mazoUniversitario.putBack(Mt2);
        mazoUniversitario.putBack(Mt3);
        mazoUniversitario.putBack(Mt4);
        mazoUniversitario.putBack(Mt5);
        mazoUniversitario.putBack(Mt6);

        mazoUniversitario.putBack(INF1);
        mazoUniversitario.putBack(INF2);
        mazoUniversitario.putBack(INF3);
        mazoUniversitario.putBack(INF4);
        mazoUniversitario.putBack(INF5);
        mazoUniversitario.putBack(INF6);
        mazoUniversitario.putBack(INF7);
        mazoUniversitario.putBack(INF8);

        mazoUniversitario.putBack(e1);
        mazoUniversitario.putBack(e2);
        mazoUniversitario.putBack(e3);
        mazoUniversitario.putBack(e4);
        mazoUniversitario.putBack(e5);

        mazoUniversitario.shuffle();

        List<Estudio> listita = new ArrayList<Estudio>();
        listita.add(H1);


        aprobados = 0; //Comienzan en 0
        reprobados = 0; //Comienzan en 0


        //MAZO CARRERA


        //Humanistico

        Ramo r1 = new Ramo("Chino", "¿Quieres aprender Chino Mandarin?. Esta es tu oportunidad!",2,listita,Area.HUMANISTA );
        Ramo r2 = new Ramo("Arte e Ingenieria", "¿Como funciona un microondas?. En este ramo lo analizarás desde 0, desde el empaque hasta cuanto resiste", 2,listita, Area.HUMANISTA);
        Ramo r3 = new Ramo("Etica", "Tus acciones del dia a dia, son moralmente correctas? o son eticamente correctas? Es tu momento de saberlo!", 2,listita, Area.HUMANISTA);

        //Informatico
        Ramo r4 = new Ramo("Estructuras Discretas", "Te volveras a God de los grafos y de LaTeX", 5,listita, Area.INFORMATICA);
        Ramo r5 = new Ramo("Programacion", "Un ramo perfecto, con Python, lo más amigable que existe", 5,listita, Area.INFORMATICA);
        Ramo r6 = new Ramo("Estructura de Datos", "Cra tu mejor amigo, ojo ojito ojote con la memoria", 5,listita, Area.INFORMATICA);
        Ramo r7 = new Ramo("TALF", "Automatas, expresiones regulares, demostraciones y más. JFLAP en el cora", 5,listita, Area.INFORMATICA);

        //Matematico

        Ramo r8 = new Ramo("Mat021", "La primera mate, donde todos llegamos diciendo que las amamos, hasta que ves algo totalmente radical y quedas plop", 7,listita, Area.MATEMATICA);
        Ramo r9 = new Ramo("Mat022", "La que corta las cabezas, todos hemos muerto alguna vez aquí, siempre es un ramo feroz y destructivo, podras superarlo?", 7,listita, Area.MATEMATICA);
        Ramo r10 = new Ramo("Intro a la Mate Avanzada", "Este ramo define si realmente te gustan MUCHO las Matematicas, el ramo que corta-cabezas de Civil Mate", 7,listita, Area.MATEMATICA);

        //Se deben agregar al mazo para empezar el juego, luego deben revolverse

        mazoCarrera.putBack(r1);
        mazoCarrera.putBack(r2);
        mazoCarrera.putBack(r3);
        mazoCarrera.putBack(r4);
        mazoCarrera.putBack(r5);
        mazoCarrera.putBack(r6);
        mazoCarrera.putBack(r7);
        mazoCarrera.putBack(r8);
        mazoCarrera.putBack(r9);
        mazoCarrera.putBack(r10);
        mazoCarrera.shuffle();

        //Juego

        System.out.println("\t.....Welcome to the Freaky card game.....\n");
        Mano manita = new Mano();
        Tablero mesadejuego = new Tablero();
        Ramo ramote = new Ramo();

        //Ciclo para que el juego se acabe cuando se cumplan las condiciones,

        while (aprobados < 4 && reprobados < 2) {
            for (int i = 0; i < 6; i++) {   //Debe tener 6 cartas en la mano para empezar el juego
                Carta manito = mazoUniversitario.draw();
                manita.anadirCarta(manito);
            }
            //Dos cartas Carrera en el tablero

            Carta cartita = mazoCarrera.draw();
            Carta cartita2 = mazoCarrera.draw();


            //Agregar las cartas al tablero


            //Mostrar el tablero al jugador y la mano que tiene el jugador (Saber que cartas tiene)

            mesadejuego.mostrarTablero();
            manita.mostrarMano();
            while (mesadejuego.getHorasDisponibles() > 0) {
                //seleccionar carta de la mano

                Scanner sc = new Scanner(System.in);
                System.out.println("Escoja una carta de su mano");
                Integer numero = sc.nextInt();
                while(numero<0 && numero>6){
                    System.out.println("Ingrese un numero correcto");
                    numero = sc.nextInt();
                }
                manita.seleccionarCarta(numero);
                for (Ramo ramitos:mesadejuego.getSemestre()) {
                    if(ramitos.calcularNota()<55){
                        reprobados+=1;
                    }
                    else{
                        aprobados+=1;
                    }
                }
            }

        }
    }
}

