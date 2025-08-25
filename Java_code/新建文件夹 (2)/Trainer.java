package Assignments.A4;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.ArrayList;

public class Trainer {
    private String name;
    private ArrayList<Pokemon> pokemons = new ArrayList<>();
    private Pokemon activatePokemon ;
    public void setName(String name){this.name = name;}
    public String getName(){return name;}
    public void setPokemons(ArrayList<Pokemon> pokemons){this.pokemons = pokemons;}
    public ArrayList<Pokemon> getPokemons(){return pokemons;}
    public void setActivatePokemon(Pokemon pokemon){this.activatePokemon = pokemon;}
    public Pokemon getActivatePokemon(){return activatePokemon;}
    public Trainer(String name, Pokemon... pokemons) {
        this.name = name;
        Pokemon[] var1 = pokemons;
        this.pokemons.add(var1[0]);
        int var2 = pokemons.length;
        ArrayList<Pokemon> list = new ArrayList<>();
        for(int var3 = 1; var3 < var2; ++var3) {
            Pokemon var4 = new Pokemon(var1[var3].getName(),var1[var3].getMaxHP(),var1[var3].getAttack(),var1[var3].getSpeed(),var1[var3].getSkills0().get(0),var1[var3].getSkills0().get(1));

            boolean var9 = true;
            if (this.pokemons != null) {
                if (this.pokemons.size() >= 6) {
                    var9 = false;
                    break;
                }

                Iterator var10 = this.pokemons.iterator();

                while(var10.hasNext()) {
                    Pokemon var11 = (Pokemon)var10.next();
                    if (var4.getName().equals(var11.getName())) {
                        var9 = false;
                        break;
                    }
                }
            }

            if (var9) {
                this.pokemons.add(var4);
            }
        }

        this.summon();
    }
    public void addPokemon(Pokemon... poke) {
        Pokemon[] var2 = poke;
        int var3 = poke.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            Pokemon var5 = var2[var4];

            boolean var10 = true;
            if (this.pokemons != null) {
                if (this.pokemons.size() >= 6) {
                    var10 = false;
                    break;
                }

                Iterator var11 = this.pokemons.iterator();

                while(var11.hasNext()) {
                    Pokemon var12 = (Pokemon)var11.next();
                    if (var5.getName().equals(var12.getName())) {
                        var10 = false;
                        break;
                    }
                }
            }

            if (var10) {
                this.pokemons.add(var5);
            }
        }

    }

    public void removePokemon(String... name) {
        ArrayList<Pokemon> Inspoke = new ArrayList<>();
        for (Pokemon e:getPokemons()) Inspoke.add(e);
        for (String n : name) {
            for (Pokemon e : this.getPokemons()) {
                if (e.getName().equals(n)) {
                    Inspoke.remove(e);
                }
            }
        }this.setPokemons(Inspoke);
    }
    public boolean isAlive(String name) {
        Pokemon Inspoke = null;
        for (Pokemon e: this.getPokemons()){
            if (e.getName().equals(name)) Inspoke = e;
        }
        if (Inspoke!=null){return Inspoke.getHP()>0;}
        else return false;
    }
    public boolean isAlive(Pokemon poke) {
     return poke.getHP()>0;
    }
    public Pokemon getPokemon(String name) {
        for (Pokemon e : this.getPokemons()) {
            if (e.getName().equals(name)) return e;
        }return null;
    }
    public Pokemon summon() {
        boolean check = false;
            for (Pokemon e : this.getPokemons()) {
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
        boolean check = false;
        for (Pokemon e: this.getPokemons()){
            if (e.getName().equals(name)&&e.getHP()>0){
                this.setActivatePokemon(e);
                check = true;
                break;
            }
        }if (!check){
            return null;
        }else return this.getActivatePokemon();
    }

    }

