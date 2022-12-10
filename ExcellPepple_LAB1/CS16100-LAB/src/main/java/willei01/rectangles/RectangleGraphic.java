package willei01.rectangles;

import java.io.File;
import java.util.Scanner;

public class RectangleGraphic {
    public static void main(String[] args) {
        try {
            File file = new File("rectangles.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                int rows = scanner.nextInt();
                int cols = scanner.nextInt();
                String filled = scanner.next();
                boolean isFilled;
                if (filled.compareToIgnoreCase("filled") != 0) {
                    isFilled = false;
                } else {
                    isFilled = true;
                }

                Rectangle rectangle = new Rectangle(rows, cols, isFilled);
                System.out.println(rectangle);
                System.out.println();

            }
            scanner.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
