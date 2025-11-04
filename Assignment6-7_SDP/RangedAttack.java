class RangedAttack implements AttackStrategy {
    public void attack(Hero attacker, Hero target) {
        int damage = 15;
        target.takeDamage(damage);
        attacker.notifyObservers(attacker.getName() + " thrown an arrow towards " + target.getName() + " for " + damage + " damage!");
    }
}