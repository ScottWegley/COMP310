package Week1;

import java.util.Arrays;

class Jan26Script {
    static int comps = 0;

    public static void main(String[] args) {
        double avg = 0;
        int best = 10;
        int worst = 0;
        long start = System.currentTimeMillis();
        double n = 10000000;
        for (int i = 0; i < n; ++i) {
            int x = (int) (Math.random() * 10);
            int y = (int) (Math.random() * 10);
            int z = (int) (Math.random() * 10);
            int m = median4(x, y, z);
            if (comps < best)
                best = comps;
            if (comps > worst)
                worst = comps;
            avg += comps;
            comps = 0;
            // System.out.println("X:" + x + " Y: " + y + " Z:" + z + " M:" + m);
        }
        System.out.println("Time: " + (System.currentTimeMillis() - start));
        System.out.println("Comps: " + avg / n);
        System.out.println("Best: " + best);
        System.out.println("Worst: " + worst);
    }

    // Not in the spirit of the assignment.
    public static int median(int x, int y, int z) {
        int[] inputs = { x, y, z };
        Arrays.sort(inputs);
        return inputs[1];
    }

    // Avg comps: 4.83999 Time: 13542
    public static int median2(int x, int y, int z) {
        int max = Math.max(Math.max(x, y), z);
        int min = Math.min(Math.min(x, y), z);
        int[] inputs = { x, y, z };
        int save = 0;
        for (int i : inputs) {
            comps += 2;
            if (i != max && i != min) {
                return i;
            } else {
                save = i;
            }
        }
        comps++;
        return (save == max ? max : min);
    }

    /*
     * public static int median3(int x, int y, int z){
     * 
     * }
     */

    // Avg comps: 2.714 Time: 11650
    public static int median4(int a, int b, int c) {
        comps += 1;
        if (a > b) {
            comps += 1;
            if (a < c) {
                return a;
            } else {
                comps += 1;
                if (b > c) {
                    return b;
                } else {
                    return c;
                }
            }
        } else {
            comps += 1;
            if (a > c) {
                return a;
            } else {
                comps += 1;
                if (b < c) {
                    return b;
                } else {
                    return c;
                }
            }
        }
    }
}