package randomwalkgraph;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author andrewtaylor
 */
public class PascalsTriangle {
    private List<List<Integer>> pascalsTriangle;
    
    public PascalsTriangle() {
        pascalsTriangle = new ArrayList<>();
        generate(1);
    }
    
    public PascalsTriangle(int numRows) { 
        pascalsTriangle = new ArrayList<>();
        generate(numRows >= 1 ? numRows : 1);
    }
    
    public void generate(int numRows) { 
        for (int i = 0; i < numRows; i++) 
            generateRow();
    }
    
    public void generateRow() {
        List<Integer> row = new ArrayList<>();
            
        if (pascalsTriangle.isEmpty())
            row.add(1);
        else if (pascalsTriangle.size() == 1) {
            row.add(1);
            row.add(1);
        }
        else {
            List<Integer> previousRow = pascalsTriangle.get(pascalsTriangle.size() - 1);
            for (int j = 0; j < previousRow.size() + 1; j++) {
                if (j == 0)
                    row.add(1);
                else if (j == previousRow.size())
                    row.add(1);
                else
                    row.add(previousRow.get(j-1) + previousRow.get(j));
            }
        }
        pascalsTriangle.add(row);
    }
    
    public List<List<Integer>> getPascalsTriangle() {
        return pascalsTriangle;
    }
    
    public List<Integer> getRow(int row) {
        if (row >= 0 && row < pascalsTriangle.size())
            return pascalsTriangle.get(row);
        
        return null;
    }
    
    public double getProbability(int numSteps, int distanceTravelled) {
        List<Integer> row = getRow(numSteps);
        
        double prob = -1;
        
        if (row != null) { 
            for (int i = 0; i < numSteps; i++) {
                int x = numSteps - (i * 2);

                if ((x == distanceTravelled) || (x == -1 * distanceTravelled))
                    prob = ((double) row.get(i)) / Math.pow(2, numSteps);
            }
        }
        
        return prob;
    }
    
    @Override
    public String toString() {
        String s = "";
        for (List<Integer> row : pascalsTriangle) 
            s += row.toString() + "\n";
        return s;
    }
}
