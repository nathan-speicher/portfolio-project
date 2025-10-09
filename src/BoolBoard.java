import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

public class BoolBoard {
    private int rows;
    private int cols;
    private boolean[][] board;

    // Default constructor
    public BoolBoard() {
        this.rows = 0;
        this.cols = 0;
        this.board = new boolean[this.rows][this.cols];
    }

    // Parameterized constructor
    public BoolBoard(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.board = new boolean[rows][cols];
    }

    //gets the value at a specific position
    public boolean get(int row, int col) {
        return this.board[row][col];
    }

    //sets the value at a specific position
    public void set(int row, int col, boolean value) {
        this.board[row][col] = value;
    }

    //returns number of rows
    public int getRowCount() {
        return this.rows;
    }

    //returns number of columns
    public int getColCount() {
        return this.cols;
    }

    //clears the board by setting all values to false
    public void clear() {
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.cols; j++) {
                this.board[i][j] = false;
            }
        }
    }

    //toggles the value at a specific position
    public void toggle(int row, int col) {
        this.board[row][col] = !this.board[row][col];
    }

    //counts the number of true values in the board
    public int countTrue() {
        int count = 0;
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.cols; j++) {
                if (this.board[i][j]) {
                    count++;
                }
            }
        }
        return count;
    }

    //fills a rectangular area with a specific boolean value
    public void fill(int startRow, int startCol, int endRow, int endCol,
            boolean value) {
        for (int i = startRow; i <= endRow; i++) {
            for (int j = startCol; j <= endCol; j++) {
                this.board[i][j] = value;
            }
        }
    }

    //prints the board to the console
    public void print() {
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.cols; j++) {
                System.out.print(this.board[i][j] ? "T " : "F ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        SimpleReader in = new SimpleReader1L();
        SimpleWriter out = new SimpleWriter1L();

        // Example usage
        BoolBoard bb = new BoolBoard(5, 5);
        bb.print();
        out.println();

        bb.set(2, 2, true);
        bb.print();
        out.println();

        bb.toggle(1, 1);
        bb.print();
        out.println();

        bb.fill(0, 0, 1, 1, true);
        bb.print();
        out.println("Number of true values: " + bb.countTrue());
        out.println();

        bb.clear();
        bb.print();
        out.println("Number of true values: " + bb.countTrue());
        out.println();

        in.close();
        out.close();
    }
}
