import java.io.*;
import java.util.ArrayList;

public class SimpleDotComGame{
    public static void main(String[] args){
        int numOfGuesses = 0;
        GameHelper helper = new GameHelper();
        SimpleDotCom theDotCom = new SimpleDotCom();
        int randomNum =(int) (Math.random()*5);
        ArrayList<Interger>locations= new ArrayList<Interger>();
        locations.add(randomNum);
        locations.add(randomNum+1);
        locations.add(randomNum+2);
        theDotCom.setLocatinCells(locations);
        boolean isAlive = true;
        while(isAlive == true) {
            String guess = helper.getUserInput("enter a number");
            String result = theDotCom.checkYourself(guess); //输入空字符时parseInt会报错
            numOfGuesses ++;
            if(result.equals("kill")) {
                isAlive = false;
                System.out.println("You took" + numOfGuesses + "guesses");
            }
        }
    }
}