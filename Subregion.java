// --- Part A ---

// Create the Subregion class according to the details given in the UML class diagram.
// i.e., https://course.cse.ust.hk/comp1022p/assignments/pa2/image/uml.jpg

// The implementation of Subregion class should be very similar to the Row class.
public class Subregion extends Subset {
    public Subregion(Cell[][] matrix, int locX, int locY) {
        for (int k = 0, i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++, k++) {
                c[k] = matrix[locX * 3 + j][locY * 3 + i];

                c[k].setSubregion(this);
            }
        }
    }
}