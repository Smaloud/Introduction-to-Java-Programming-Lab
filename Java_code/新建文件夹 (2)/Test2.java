package Assignments.A4;

public class Test2 {
    public static void main(String[] args) {
        Skill attack = new Skill("Beat", Skill.Type.Attack, 10, 2);
        Skill heal = new Skill("Heal", Skill.Type.Heal, 10, 10);
        Pokemon pokemon1 = new Pokemon("Pikachu", 50, 2, 10, attack, heal);
        Pokemon pokemon2 = new Pokemon("Paimon", 50, 2, 5, attack, heal);
        Trainer trainer1 = new Trainer("XiaoZhi", pokemon1);
        Trainer trainer2 = new Trainer("Traveler", pokemon2);
        BattleField bf = new BattleField(trainer1, trainer2);
        bf.battle("Beat", "Beat");
        System.out.println(bf);
        bf.battle("Beat", "Beat");
        System.out.println(bf);
        bf.battle("Beat", "Beat");
        System.out.println(bf);
    }

}
