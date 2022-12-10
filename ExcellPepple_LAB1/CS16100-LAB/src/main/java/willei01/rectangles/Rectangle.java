package willei01.rectangles;

public class Rectangle {
    private int cols;
    private int rows;
    private boolean filled;

    public Rectangle(int rows, int cols, boolean filled) {
        this.cols = cols;
        this.rows = rows;
        this.filled = filled;
        System.out.println("Rectangle;");
    }


    public String toString() {
        if (this.filled){
            for (int i = 0 ; i < rows; i++) {
                System.out.print("#");
                for (int j = 0; j < cols - 1; j++) {
                    System.out.print("#");
                }
                System.out.println();
            }
        } else {
            for (int i = 0; i < rows; i++) {
                System.out.print("#");
                for (int j = 0; j < cols ; j++) {

                    if (i == 0 || i == cols - 1 || i==rows-1 || j==cols-1) {
                        System.out.print("#");
                    }
                    else{
                        System.out.print(" ");
                    }
                }
                System.out.println();
            }
        }
        return "";
    }
}
