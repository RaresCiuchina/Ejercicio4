import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class Ejercicio4Test {

    static Ejercicio4 ej;

    @BeforeAll
    static void firstInit() {
        System.out.println("firstInit");
        ej = new Ejercicio4();
        ej.arrayPokemons = ObtenerPokemonsRequest.Companion.get(1,9);
        for (Pokemon poke : ej.arrayPokemons){
            System.out.println(poke);
        }
     }


    @BeforeEach
    void setUp() {
        System.out.println("setUp");
    }

    @AfterEach
    void tearDown() {
        System.out.println("tearDown");
    }


    @Test
    void pokemonMasGordosQue() {
        Pokemon[] pokemonEsperados = {
                new Pokemon(20, 3, "venusaur", 1000),
                new Pokemon(17, 6, "charizard", 905),
                new Pokemon(16, 9, "blastoise", 855)
        };
        Pokemon[] pokemonActuales = ej.pokemonMasGordosQue(250);
        Assertions.assertArrayEquals(pokemonEsperados, pokemonActuales);
    }

    @Test
    void pokemonMasGordosQue02() {
        Pokemon[] pokemonEsperados = new Pokemon[0];
        Pokemon[] pokemonActuales = ej.pokemonMasGordosQue(2000);
        Assertions.assertArrayEquals(pokemonEsperados, pokemonActuales);
    }
    @Test
    void pokemonMasGordosQue03() {
        Pokemon[] pokemonEsperados = {
                new Pokemon(20, 3, "venusaur", 1000),
                new Pokemon(17, 6, "charizard", 905)
        };
        Pokemon[] pokemonActuales = ej.pokemonMasGordosQue(855);
        Assertions.assertArrayEquals(pokemonEsperados, pokemonActuales);
    }

    @Test
    void pokemonMasGordosQue04() {
        Pokemon[] pokemonActuales = ej.pokemonMasGordosQue(0);
        Assertions.assertArrayEquals(ej.arrayPokemons, pokemonActuales);
    }


    /* ______________ _____________________________________________*/
    @Test
    void getPokemonMenosGordo() {
        Pokemon[] pokemonEsperados = {
                new Pokemon(7, 1, "bulbasaur", 69),
                new Pokemon(6, 4, "charmander", 85),
        };
        Pokemon[] pokemonActuales = ej.getPokemonMenosGordo(90);
        Assertions.assertArrayEquals(pokemonEsperados, pokemonActuales);
    }

    @Test
    void getPokemonMenosGordo1() {
        Pokemon[] pokemonEsperados = new Pokemon[0];
        Pokemon[] pokemonActuales = ej.getPokemonMenosGordo(69);
        Assertions.assertArrayEquals(pokemonEsperados, pokemonActuales);
    }

    @Test
    void getpokemonMenosGordos2() {
        Pokemon[] pokemonActuales = ej.getPokemonMenosGordo(10000);
        Assertions.assertArrayEquals(ej.arrayPokemons, pokemonActuales);
    }

/* ---------------------------------------------------------------------*/


    @Test
    void pokemonEntrePesos(){
        Pokemon[] pokemonEsperados = {
                new Pokemon(7, 1, "bulbasaur", 69),
                new Pokemon(6, 4, "charmander", 85),
                new Pokemon(5, 7, "squirtle", 90)
        };
        Pokemon[] pokemonActuales = ej.getPokemonPesoEntre(95, 50);
        Assertions.assertArrayEquals(pokemonEsperados, pokemonActuales);
    }



    @Test
    void pokemonEntrePesos1(){
        // Si uno de los dos pesos es igual al peso de pokemon
        Pokemon[] pokemonEsperados = {
                new Pokemon(7, 1, "bulbasaur", 69),
                new Pokemon(6, 4, "charmander", 85),
        };
        Pokemon[] pokemonActuales = ej.getPokemonPesoEntre(90, 50);
        Assertions.assertArrayEquals(pokemonEsperados, pokemonActuales);
    }

    @Test
    void pokemonEntrePesos2(){
        //Comprueba que cambiando el peso minimo como el maximo y el maximo como el minimo
        // devuelva un array vacio.
        Pokemon[] pokemonEsperados = new Pokemon[0];
        Pokemon[] pokemonActuales = ej.getPokemonPesoEntre(50, 90);
        Assertions.assertArrayEquals(pokemonEsperados, pokemonActuales);
    }

    @Test
    void pokemonEntrePesos3(){
        //Comprueba que devuelva la excepcion NullPointer cuando los argumentos son nulos
        Assertions.assertThrows(NullPointerException.class, ()-> ej.getPokemonPesoEntre(null, 50));
    }

    /*-----------------------------------------------------------------*/
    @Test
    void pokemonNombreMasLargoQue(){
        //Comprueba que el nombre de los pokemon dados son mas largos que el numero
        //introducido
        Pokemon[] pokemonEsperados = {
                new Pokemon(6, 4, "charmander", 85),
                new Pokemon(11, 5, "charmeleon", 190)
        };
        Pokemon[] pokemonActuales = ej.getPokemonNombreMasLargoQue(9);
        Assertions.assertArrayEquals(pokemonEsperados, pokemonActuales);
    }

    @Test
    void pokemonNombreMasLargoQue1(){
        //Comprueba que devuelva un array vacio si se pone longitud del texto 10 (el maximo)
        Pokemon[] pokemonEsperados = new Pokemon[0];
        Pokemon[] pokemonActuales = ej.getPokemonNombreMasLargoQue(10);
        Assertions.assertArrayEquals(pokemonEsperados, pokemonActuales);
    }

    @Test
    void pokemonNombreMasLargoQue2(){
        //Comprueba que devuelva todos los pokemon si pones longitud 0
        Pokemon[] pokemonActuales = ej.getPokemonNombreMasLargoQue(0);
        Assertions.assertArrayEquals(ej.arrayPokemons, pokemonActuales);
    }


    /*---------------- -----------------------------------------------------------------*/
    @Test
    void pokemonNombreMasCorto(){
        //Comprueba que devuelva los pokemon con nombre mas corto que la longitud dada
        Pokemon[] pokemonEsperados = {
                new Pokemon(10, 2, "ivysaur", 130)
        };
        Pokemon[] pokemonActuales = ej.getPokemonNombreMasCortoQue(8);
        Assertions.assertArrayEquals(pokemonEsperados, pokemonActuales);
    }

    @Test
    void pokemonNombreMasCorto1(){
        //Comprueba que devuelva todos los pokemon cuando se le pone longitud 11
        Pokemon[] pokemonActuales = ej.getPokemonNombreMasCortoQue(11);
        Assertions.assertArrayEquals(ej.arrayPokemons, pokemonActuales);
    }

    @Test
    void pokemonNombreMasCorto2(){
        //Comprueba que devuelva un array vacio cuando se pone longitud 7
        Pokemon[] pokemonEsperados = new Pokemon[0];
        Pokemon[] pokemonActuales = ej.getPokemonNombreMasCortoQue(7);
        Assertions.assertArrayEquals(pokemonEsperados, pokemonActuales);
    }

    /*-------------------------------------------------------------------------*/


    @Test
    void getPokemonQueContengaLasSiguientesLetras() {
        Pokemon[] pokemonEsperados = {
                new Pokemon(7, 1, "bulbasaur", 69),
                new Pokemon(10, 2, "ivysaur", 130),
                new Pokemon(20, 3, "venusaur", 1000)
        };
        Pokemon[] pokemonActuales = ej.getPokemonQueContengaLasSiguientesLetras("saur");
        Assertions.assertArrayEquals(pokemonEsperados, pokemonActuales);
    }


}