import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static StringBuilder[] field;

    public static void main(String[] args) {
        field = createField(); // создаем поле
        String input = scanner.nextLine(); // ввод строки с содержимым поля
        field = fillingGrid(input); // заполняем поле
        printField(); // печатаем поле
        String findWinner = findWinner(input); // ищем победителя, запоминаем, если он есть

        boolean impossible = checkImpossible(input, findWinner); // проверяем, возможна ли введенная ситуация
        boolean gameNotFinished = checkGameNotFinished(input);
        if (impossible) System.out.println("Impossible");
        else if (!findWinner.contains("wins") && !gameNotFinished)
            System.out.println("Draw"); // проверка на ничью
        else if (!findWinner.contains("wins") && gameNotFinished)
            System.out.println("Game not finished"); // проверка на завершенность игры
        else System.out.println(findWinner);
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

    private static boolean checkImpossible(String input, String findWinner) {
        // impossible
        int countX = 0, countO = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == 'X') {
                countX++;
            }
            if (input.charAt(i) == 'O') {
                countO++;
            }
        }
        if (countO - countX > 1 || countX - countO > 1) {
            return true;
        }
        return findWinner.contains("X wins") && findWinner.contains("O wins");
    }

    private static boolean checkGameNotFinished(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '_') {
                return true;
            }
        }
        return false;
    }

    private static String findWinner(String input) {
        StringBuilder res = new StringBuilder();
        // horizontal
        if (input.charAt(0) == input.charAt(1) && input.charAt(1) == input.charAt(2)) {
            if (input.charAt(0) == 'X') {
                res.append("X wins");
            } else res.append("O wins");
        } else if (input.charAt(3) == input.charAt(4) && input.charAt(4) == input.charAt(5)) {
            if (input.charAt(3) == 'X') {
                res.append("X wins");
            } else res.append("O wins");
        } else if (input.charAt(6) == input.charAt(7) && input.charAt(7) == input.charAt(8)) {
            if (input.charAt(6) == 'X') {
                res.append("X wins");
            } else res.append("O wins");
        }

        // verticals
        if (input.charAt(0) == input.charAt(3) && input.charAt(3) == input.charAt(6)) {
            if (input.charAt(0) == 'X') {
                res.append("X wins");
            } else res.append("O wins");
        }
        if (input.charAt(1) == input.charAt(4) && input.charAt(4) == input.charAt(7)) {
            if (input.charAt(1) == 'X') {
                res.append("X wins");
            } else res.append("O wins");
        }
        if (input.charAt(2) == input.charAt(5) && input.charAt(5) == input.charAt(8)) {
            if (input.charAt(2) == 'X') {
                res.append("X wins");
            } else res.append("O wins");
        }

        // diagonals
        if ((input.charAt(0) == input.charAt(4) && input.charAt(4) == input.charAt(8)) ||
                (input.charAt(2) == input.charAt(4) && input.charAt(4) == input.charAt(6))) {
            if (input.charAt(4) == 'X') {
                res.append("X wins");
            }
            if (input.charAt(4) == 'O') {
                res.append("O wins");
            }
        }
        return res.toString();
    }

}
