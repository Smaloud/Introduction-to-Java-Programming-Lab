package Assignments.A4;

import java.util.ArrayList;

public class Trainer {
    private String name;
    private ArrayList<Pokemon> pokemons;
    private Pokemon activatePokemon ;
    public void setName(String name){this.name = name;}
    public String getName(){return name;}
    public void setPokemons(ArrayList<Pokemon> pokemons){this.pokemons = pokemons;}
    public ArrayList<Pokemon> getPokemons(){return pokemons;}
    public void setActivatePokemon(Pokemon pokemon){this.activatePokemon = pokemon;}
    public Pokemon getActivatePokemon(){return activatePokemon;}
    public Trainer(String name, Pokemon... pokemons) {
        this.name = name;
        ArrayList<Pokemon> pokemons1 = new ArrayList<>();
        while (pokemons1.size()<=6){
            for (Pokemon e:pokemons) {
                pokemons1.add(e);
                for (int i = 0; i < pokemons1.size()-1; i++) {
                    if (e.equals(pokemons1.get(i))) pokemons1.remove(e);
                }
            }
        }
        this.pokemons = pokemons1;
    }
    public void addPokemon(Pokemon... poke) {
        while (this.pokemons.size()<=6){
            for (Pokemon e:poke) {
                this.pokemons.add(e);
                for (int i = 0; i < this.pokemons.size()-1; i++) {
                    if (e.equals(this.pokemons.get(i))) this.pokemons.remove(e);
                }
            }
        }
    }
    public void removePokemon(String... name) {
        for (String n : name) {
            for (Pokemon e : this.getPokemons()) {
                if (e.getName().equals(n)) this.pokemons.remove(e);
            }
        }
    }
    public boolean isAlive(String name) {
        Pokemon Inspoke = null;
        for (Pokemon e:pokemons){
            if (e.getName().equals(name)) Inspoke = e;
        }
        if (Inspoke!=null){return Inspoke.getHP()>0;}
        else return false;
    }
    public boolean isAlive(Pokemon poke) {
     return poke.getHP()>0;
    }
    public Pokemon getPokemon(String name) {
        for (Pokemon e : this.pokemons) {
            if (e.getName().equals(name)) return e;
        }return null;
    }
    public Pokemon summon() {
        boolean check = false;
            for (Pokemon e : this.pokemons) {
                if (e.getHP() > 0) {
                    this.setActivatePokemon(e);
                    check = true;
                    break;
                }
            }
            if (!check) {
                return null;
            }else return this.getActivatePokemon();
        }
    public Pokemon summon(String name){
        for (Pokemon e: this.pokemons){
            if (e.getName().equals(name)&&e.getHP()>0){
                this.activatePokemon = e;
                return e;
            }
        }return null;
    }


}
