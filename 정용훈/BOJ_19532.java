import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_19532 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        Equation one = new Equation(
                Integer.parseInt(st.nextToken()),
                Integer.parseInt(st.nextToken()),
                Integer.parseInt(st.nextToken()));

        Equation theOther = new Equation(
                Integer.parseInt(st.nextToken()),
                Integer.parseInt(st.nextToken()),
                Integer.parseInt(st.nextToken()));

        findSolution(one, theOther);

    }

    private static void findSolution(Equation one, Equation theOther) {
        for (int x = -999; x <= 999; x++) {
            for (int y = -999; y <= 999; y++) {
                if (one.isSatisfied(x, y)) {
                    if (theOther.isSatisfied(x, y)) {
                        System.out.printf("%d %d\n", x, y);
                        return;
                    }
                }
            }
        }
    }

    static class Equation {
        int xCoefficient;
        int yCoefficient;
        int constant;

        public Equation(int xCoefficient, int yCoefficient, int constant) {
            this.xCoefficient = xCoefficient;
            this.yCoefficient = yCoefficient;
            this.constant = constant;
        }

        public boolean isSatisfied(int x, int y) {
            return x * xCoefficient + y * yCoefficient == constant;
        }
    }
}
