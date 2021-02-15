package io;

import linearSystem.LinearSystem;


public interface LinearSystemWriter {
    void printInfo(String s);
    void printMatrix(double[][] a, double[] b);
    void printX(LinearSystem linearSystem);
    void printDiscrepancy(LinearSystem linearSystem);
}
