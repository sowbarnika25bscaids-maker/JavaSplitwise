public class Main {

    public static void main(String[] args) {

        String payerName = "Riya";
        double totalAmount = 500.0;
        int numFriends = 3;

        double amountPerFriend = totalAmount / numFriends;

        System.out.println("=== Splitwise Console ===");
        System.out.println("Track shared expenses with friends.");
        System.out.println("Ready. More features coming in the next lessons.");

        System.out.println("Payer Name: " + payerName);
        System.out.println("Total Amount: " + totalAmount);
        System.out.println("Number of Friends: " + numFriends);
        System.out.println("Amount Per Friend: " + amountPerFriend);

    }

}