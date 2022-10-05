import java.util.Scanner;

public class Main {

    public static int getNumberOfMaxParam(int a, int b, int c) {
        int[] number = {a, b, c};
        int max = 0;
        int maxindex = 0;
        for(int i = 0 ; i < number.length ; i++){
            if(max < number[i]){
                max = number[i];
                maxindex = i+1;
            }
        }
        return maxindex;
        // write a body here
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        final int a = scanner.nextInt();
        final int b = scanner.nextInt();
        final int c = scanner.nextInt();

        System.out.println(getNumberOfMaxParam(a, b, c));
    }

}