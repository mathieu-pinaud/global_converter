import java.util.Scanner;

public class ParamHandler {
    public String base;
    public String text;
    public int[] possible_bases;

    public ParamHandler (String[] raw_param, Scanner keyb){
        if (raw_param.length == 2){
            if (check_base(raw_param[0]) != -1 && check_text(raw_param[1])){
                this.base = raw_param[0];
                this.text = raw_param[1];
            } else {
                this.base = get_base(keyb);
                this.text = get_text(keyb);
            }
        } else {
            this.base = get_base(keyb);
            this.text = get_text(keyb);
        }
        check_textbase(this.text);
    }

    public void check_textbase(String text) {
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
        this.possible_bases = base_list;
    }


    public static int check_base(String test_base){

        String[] good_bases = {"octale", "-o", "hexadecimal", "-h", "binaire", "-b", "decimal", "-d", "texte", "-t"};
        for (int i = 0; i < good_bases.length; i += 1)
            if (test_base.equals(good_bases[i]))
                return (i);
        return (-1);
    }

    public static boolean check_text(String test_text){

        String valid_char = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ 1234567890";
        for (int i = 0; i < test_text.length(); i += 1)
            if (valid_char.indexOf(test_text.charAt(i)) == -1)
                return (false);
        return (true);
    }

    public static String get_text(Scanner keyb){
        System.out.println("entrez le texte a convertir");
        String new_text = keyb.nextLine();
        if (check_text(new_text))
            return (new_text);
        System.out.println("Saisie incorrecte");
        return (get_text(keyb));
    }

    public static String get_base(Scanner keyb){
        System.out.println("Entrez une base correcte : octale (-o), binaire (-b), hexadecimal (-h), decimal (-d),texte (-t)");
        String new_base = keyb.nextLine();
        if (check_base(new_base) != -1)
            return (new_base);
        System.out.println("Saisie incorrecte");
        return (get_base(keyb));
    }

}