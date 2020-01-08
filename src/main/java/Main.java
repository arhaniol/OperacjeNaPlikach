import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] arg) {
        System.out.println("Task 1:");
        task1();
    }

    private static void task1() {
        Scanner input = new Scanner(System.in);
        String filePath,
                line;
        boolean isEnd;
        FileWriter fileWriter = null;
        System.out.print("Wprowadz ścieżkę do pliku: ");
        filePath = input.nextLine();

        try {
            fileWriter = new FileWriter(filePath);
            System.out.println("Wprowadz kilka linijek teksu (aby zakończyć wprowadz '-')");
            do {
                line = input.nextLine();
                isEnd = !line.equals("-");
                if (isEnd) {
                    fileWriter.write(line + System.lineSeparator());
                }
            } while (isEnd);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
