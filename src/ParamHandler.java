import java.util.Scanner;

public class ParamHandler {
    public int base;
    public String text;
    public int text_base = -1;

    public int text_base_length;

    public ParamHandler (String[] raw_param, Scanner keyb){
        if (raw_param.length == 2){
            if (check_base(raw_param[0]) != -1 && check_text(raw_param[1])){
                this.base = check_base(raw_param[0]);
                this.text = raw_param[1];
            } else {
                set_base(keyb);
                set_text(keyb);
            }
        } else {
            set_base(keyb);
            set_text(keyb);
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
        last_verif(base_list);
    }

    public void set_text_base_length(int base_nb) {
        int[] base_length = {2, 8, 10, 16, -1};
        this.text_base_length = base_length[base_nb];

    }

    public void last_verif(int[] base_list) {
        String[] my_tab = this.text.split(" ");
        int[] base_length = {2, 8, 10, 16, -1};
        String base = "0123456789ABCDEF";
        for (int i = 0; i < 4; i += 1) {
            if (base_list[i] == 1) {
                int[] tmp = Tools.base_string_array_to_decimal_array(my_tab, base.substring(0, base_length[i]));
                for (int j : tmp)
                    if (!Tools.is_int_valid(j)) {
                        base_list[i] = 0;
                        break;
                    }
            }
        }
        for (int i = 0; i < 5; i +=1) {
            if (base_list[i] == 1) {
                this.text_base = i;
                break;
            }
        }
        if (this.text_base == -1){
            System.out.println("Le texte a traduire ne correspond a aucune base viable");
            return;
        }
        set_text_base_length(this.text_base);
        if (this.base == this.text_base)
            System.out.println(this.text);
        else if (this.text_base == 4)
            FromTextConvertor.text_convertor(this.text, base_length[this.base]);
        else {
            FromBaseConvertor.base_convertor(my_tab, this.text_base_length);
        }
    }

    public static int check_base(String test_base){

        String[] good_bases = {"binaire", "octale", "decimal", "hexadecimal", "texte", "-b", "-o", "-d", "-h", "-t"};
        for (int i = 0; i < good_bases.length; i += 1)
            if (test_base.equals(good_bases[i]))
                return (i % 5);
        return (-1);
    }

    public static boolean check_text(String test_text){

        String valid_char = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ 1234567890";
        for (int i = 0; i < test_text.length(); i += 1)
            if (valid_char.indexOf(test_text.charAt(i)) == -1)
                return (false);
        return (true);
    }

    public void set_text(Scanner keyb){
        System.out.println("entrez le texte a convertir");
        String new_text = keyb.nextLine();
        if (check_text(new_text)) {
            this.text = new_text;
            return;
        }
        System.out.println("Saisie incorrecte");
        set_text(keyb);
    }

    public void set_base(Scanner keyb){
        System.out.println("Entrez une base correcte : octale (-o), binaire (-b), hexadecimal (-h), decimal (-d),texte (-t)");
        String new_base = keyb.nextLine();
        if (check_base(new_base) != -1) {
            this.base = check_base(new_base);
            return;
        }
        System.out.println("Saisie incorrecte");
        set_base(keyb);
    }

}