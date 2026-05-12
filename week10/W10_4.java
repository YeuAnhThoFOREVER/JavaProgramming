package week10;

import java.util.Scanner;

abstract class Player {
    protected String shape[] = {"가위", "바위", "보"};
    private String name;
    public Player(String name) { this.name = name; }
    public String getName() { return name; }
    abstract public String turn();
}

class MachinePlayer extends Player {
    public MachinePlayer(String name) { super(name); }
    public String turn() {
        return shape[(int)(Math.random() * 3)];
    }
}

class HumanPlayer extends Player {
    public HumanPlayer(String name) { super(name); }
    public String turn() {
        try (Scanner sc = new Scanner(System.in)) {
			System.out.print(getName() + ", 뭘 내시겠습니까? ");
			return sc.nextLine();
		}
    }
}

public class W10_4 {
    public static void main(String[] args) {
        Player machine = new MachinePlayer("터미네이터");
        Player human = new HumanPlayer("황기태");
        String m = machine.turn();
        String h = human.turn();
        System.out.println(machine.getName() + ":" + m + ", " + human.getName() + ":" + h);
        if (h.equals(m))
            System.out.println(machine.getName() + " 승리!");
        else
            System.out.println(human.getName() + " 승리!");
    }
}