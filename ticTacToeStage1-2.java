import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static StringBuilder[] field;

    public static void main(String[] args) {
        field = createField();
        field = fillingGrid(scanner.nextLine());
        printField();
    }

    static StringBuilder[] createField() {
        StringBuilder[] field = new StringBuilder[5];
        for (int i = 0; i < field.length; i++) {
            field[i] = new StringBuilder();
            field[i].append("---------");
        }

        for (int i = 1; i < 4; i++) {
            field[i].setCharAt(0, '|');
            field[i].setCharAt(8, '|');
        }
        return field;
    }

    private static StringBuilder[] fillingGrid(String input) {
        System.out.println("Enter cells: " + input);
        String[] gird = input.split("");
        field[1].replace(1, 8, " " + gird[0] + " " + gird[1] + " " + gird[2] + " ");
        field[2].replace(1, 8, " " + gird[3] + " " + gird[4] + " " + gird[5] + " ");
        field[3].replace(1, 8, " " + gird[6] + " " + gird[7] + " " + gird[8] + " ");
        return field;
    }

    static void printField() {
        for (StringBuilder str : field)
            System.out.println(str);
    }
}
