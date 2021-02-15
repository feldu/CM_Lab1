package io;

import java.util.Scanner;

public class LinearSystemConsoleReader implements LinearSystemReader {
    Scanner in = new Scanner(System.in);

    @Override
    public double[][] readMatrixCoefficients(int n) {
        Scanner in = new Scanner(System.in);
        double[][] a = new double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("a(" + (i + 1) + ", " + (j + 1) + "): ");
                a[i][j] = in.nextDouble();
            }
        }
        return a;

    }

    @Override
    public double[] readFreeCoefficients(int n) {
        double[] b = new double[n];
        for (int i = 0; i < n; i++) {
            System.out.print("b(" + (i + 1) + "): ");
            b[i] = in.nextDouble();
        }
        return b;
    }

    @Override
    public int readMatrixSize() {
        System.out.print("n: ");
        int n = in.nextInt();
        if (n <= 0) throw new RuntimeException("N must be greater than 0");
        return n;
    }


}
