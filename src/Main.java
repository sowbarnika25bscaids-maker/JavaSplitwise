public class Main {

    public static void main(String[] args) {

        System.out.println("=== Splitwise Console ===");
        System.out.println("Track shared expenses with friends.");
        System.out.println("Ready. More features coming in the next lessons.");

        String payerName = "Riya";
        double totalAmount = 500.0;
        int numFriends = 3;

        System.out.println(payerName);
        System.out.println(totalAmount);
        System.out.println(numFriends);

        double perPersonShare = totalAmount / numFriends;

        System.out.println(perPersonShare);

    }

}