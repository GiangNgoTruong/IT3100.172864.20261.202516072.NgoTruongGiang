import javax.swing.JOptionPane;

public class MediaCostAnalysis {
    public static void main(String[] args) {
        String[] title = {"Lion King", "Star Wars", "Aladin", "Frozen", "Coco"};
        double[] cost = {19.95, 24.95, 18.99, 27.50, 15.00};

        int maxIdx = 0;
        int minIdx = 0;
        double total = 0;

        for (int i = 0; i < cost.length; i++) {
            if (cost[i] > cost[maxIdx]) {
                maxIdx = i;
            }
            if (cost[i] < cost[minIdx]) {
                minIdx = i;
            }

            double finalCost = cost[i] > 20 ? cost[i] * 0.9 : cost[i];
            total += finalCost;
        }

        String result = "Max: " + title[maxIdx] + " - " + cost[maxIdx] + "\n" +
                        "Min: " + title[minIdx] + " - " + cost[minIdx] + "\n" +
                        "Total after discount: " + String.format("%.2f", total);

        JOptionPane.showMessageDialog(null, result, "Media Cost Analysis", JOptionPane.INFORMATION_MESSAGE);
    }
}