package GoL.framework;

import java.util.Arrays;

/**
 *
 * @author Andrei
 */
public class Engine {

    private byte[][] currentField;
    private byte[][] nextField;
    private int dim;

    public Engine(int dim) {
        currentField = new byte[dim][dim];
        nextField = new byte[dim][dim];
        this.dim = dim;

    }

    public void setValues(int[] coord) {
        for (int i = 0; i < coord.length; i++) {
            currentField[coord[i] % dim][coord[i] / dim] = 1;
        }
    }

    public void setValue(int coord) {
        currentField[coord % dim][coord / dim] = 1;
    }

    public void printField() {

        for (int i = 0; i < dim; i++) {
            System.out.println();
            for (int j = 0; j < dim; j++) {
                System.out.printf("%d   ", currentField[j][i]);
            }
        }
        System.out.println();
        System.out.println();
    }

    public byte neighbourCount(int i, int j) {
        byte count = 0;
        if (i == 0 && j == 0) {
            if (currentField[i + 1][j] == 1) {
                count++;
            }
            if (currentField[i][j + 1] == 1) {
                count++;
            }
            if (currentField[i + 1][j + 1] == 1) {
                count++;
            }
        } else if (i == 0 && j == (dim - 1)) {
            if (currentField[i][j - 1] == 1) {
                count++;
            }
            if (currentField[i + 1][j - 1] == 1) {
                count++;
            }
            if (currentField[i + 1][j] == 1) {
                count++;
            }

        } else if ((i == dim - 1) && (j == dim - 1)) {
            if (currentField[i - 1][j - 1] == 1) {
                count++;
            }
            if (currentField[i - 1][j] == 1) {
                count++;
            }
            if (currentField[i][j - 1] == 1) {
                count++;
            }
        } else if (i == (dim - 1) && j == 0) {
            if (currentField[i - 1][j] == 1) {
                count++;
            }
            if (currentField[i - i][j + 1] == 1) {
                count++;
            }
            if (currentField[i][j + 1] == 1) {
                count++;
            }
        } else if (i == 0 && j > 0 && j < (dim - 1)) {
            if (currentField[i][j - 1] == 1) {
                count++;
            }
            if (currentField[i][j + 1] == 1) {
                count++;
            }
            if (currentField[i + 1][j + 1] == 1) {
                count++;
            }
            if (currentField[i + 1][j] == 1) {
                count++;
            }
            if (currentField[i + 1][j - 1] == 1) {
                count++;
            }
        } else if (i == (dim - 1) && j > 0 && j < (dim - 1)) {
            if (currentField[i][j - 1] == 1) {
                count++;
            }
            if (currentField[i][j + 1] == 1) {
                count++;
            }
            if (currentField[i - 1][j + 1] == 1) {
                count++;
            }
            if (currentField[i - 1][j] == 1) {
                count++;
            }
            if (currentField[i - 1][j - 1] == 1) {
                count++;
            }
        } else if (j == 0 && i > 0 && i < (dim - 1)) {
            if (currentField[i - 1][j] == 1) {
                count++;
            }
            if (currentField[i + 1][j] == 1) {
                count++;
            }
            if (currentField[i - 1][j + 1] == 1) {
                count++;
            }
            if (currentField[i][j + 1] == 1) {
                count++;
            }
            if (currentField[i + 1][j + 1] == 1) {
                count++;
            }
        } else if (j == (dim - 1) && i > 0 && i < (dim - 1)) {
            if (currentField[i - 1][j] == 1) {
                count++;
            }
            if (currentField[i + 1][j] == 1) {
                count++;
            }
            if (currentField[i - 1][j - 1] == 1) {
                count++;
            }
            if (currentField[i][j - 1] == 1) {
                count++;
            }
            if (currentField[i + 1][j - 1] == 1) {
                count++;
            }
        } else {
            if (currentField[i - 1][j - 1] == 1) {
                count++;
            }
            if (currentField[i - 1][j] == 1) {
                count++;
            }
            if (currentField[i - 1][j + 1] == 1) {
                count++;
            }
            if (currentField[i][j + 1] == 1) {
                count++;
            }
            if (currentField[i + 1][j + 1] == 1) {
                count++;
            }
            if (currentField[i + 1][j] == 1) {
                count++;
            }
            if (currentField[i + 1][j - 1] == 1) {
                count++;
            }
            if (currentField[i][j - 1] == 1) {
                count++;
            }

        }

        return count;
    }

    public void setStatus(int i, int j) {
        if (neighbourCount(i, j) <= 1) {
            nextField[i][j] = 0;
        } else if (neighbourCount(i, j) == 2 && currentField[i][j] == 1) {
            nextField[i][j] = 1;
        } else if (neighbourCount(i, j) == 3) {
            nextField[i][j] = 1;
        } else if (neighbourCount(i, j) > 3) {
            nextField[i][j] = 0;
        }
    }

    public void oneTurn() {
        int i, j;
        for (i = 0; i < dim; i++) {
            for (j = 0; j < dim; j++) {
                setStatus(i, j);
            }
        }
        currentField = nextField;
        printField();

    }

    public static void main(String[] args) {

        Engine en = new Engine(10);
        int[] values = {2,7,13,21,23,94,95,66,71,8,1,45,46,55,31,34,66,56};
        en.setValues(values);
        en.printField();
        en.oneTurn();
        en.oneTurn();
        en.oneTurn();
        en.oneTurn();
        en.oneTurn();
        en.oneTurn();
        en.oneTurn();
        en.oneTurn();
        en.oneTurn();
        en.oneTurn();

    }

}
