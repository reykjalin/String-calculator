package is.ru.stringcalculator;

public class Calculator {
    public static int add(String numbers) throws Exception {
        if(numbers.isEmpty())
            return 0;
        else{
            String delim = getDelim(numbers);
            if(!delim.isEmpty())
                numbers = removeDelim(numbers);

            String msg = hasNegative(numbers, delim);
            if(msg.isEmpty()){
                return getSum(numbers, delim);
            }
            else
                throw new Exception(msg);
        }
    }

    private static int toInt(String str) { return Integer.parseInt(str); }

    private static int getSum(String str, String customDelim) {
        String numbers[] = str.split("[," + customDelim + "\\n]");
        int sum = 0;
        for(int i = 0; i < numbers.length; i++){
            if(toInt(numbers[i]) <= 1000)
                sum += toInt(numbers[i]);
        }
        return sum;
    }

    private static String hasNegative(String str, String customDelim){
        String msg = "Negatives not allowed: ";
        boolean hasNeg = false;

        String numbers[] = str.split("[,\\n" + customDelim + "]");
        for(int i = 0; i < numbers.length; i++){
            if(toInt(numbers[i]) < 0){
                msg += numbers[i] + ",";
                hasNeg = true;
            }
        }

        if(hasNeg)
            return msg.substring(0, msg.length() - 1);
        return "";
    }

    private static boolean hasNewLine(String str) { return hasDelim(str, "\n"); }

    private static boolean hasDelim(String str, String delim) { return str.contains(delim); }

    private static String getDelim(String str) {
        if(str.startsWith("//")){
            return str.substring(2, str.indexOf("\n"));
        }
        return "";
    }

    private static String removeDelim(String str) {
        return str.substring(str.indexOf("\n") + 1, str.length());
    }
}
