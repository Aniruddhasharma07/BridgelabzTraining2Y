import java.util.Scanner;

public class CountingSortStudentAges {

    public static void countingSort(int[] ages) {
        int n = ages.length;
        int minAge = 10;
        int maxAge = 18;
        int range = maxAge - minAge + 1;

        int[] count = new int[range];
        int[] output = new int[n];

        for (int i = 0; i < n; i++) {
            count[ages[i] - minAge]++;
        }

        for (int i = 1; i < range; i++) {
            count[i] += count[i - 1];
        }

        for (int i = n - 1; i >= 0; i--) {
            output[count[ages[i] - minAge] - 1] = ages[i];
            count[ages[i] - minAge]--;
        }

        for (int i = 0; i < n; i++) {
            ages[i] = output[i];
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        int[] ages = new int[n];
        System.out.println("Enter student ages (10 to 18):");
        for (int i = 0; i < n; i++) {
            ages[i] = sc.nextInt();
        }

        countingSort(ages);

        System.out.println("Sorted ages in ascending order:");
        for (int age : ages) {
            System.out.print(age + " ");
        }
        sc.close();
    }
}
