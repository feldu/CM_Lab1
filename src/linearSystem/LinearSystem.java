package linearSystem;

public class LinearSystem {
    private int n;
    private double[][] a;
    private double[] b;
    private double[] x;

    public LinearSystem(int n, double[][] a, double[] b) {
        this.n = n;
        this.a = a;
        this.b = b;
        x = new double[n];
    }

    public double[] findDiscrepancy() {
        double[] r = new double[a.length];
        double sum;
        for (int i = 0; i < a.length; i++) {
            sum = 0;
            for (int j = 0; j < a[i].length; j++) {
                sum = sum + a[i][j] * x[j];
            }
            r[i] = sum - b[i];
        }
        return r;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public double[][] getA() {
        return a;
    }

    public void setA(double[][] a) {
        this.a = a;
    }

    public double[] getB() {
        return b;
    }

    public void setB(double[] b) {
        this.b = b;
    }

    public double[] getX() {
        return x;
    }

    public void setX(double[] x) {
        this.x = x;
    }
}
