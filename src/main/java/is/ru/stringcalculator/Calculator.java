package is.ru.stringcalculator;

public class Calculator {
    public static int add(String str) throws Exception {
        if(str.isEmpty())
            return 0;
        else{
            String delim = getDelim(str);
            if(!delim.isEmpty())
                str = removeDelim(str);

            String nums[] = splitString(str, delim);
            String msg = findNeg(nums);
            if(msg.isEmpty())
                return getSum(nums);
            throw new Exception(msg);
        }
    }

    private static int toInt(String str) { return Integer.parseInt(str); }

    private static int getSum(String[] nums){
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            int num = toInt(nums[i]);
            if(num <= 1000)
                sum += num;
        }
        return sum;
    }

    private static String[] splitString(String str, String delim){
        return str.split("[,\\n" + delim + "]");
    }
    
    private static String findNeg(String[] nums){
        String msg = "Negatives not allowed: ";
        boolean hasNeg = false;

        for(int i = 0; i < nums.length; i++){
            if(isNeg(nums[i])){
                msg += nums[i] + ",";
                hasNeg = true;
            }
        }

        if(hasNeg)
            return msg.substring(0, msg.length() - 1);
        return "";
    }

    private static boolean isNeg(String str){ return toInt(str) < 0; }

    private static String getDelim(String str){
        if(str.startsWith("//")){
            return str.substring(2, str.indexOf("\n"));
        }
        return "";
    }

    private static String removeDelim(String str){
        return str.substring(str.indexOf("\n") + 1, str.length());
    }
}
