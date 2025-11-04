class MagicAttack implements AttackStrategy {
    public void attack(Hero attacker, Hero target) {
        int damage = 25;
        target.takeDamage(damage);
        attacker.notifyObservers(attacker.getName() + " used magic towards " + target.getName() + " for " + damage + " damage!");
    }
}