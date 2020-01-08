import java.io.*;
import java.nio.file.NoSuchFileException;
import java.util.Scanner;

public class Main {
    public static void main(String[] arg) {
        System.out.println("Task 1:");
        task1();
        System.out.println("Task 2:");
        task2();
        System.out.println("Task 3:");
        task3();
        System.out.println("Task 4:");
        task4();
    }

    private static void task4() {
        Scanner input = new Scanner(System.in);
        String filePath;
        int day,
                year,
                month;

        System.out.print("Podaj ścieżkę do czytaneto pliku: ");
        filePath = input.nextLine();

        try (DataInputStream inputStream = new DataInputStream(new FileInputStream(filePath))) {
            year = inputStream.readInt();
            month = inputStream.readInt();
            day = inputStream.readInt();

            System.out.println(String.format("Urodzony: %d-%d-%d", day, month, year));
        } catch (NoSuchFileException e) {
            System.out.println("Niepoprawna scieżka!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void task3() {
        Scanner input = new Scanner(System.in);
        String filePath;
        int day,
                month,
                year;

        System.out.print("Podaj ścieżkę do pliku: ");
        filePath = input.nextLine();
        try (DataOutputStream outputStream = new DataOutputStream(new FileOutputStream(filePath))) {
            System.out.print("Podaj rok urodzenia: ");
            year = input.nextInt();
            System.out.print("Podaj miesiąc urodzenia: ");
            month = input.nextInt();
            System.out.print("Podaj dzień urodzenia: ");
            day = input.nextInt();

            outputStream.writeInt(year);
            outputStream.writeInt(month);
            outputStream.writeInt(day);
        } catch (FileNotFoundException e) {
            System.out.println("Niepoprawna scieżka!");
        } catch (IOException e) {
            e.printStackTrace();
        }
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
