import java.io.*;
import java.util.ArrayList;
public class SimpleDotCom {
    // int numOfHits = 0;
    // int[] locationCells;
    private ArrayList<Interger> locationCells;
    // public void setLocatinCells(int[] locs) {
    public void setLocatinCells(ArrayList<Interger> loc) {
        locationCells = locs;
    }
    public String checkYourself(String stringGuess) {
        int guess = Integer.parseInt(stringGuess);
        String result = "miss";
        int index = locationCells.indexOf(guess);
        if(index>0) {
            locationCells.remove(index);
            if(locationCells.isEmpty()) {
                result = "kill";
            }else{
                result = "hit";
            }
        }
        // for (int cell: locationCells) {
        //     if (guess == cell) {
        //         result = "hit";
        //         numOfHits++;
        //         break;
        //     }
        // }
        // if(numOfHits == locationCells.length) {
        //     result = "kill";
        // }
        System.out.println(result);
        return result;
    }
}