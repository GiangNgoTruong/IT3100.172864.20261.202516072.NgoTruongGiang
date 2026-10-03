import javax.swing.JOptionPane;

public class Month{
    public static void main(String[] args) {
        int month = -1;
        int year = -1;

        while (true) {
            String monthInput = JOptionPane.showInputDialog(
                "Enter month (full name, 3-letter abbreviation, or number 1-12):"
            );
            if (monthInput == null) {
                System.exit(0);
            }
            month = parseMonth(monthInput.trim());

            String yearInput = JOptionPane.showInputDialog(
                "Enter year: "
            );
            if (yearInput == null) {
                System.exit(0);
            }
            year = parseYear(yearInput.trim());
            if (month != -1 && year != -1) {
                break;
            } else {
                JOptionPane.showMessageDialog(
                    null, 
                    "Invalid month or year entered! Please try again.", 
                    "Error", 
                    JOptionPane.ERROR_MESSAGE
                );
            }
        }
        int days = getDaysInMonth(month, year);
        JOptionPane.showMessageDialog(
            null, 
            "The month has " + days + " days.", 
            "Result", 
            JOptionPane.INFORMATION_MESSAGE
        );
    }

    public static int parseMonth(String input) {
        String lower = input.toLowerCase().trim();
        
        if (lower.equals("january") || lower.equals("jan.") || lower.equals("jan") || lower.equals("1")) return 1;
        if (lower.equals("february") || lower.equals("feb.") || lower.equals("feb") || lower.equals("2")) return 2;
        if (lower.equals("march") || lower.equals("mar.") || lower.equals("mar") || lower.equals("3")) return 3;
        if (lower.equals("april") || lower.equals("apr.") || lower.equals("apr") || lower.equals("4")) return 4;
        if (lower.equals("may") || lower.equals("5")) return 5;
        if (lower.equals("june") || lower.equals("jun.") || lower.equals("jun") || lower.equals("6")) return 6;
        if (lower.equals("july") || lower.equals("jul.") || lower.equals("jul") || lower.equals("7")) return 7;
        if (lower.equals("august") || lower.equals("aug.") || lower.equals("aug") || lower.equals("8")) return 8;
        if (lower.equals("september") || lower.equals("sept.") || lower.equals("sep.") || lower.equals("sep") || lower.equals("9")) return 9;
        if (lower.equals("october") || lower.equals("oct.") || lower.equals("oct") || lower.equals("10")) return 10;
        if (lower.equals("november") || lower.equals("nov.") || lower.equals("nov") || lower.equals("11")) return 11;
        if (lower.equals("december") || lower.equals("dec.") || lower.equals("dec") || lower.equals("12")) return 12;
        
        return -1;
    }
    public static int parseYear(String input) {
        int y = Integer.parseInt(input);
        if (y >= 0) {
            return y;
        }
        return -1;
    }

    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public static int getDaysInMonth(int month, int year) {
        switch (month) {
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                return 31;
            case 4: case 6: case 9: case 11:
                return 30;
            case 2:
                return isLeapYear(year) ? 29 : 28;
            default:
                return 0;
        }
    }
}