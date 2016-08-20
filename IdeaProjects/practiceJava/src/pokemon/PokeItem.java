package pokemon;
public class PokeItem { // Class name needs to be in Camelcase - PokeItem (big P)
    String name;
    String description;
    int captureRate;
    int fleeRate;
    int hp;


    public PokeItem(String inputName, String inputDescription, int inputCaptureRate, int inputFleeRate){
        name = inputName;
        description = inputDescription;
        captureRate = inputCaptureRate;
        fleeRate = inputFleeRate;
    }
    public PokeItem(String inputName, String inputDescription, int inputHP){
        name = inputName;
        description = inputDescription;
        hp = inputHP;
    }
    public void heal(PokeItem potion, Pokemon pokemon){
        pokemon.hp += potion.hp;
        System.out.println(pokemon.name + " has recovered " + potion.hp +" HP.");
    }
    public void catchPokemon(PokeItem ball, Pokemon wildPokemon){
        int n =  (int) (Math.random()*100);
        if (n < ball.captureRate){
            System.out.println("Gotcha! " + wildPokemon.name + " was caught!");
            wildPokemon.caught = true;
        } else {
            System.out.println(wildPokemon.name + " got out.");
            if ( (int) (Math.random()*100) < ball.fleeRate){
                System.out.println(wildPokemon.name + " escaped.");
                wildPokemon.caught = true;
            }
        }
    }

    public void use(PokeItem item, Pokemon pokemon){
        if(item.name.contains("Potion")){
            heal(item, pokemon);
        } else if(item.name.contains("Ball")){
            catchPokemon(item, pokemon);
        }
    }
    public static void main(String... args) {

    }
}

