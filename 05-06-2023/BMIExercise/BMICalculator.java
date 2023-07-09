package BMIExercise;

import java.util.Scanner;

public class BMICalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter weight: ");
        double weight = scanner.nextDouble();

        System.out.print("Enter height: ");
        double height = scanner.nextDouble();

        scanner.nextLine(); // Consume the newline character

        System.out.print("Enter units (English/Metric): ");
        String units = scanner.nextLine();

        double bmi = calculateBMI(weight, height, units);
        String bmiCategory = evaluateBMI(bmi);

        System.out.println("BMI: " + bmi);
        System.out.println("BMI Category: " + bmiCategory);

        scanner.close();
    }

    public static double calculateBMI(double weight, double height, String units) {
        
        double bmi = 0;

        if (units.equalsIgnoreCase("English"))
            bmi = (weight * 703) / ( height * height );
        else
            bmi = weight / ( height * height );

        return bmi;
    }

    public static String evaluateBMI(double bmi) {
        if (bmi < 18.5)
            return "Underweight";
        else if (bmi >= 18.5 && bmi <= 24.9)
            return "Normal";
        else if (bmi >= 25 && bmi <= 29.9)
            return "Overweight";
        else
            return "Obese";
    }
}
