class MeleeAttack implements AttackStrategy {
    public void attack(Hero attacker, Hero target) {
        int damage = 20;
        target.takeDamage(damage);
        attacker.notifyObservers(attacker.getName() + " sliced " + target.getName() + " for " + damage + " damage.");
    }
}