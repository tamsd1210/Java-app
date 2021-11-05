import java.util.*;

public class LuckyNumber {
    public static void main(String[] args) {
        play();
        report();
    }
    public static void play() {
        Random rand = new Random();
        int LuckyNum = rand.nextInt(100) + 1;
        System.out.println();

        int x, yourNum;
        Scanner input = new Scanner(System.in);
        System.out.println("Chào mừng bạn đến với trò chơi đoán số ngẫu nhiên từ 0 đến 100.");
        System.out.println("************");

        for (x = 1; x < 100; x++) {
            System.out.print("Số bạn dự đoán là: ");
            yourNum = input.nextInt();

            if (yourNum > LuckyNum) {
                System.out.println("Số may mắn nhỏ hơn số bạn dự đoán.");
            } else if (yourNum < LuckyNum) {
                System.out.println("Số may mắn lớn hơn số bạn dự đoán.");
            } else {
                System.out.println("Chúc mừng Bạn đã đoán đúng ở lượt chơi thứ " + x + ".");
                System.out.println("************");
                break;
                }
            }
        }
    public static void report() {
        int totalGame = 1;
        // chưa đặt được biểu thức nên set tạm = 1;
        int totalGuesses = 1;
        int avgGuessGame = totalGuesses/totalGame;
        // chưa đặt được biểu th71c nên set tạm =0;
        int bestGame = 0;

        do {
            Scanner input = new Scanner(System.in);
            System.out.print("Bạn có muốn đoán số tiếp không? ");
            String playAgain = input.next();

                if (playAgain.equals("y") || playAgain.equals("Y") || playAgain.equals("yes") || playAgain.equals("YES")) {
                play();
                } else if (playAgain.equals("n") || playAgain.equals("N") || playAgain.equals("NO") || playAgain.equals("No")) {
                System.out.println("\nKết quả trò chơi:");
                break;
                }
                totalGame++;
                } while (totalGame <= 100);
                System.out.println("************");
                System.out.println("Tổng số lần chơi = " + totalGame);

                // các kết quả 3 dòng sau chưa chính xác.
                System.out.println("Tổng số lượt đoán = " +totalGuesses);
                System.out.println("Số dự đoán trung bình mỗi lần chơi = " + avgGuessGame);
                System.out.println("Lần chơi có lượt dự đoán ít nhất = " + bestGame);
    }
}