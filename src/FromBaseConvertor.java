public class FromBaseConvertor {
    public static void base_convertor(String[] base_text, int base_length){
        String base = "0123456789ABCDEF".substring(0, base_length);
        int [] int_array = Tools.base_string_array_to_decimal_array(base_text, base);
        for (int j : int_array) {
            char c = (char) j;
            System.out.print(c);
        }
        System.out.println();
    }
}