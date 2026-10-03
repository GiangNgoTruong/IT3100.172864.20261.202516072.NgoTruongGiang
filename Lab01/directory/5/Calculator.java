import javax.swing.JOptionPane;

public class Calculator{
    public static void main(String[] args){
        char op = JOptionPane.showInputDialog(null,"Choose an operator (+,-,*,/): ","Choose operator",JOptionPane.INFORMATION_MESSAGE).charAt(0);
        String sx = JOptionPane.showInputDialog(null,"Please input the first number: ","First number",JOptionPane.INFORMATION_MESSAGE);
        double x = Double.parseDouble(sx);
        String sy = JOptionPane.showInputDialog(null,"Please input the second number: ","Second number",JOptionPane.INFORMATION_MESSAGE);
        double y = Double.parseDouble(sy);
        if (op == '/'){
            if (y == 0){
                JOptionPane.showMessageDialog(null,"Can't divide by 0");
                return;
            }
        }
        double result = ((op == '+') ? x + y : (op == '-') ? x - y : (op == '*') ? x * y : x / y);
        String sresult = Double.toString(result);
        JOptionPane.showMessageDialog(null, sx + " " + op + " " + sy  + " = " + sresult);
    }

}