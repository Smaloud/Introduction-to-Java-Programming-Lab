package Assignments.A4;

import java.util.ArrayList;

public class Pokemon {
    private String name;
    private int HP;
    private int maxHP;
    private int attack;
    private int speed;
    private ArrayList<Skill> skills;

    public Pokemon(String name, int maxHP, int attack, int speed, Skill... skills) {
        this.name = name;
        this.maxHP = maxHP;
        this.HP = maxHP;
        this.attack = attack;
        this.speed = speed;
        ArrayList<Skill> skills1 = new ArrayList<>();
        for (Skill e:skills) {
            Skill cnt = new Skill(e.getName(),e.getType(),e.getPower(),e.getPP());
            skills1.add(cnt);
            this.skills = skills1;
        }

    }
    public void setName(String name){this.name = name;}
    public String getName(){return name;}
    public void setMaxHP(int maxHP){this.maxHP = maxHP;}
    public int getMaxHP(){return maxHP;}
    public void setAttack(int attack){this.attack = attack;}
    public int getAttack(){return attack;}
    public void setSpeed(int speed){this.speed = speed;}
    public int getSpeed(){return speed;}
    public void setSkills0(ArrayList<Skill> skills){this.skills = skills;}
    public ArrayList<Skill> getSkills0(){return skills;}
    public Skill getSkills(String name){
        Skill InsSkill = null;
        for (Skill e: skills) {
            if (e.getName().equals(name)) {
                InsSkill = e ;
            }
        }return InsSkill;
    }
    public void setHP(int HP){if (HP>this.getMaxHP()){
    this.HP = maxHP;}else {this.HP = HP;}
        if (HP<0) this.HP = 0;
    }
    public int getHP(){return HP;}
    public boolean isAlive(){
        return this.getHP()>0;
    }
    public void useSkillTo(Pokemon target, Skill skill){
        int InsHP;
        if (skill!=null&&skill.getPP()>0&&skill.getType() == Skill.Type.Attack){
            InsHP=target.getHP()-skill.getPower()*this.attack;
            target.setHP(InsHP);
            skill.setPP(skill.getPP()-1);
        }
        if (skill!=null&&skill.getPP()>0&&skill.getType() == Skill.Type.Heal){
            InsHP = target.getHP()+skill.getPower();
            target.setHP(InsHP);
            skill.setPP(skill.getPP()-1);
        }
    }
    public String toString(){
        return String.format("%s: %d/%d",this.name,this.getHP(),this.getMaxHP());
    }
}