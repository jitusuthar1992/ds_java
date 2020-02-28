package main.java1.java7Features;

/**
 * @author jitendra.kumar01
 * 01/01/20
 */
public class StringSupportedInSwitch {
    public static void main(String[] args)
    {
        System.out.println(getExpendedMessage("one"));
        System.out.println(getExpendedMessage("three"));
        System.out.println(getExpendedMessage("five"));
    }

    static String getExpendedMessage(final String token)
    {
        String value = null;

        switch (token)
        {
            case ("one"):
                value = "Token one identified";
                break;

            case ("two"):
                value = "Token two identified";
                break;

            case ("three"):
                value = "Token three identified";
                break;

            case ("four"):
                value = "Token four identified";
                break;

            default:
                value = "No token was identified";
        }

        return value;
    }
}
