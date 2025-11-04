import java.util.*;
class Hero {
    protected String name;
    protected int health = 100;
    protected AttackStrategy attackStrategy;
    protected List<Observer> observers = new ArrayList<>();
    public Hero(String name) {
        this.name = name;
    }

    public void setAttackStrategy(AttackStrategy strategy) {
        this.attackStrategy = strategy;
        notifyObservers(name + " changed the type of attack to " + strategy.getClass().getSimpleName());
    }

    public void attack(Hero target) {
        if (attackStrategy != null) {
            attackStrategy.attack(this, target);
        } else {
            System.out.println(name + " hasn't chosen the type of attack");
        }
    }

    public void takeDamage(int damage) {
        health -= damage;
        if (health <= 0) {
            health = 0;
            notifyObservers(name + " is dead. Congrats!");
        } else {
            notifyObservers(name + " now has " + health + " HP");
        }
    }
    public boolean isAlive() {
        return health > 0;
    }
    public String getName() {
        return name;
    }
    public void addObserver(Observer o) {
        observers.add(o);
    }
    public void notifyObservers(String message) {
        for (Observer o : observers) {
            o.wtf(message);
        }
    }
}