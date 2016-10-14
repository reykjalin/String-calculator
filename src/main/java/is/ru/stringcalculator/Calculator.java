package is.ru.stringcalculator;

public class Calculator {
    public static int add(String str){
        if(str.isEmpty())
            return 0;

        String nums[] = str.split(",");
        int sum = 0;
        for(int i = 0; i < nums.length; i++)
            sum += toInt(nums[i]);
        return sum;
    }

    private static int toInt(String str) { return Integer.parseInt(str); }
}
