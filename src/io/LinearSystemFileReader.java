package io;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * Reading file format:
 *
 *      n
 *      a(1,1) a(1,2) a(1,3) | b(1)
 *      a(2,1) a(2,2) a(2,3) | b(2)
 *      a(3,1) a(3,2) a(3,3) | b(3)
 *
 *
 */
public class LinearSystemFileReader implements LinearSystemReader {
    private final List<String> lines;

    public LinearSystemFileReader(String FILE_NAME) throws IOException {
        lines = Files.readAllLines(Paths.get(FILE_NAME), StandardCharsets.UTF_8);
    }

    @Override
    public int readMatrixSize() {
        return Integer.parseInt(lines.get(0).trim());
    }

    @Override
    public double[][] readMatrixCoefficients(int n) {
        double[][] a = new double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = Double.parseDouble(lines.get(i + 1).split(" +")[j]);
            }
        }
        return a;
    }

    @Override
    public double[] readFreeCoefficients(int n) {
        double[] b = new double[n];
        for (int i = 0; i < n; i++) {
            b[i] = Double.parseDouble(lines.get(i + 1).split(" +")[lines.get(i + 1).split(" +").length - 1]);
        }
        return b;
    }
}
