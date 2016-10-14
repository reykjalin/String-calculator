package is.ru.stringcalculator;

public class Calculator {
    public static int add(String str){
        if(str.isEmpty())
            return 0;
        else
            return toInt(str);
    }

    private static int toInt(String str) { return Integer.parseInt(str); }
}
