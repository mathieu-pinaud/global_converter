import java.util.Scanner;

public class ParamHandler {
    public String base;
    public String text;

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