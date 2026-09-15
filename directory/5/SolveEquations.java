import javax.swing.JOptionPane;

public class SolveEquations{
    public static void main(String[] args){
        boolean flag = true;
        String strOption = "";
        while (flag){
            strOption = JOptionPane.showInputDialog(null,"Choose an equation (1.first degree equation, 2.system of first degree equation with 2 variables, 3. second degree equation): ",
                "Choose operator",JOptionPane.INFORMATION_MESSAGE);
            if (strOption == null) {
                System.exit(0);
            }
            flag = false;
            if (!strOption.equals("1") && !strOption.equals("2") && !strOption.equals("3")){
                JOptionPane.showMessageDialog(null,"Please choose a valid option");
                flag = true;
            }
        }

        int option = Integer.parseInt(strOption);
        Object result;
        
        switch (option){
            case 1:{
                double[] a = new double[3];
                for(int i = 0;i<3;i++){
                    String str = JOptionPane.showInputDialog(null,"Input a"+ Integer.toString(i+1),"a1x + a2 = a3",JOptionPane.INFORMATION_MESSAGE);
                    a[i] = Double.parseDouble(str);
                }
                result = first_degree(a);
                if (result instanceof String){
                    JOptionPane.showMessageDialog(null,result);
                }
                else{
                    double solution = (double) result;
                    JOptionPane.showMessageDialog(null, Double.toString(solution));
                }
                break;
            }

            case 2:{
                double[] a = new double[3];
                double[] b = new double[3];
                JOptionPane.showMessageDialog(null,"First equation");
                for(int i = 0;i<3;i++){
                    String str = JOptionPane.showInputDialog(null,"Input a"+ Integer.toString(i+1),"a1x1 + a2x2 = a3",JOptionPane.INFORMATION_MESSAGE);
                    a[i] = Double.parseDouble(str);
                }
                JOptionPane.showMessageDialog(null,"Second equation");
                for(int i = 0;i<3;i++){
                    String str = JOptionPane.showInputDialog(null,"Input b"+ Integer.toString(i+1),"b1x1 + b2x2 = b3",JOptionPane.INFORMATION_MESSAGE);
                    b[i] = Double.parseDouble(str);
                }
                result = first_degree_system(a,b);
                if (result instanceof String){
                    JOptionPane.showMessageDialog(null,result); 
                }
                else{
                    double[] solutions = (double[]) result;
                    String result_str = "";
                    for(int i = 0; i< solutions.length; i++){
                        result_str += ("x" + Integer.toString(i+1) + " = " + Double.toString(solutions[i]) + "\n");
                    }
                    JOptionPane.showMessageDialog(null,result_str);
                }
                break;
            }

            case 3:{
                double[] a = new double[4];
                for(int i = 0;i<4;i++){
                    String str = JOptionPane.showInputDialog(null,"Input a"+ Integer.toString(i+1),"a1x^2 + a2x + a3 = a4",JOptionPane.INFORMATION_MESSAGE);
                    a[i] = Double.parseDouble(str);
                }
                result = second_degree(a);
                if (result instanceof String){
                    JOptionPane.showMessageDialog(null,result);
                }
                else{
                    double[] solutions = (double[]) result;
                    String result_str = "";
                    for(int i = 0; i< solutions.length; i++){
                        result_str += ("x = " + Double.toString(solutions[i]) + "\n");
                    }
                    JOptionPane.showMessageDialog(null,result_str);
                }
                break;
            }

            default:
                break;
        }
    }

    public static Object first_degree(double a[]){
        if (a[0] == 0){
            if(a[1] == a[2]){
                return "Infinite solutions";
            }
            else{
                return "No solution";
            }
        }
        return (a[2]-a[1])/a[0];
    }
    public static Object first_degree_system(double a[],double b[]){
        double d = a[0]*b[1] - b[0]*a[1];
        if (d == 0){
            if (a[0] * b[2] == b[0] * a[2] && a[1] * b[2] == b[1] * a[2]){
                return "Infinite solutions";
            } 
            else {
                return "No solution";
            }
        }
        double dx = a[2]*b[1] - b[2]*a[1];
        double dy = a[0]*b[2] - b[0]*a[2];
        return new double[] {dx / d, dy / d};
    }
    public static Object second_degree(double a[]){
        if (a[0] == 0){
            double[] firstDegree = {a[1],a[2],a[3]};
            return first_degree(firstDegree);
        }
        double delta_square = a[1]*a[1] - 4*a[0]*(a[2]-a[3]);
        if (delta_square < 0){
            return "No real solution";
        }
        double delta = Math.sqrt(delta_square);
        if (delta == 0) return new double[] {-a[1] / (2 * a[0])};
        return new double[] {(-a[1]+delta)/(2*a[0]),(-a[1]-delta)/(2*a[0])};
    }
}