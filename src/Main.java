import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Splitwise Console ===");
        System.out.println("Track shared expenses with friends.");
        System.out.println("Ready. More features coming in the next lessons.");

        Scanner input = new Scanner(System.in);
        ArrayList<String> friends = new ArrayList<>();
        boolean running = true;

        while (running) {
            System.out.println("=== Menu ===");
            System.out.println("1. Record expense");
            System.out.println("2. Add friend");
            System.out.println("3. List friends");
            System.out.println("0. Quit");
            System.out.print("Choice: ");
            int choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1 -> {
                    if (friends.isEmpty()) {
                        System.out.println("No friends yet. Add friends first (option 2).");
                    } else {
                        int numFriends = friends.size();
                        System.out.print("Who paid? ");
                        String payerName = input.nextLine();
                        System.out.print("Total amount (₹)? ");
                        double totalAmount = input.nextDouble();
                        double perPersonShare = totalAmount / numFriends;
                        String expenseLine = "%s paid ₹%.2f".formatted(payerName, totalAmount);
                        String shareLine = "Each person pays: %.2f".formatted(perPersonShare);
                        System.out.println(expenseLine);
                        System.out.println(shareLine);
                    }
                }
                case 2 -> addFriend(input, friends);
                case 3 -> {
                    if (friends.isEmpty()) {
                        System.out.println("No friends yet.");
                    } else {
                        System.out.println("Friends:");
                        for (String name : friends) {
                            System.out.println("- " + name);
                        }
                    }
                }
                case 0 -> {
                    System.out.println("Goodbye!");
                    running = false;
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }

    public static void addFriend(Scanner input, ArrayList<String> friends) {
        System.out.print("Friend name: ");
        String friendName = input.nextLine();
        friends.add(friendName);
        System.out.println("Added " + friendName + ".");
    }
}