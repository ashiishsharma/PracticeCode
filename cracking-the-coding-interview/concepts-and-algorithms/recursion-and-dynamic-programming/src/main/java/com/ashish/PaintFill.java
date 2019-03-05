package com.ashish;

public class PaintFill {

    enum Color {Black, White, Red, Yellow, Green}

    public boolean paintFill(Color[][] screen, int row, int column, Color newColor) {
        if (screen[row][column] == newColor) {
            return false;
        }
        return paintFill(screen, row, column, screen[row][column], newColor);
    }

    private boolean paintFill(Color[][] screen, int row, int column, Color oldColor, Color newColor) {
        if (row < 0 || row >= screen.length || column < 0 || column >= screen[0].length) {
            return false;
        }
        if (screen[row][column] == oldColor) {
            screen[row][column] = newColor;
            paintFill(screen, row - 1, column, oldColor, newColor);// up
            paintFill(screen, row + 1, column, oldColor, newColor);// down
            paintFill(screen, row, column - 1, oldColor, newColor);// left
            paintFill(screen, row, column + 1, oldColor, newColor);// right
        }
        return true;
    }
}


