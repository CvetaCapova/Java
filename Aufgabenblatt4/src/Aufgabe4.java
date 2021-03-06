/*
    Aufgabe 4) Rekursion mit Strings
*/
public class Aufgabe4 {

    private static String insertCharValue(String text) {
        // TODO: Implementieren Sie hier Ihre Lösung für die Methode
        assert text != null && text.length() >= 0;
        if (text.length() > 0) {
            return insertCharValue(text.substring(0, text.length() - 1)) + "(" + (int) (text.charAt(text.length() - 1)) + text.charAt(text.length() - 1) + ")";
        } else {
            return text;
        }
    }

    private static String removeCharsInString(String text) {
        if (text.length() > 0) {
            if (text.length() == 1) {
                return ""; //entfernt das erste Buchstabe; text.charAt(0)
            } else if (text.charAt(text.length() - 1) == text.charAt(0)) {
                return removeCharsInString(text.substring(0, text.length() - 1));

            } else {
                return removeCharsInString(text.substring(0, text.length() - 1)) + text.charAt(text.length() - 1);

            }

        } else {

            return text;
        }

    }

    private static String shiftMaxCharRight(String text) {
        // TODO: Implementieren Sie hier Ihre Lösung für die Methode
        if (text.length() > 1) {
            String textNew = shiftMaxCharRight(text.substring(1)); //text bleibt unverändert, wir verändern nur textNew
            if (text.charAt(0) > textNew.charAt(textNew.length()-1)) {
                return text.substring(1) + text.charAt(0); //größtes Buchstabe am Ende
            } else {
                return text.charAt(0)+textNew; //textNew- der String, der neu organisiert ist

            }

        } else {
            return text;

        }
    }

    public static void main(String[] args) {
        System.out.println(insertCharValue("hallo"));
        System.out.println(insertCharValue("a!"));
        System.out.println(insertCharValue("Ein Test"));
        System.out.println();

        System.out.println(removeCharsInString("testtrompete"));
        System.out.println(removeCharsInString("test"));
        System.out.println(removeCharsInString("t"));
        System.out.println(removeCharsInString("angabe"));
        System.out.println();

        System.out.println(shiftMaxCharRight("acmbwxdzfjdk"));
        System.out.println(shiftMaxCharRight(""));
        System.out.println(shiftMaxCharRight("za"));
        System.out.println(shiftMaxCharRight("a"));
        System.out.println(shiftMaxCharRight("habcdefg"));

        assert (insertCharValue("hallo").equals("(104h)(97a)(108l)(108l)(111o)"));
        assert (insertCharValue("a!").equals("(97a)(33!)"));
        assert (insertCharValue("Ein Test").equals("(69E)(105i)(110n)(32 )(84T)(101e)(115s)(116t)"));

        assert (removeCharsInString("testtrompete").equals("esrompee"));
        assert (removeCharsInString("test").equals("es"));
        assert (removeCharsInString("t").equals(""));
        assert (removeCharsInString("angabe").equals("ngbe"));

        assert (shiftMaxCharRight("acmbwxdzfjdk").equals("acmbwxdfjdkz"));
        assert (shiftMaxCharRight("").equals(""));
        assert (shiftMaxCharRight("za").equals("az"));
        assert (shiftMaxCharRight("a").equals("a"));
        assert (shiftMaxCharRight("habcdefg").equals("abcdefgh"));
    }
}
