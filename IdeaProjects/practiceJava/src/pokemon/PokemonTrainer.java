package pokemon;


import java.util.*;
public class PokemonTrainer {
    //Name, Age, Team, experience point, list of pokemons, list of items
    String name;
    String team;
    List<Pokemon> pokemons = new ArrayList<Pokemon>(); // Try to see if you can use List<Pokemon> here
    List<PokeItem> items = new ArrayList<PokeItem>(); // Use List<PokeItem> here
    int age;
    int exp;

    public PokemonTrainer(String inputName, String inputTeam, int inputAge){
        name = inputName;
        team = inputTeam;
        age = inputAge;
    }
    public void catchPokemon(Pokemon poke){
        pokemons.add(poke);
        exp += 50;
    }
    public void getItem(PokeItem item){
        items.add(item);
        exp += 50;
    }
    public void printTrainerStats(){
        System.out.print("Name: " + name + ", Exp: "+ exp + ", Pokemon:" + pokemons + ", Item(s):" + items);
    }
    public static void main(String... args) {
        PokemonTrainer Trevor = new PokemonTrainer("Trevor", "Valor", 23);
        //PokeItem rareCan = new PokeItem("rare candy","treat for pokemon");
        //PokeItem dogPoop = new PokeItem("dog poop", "treat for Growlithe");
        //Trevor.getItem(rareCan);
        //Trevor.getItem(dogPoop);
       Pokemon Dratini = new Pokemon("Dratini", 26);
       //  Pokemon Snorlax = new Pokemon("Snorlax", "Normal", 98, 77);
        Trevor.catchPokemon(Dratini);
       // Trevor.catchPokemon(Snorlax);
        Trevor.printTrainerStats();
    }
}
