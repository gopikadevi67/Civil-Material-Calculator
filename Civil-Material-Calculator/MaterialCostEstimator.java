import java.util.*;

class MaterialItem {
    String description;
    String unit;
    double netQuantity;
    double wastagePercent;
    double unitRateMaterial;
    double unitRateLabour;

    MaterialItem(String description, String unit, double netQuantity, double wastagePercent, double unitRateMaterial, double unitRateLabour) {
        this.description = description;
        this.unit = unit;
        this.netQuantity = netQuantity;
        this.wastagePercent = wastagePercent;
        this.unitRateMaterial = unitRateMaterial;
        this.unitRateLabour = unitRateLabour;
    }

    double getQuantityWithWastage() {
        return netQuantity * (1 + wastagePercent / 100);
    }

    double getMaterialCost() {
        return getQuantityWithWastage() * unitRateMaterial;
    }

    double getLabourCost() {
        return netQuantity * unitRateLabour;
    }

    double getTotalCost() {
        return getMaterialCost() + getLabourCost();
    }

    void displayItem() {
        System.out.println("----------------------------------");
        System.out.println("Description       : " + description);
        System.out.println("Unit              : " + unit);
        System.out.printf("Net Quantity      : %.2f %s%n", netQuantity, unit);
        System.out.printf("Wastage %%         : %.2f%%%n", wastagePercent);
        System.out.printf("Quantity (with wastage): %.2f %s%n", getQuantityWithWastage(), unit);
        System.out.printf("Material Cost     : ₹%.2f%n", getMaterialCost());
        System.out.printf("Labour Cost       : ₹%.2f%n", getLabourCost());
        System.out.printf("Total Cost        : ₹%.2f%n", getTotalCost());
    }
}

public class MaterialCostEstimator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<MaterialItem> items = new ArrayList<>();

        System.out.println("===== MATERIAL COST ESTIMATOR =====");
        System.out.print("Enter Project Name: ");
        String projectName = sc.nextLine();

        System.out.print("Enter number of items: ");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for item " + (i + 1) + ":");
            System.out.print("Description: ");
            String desc = sc.nextLine();

            System.out.print("Unit (e.g., m2, m3, nos): ");
            String unit = sc.nextLine();

            System.out.print("Net Quantity: ");
            double qty = sc.nextDouble();

            System.out.print("Wastage %: ");
            double waste = sc.nextDouble();

            System.out.print("Material Unit Rate (₹): ");
            double matRate = sc.nextDouble();

            System.out.print("Labour Unit Rate (₹): ");
            double labRate = sc.nextDouble();
            sc.nextLine(); // consume newline

            items.add(new MaterialItem(desc, unit, qty, waste, matRate, labRate));
        }

        System.out.print("Enter Tax Percentage (e.g., 18 for 18%): ");
        double taxPercent = sc.nextDouble();

        double subtotal = 0;
        for (MaterialItem item : items) {
            subtotal += item.getTotalCost();
        }

        double taxAmount = subtotal * (taxPercent / 100);
        double grandTotal = subtotal + taxAmount;

        System.out.println("\n====================================");
        System.out.println("         COST ESTIMATION REPORT      ");
        System.out.println("====================================");
        System.out.println("Project: " + projectName);
        System.out.println("------------------------------------");

        for (MaterialItem item : items) {
            item.displayItem();
        }

        System.out.println("====================================");
        System.out.printf("Subtotal          : ₹%.2f%n", subtotal);
        System.out.printf("Tax (%.2f%%)        : ₹%.2f%n", taxPercent, taxAmount);
        System.out.printf("GRAND TOTAL       : ₹%.2f%n", grandTotal);
        System.out.println("====================================");

        sc.close();
    }
}
