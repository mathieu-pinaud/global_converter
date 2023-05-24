import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        ParamHandler good_params = new ParamHandler(args, keyboard);
        System.out.println(good_params.text);
        System.out.println(good_params.base);

        for (int i: Tools.string_to_decimal_array(good_params.text))
            System.out.print(i + " ");
        System.out.println(" ");
        String[] test_darray_to_stringbase = Tools.decimal_array_to_base_string_array(Tools.string_to_decimal_array(good_params.text), "01234567");
        for (int i = 0; i < test_darray_to_stringbase.length; i+= 1)
            System.out.print(test_darray_to_stringbase[i] + ' ');
        System.out.println(" ");
        int[] test_string_base_todarray = Tools.base_string_array_to_decimal_array(test_darray_to_stringbase, "01234567");
        for (int i : test_string_base_todarray)
            System.out.print(i + " ");
    }
}