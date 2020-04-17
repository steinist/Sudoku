import java.io.*;
import java.util.Scanner;

public class IO {
    private FileWriter out;
    private PrintWriter bOutput;
    private File file;

    public IO() throws IOException {

    }

    public void write(String address, Board b) throws IOException {
        // --- Part B ---

		// Description:
		// This method is for writing the game data to a file (i.e., Export function).
		// There are three parts of Sudoku that you need to save:
		// 1. value
		// 2. solution
		// 3. given

		// Hint:
		// Use getBoard(), getValue(), getSolution(), and getGiven() methods
        file = new File (address);
        bOutput = new PrintWriter(file);

        Cell[][] cells = new Cell[9][9];
        int[][] values = new int[9][9];
        boolean[][] givens = new boolean[9][9];
        int[][] solutions = new int[9][9];

        for (int i = 0; i < 9; i++){
            for (int j = 0; j < 9; j++){
                cells[i][j] = b.getBoard()[i][j];
                    }
                }

        for (int i = 0; i < 9; i++){
            for (int j = 0; j < 9; j++){
                solutions[i][j] = b.getSolution()[i][j];

                givens[i][j] = cells[i][j].getGiven();

                values[i][j] = cells[i][j].getValue();
            }
        }


        for (int i = 0; i < 9; i++){
            for (int j = 0; j < 9; j++){
                bOutput.println(values[i][j]);

                bOutput.println(givens[i][j]);

                bOutput.println(solutions[i][j]);

            }
        }


        bOutput.close();
    }

    public Board read(String address) throws IOException {
        // --- Part B ---

		// Description:
		// This method is for reading the game data from a file (i.e., Import function).
		// Read all the data you have saved, i.e., value, solution, and given,
		// and construct a Board object using constructor of Board.

        // This method returns the constructed Board object.
        file = new File(address);
        Scanner sc = new Scanner(file);


        int[][] values = new int[9][9];
        boolean[][] givens = new boolean[9][9];
        int[][] solutions = new int[9][9];

        for (int i = 0; i < 9; i++){
            for (int j = 0; j < 9; j++){
                int loadValues = sc.nextInt();
                values[i][j] = loadValues;

                boolean loadGivens = sc.nextBoolean();
                givens[i][j] = loadGivens;

                int loadSolutions = sc.nextInt();
                solutions[i][j] = loadSolutions;
            }
        }

        sc.close();

        Board board = new Board(values, solutions, givens);

        return board;
    }
}
