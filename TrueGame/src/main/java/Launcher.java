import java.io.IOException;
import java.util.Scanner;

public class Launcher {
    public static String playerName1 = "Player1";
    public static String playerName2 = "Player2";
    public static int[][] battleField1 = new int[10][10];
    public static int[][] battleField2 = new int[10][10];
    public static int[][] battleMonitor1 = new int[10][10];
    public static int[][] battleMonitor2 = new int[10][10];
    public static Scanner scanner = new Scanner(System.in);
    public static boolean firstPlayerTurn = true;

    public static void main(String[] args) throws IOException,InterruptedException {
        System.out.println();
        System.out.println(playerName1 + " " + playerName2 + "  Battle Pussy");
        System.out.println();
        System.out.println("  0 1 2 3 4 5 6 7 8 9");
        for (int i = 0; i < 10; i++) {
            System.out.println(i + " * * * * * * * * * *");

        }
    }
}