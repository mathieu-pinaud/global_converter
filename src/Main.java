import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        ParamHandler good_params = new ParamHandler(args, keyboard);
        System.out.println(good_params.text);
        System.out.println(good_params.base);
        for (int i : Tools.check_base(good_params.text))
            System.out.println(i);
        keyboard.close();
    }
}