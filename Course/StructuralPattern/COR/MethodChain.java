package COR;

public class MethodChain {
    public static void main(String[] args) {
        Creature creature = new Creature("Goblin", 2, 4);
        System.out.println(creature);

        CreatureModifier rootModifier = new CreatureModifier(creature);

        rootModifier.add(new NoBonusesModifier(creature));

        rootModifier.add(new DoubleAttackModifier(creature));
        rootModifier.add(new IncreaseDefenseModifier(creature));

        rootModifier.handle();
        System.out.println(creature);
    }
}


class Creature {

    public String name;
    public int attack, defense;

    public Creature(String name, int attack, int defense) {
        this.name = name;
        this.attack = attack;
        this.defense = defense;
    }

    @Override
    public String toString() {
        return String.format("%s (Attack: %d, Defense: %d)", name, attack, defense);
    }
}

class CreatureModifier {
    protected Creature creature;
    protected CreatureModifier next;

    public CreatureModifier(Creature creature) {
        this.creature = creature;
    }

    public void add(CreatureModifier cm) {
        if (next != null) {
            next.add(cm);
        } else {
            next = cm;
        }
    }

    public void handle() {
        if (next != null) next.handle();
    }
}

class DoubleAttackModifier extends CreatureModifier {

    public DoubleAttackModifier(Creature creature) {
        super(creature);
    }

    @Override
    public void handle() {
        System.out.println("Doubling: " + creature.name + "'s attack");
        creature.attack *= 2;
        super.handle();
    }
}

class IncreaseDefenseModifier extends CreatureModifier {
    public IncreaseDefenseModifier(Creature creature) {
        super(creature);
    }

    @Override
    public void handle() {
        System.out.println("Increasing " + creature.name + "'s defense");
        creature.defense += 3;
        super.handle();
    }
}

class NoBonusesModifier extends CreatureModifier {
    public NoBonusesModifier(Creature creature) {
        super(creature);
    }

    @Override
    public void handle() {
        System.out.println("No bonuses");

    }
}