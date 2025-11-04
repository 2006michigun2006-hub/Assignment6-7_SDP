import java.util.*;
class Game {
    private Hero player1;
    private Hero player2;
    private Scanner scanner = new Scanner(System.in);
    private Observer logger = new GameLogger();
    public void startGame() {
        System.out.print("Enter name for Player 1: ");
        player1 = new Hero(scanner.next());
        player1.addObserver(logger);
        System.out.print("Enter name for Player 2: ");
        player2 = new Hero(scanner.next());
        player2.addObserver(logger);
        chooseAttack(player1);
        chooseAttack(player2);
        while(player1.isAlive() && player2.isAlive()) {
            takeTurn(player1, player2);
            if(!player2.isAlive()) {
                break;
            }
            takeTurn(player2, player1);
        }
        System.out.println("Game is over. Bye Bye!");
        if(player1.isAlive()) {
            System.out.println(player1.getName() + " won");
        } else {
            System.out.println(player2.getName() + " won");
        }
    }
    private void chooseAttack(Hero hero) {
        System.out.println(hero.getName() + ", please choose the type of your attack:\n 1) Melee \n 2) Ranged \n 3) Magic\n");
        int choice = scanner.nextInt();
        switch(choice) {
            case 1:
                hero.setAttackStrategy(new MeleeAttack());
                break;
            case 2:
                hero.setAttackStrategy(new RangedAttack());
                break;
            case 3:
                hero.setAttackStrategy(new MagicAttack());
                break;
            default:
                hero.setAttackStrategy(new MeleeAttack());
                break;
        }
    }
    private void takeTurn(Hero attacker, Hero target) {
        System.out.println("\nTurn is on " + attacker.getName());
        System.out.println("1) Attack");
        System.out.println("2) Change the type of attack");
        System.out.println("3) Get a PowerUp");
        int choice = scanner.nextInt();
        switch(choice) {
            case 1:
                attacker.attack(target);
                break;
            case 2:
                chooseAttack(attacker);
                break;
            case 3:
                System.out.println("Chose what you want to do:\n 1) Shield \n 2) PowerUp \n");
                int up = scanner.nextInt();
                if (up == 1) {
                    attacker = new ShieldDecorator(attacker);
                } else {
                    attacker = new PowerUpDecorator(attacker);
                }
                if (attacker.getName().equals(player1.getName())) {
                    player1 = attacker;
                } else {
                    player2 = attacker;
                }
                break;
            default:
                System.out.println("You skipped your turn loser;(");
                break;
        }
    }
}
//this is Facade Pattern