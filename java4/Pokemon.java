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
        for (Skill e : skills) {
            Skill cnt = new Skill(e.getName(), e.getType(), e.getPower(), e.getPP());
            skills1.add(cnt);
            this.skills = skills1;
        }

    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setMaxHP(int maxHP) {
        this.maxHP = maxHP;
    }

    public int getMaxHP() {
        return maxHP;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getAttack() {
        return attack;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSkills0(ArrayList<Skill> skills) {
        this.skills = skills;
    }

    public ArrayList<Skill> getSkills() {
        return skills;
    }

    public Skill getSkills(String name) {
        for (Skill s : skills) {
            if (s.getName().equals(name)) {
                return s;
            }
        }
        return null;
    }

    public void setHP(int HP) {
        if (HP > maxHP) {
            this.HP = maxHP;
        } else if (HP < 0) {
            this.HP = 0;
        } else {
            this.HP = HP;
        }
    }

    public int getHP() {
        return HP;
    }

    public boolean isAlive() {
        return this.getHP() > 0;
    }

    public void useSkillTo(Pokemon target, Skill skill) {
        if (skill.getPP() > 0) {
            if (skill.getType() == Skill.Type.Attack) {
                target.setHP(target.getHP() - skill.getPower() * this.attack);
            } else {
                target.setHP(target.getHP() + skill.getPower());
            }
            skill.setPP(skill.getPP() - 1);
        }
    }

    public String toString() {
        return String.format("%s: %d/%d", this.name, this.getHP(), this.getMaxHP());
    }
}