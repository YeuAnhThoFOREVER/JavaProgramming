package day11;

import week11.PhoneInterface;

public class SmartPhone extends Calc implements PhoneInterface {

    public static void main(String[] args) {
        SmartPhone sp = new SmartPhone();
        sp.sendCall();
        sp.receiveCall();
        
        // This will now work because sp inherits calculate() from Calc!
        System.out.println("3 + 5 = " + sp.calculate(3, 5));
    }

    public int calculate(int a, int b) {
        // Based on the "3 + 5 = 8" logic from your slide, this should add them
        return a + b;
	}

	@Override
    public void sendCall() {
        System.out.println("스마트폰 벨~~~~");
    }

    @Override
    public void receiveCall() {
        System.out.println("전화를 받습니다."); // Optional: Fill this in so it's not empty
    }
}