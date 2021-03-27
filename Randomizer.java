import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;


public class Randomizer {

    
    public static void main(String[] args) {

        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;
        
        List<RandomNumber> numbers = new ArrayList<RandomNumber>();
        
        Random rn = new Random();

        try {

        for (int i = 0; i < 100; i++) {
            int randomNum = 0;
            
            randomNum = rn.nextInt(max) + min;
            if (randomNum < 0) {
                
                int nextRandomNum = rn.nextInt(max) + min;
                RandomNumber number = new RandomNumber(nextRandomNum);
                numbers.add(number);
        
            }
            RandomNumber number = new RandomNumber(randomNum);
            numbers.add(number);
        }

        } catch(IllegalArgumentException e) {
            System.out.println("Illegal Arguement Exception: " + e.getMessage());
            
        }
        
        try {
            Collections.sort(numbers);
        } catch (ClassCastException e) {
            System.out.println("Class Cast Exception: " + e.getMessage());
        } catch(UnsupportedOperationException e) {
            System.out.println("UnsupportedOperationException: " + e.getMessage());
        } catch(IllegalArgumentException e) {
            System.out.println("Illegal Arguement Exception: " + e.getMessage());
        }
        
        for (int i = 0; i < numbers.size(); i++) {
            
            System.out.println(numbers.get(i).getNum());
        }

    }


    public int compareTo(Object o) {
        return 0;
    }

    

}

class RandomNumber extends Randomizer implements Comparable {
    
    private int num = 0;

    public int getNum() {
        return this.num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public RandomNumber() {
        super();
    }

    public RandomNumber(int num) {
        super();
        this.num = num;
    } 

    
    public int compareTo(RandomNumber rn) {
        if(this.num == rn.num) {
            return 0;
        } else if (this.num > rn.num) {
            return 1;
        } else {
            return -1;
        }

    }

   
    
    // public int compareTo(Object o) {
    //     return 0;
    // }
    
}