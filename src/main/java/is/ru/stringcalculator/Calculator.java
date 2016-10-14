package is.ru.stringcalculator;

public class Calculator {
    public static int add(String str) throws Exception {
        if(str.isEmpty())
            return 0;

        String delim = "";
        if(str.startsWith("//")){
            delim = str.substring(2, str.indexOf("\n"));
            str = str.substring(str.indexOf("\n") + 1, str.length());
        }
        String nums[] = splitString(str, delim);
        String msg = findNeg(nums);
        if(!msg.isEmpty())
            throw new Exception(msg);
        return sum(nums);
    }

    private static int toInt(String str) { return Integer.parseInt(str); }

    private static String[] splitString(String str, String delim){
        return str.split("[,\\n" + delim + "]");
    }

    private static int sum(String[] nums){
        int sum = 0;
        for(int i = 0; i < nums.length; i++)
            if(toInt(nums[i]) <= 1000)
                sum += toInt(nums[i]);
        return sum;
    }

    private static boolean isNeg(String str) { return toInt(str) < 0; }

    private static String findNeg(String[] nums){
        boolean first = true;
        String msg = "";
        for(int i = 0; i < nums.length; i++){
            if(isNeg(nums[i])){
                if(first){
                    msg += "Negatives not allowed: " + nums[i];
                    first = false;
                }
                else
                    msg += "," + nums[i];
            }
        }
        return msg;
    }
}
