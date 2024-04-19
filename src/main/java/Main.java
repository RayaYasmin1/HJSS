import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean exitRequested = false;
        while (!exitRequested) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Welcome to HJSS swimming management System:");
            System.out.println("1. Register");
            System.out.println("2. Book A Lesson");
            System.out.println("3.Coach Monthly report");
            System.out.println("4.Attend A lesson:");
            System.out.println("5.Change/cancel A Booking");
            System.out.println("6.Learner Monthly Report");
            System.out.println("7.Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> Learner.RegisterNewLearner();
                case 2 -> Learner.BookALesson();
                case 3 -> Coach.CoachMonthlyReport();
                case 4->Learner.attendALesson();
                case 5->Learner.cancel_change_booking();
                case 6-> Learner.LearnerMonthlyReport();
                case 7-> {
                    exitRequested = true;
                    System.out.println("Thank you for using the system. Goodbye!");
                }
                default -> System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }
}
