Steps:
1. init game. To point where Dot Com should locate.
2. start game. Let the player guess. If true, add 1 to a variable.
3. end game until the variable equals to 3.
   
class Game {

}

### 编写程序
开发类通常的经验：
1. 找出类应该做的事情
2. 列出实例变量和方法
3. 编写方法的伪代码
4. 编写方法的测试用程序
5. 实现类
6. 测试方法
7. 除错或重新设计

public class SimpleDotComTestDrive{
    public static void main (String[] args) {
        SimpleDotCom dot = new SimpleDotCom();
        int[] locations = {2,3,4};
        dot.setLocationCells(locations);
        String userGuess = "2";
        String result = dot.checkYourself(userGuess);
        String testResult = "failed";
        if (result.equals("hit")) {
            testResult = "passed"
        }
        System.out.printIn(testResult);
    }
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
    System.out.printIn(result);
    return result;
}

正式程序的伪代码

DECLARE an int variable -> numberOfHits
DECLARE a method to let the player guess while numberOfHits < Total
DECLARE a method to locate the cell

DECLARE an int variable to hold the number of user guesses, named numOfGuesses, set it to 0;
MAKE a new SimpleDotCom instance
COMPUTE a random number between 0 and 4 that will be the starting location cell position.
MAKE an int array with 3 ints using the randomly-generated number, that number incremented by 1, and taht number incremented by 2(example 3,4,5)
INVOKE the setLocationCells() method on the SimpleDotCom instance
DECLARE a boolean variable representign the state of the game, named isAlive, set it to true
while the dot com is still alive
    get user input from the command line
    invoke the checkYourself method on the SimpleDotCom instance
    INCREMENT numOfGuesses variable
    if result is kill
        set isAlive to kill
        print the number of user guesses
        