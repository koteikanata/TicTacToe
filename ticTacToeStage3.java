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
            field[i].append("--_-_-_--");

        }
        field[0].replace(0, 9, "---------");
        field[4].replace(0, 9, "---------");

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
        // horizontal
        if (input.charAt(0) == input.charAt(1) && input.charAt(1) == input.charAt(2)) {
            if (input.charAt(0) == 'X') {
                System.out.println("X wins");
            } else System.out.println("O wins");
        } else if (input.charAt(3) == input.charAt(4) && input.charAt(4) == input.charAt(5)) {
            if (input.charAt(3) == 'X') {
                System.out.println("X wins");
            } else System.out.println("O wins");
        } else if (input.charAt(6) == input.charAt(7) && input.charAt(7) == input.charAt(8)) {
            if (input.charAt(6) == 'X') {
                System.out.println("X wins");
            } else System.out.println("O wins");
            return;
        }
        // verticals
        else if (input.charAt(0) == input.charAt(3) && input.charAt(3) == input.charAt(6)) {
            if (input.charAt(0) == 'X') {
                System.out.println("X wins");
            } else System.out.println("O wins");
        } else if (input.charAt(1) == input.charAt(4) && input.charAt(4) == input.charAt(7)) {
            if (input.charAt(1) == 'X') {
                System.out.println("X wins");
            } else System.out.println("O wins");
        } else if (input.charAt(2) == input.charAt(5) && input.charAt(5) == input.charAt(8)) {
            if (input.charAt(2) == 'X') {
                System.out.println("X wins");
            } else System.out.println("O wins");
            return;
        }

        // diagonals
        else if ((input.charAt(0) == input.charAt(4) && input.charAt(4) == input.charAt(8)) ||
                (input.charAt(2) == input.charAt(4) && input.charAt(4) == input.charAt(6))) {
            if (input.charAt(4) == 'X') {
                System.out.println("X wins");
            } else {
                System.out.println("O wins");
            }
            return;
        }

        // game not finished
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == ' ') {
                System.out.println("Game not finished");
                return;
            }
        }

        // draw
        System.out.println("Draw");
        
        // impossible


    }

}
