package is.ru.stringcalculator;

public class Calculator {
    public static int add(String str) throws Exception {
        if(str.isEmpty())
            return 0;

        String nums[] = splitString(str);
        boolean first = true;
        String msg = "";
        for(int i = 0; i < nums.length; i++){
            if(toInt(nums[i]) < 0){
                if(first){
                    msg += "Negatives not allowed: " + nums[i];
                    first = false;
                }
                else
                    msg += "," + nums[i];
            }
        }
        if(!msg.isEmpty())
            throw new Exception(msg);
        return sum(nums);
    }

    private static int toInt(String str) { return Integer.parseInt(str); }

    private static String[] splitString(String str){
        return str.split("[,\\n]");
    }

    private static int sum(String[] nums){
        int sum = 0;
        for(int i = 0; i < nums.length; i++)
            sum += toInt(nums[i]);
        return sum;
    }
}
