abstract class HeroDecorator extends Hero {
    protected Hero sloy;
    public HeroDecorator(Hero hero) {
        super(hero.getName());
        this.sloy = hero;
    }
    public void addObserver(Observer o) {
        sloy.addObserver(o);
    }
    public void notifyObservers(String message) {
        sloy.notifyObservers(message);
    }
    public boolean isAlive() {
        return sloy.isAlive();
    }
    public void setAttackStrategy(AttackStrategy strategy) {
        sloy.setAttackStrategy(strategy);
    }
}