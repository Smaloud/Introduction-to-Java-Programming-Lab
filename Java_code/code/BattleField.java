package Assignments.A4;


public class BattleField {
    private Trainer trainerA;
    private Trainer trainerB;
    private int turn = 0;

    public BattleField(Trainer trainerA, Trainer trainerB) {
        this.trainerA = trainerA;
        this.trainerB = trainerB;
    }

    public void setTrainerA(Trainer trainerA) {
        this.trainerA = trainerA;
    }

    public Trainer getTrainerA() {
        return trainerA;
    }

    public void setTrainerB(Trainer trainerB) {
        this.trainerB = trainerB;
    }

    public Trainer getTrainerB() {
        return trainerB;
    }

    public void battle(String tp1, String tp2) {
        turn++;
        if (this.trainerA.summon()!=null) this.trainerA.summon();
        if (this.trainerB.summon()!=null) this.trainerB.summon();
        if (this.trainerA.getActivatePokemon().getSpeed() >= this.trainerB.getActivatePokemon().getSpeed()) {
            if (this.trainerA.getActivatePokemon().isAlive()){
            if (this.trainerA.getActivatePokemon().getSkills(tp1).getType().equals(Skill.Type.Attack)) {
                this.trainerA.getActivatePokemon().useSkillTo(this.trainerB.getActivatePokemon(), this.trainerA.getActivatePokemon().getSkills(tp1));
                if (this.trainerB.getActivatePokemon().isAlive()){
                    if (this.trainerB.getActivatePokemon().getSkills(tp2).getType().equals(Skill.Type.Attack)) {
                        this.trainerB.getActivatePokemon().useSkillTo(this.trainerA.getActivatePokemon(),this.trainerB.getActivatePokemon().getSkills(tp2));
                    }else if (this.trainerB.getActivatePokemon().getSkills(tp2).getType().equals(Skill.Type.Heal))
                        this.trainerB.getActivatePokemon().useSkillTo(this.trainerB.getActivatePokemon(),this.trainerB.getActivatePokemon().getSkills(tp2));
                }
            }}
        } else if (this.trainerB.getActivatePokemon().getSpeed() > this.trainerA.getActivatePokemon().getSpeed()){
            if (this.trainerB.getActivatePokemon().isAlive()){
                if (this.trainerB.getActivatePokemon().getSkills(tp2).getType().equals(Skill.Type.Attack)) {
                    this.trainerB.getActivatePokemon().useSkillTo(this.trainerA.getActivatePokemon(), this.trainerB.getActivatePokemon().getSkills(tp2));
                    if (this.trainerA.getActivatePokemon().isAlive()){
                        if (this.trainerA.getActivatePokemon().getSkills(tp1).getType().equals(Skill.Type.Attack)) {
                            this.trainerA.getActivatePokemon().useSkillTo(this.trainerB.getActivatePokemon(),this.trainerA.getActivatePokemon().getSkills(tp1));
                        }else if (this.trainerA.getActivatePokemon().getSkills(tp1).getType().equals(Skill.Type.Heal))
                            this.trainerA.getActivatePokemon().useSkillTo(this.trainerA.getActivatePokemon(),this.trainerA.getActivatePokemon().getSkills(tp1));
                    }
                }}
        }
    }

    public int checkwin() {
        if (this.trainerA.summon() == null && this.trainerB.summon() != null) {
            return 2;
        } else if (this.trainerA.summon() != null && this.trainerB.summon() != null) return 0;
        else if (this.trainerA.summon() != null && this.trainerB.summon()== null) return 1;
        else return -1;
    }

    public String toString() {
        if (this.checkwin() == 1) {
            return String.format("Turn %d:\nTrainer %s's Pokemon %s: %d/%d\nTrainer %s's Pokemon %s: %d/%d\nWinner: %s\n",
                    turn, this.trainerA.getName(), trainerA.getActivatePokemon().getName(), this.trainerA.getActivatePokemon().getHP(), this.trainerA.getActivatePokemon().getMaxHP(),
                    this.trainerB.getName(), trainerB.getActivatePokemon().getName(), this.trainerB.getActivatePokemon().getHP(), this.trainerB.getActivatePokemon().getMaxHP(),trainerA.getName() );
        }else if (this.checkwin() == 2){return String.format("Turn %d:\nTrainer %s's Pokemon %s: %d/%d\nTrainer %s's Pokemon %s: %d/%d\nWinner: %s\n",
                turn, this.trainerA.getName(), trainerA.getActivatePokemon().getName(), this.trainerA.getActivatePokemon().getHP(), this.trainerA.getActivatePokemon().getMaxHP(),
                this.trainerB.getName(), trainerB.getActivatePokemon().getName(), this.trainerB.getActivatePokemon().getHP(), this.trainerB.getActivatePokemon().getMaxHP(),trainerB.getName() );
        }else{return String.format("Turn %d:\nTrainer %s's Pokemon %s: %d/%d\nTrainer %s's Pokemon %s: %d/%d\n",
                turn, this.trainerA.getName(), trainerA.getActivatePokemon().getName(), this.trainerA.getActivatePokemon().getHP(), this.trainerA.getActivatePokemon().getMaxHP(),
                this.trainerB.getName(), trainerB.getActivatePokemon().getName(), this.trainerB.getActivatePokemon().getHP(), this.trainerB.getActivatePokemon().getMaxHP());

        }
    }
}