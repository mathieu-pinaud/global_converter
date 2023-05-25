public class FromTextConvertor {
    public static void text_convertor(String texte, int base_length) {
        String base = "0123456789ABCDEF".substring(0, base_length);
        int[] int_text = Tools.string_to_decimal_array(texte);
        String[] res = Tools.decimal_array_to_base_string_array(int_text, base);
        for (String s : res) {
            System.out.print(s + " ");
        }
        System.out.println();
    }

}