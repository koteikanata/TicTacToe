
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static StringBuilder[] field;
    private static StringBuilder inputWithGrid;

    public static void main(String[] args) {
        field = createField(); // создаем поле
        inputWithGrid = new StringBuilder(scanner.nextLine()); // ввод строки с содержимым поля
        field = fillingGrid(String.valueOf(inputWithGrid)); // заполняем поле
        printField(); // печатаем поле
        userInput();
        field = fillingGrid(String.valueOf(inputWithGrid)); // заполняем поле новой строкой
        printField(); // печатаем новое поле
    }

    static StringBuilder[] createField() {
        StringBuilder[] field = new StringBuilder[5];

        for (int i = 0; i < field.length; i++) {
            field[i] = new StringBuilder();
            field[i].append("         ");
        }
        field[0].replace(0, 8, "---------");
        field[4].replace(0, 8, "---------");

        for (int i = 1; i < 4; i++) {
            field[i].setCharAt(0, '|');
            field[i].setCharAt(8, '|');
        }
        return field;
    }

    private static StringBuilder[] fillingGrid(String input) {
        System.out.println("Enter cells: " + input);
        String[] gird = input.replaceAll("_", " ").split("");
        field[1].replace(1, 8, " " + gird[0] + " " + gird[1] + " " + gird[2] + " ");
        field[2].replace(1, 8, " " + gird[3] + " " + gird[4] + " " + gird[5] + " ");
        field[3].replace(1, 8, " " + gird[6] + " " + gird[7] + " " + gird[8] + " ");

        return field;
    }

    private static void printField() {
        for (StringBuilder str : field)
            System.out.println(str);
    }

    private static void userInput() {
        System.out.print("Enter the coordinates: ");
        String coordinates = scanner.nextLine().trim();

        if (!Character.isDigit(coordinates.charAt(0)) || !Character.isDigit(coordinates.charAt(2))) {
            System.out.println("You should enter numbers!");
            userInput();
            return;
        }
        String strRow = String.valueOf(coordinates.charAt(0));
        String strColumn = String.valueOf(coordinates.charAt(2));
        int row = Integer.parseInt(strRow);
        int column = Integer.parseInt(strColumn);

        if (row > 3 || column > 3) {
            System.out.println("Coordinates should be from 1 to 3!");
            userInput();
            return;
        }

        int indexStr = 0, count = 0;

        for (int i = 1; i < 4; i++) {
            for (int k = 1; k < 4; k++) {
                if (row == i && column == k) {
                    indexStr = count;
                    break;
                }
                count++;
            }
        }

        if (inputWithGrid.charAt(indexStr) != '_') {
            System.out.println("This cell is occupied! Choose another one!");
            userInput();
        } else inputWithGrid.replace(indexStr, ++indexStr, "X");
    }

}
