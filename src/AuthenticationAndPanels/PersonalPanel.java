

package AuthenticationAndPanels;

import java.util.Scanner;
import PersonalDataTracker.StepTracker;
import PersonalDataTracker.WaterIntake;
import PersonalDataTracker.HealthMetrics;
import Calculation.SleepTracker;
import Calculation.WorkOutTracker;
import MainProgramme.ServiceHandler;
public class PersonalPanel {
    private Scanner scanner = new Scanner(System.in);
    private boolean isLoggedIn;
    private String loggedInUser;
    private SleepTracker sleepTracker;
    private WorkOutTracker workoutTracker;
    private StepTracker stepTracker;
    private WaterIntake waterIntakeTracker;
    private HealthMetrics healthMetricsTracker;

    public PersonalPanel(String loggedInUser) {
        this.loggedInUser = loggedInUser;
        this.isLoggedIn = true;
        this.sleepTracker = new SleepTracker(loggedInUser);
        this.workoutTracker = new WorkOutTracker(loggedInUser);
        this.stepTracker = new StepTracker(loggedInUser);
        this.waterIntakeTracker = new WaterIntake(loggedInUser);
        this.healthMetricsTracker = new HealthMetrics(loggedInUser);
    }

    public void showPanel() {
        while (isLoggedIn) {
            ServiceHandler.clearScreen();
            System.out.println("===== Personal Panel =====");
            System.out.println("Welcome, " + loggedInUser + "!");
            System.out.println("Choose an option:");
            System.out.println("1. Track Health Metrics");
            System.out.println("2. Track Water Intake");
            System.out.println("3. Track Steps");
            System.out.println("4. Track Workout");
            System.out.println("5. Track Sleep");
            System.out.println("6. Logout");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    trackHealthMetrics();
                    break;
                case 2:
                    trackWaterIntake();
                    break;
                case 3:
                    trackSteps();
                    break;
                case 4:
                    trackWorkout();
                    break;
                case 5:
                     trackSleep();
                    break;
                case 6:
                    logout();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    ServiceHandler.pause();
            }
        }
    }

    private void logout() {
        System.out.println("Logging out...");
        isLoggedIn = false;
        loggedInUser = null;
    }

    private void trackSleep() {
        ServiceHandler.clearScreen();
        System.out.println("===== Sleep Tracker =====");
        System.out.println("1. Start Sleep Timer");
        System.out.println("2. Stop Sleep Timer");
        System.out.println("3. View Sleep Records");

        System.out.print("Enter your choice: ");
        int sleepChoice = scanner.nextInt();
        scanner.nextLine();

        switch (sleepChoice) {
            case 1:
                sleepTracker.startActivity();
                break;
            case 2:
                sleepTracker.stopActivity();
                break;
            case 3:
                sleepTracker.viewRecords();
                break;
            default:
                System.out.println("Invalid choice.");
        }
        ServiceHandler.pause();
    }

    private void trackWaterIntake() {
        ServiceHandler.clearScreen();
        System.out.println("===== Water Intake Tracker =====");
        System.out.println("1. Record & Save Water Intake");
        System.out.println("2. View Water Intake History");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                System.out.print("Enter water intake amount (liters): ");
                double amount = scanner.nextDouble();
                scanner.nextLine();
                waterIntakeTracker.addRecord(amount);
                break;
            case 2:
                waterIntakeTracker.viewHistory();
                break;
            default:
                System.out.println("Invalid choice.");
        }
        ServiceHandler.pause();
    }

    private void trackSteps() {
        ServiceHandler.clearScreen();
        System.out.println("===== Step Tracker =====");
        System.out.println("1. Record & Save Steps");
        System.out.println("2. View Step History");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                System.out.print("Enter number of steps: ");
                int steps = scanner.nextInt();
                scanner.nextLine();
                stepTracker.addRecord(steps);
                break;
            case 2:
                stepTracker.viewHistory();
                break;
            default:
                System.out.println("Invalid choice.");
        }
        ServiceHandler.pause();
    }

    private void trackWorkout() {
        ServiceHandler.clearScreen();
        System.out.println("===== Workout Tracker =====");
        System.out.println("1. Start Workout Timer");
        System.out.println("2. Stop Workout Timer");
        System.out.println("3. View Workout Records");
        System.out.print("Enter your choice: ");
        int workoutChoice = scanner.nextInt();
        scanner.nextLine();

        switch (workoutChoice) {
            case 1:
                workoutTracker.startActivity();
                break;
            case 2:
                workoutTracker.stopActivity();
                break;
            case 3:
                workoutTracker.viewRecords();
                break;
            default:
                System.out.println("Invalid choice.");
        }
        ServiceHandler.pause();
    }

    private void trackHealthMetrics() {
        ServiceHandler.clearScreen();
        System.out.println("===== Health Metrics Tracker =====");
        System.out.println("1. Record & Save Health Metrics");
        System.out.println("2. View Health History");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                System.out.print("Enter Blood Pressure (e.g., 120/80): ");
                String bloodPressure = scanner.nextLine();
                System.out.print("Enter Glucose Level (mg/dL): ");
                String glucose = scanner.nextLine();
                System.out.print("Enter Heart Rate (bpm): ");
                String heartRate = scanner.nextLine();
                System.out.print("Enter Pulse Rate (bpm): ");
                String pulseRate = scanner.nextLine();
                healthMetricsTracker.addRecord(bloodPressure, glucose, heartRate, pulseRate);
                break;
            case 2:
                healthMetricsTracker.viewHistory();
                break;
            default:
                System.out.println("Invalid choice.");
        }
       ServiceHandler.pause();
    }





}



