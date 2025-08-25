public class BattleField {
    private Trainer trainerA;
    private Trainer trainerB;
    private int turn = 1;

    public BattleField(Trainer trainerA, Trainer trainerB) {
        this.trainerA = trainerA;
        this.trainerB = trainerB;
        trainerA.summon();
        trainerB.summon();
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
        Pokemon PA = this.trainerA.getActivatePokemon();
        Pokemon PB = this.trainerB.getActivatePokemon();

        Skill SA = PA.getSkills(tp1);
        Skill SB = PB.getSkills(tp2);

        if (PA.getSpeed() >= PB.getSpeed()) {
            if (SA.getType() == Skill.Type.Attack) {
                PA.useSkillTo(PB, SA);
                if (PB.isAlive()) {
                    if (SB.getType() == Skill.Type.Attack) {
                        PB.useSkillTo(PA, SB);
                    } else {
                        PB.useSkillTo(PB, SB);
                    }
                }
            } else {
                PA.useSkillTo(PA, SA);
                if (SB.getType() == Skill.Type.Attack) {
                    PB.useSkillTo(PA, SB);
                } else {
                    PB.useSkillTo(PB, SB);
                }
            }
        } else {
            if (SB.getType() == Skill.Type.Attack) {
                PB.useSkillTo(PA, SB);
                if (PA.isAlive()) {
                    if (SA.getType() == Skill.Type.Attack) {
                        PA.useSkillTo(PB, SA);
                    } else {
                        PA.useSkillTo(PA, SA);
                    }
                }
            } else {
                PB.useSkillTo(PB, SB);
                if (SA.getType() == Skill.Type.Attack) {
                    PA.useSkillTo(PB, SA);
                } else {
                    PA.useSkillTo(PA, SA);
                }
            }
        }

        if (!PA.isAlive())
            this.trainerA.summon();
        if (!PB.isAlive())
            this.trainerB.summon();
        turn++;
    }

    public int checkWin() {
        if (this.trainerA.summon() == null && this.trainerB.summon() != null) {
            return 2;
        } else if (this.trainerA.summon() != null && this.trainerB.summon() != null)
            return 0;
        else if (this.trainerA.summon() != null && this.trainerB.summon() == null)
            return 1;
        else
            return -1;
    }

    public String toString() {
        if (this.checkWin() == 1) {
            return String.format(
                    "Turn %d:\nTrainer %s's Pokemon %s: %d/%d\nTrainer %s's Pokemon %s: %d/%d\nWinner: %s\n",
                    turn - 1, this.trainerA.getName(), trainerA.getActivatePokemon().getName(),
                    this.trainerA.getActivatePokemon().getHP(), this.trainerA.getActivatePokemon().getMaxHP(),
                    this.trainerB.getName(), trainerB.getActivatePokemon().getName(),
                    this.trainerB.getActivatePokemon().getHP(), this.trainerB.getActivatePokemon().getMaxHP(),
                    trainerA.getName());
        } else if (this.checkWin() == 2) {
            return String.format(
                    "Turn %d:\nTrainer %s's Pokemon %s: %d/%d\nTrainer %s's Pokemon %s: %d/%d\nWinner: %s\n",
                    turn - 1, this.trainerA.getName(), trainerA.getActivatePokemon().getName(),
                    this.trainerA.getActivatePokemon().getHP(), this.trainerA.getActivatePokemon().getMaxHP(),
                    this.trainerB.getName(), trainerB.getActivatePokemon().getName(),
                    this.trainerB.getActivatePokemon().getHP(), this.trainerB.getActivatePokemon().getMaxHP(),
                    trainerB.getName());
        } else {
            return String.format("Turn %d:\nTrainer %s's Pokemon %s: %d/%d\nTrainer %s's Pokemon %s: %d/%d\n",
                    turn - 1, this.trainerA.getName(), trainerA.getActivatePokemon().getName(),
                    this.trainerA.getActivatePokemon().getHP(), this.trainerA.getActivatePokemon().getMaxHP(),
                    this.trainerB.getName(), trainerB.getActivatePokemon().getName(),
                    this.trainerB.getActivatePokemon().getHP(), this.trainerB.getActivatePokemon().getMaxHP());

        }
    }
}