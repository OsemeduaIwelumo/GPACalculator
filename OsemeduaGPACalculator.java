import java.util.Scanner;
public class OsemeduaGPACalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the GPA Calculator");
        System.out.println("Enter course details or type 'exit' to calculate GPA:");

        System.out.println("|---------------|---------------|-----|--------------|");
        System.out.println("| COURSE & CODE | COURSE UNIT | GRADE | GRADE-UNIT |");
        System.out.println("|---------------|---------------|--------|--------------|");

        double totalQualityPoint = 0.0;
        int totalGradeUnit = 0;

        while (true) {
            System.out.print("Course name and code: ");
            String courseNameAndCode = scanner.nextLine();
            if (courseNameAndCode.equalsIgnoreCase("exit")) {
                break;
            }

            System.out.print("Course unit: ");
            int courseUnit = Integer.parseInt(scanner.nextLine());

            System.out.print("Course score: ");
            int courseScore = Integer.parseInt(scanner.nextLine());

            int gradeUnit = calculateGradeUnit(courseScore);
            double qualityPoint = calculateQualityPoint(courseUnit, gradeUnit);

            totalQualityPoint += qualityPoint;
            totalGradeUnit += courseUnit;

            printCourseDetails(courseNameAndCode, courseUnit, courseScore, gradeUnit);

            System.out.println("|------------------|---------------|--------|--------------|");
        }

        double gpa = calculateGPA(totalQualityPoint, totalGradeUnit);
        System.out.printf("\nYour GPA is = %.2f to 2 decimal places.\n", gpa);

        scanner.close();
    }

    public static int calculateGradeUnit(int score) {
        if (score >= 70) {
            return 5;
        } else if (score >= 60) {
            return 4;
        } else if (score >= 50) {
            return 3;
        } else if (score >= 45) {
            return 2;
        } else if (score >= 40) {
            return 1;
        } else {
            return 0;
        }
    }

    public static double calculateQualityPoint(int courseUnit, int gradeUnit) {
        return courseUnit * gradeUnit;
    }

    public static void printCourseDetails(String courseNameAndCode, int courseUnit, int courseScore, int gradeUnit) {
        System.out.println("| " + String.format("%-16s", courseNameAndCode) + "| " + String.format("%-13s", courseUnit) +
                "| " + String.format("%-6s", getGrade(courseScore)) + "| " + String.format("%-12s", gradeUnit) + "|");
    }

    public static double calculateGPA(double totalQualityPoint, int totalGradeUnit) {
        return totalQualityPoint / totalGradeUnit;
    }

    public static String getGrade(int score) {
        if (score >= 70) {
            return "A";
        } else if (score >= 60) {
            return "B";
        } else if (score >= 50) {
            return "C";
        } else if (score >= 45) {
            return "D";
        } else if (score >= 40) {
            return "E";
        } else {
            return "F";
        }
    }
}