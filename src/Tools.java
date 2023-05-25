public class Tools {
    public static int[] string_to_decimal_array(String text) {
        int[] decimal_string = new int[text.length()];
        for (int i = 0; i < text.length(); i += 1)
            decimal_string[i] = text.charAt(i);
        return decimal_string;
    }

    public static String reverse_string(String to_rev) {
        String res = "";
        for (int i = to_rev.length() - 1; i >= 0; i -=1)
            res += to_rev.charAt(i);
        return res;
    }

    public static String[] decimal_array_to_base_string_array(int[] ints, String base) {
        String[] res = new String[ints.length];
        int base_length = base.length();
        int j = 0;
        for (int i: ints){
            String tmp = "";
            while (i > 0) {
                tmp += base.charAt(i % base_length);
                i = (i - (i % base_length)) / base_length;
            }

            res[j] = reverse_string(tmp);
            j += 1;
        }
        return res;
    }

    public static int compute_power(int to_compute, int power) {
        int res = 1;
        for (int i = 0; i < power; i += 1)
            res *= to_compute;
        return res;
    }

    public static int[] base_string_array_to_decimal_array(String[] text, String base) {
        int[] res = new int[text.length];
        int base_length = base.length();

        for (int i = 0; i < text.length; i+=1) {
            int power= 0;
            for (int j = text[i].length() - 1; j >= 0; j -= 1) {
                    res[i] += (text[i].charAt(j) - '0') * compute_power(base_length, power);
                    power += 1;
            }
        }
        return res;
    }

    public static boolean is_int_valid(int i){
        return (i > '0' && i < '9') || (i > 'A' && i < 'Z') || (i > 'a' && i < 'z') || i == ' ';
    }
}