public class Subset implements Validator {
    protected Cell[] c;

    public Subset() {
        c = new Cell[9];
    }
    
    @Override
    public boolean isValid() {
        // --- Part A ---
		
		// Description:
		// This method returns true if the subset (represented by c) 
		// contains 1-9 exactly once.
        int tally = 0;
        for (int i = 0; i < c.length; i++){
            for (int j = 1; j < 10; j++){
                if (c[i].getValue() == j){
                    tally++;
                    break;
                }
            }
        }
        if (tally == 9)
            return true;
        else
            return false;
    }

    public boolean[] markings() {
		// --- Part A ---
		
		// Description: 
		// This method returns a boolean array of size 10, say a, where
		// a[i] is true if the subset does not contain i.
		
		// Explanation:
		// a[i] represents whether number represented by index i can be marked.
		// e.g., if a[2] is true, then it means the number 2 can be marked
		// by the player.
        boolean[] markingBoolean = new boolean[10];
        for (int i = 0; i < markingBoolean.length; i++){
            for (int j = 0; j < c.length; j++) {
                if (c[j].getValue() == i) {
                    markingBoolean[i] = false;
                    break;
                }
                else {
                    markingBoolean[i] = true;
                }
            }
        }
        return markingBoolean;
    }

    public boolean conflict(int n) {
        // --- Part A ---
		
		// Description:
		// This method returns true if the subset (represented by c) contains n.
        boolean conflictBoolean = false;
        for (int i = 1; i < c.length; i++){
            if (c[i].getValue() == n){
                conflictBoolean = true;
                break;
            }
        }
        return conflictBoolean;
    }

}
