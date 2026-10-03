import javax.swing.JOptionPane;
public class Star{
    public static void main(String[] args){
        String strN = JOptionPane.showInputDialog("Enter n: ");
        int n = Integer.parseInt(strN);
        for (int i = 0;i < n; i++){
            for (int j = 0; j<=i;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}