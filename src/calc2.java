import java.util.Scanner;

public class calc2 {
    public static void main(String[] args) throws Exception {
        System.out.println("");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        System.out.println(parse(str));
    }

    static String parse(String str) throws Exception {
        int a=0;
        int b=0;
        boolean isRim;
        String zn;
        String res;
        str=str.replace(" ", "");
        String[] znak = str.split("[+\\-*/]");
        if (znak.length != 2) throw new Exception("Oshibka");
        zn = detectoper(str);
        if (zn == null) throw new Exception("Oshibka");
        if (Roman.isRim(znak[0]) && Roman.isRim(znak[1])) {
            a = Roman.convertToArabian(znak[0]);
            b = Roman.convertToArabian(znak[1]);
            isRim = true;
        }  else if (!Roman.isRim(znak[0]) && !Roman.isRim(znak[1])) {
            a = Integer.parseInt(znak[0]);
            b = Integer.parseInt(znak[1]);
            isRim = false;
        }
        else {throw new Exception("Oshibka");}
        if  (a > 10 || b > 10) {
            throw new Exception("Oshibka");
        }
        int arab = calc(a, b, zn);
        if (isRim) {
            if (arab <= 0) {
                throw new Exception("Oshibka");
            }

            res = Roman.convertToRoman(arab);
        } else {
            res = String.valueOf(arab);
        }
        return res;
    }

    static String detectoper(String str) {
        if (str.contains("+")) return "+";
        else if (str.contains("-")) return "-";
        else if (str.contains("/")) return "/";
        else if (str.contains("*")) return "*";
        else return null;

    }

    static int calc(int a, int b, String zn) {
        if (zn.equals("+")) return a + b;
        else if (zn.equals("-")) return a - b;
        else if (zn.equals("*")) return a * b;
        else return  a / b;

    }
}

class Roma {
    static String[] RimArray = new String[]{"0", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI",
            "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX", "XXI", "XXII", "XXIII", "XXIV",
            "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI",
            "XXXVII", "XXXVIII", "XXXIX", "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII",
            "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX", "LXI", "LXII",
            "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX", "LXXI", "LXXII", "LXXIII", "LXXIV",
            "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX", "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV",
            "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII",
            "XCVIII", "XCIX", "C"};


    public static boolean isRim(String val) {
        for (int i = 0; i < RimArray.length; i++) {
            if (val.equals(RimArray[i])) {
                return true;
            }
        }
        return false;
    }


    public static int convertToArabian(String roman) {
        for (int i = 0; i < RimArray.length; i++) {
            if (roman.equals(RimArray[i])) {
                return i;
            }
        }
        return -1;
    }

    public static String convertToRoman(int arab) {
        return RimArray[arab];
    }
}
