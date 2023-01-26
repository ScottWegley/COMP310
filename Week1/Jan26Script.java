package Week1;

import java.util.Arrays;

class Jan26Script {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(median2(1, 2, 3));
        System.out.println(System.currentTimeMillis() - start);
    }

    //Recorded runtime of 5 ms
    public static int median(int x, int y, int z){
        int[] inputs = {x,y,z};
        Arrays.sort(inputs);
        return inputs[1];
    }

    //Recorded runtime of 1 ms 
    public static int median2(int x, int y, int z){
        int max = Math.max(Math.max(x,y), z);
        int min = Math.min(Math.min(x,y), z);
        int[] inputs = {x,y,z};
        for (int i : inputs) {
            if(i != max && i != min) return i;
        }
        return -1;
    }
}