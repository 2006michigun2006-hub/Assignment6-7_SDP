class PowerUpDecorator extends HeroDecorator {
    public PowerUpDecorator(Hero hero) {
        super(hero);
        sloy.notifyObservers(hero.getName() + " has strengthen the attack for 10 damage.");
    }
    public void attack(Hero target) {
        System.out.println(getName() + " is attacking with PowerUp.");
        sloy.attack(target);
        target.takeDamage(10);
    }
}