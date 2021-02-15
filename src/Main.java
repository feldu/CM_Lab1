import io.*;
import linearSystem.LinearSystem;
import methods.GaussMethodWithSelection;
import methods.SolvingMethod;

import java.io.IOException;
import java.util.InputMismatchException;

public class Main {
    private static LinearSystemReader in;
    private static LinearSystemWriter out;
    private static SolvingMethod method;

    public static void main(String[] args) {
        try {
            configure(args);
            int n = in.readMatrixSize();
            LinearSystem linearSystem = new LinearSystem(n, in.readMatrixCoefficients(n), in.readFreeCoefficients(n));
            method.solve(linearSystem);
            out.printX(linearSystem);
            out.printDiscrepancy(linearSystem);
        } catch (InputMismatchException e) {
            System.err.println("Неверный формат");
        } catch (IOException e) {
            System.err.println("Не удалось прочитать из файла");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Неверный формат файла. Требуемый формат (пример, для n=3): ");
            System.err.println("n\n" +
                    "a(1,1) a(1,2) a(1,3) | b(1)\n" +
                    "a(2,1) a(2,2) a(2,3) | b(2)\n" +
                    "a(3,1) a(3,2) a(3,3) | b(3)");
        } catch (RuntimeException e) {
            System.err.println(e.getMessage());
        }
    }

    private static void configure(String[] args) throws IOException {
        if (args.length == 0) {
            in = new LinearSystemConsoleReader();
        }
        else if (args.length == 1) {
            in = new LinearSystemFileReader(args[0]);
        }
        out = new LinearSystemConsoleWriter();
        method = new GaussMethodWithSelection(out);
    }
}
