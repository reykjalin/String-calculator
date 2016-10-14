package is.ru.stringcalculator;

public class Calculator {
    public static int add(String str){
        if(str.isEmpty())
            return 0;
        else
            return Integer.parseInt(str);
    }
}
