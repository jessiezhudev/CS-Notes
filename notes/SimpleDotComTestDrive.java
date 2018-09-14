public class SimpleDotComTestDrive{
    public static void main (String[] args) {
        SimpleDotCom dot = new SimpleDotCom();
        int[] locations = {2,3,4};
        dot.setLocationCells(locations);
        String userGuess = "2";
        String result = dot.checkYourself(userGuess);
    }
    public class SimpleDotCom {
        int numOfHits = 0;
        int[] locationCells;
        public void setLocationCells(int[] locs) {
            locationCells = locs;
        }
        public String checkYourself(String stringGuess) {
            int guess = Integer.parseInt(stringGuess);
            String result = "miss";
            for (int cell: locationCells) {
                if (guess == cell) {
                    result = "hit";
                    numOfHits++;
                    break;
                }
            }
            if(numOfHits == locationCells.length) {
                result = "kill";
            }
            // System.out.printIn(result);
            return result;
        }
    }
}

