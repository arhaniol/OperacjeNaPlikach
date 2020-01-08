import java.io.*;
import java.nio.file.NoSuchFileException;
import java.util.Scanner;

public class Main {
    public static void main(String[] arg) {
        System.out.println("Task 1:");
        task1();
        System.out.println("Task 2:");
        task2();
    }

    private static void task2() {
        BufferedReader fileReader = null;
        String filePath,
                line;
        Scanner input = new Scanner(System.in);
        int count = 0;

        System.out.print("Podaj scieżkę pliku do odczytu: ");
        filePath = input.nextLine();

        try {
            fileReader = new BufferedReader(new FileReader(filePath));
            do {
                line = fileReader.readLine();
                if (line != null) {
                    count++;
                }
            } while (line != null);
            System.out.println("Przyczytano " + count + " linijek tekstu.");
        } catch (FileNotFoundException e) {
            System.out.println("Nieprawidłowa ścieżka :(");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
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
        } catch (FileNotFoundException e) {
            System.out.println("Nie wprowadzono scieżki :(");
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
