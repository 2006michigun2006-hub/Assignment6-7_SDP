class ShieldDecorator extends HeroDecorator {
    public ShieldDecorator(Hero hero) {
        super(hero);
        sloy.notifyObservers(hero.getName() + " is wearing a shield now.");
    }
    public void takeDamage(int damage) {
        int reduced = Math.max(0, damage - 10);
        sloy.takeDamage(reduced);
    }
}