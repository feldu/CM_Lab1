package io;

import linearSystem.LinearSystem;


public class LinearSystemConsoleWriter implements LinearSystemWriter {
    @Override
    public void printInfo(String s) {
        System.out.println(s);
    }

    @Override
    public void printMatrix(double[][] a, double[] b) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                System.out.printf("%.2f ", a[i][j]);
            }
            System.out.printf("| %.2f \n", b[i]);
        }
    }

    @Override
    public void printX(LinearSystem linearSystem) {
        System.out.println("Корни: ");
        for (int i = 0; i < linearSystem.getX().length; i++) {
            System.out.printf("x(%d)=%.4f\n", i, linearSystem.getX()[i]);
        }
    }

    @Override
    public void printDiscrepancy(LinearSystem linearSystem) {
        double[] r = linearSystem.findDiscrepancy();
        System.out.println("Невязка: ");
        for (int i = 0; i < r.length; i++) {
            System.out.printf("r(%d)=%.1e\n", i, r[i]);
        }
    }
}
