import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static StringBuilder[] field;
    private static StringBuilder inputWithGrid = new StringBuilder("         ");
    private static int numOfUser = 0;
    private static String resultOfGame = "";

    public static void main(String[] args) {
        field = createField(); // создаем поле
        fillingGrid(String.valueOf(inputWithGrid));
        printField(); // печатаем поле

        do {
            userInput();
        } while (checkGameNotFinished(String.valueOf(inputWithGrid)));
        //пока
        System.out.println(resultOfGame);
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

    private static void printField() {
        for (StringBuilder str : field)
            System.out.println(str);
    }

    private static void userInput() {
        System.out.print("Enter the coordinates: ");
        String coordinates = scanner.nextLine();

        if (coordinates.length() < 3) {
            System.out.println("You should enter numbers!");
            userInput();
            return;
        }
        if (!Character.isDigit(coordinates.charAt(0)) || !Character.isDigit(coordinates.charAt(2))) {
            System.out.println("You should enter numbers!");
            userInput();
            return;
        }
        String strRow = String.valueOf(coordinates.charAt(0));
        String strColumn = String.valueOf(coordinates.charAt(2));
        int row = Integer.parseInt(strRow);
        int column = Integer.parseInt(strColumn);

        if (row > 3 || column > 3 || row < 1 || column < 0) {
            System.out.println("Coordinates should be from 1 to 3!");
            userInput();
            return;
        }

        int indexStr = 0, countIndex = 0;

        for (int i = 1; i < 4; i++) {
            for (int k = 1; k < 4; k++) {
                if (row == i && column == k) {
                    indexStr = countIndex;
                    break;
                }
                countIndex++;
            }
        }

        if (inputWithGrid.charAt(indexStr) != ' ') {
            System.out.println("This cell is occupied! Choose another one!");
            userInput();
        } else if (numOfUser == 0) {
            inputWithGrid.replace(indexStr, ++indexStr, "X");
            numOfUser++;
            fillingGrid(String.valueOf(inputWithGrid));
            printField();
        } else {
            inputWithGrid.replace(indexStr, ++indexStr, "O");
            numOfUser = 0;
            fillingGrid(String.valueOf(inputWithGrid));
            printField();
        }
    }

    private static StringBuilder[] fillingGrid(String input) {
        String[] gird = input.split("");
        field[1].replace(1, 8, " " + gird[0] + " " + gird[1] + " " + gird[2] + " ");
        field[2].replace(1, 8, " " + gird[3] + " " + gird[4] + " " + gird[5] + " ");
        field[3].replace(1, 8, " " + gird[6] + " " + gird[7] + " " + gird[8] + " ");
        return field;
    }

    // игра не закончена, пока чек возвращает true
    private static boolean checkGameNotFinished(String input) {
        // return true пока в строке есть пробелы и findWinner возвращает true
        if (!input.contains(" ") && !findWinner(String.valueOf(inputWithGrid))) {
            return false;
        } else if (!input.contains(" ") && findWinner(String.valueOf(inputWithGrid))) {
            resultOfGame = " Draw";
            return false;
        } else return true;
    }

    private static boolean findWinner(String input) {
        StringBuilder res = new StringBuilder();
        // horizontal
        if (input.charAt(0) == input.charAt(1) && input.charAt(1) == input.charAt(2)) {
            if (input.charAt(0) == 'X') {
                res.append("X wins");
            } else if
            (input.charAt(0) == 'O') {
                res.append("O wins");
            }
        } else if (input.charAt(3) == input.charAt(4) && input.charAt(4) == input.charAt(5)) {
            if (input.charAt(3) == 'X') {
                res.append("X wins");
            } else if (input.charAt(3) == 'O')
                res.append("O wins");
        } else if (input.charAt(6) == input.charAt(7) && input.charAt(7) == input.charAt(8)) {
            if (input.charAt(6) == 'X') {
                res.append("X wins");
            } else if (input.charAt(6) == 'O') res.append("O wins");
        }

        // verticals
        if (input.charAt(0) == input.charAt(3) && input.charAt(3) == input.charAt(6)) {
            if (input.charAt(0) == 'X') {
                res.append("X wins");
            } else if (input.charAt(0) == 'O') res.append("O wins");
        }
        if (input.charAt(1) == input.charAt(4) && input.charAt(4) == input.charAt(7)) {
            if (input.charAt(1) == 'X') {
                res.append("X wins");
            } else if (input.charAt(1) == 'O') res.append("O wins");
        }
        if (input.charAt(2) == input.charAt(5) && input.charAt(5) == input.charAt(8)) {
            if (input.charAt(2) == 'X') {
                res.append("X wins");
            } else if (input.charAt(2) == 'O') res.append("O wins");
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
        if (res.toString().contains("X") && !res.toString().contains("O")) {
            resultOfGame = "X wins";
            return false;
        } else if (!res.toString().contains("X") && res.toString().contains("O")) {
            resultOfGame = "O wins";
            return false;
        } else if (res.toString().contains("X") && res.toString().contains("O")) {
            resultOfGame = "Draw";
            return false;
        } else if (res.length() > 6 && !inputWithGrid.toString().contains(" ")) {
            resultOfGame = "Draw";
            return false;
        } else if (res.length() > 1) {
            resultOfGame = String.valueOf(res);
            return false;
        } else return true;
    }
}
