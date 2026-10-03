import java.util.Arrays;
import javax.swing.JOptionPane;

public class MediaCostSorter {
    public static void main(String[] args) {
        String sizeStr = JOptionPane.showInputDialog("Enter the number of media costs:");
        if (sizeStr == null) System.exit(0);
        
        int size = Integer.parseInt(sizeStr.trim());
        double[] mediaCosts = new double[size];

        for (int i = 0; i < size; i++) {
            String costStr = JOptionPane.showInputDialog("Enter media cost " + (i + 1) + ":");
            if (costStr == null) System.exit(0);
            mediaCosts[i] = Double.parseDouble(costStr.trim());
        }

        String originalArrayStr = Arrays.toString(mediaCosts);
        Arrays.sort(mediaCosts);

        double sum = 0;
        for (double cost : mediaCosts) {
            sum += cost;
        }
        double average = (size > 0) ? (sum / size) : 0;

        String resultMessage = "Sorted Array: " + Arrays.toString(mediaCosts) + "\n" +
                               "Sum: " + sum + "\n" +
                               "Average: " + average;

        JOptionPane.showMessageDialog(null, resultMessage, "Media Costs Analysis", JOptionPane.INFORMATION_MESSAGE);
    }
}