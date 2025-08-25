package Assignments.A4;

public class Test {
    public static void main(String[] args) {
            Skill attack = new Skill("Beat", Skill.Type.Attack, 40, 10);
            Skill heal = new Skill("Heal", Skill.Type.Heal, 40, 10);
            Pokemon pokemon1 = new Pokemon("Pikachu", 50, 1, 10, attack, heal);
            Pokemon pokemon2 = new Pokemon("Paimon", 50, 1, 5, attack, heal);
            Pokemon pokemon3 = new Pokemon("Zelda", 50, 1, 5, attack, heal);
            Trainer trainer1 = new Trainer("XiaoZhi", pokemon1);
            Trainer trainer2 = new Trainer("Traveler", pokemon2, pokemon3);
            BattleField bf = new BattleField(trainer1, trainer2);
            bf.battle("Beat", "Beat");
            System.out.println(bf);
            bf.battle("Beat", "Heal");
            System.out.println(bf);
            bf.battle("Heal", "Beat");
            System.out.println(bf);
            bf.battle("Beat", "Beat");
            System.out.println(bf);
            bf.battle("Beat", "Beat");
            System.out.println(bf);
        }
    }

