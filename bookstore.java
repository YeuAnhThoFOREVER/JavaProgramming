package week6;

import java.util.Scanner;
import java.util.ArrayList;

public class bookstore {
    
    static String userName;
    static int userMobile;
    static String greeting = "Welcome to Shopping Mall";
    static String tagline = "Welcome to Book Market!";
    
    // Cart storage
    static ArrayList<String> cartItems = new ArrayList<>();
    static ArrayList<Integer> cartPrices = new ArrayList<>();
    static ArrayList<Integer> cartQuantities = new ArrayList<>();
    
    // ✅ Pre-loaded shop menu items
    static String[] menuNames = {"Coffee", "Plan Cake", "Coconut", "Capuchino","NoteBook", "TextBook"};
    static int[] menuPrices = {3000, 5000, 4000, 5500, 2500, 1500};
    
    static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        System.out.println("당신의 이름을 입력하세요:");
        userName = sc.next();
        System.out.println("연락처를 입력하시오:");
        userMobile = sc.nextInt();
        
        System.out.println("*".repeat(40));
        System.out.println("\t" + greeting);
        System.out.println("\t" + tagline);
        System.out.println("*".repeat(40));
        
        boolean running = true;
        while (running) {
            printMenu();
            int choice = sc.nextInt();
            switch (choice) {
                case 1: menuGuestInfo(); break;
                case 2: menuCartItemList(); break;
                case 3: menuCartClear(); break;
                case 4: menuCartAddItem(); break;
                case 5: menuCartRemoveItemCount(); break;
                case 6: menuCartRemoveItem(); break;
                case 7: menuCartBill(); break;
                case 8: running = menuExit(); break;
                default: System.out.println("잘못된 입력입니다.");
            }
        }
    }
    
    static void printMenu() {
        System.out.println("\n========== MAIN MENU ==========");
        System.out.println("→1. 고객 정보 확인하기: menuGuestInfo()");
        System.out.println("→2. 장바구니 상품 목록 보기: menuCartItemList()");
        System.out.println("→3. 장바구니 비우기: menuCartClear()");
        System.out.println("→4. 바구니에 항목 추가하기: menuCartAddItem()");
        System.out.println("→5. 장바구니의 항목 수량 줄이기: menuCartRemoveItemCount()");
        System.out.println("→6. 장바구니의 항목 삭제하기: menuCartRemoveItem()");
        System.out.println("→7. 영수증 표시하기: menuCartBill()");
        System.out.println("→8. 종료: menuExit()");
        System.out.print("선택: ");
    }

    // ✅ Show shop menu before adding to cart
    static void showShopMenu() {
        System.out.println("\n---------- 상품 목록 ----------");
        for (int i = 0; i < menuNames.length; i++) {
            System.out.println((i + 1) + ". " + menuNames[i] + " - " + menuPrices[i] + "원");
        }
        System.out.println("--------------------------------");
    }
    
    // 1. Guest info
    static void menuGuestInfo() {
        System.out.println("\n[ 고객 정보 ]");
        System.out.println("이름: " + userName);
        System.out.println("연락처: " + userMobile);
    }
    
    // 2. Show cart
    static void menuCartItemList() {
        System.out.println("\n[ 장바구니 목록 ]");
        if (cartItems.isEmpty()) {
            System.out.println("장바구니가 비어 있습니다.");
            return;
        }
        for (int i = 0; i < cartItems.size(); i++) {
            System.out.println((i + 1) + ". " + cartItems.get(i)
                + " | 가격: " + cartPrices.get(i)
                + "원 | 수량: " + cartQuantities.get(i));
        }
    }
    
    // 3. Clear cart
    static void menuCartClear() {
        cartItems.clear();
        cartPrices.clear();
        cartQuantities.clear();
        System.out.println("장바구니를 비웠습니다.");
    }
    
    // 4. Add item - picks from shop menu ✅
    static void menuCartAddItem() {
        showShopMenu();
        System.out.print("추가할 상품 번호를 선택하세요: ");
        int idx = sc.nextInt() - 1;
        
        if (idx < 0 || idx >= menuNames.length) {
            System.out.println("잘못된 번호입니다.");
            return;
        }
        
        System.out.print("수량 입력: ");
        int qty = sc.nextInt();
        
        String selectedName = menuNames[idx];
        int selectedPrice = menuPrices[idx];
        
        // Check if already in cart, if so just increase quantity
        boolean found = false;
        for (int i = 0; i < cartItems.size(); i++) {
            if (cartItems.get(i).equals(selectedName)) {
                cartQuantities.set(i, cartQuantities.get(i) + qty);
                found = true;
                break;
            }
        }
        
        if (!found) {
            cartItems.add(selectedName);
            cartPrices.add(selectedPrice);
            cartQuantities.add(qty);
        }
        
        System.out.println("✅ " + selectedName + " " + qty + "개 추가 완료!");
    }
    
    // 5. Reduce quantity
    static void menuCartRemoveItemCount() {
        menuCartItemList();
        if (cartItems.isEmpty()) return;
        System.out.print("수량을 줄일 항목 번호: ");
        int idx = sc.nextInt() - 1;
        if (idx < 0 || idx >= cartItems.size()) {
            System.out.println("잘못된 번호입니다.");
            return;
        }
        System.out.print("줄일 수량: ");
        int qty = sc.nextInt();
        int current = cartQuantities.get(idx);
        if (qty >= current) {
            System.out.println(cartItems.get(idx) + " 항목이 삭제되었습니다.");
            cartItems.remove(idx);
            cartPrices.remove(idx);
            cartQuantities.remove(idx);
        } else {
            cartQuantities.set(idx, current - qty);
            System.out.println("수량 업데이트 완료!");
        }
    }
    
    // 6. Remove item
    static void menuCartRemoveItem() {
        menuCartItemList();
        if (cartItems.isEmpty()) return;
        System.out.print("삭제할 항목 번호: ");
        int idx = sc.nextInt() - 1;
        if (idx < 0 || idx >= cartItems.size()) {
            System.out.println("잘못된 번호입니다.");
            return;
        }
        System.out.println("🗑️ " + cartItems.get(idx) + " 삭제 완료!");
        cartItems.remove(idx);
        cartPrices.remove(idx);
        cartQuantities.remove(idx);
    }
    
    // 7. Receipt
    static void menuCartBill() {
        System.out.println("\n========== 영수증 ==========");
        System.out.println("고객명: " + userName);
        System.out.println("연락처: " + userMobile);
        System.out.println("----------------------------");
        if (cartItems.isEmpty()) {
            System.out.println("장바구니가 비어 있습니다.");
        } else {
            int total = 0;
            for (int i = 0; i < cartItems.size(); i++) {
                int subtotal = cartPrices.get(i) * cartQuantities.get(i);
                System.out.println(cartItems.get(i)
                    + " x" + cartQuantities.get(i)
                    + " = " + subtotal + "원");
                total += subtotal;
            }
            System.out.println("----------------------------");
            System.out.println("합계: " + total + "원");
        }
        System.out.println("============================");
    }
    
    // 8. Exit
    static boolean menuExit() {
        System.out.println("이용해 주셔서 감사합니다. 안녕히 가세요!");
        sc.close();
        return false;
    }
}