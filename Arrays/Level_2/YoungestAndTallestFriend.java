import java.util.Scanner;

public class YoungestAndTallestFriend {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String[] names = {"Amar", "Akbar", "Anthony"};

        int[] ages = new int[names.length];
        double[] heights = new double[names.length];

        for (int i = 0; i < names.length; i++) {
            System.out.print("Enter age of " + names[i] + ": ");
            ages[i] = input.nextInt();

            System.out.print("Enter height of " + names[i] + " (in cm): ");
            heights[i] = input.nextDouble();
        }

        int youngestIndex = 0;
        int tallestIndex = 0;

        for (int i = 1; i < names.length; i++) {
            if (ages[i] < ages[youngestIndex]) {
                youngestIndex = i;
            }
            if (heights[i] > heights[tallestIndex]) {
                tallestIndex = i;
            }
        }

        System.out.println("\nThe youngest friend is " + names[youngestIndex]
                + " with age " + ages[youngestIndex]);
        System.out.println("The tallest friend is " + names[tallestIndex]
                + " with height " + heights[tallestIndex] + " cm");

        input.close();
    }
}

