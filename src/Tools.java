public class Tools {
    public static int[] check_base(String text) {
        int[] base_list = {1, 1, 1, 1, 1};
        String base = "0123456789ABCDEF";
        for (int i = 0; i < text.length(); i += 1) {
            if (text.charAt(i) != ' ') {
                int verif = base.indexOf(text.charAt(i));
                if (verif > 1 || verif == -1)
                    base_list[0] = 0;
                if (verif > 7 || verif == -1)
                    base_list[1] = 0;
                if (verif > 9 || verif == -1)
                    base_list[2] = 0;
                if (verif == -1)
                    base_list[3] = 0;
            }
        }
        return (base_list);
    }
}