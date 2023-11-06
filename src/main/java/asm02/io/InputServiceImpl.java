package asm02.io;

import java.util.Scanner;

public class InputServiceImpl implements InputService {
    private final  Scanner scanner;

    public InputServiceImpl() {
        scanner = new Scanner(System.in);
    }

    @Override
    public double[] input() {
            System.out.print("Please enter input number of elements: ...");
            int n = scanner.nextInt();
            System.out.printf("Please enter input elements: ...");
            double[] arr = new double[n];
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextDouble();
            }
            return arr;

    }
}
