package model;

/**
 * One recorded expense: who paid and how much.
 *
 * @param payerName the name of the friend who paid
 * @param amount the total amount in rupees
 */
public record ExpenseLine(String payerName, double amount) {
}