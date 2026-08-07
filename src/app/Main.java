package app;

import java.util.ArrayList;
import java.util.Scanner;
import model.ExpenseLine;
import model.Friend;

/**
 * Splitwise console application for tracking shared expenses with friends.
 */
public class Main {
    /**
     * Starts the Splitwise console application and runs the menu loop.
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        System.out.println("=== Splitwise Console ===");
        System.out.println("Track shared expenses with friends.");
        System.out.println("Ready. More features coming in the next lessons.");

        Scanner input = new Scanner(System.in);
        ArrayList<Friend> friends = new ArrayList<>();
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

                        ExpenseLine line = new ExpenseLine(payerName, totalAmount);

                        double perPersonShare = line.amount() / numFriends;
                        String expenseLine = "%s paid ₹%.2f".formatted(
                                line.payerName(), line.amount());
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
                        for (Friend friend : friends) {
                            System.out.println(FriendDisplay.listLine(friend));
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

    /**
     * Prompts for a friend name and adds a new {@link Friend} to the list.
     * @param input the scanner used to read the friend's name
     * @param friends the list to which the new friend is appended
     */
    public static void addFriend(Scanner input, ArrayList<Friend> friends) {
        System.out.print("Friend name: ");
        String friendName = input.nextLine();
        Friend friend = new Friend(friendName);
        friends.add(friend);
        System.out.println(FriendDisplay.addedMessage(friend));
    }

    // Private helper — not documented (not part of public API).
    private static class FriendDisplay {
        static String listLine(Friend friend) {
            return "- %d: %s".formatted(friend.getId(), friend.getName());
        }

        static String addedMessage(Friend friend) {
            return "Added %s (id %d).".formatted(friend.getName(), friend.getId());
        }
    }
}