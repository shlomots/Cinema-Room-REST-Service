import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // start coding here
        String outputPrefix = "You have chosen a";
        switch(scanner.nextInt()){
            
            case 1:
                System.out.println(outputPrefix + " square");
                break;

            case 2:
                System.out.println(outputPrefix + " circle");
                break;

            case 3:
                System.out.println(outputPrefix + " triangle");
                break;

            case 4:
                System.out.println(outputPrefix + " rhombus");
                break;

            default:
                System.out.println("There is no such shape!");
        }
    }
}
