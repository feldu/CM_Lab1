package io;

import java.io.IOException;

public interface LinearSystemReader {
    double[][] readMatrixCoefficients(int n) throws IOException;
    double[] readFreeCoefficients(int n);
    int readMatrixSize();
}
