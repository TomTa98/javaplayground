package pokemon;
import java.util.*;

public class Pokemon {
    String name;
   // String type;
    int hp;
   // int attack;
    int speed;
    boolean caught;
    List<PokeMove> moves = new ArrayList<PokeMove>();
    List<PokeItem> items = new ArrayList<PokeItem>();

    public Pokemon (String inputName, int inputHp){
        name = inputName;
        hp = inputHp;
    }

    public void addMove(PokeMove newMove){
        if(moves.size() < 4) {
            moves.add(newMove);
        }
    }
    public void addItem(PokeItem newItem){
        items.add(newItem);
    }
    public void displayMoves(List<PokeMove> moves){
        int count = 0;
        for (int i = 0; i < moves.size(); i++){
            System.out.println(count+1 + ") " + moves.get(count).name + " DMG:" + moves.get(count).dmg + " PP:" + moves.get(count).pp);
            count++;
        }
    }
    public void displayItems(List<PokeItem> item){//show the items
        int count = 0;
        for (int i = 0; i < item.size(); i++){
            System.out.println(count+1 + ") " + item.get(count).name +  " Desc:" + item.get(count).description);
            count++;
        }
    }
    public void attack(Pokemon opponentPokemon){
        System.out.println(name + "'s turn.");
        displayMoves(moves);
        Scanner reader = new Scanner(System.in);
        int n = reader.nextInt();
        opponentPokemon.hp -= moves.get(n-1).dmg;
        moves.get(n-1).pp--;
        System.out.println(opponentPokemon.name + " has taken " + moves.get(n-1).dmg +" damage. It now has " + Math.max(0,opponentPokemon.hp) + " HP.");
    }
    public void useItem(Pokemon opponentPokemon){
        displayItems(items);
        Scanner reader = new Scanner(System.in);
        int n = reader.nextInt();
        if(items.get(n-1).name.contains("Ball")){
            items.get(n-1).use(items.get(n-1),opponentPokemon);
            if (!opponentPokemon.caught) {
                opponentPokemon.attack(this);
                showOptions(opponentPokemon);
            }
        } else if(items.get(n-1).name.contains("Potion")){
            items.get(n - 1).use(items.get(n - 1), this);
            opponentPokemon.attack(this);
            showOptions(opponentPokemon);
        }
    }

    public void battle(Pokemon opponentPokemon){
        int count = 1;
        while(opponentPokemon.hp > 0 && hp > 0 && !opponentPokemon.caught){
            if( count%2 ==1 ) {
                attack(opponentPokemon);
            } else {
                opponentPokemon.attack(this);
                if (opponentPokemon.hp > 0 && hp > 0) showOptions(opponentPokemon);// at the end of enemy's turn, show options
            }
            count ++;
        }
        if(opponentPokemon.hp < hp){
            System.out.println(opponentPokemon.name + " fainted!");
        } else System.out.println(name + " fainted!");
    }
    public void showOptions(Pokemon pokemon){

        System.out.println("What will "+name+" do?\n1) FIGHT  2) BAG  3) RUN");
        Scanner reader = new Scanner(System.in);
        int n = reader.nextInt();
        if (n == 1){
            battle(pokemon);
        } else if (n == 2){
            useItem(pokemon);
        } else if (n == 3){
            if(Math.random()*100 < 50 ) {
                System.out.println("Successfully escaped.");
            } else {
                System.out.println("Escape failed.");
                pokemon.attack(this);
                showOptions(pokemon);
            }
        }
    }
    public void encounterPokemon(Pokemon pokemon){
        System.out.println("A wild "+pokemon.name+" appeared! \n");
        showOptions(pokemon);
    }


    public static void main(String... args){
        PokeMove tackle = new PokeMove("Tackle", 3, 10);
        PokeMove ember = new PokeMove("Ember",6, 10);
        PokeMove flamethrower = new PokeMove("Flamethrower", 10, 15);
        PokeItem greatBall = new PokeItem("Great Ball", "Better than Good Ball", 0, 10);
        PokeItem superPotion = new PokeItem("Super Potion", "Recovers 2 HP", 2);
        Pokemon growlithe = new Pokemon("Growlithe", 20);
        Pokemon rattata = new Pokemon("Rattata", 12);
        growlithe.addMove(ember);
        growlithe.addMove(flamethrower);
        rattata.addMove(tackle);
        growlithe.addItem(greatBall);
        growlithe.addItem(superPotion);
        growlithe.encounterPokemon(rattata);
    }
}