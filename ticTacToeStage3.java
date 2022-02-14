import java.util.*;

class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static StringBuilder[] field;

    public static void main(String[] args) {
        field = createField();
        String input = scanner.nextLine();
        field = fillingGrid(input);
        printField();
        findWinner(input);
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

    private static void findWinner(String input) {
        System.out.println("X wins");
        System.out.println("O wins");
        System.out.println("Draw");
        System.out.println("Game not finished");
        System.out.println("Impossible");
    }

}
