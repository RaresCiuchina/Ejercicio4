import java.util.Arrays;

public class Ejercicio4 {

    public Pokemon[] arrayPokemons = new Pokemon[0];

    public void iniciarEjercicio4() {
        System.out.println("Empezando el ej4");
        for (Pokemon pokemon : arrayPokemons) {
            System.out.println(pokemon);
        }
        System.out.println("Resultado de pokemonMasGordosQue");
        Pokemon[] result = pokemonMasGordosQue(225);
        for (Pokemon pokemon : result) {
            System.out.println(pokemon);
        }
    }

    public Pokemon[] pokemonMasGordosQue(Integer peso){
        Pokemon[] out = new Pokemon[arrayPokemons.length];
        int i = 0;
        for (Pokemon pokemon : arrayPokemons) {
            if (pokemon.getWeight() > peso) {
                out[i] = pokemon;
                i++;
            }
        }
        return getArraySinNulos(out, i);
       }

    public Pokemon[] getPokemonQueContengaLasSiguientesLetras(String letras)  {
        Pokemon[] out = new Pokemon[arrayPokemons.length];
        int i = 0;
        for (Pokemon pokemon : arrayPokemons) {
            char[] arrayLetras = letras.toCharArray();

            boolean encontrado = true;
            for (char letra : arrayLetras) {
                if (!pokemon.getName().contains(String.valueOf(letra))) {
                    encontrado = false;
                    break;
                }
            }
            if (encontrado) {
                out[i] = pokemon;
                i++;
            }
        }
        return getArraySinNulos(out, i);
    }
    // Atención, esta operación debe devolver un array de pokemons vacio si letras fuera null.

    // No hay que tener en cuenta el orden
    public Pokemon[] getArraySinNulos(Pokemon[] pokemons, int comienzoNulos) {
        return Arrays.copyOfRange(pokemons, 0, comienzoNulos);
    }


    /*
    Calculandolo tu mismo
     */
    public Pokemon[] getArraySinNulos(Pokemon[] pokemons) {
        int comienzoNulos = 0;
        while (comienzoNulos < pokemons.length) {
            if (pokemons[comienzoNulos] != null){
                comienzoNulos++;
            } else {
                break;
            }
        }
        return Arrays.copyOfRange(pokemons, 0, comienzoNulos);
    }

}
