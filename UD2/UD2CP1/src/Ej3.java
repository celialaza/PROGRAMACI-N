import java.util.Scanner;

public class Ej3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num;
        do{
            System.out.println("Introduce un número: ");
            num = sc.nextInt();
        } while (num<1);
        sc.close();
    }
}
