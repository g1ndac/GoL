/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
        if         ((i == 0 && j == 0)
                || (i == 0 && j == (dim - 1))
                || ((i == dim - 1) && (j == dim - 1))
                || (i == (dim - 1) && j == 0)) {
            
        }
    }

    public static void main(String[] args) {

        Engine en = new Engine(10);
        int[] values = {1};
        en.setValues(values);
        en.printField();
        en.setValue(10);
        en.printField();

    }

}
