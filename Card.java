import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;                MỜ CỜ SỜ CODE ĐỈNH QUÁ          
                                        I LOVE YOU MWOF CỜ SỜ
import java.util.List;
import java.util.Scanner;

public class Card {
    static Scanner in = new Scanner(System.in);
    static List<List<String>> vgaInfo = new ArrayList<List<String>>();
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";

    public Card() {
        try {
            File dataFile = new File("data.txt");
            Scanner readData = new Scanner(dataFile);
            while (readData.hasNextLine()) {
                List<String> data = Arrays.asList(readData.nextLine().split("; "));
                vgaInfo.add(data);
            }
            readData.close();
        } catch (Exception e) {}
    }

    void getAllVgaInfo() {
        System.out.printf("%-21s | %-17s | %-13s | %-13s | %-15s\n",
        "Model", "Max Memory Size", "Core Clock", "Max TDP", "Price");
        for(List<String> list : vgaInfo) {
            System.out.printf("%-21s | %-17s | %-13s | %-13s | %-15s\n",
            list.get(0), list.get(1), list.get(2), list.get(3), list.get(4));
        }
    }

    void queryVgaInf() {
        while(true) {
            System.out.print("Enter model: ");
            String model = in.nextLine().toLowerCase();
            System.out.println("\n======================================================================================");
            List<Integer> pos = new ArrayList<>();
            for(int i = 0; i < vgaInfo.size(); i++) {
                if (vgaInfo.get(i).get(0).toLowerCase().contains(model)) pos.add(i);
            }
            if (!pos.isEmpty()) {
                System.out.printf(ANSI_RED + "%-23s | %-17s | %-13s | %-13s | %-15s\n",
                "Model", "Max Memory Size", "Core Clock", "Max TDP", "Price" + ANSI_RESET);
                for(int i : pos) {
                    System.out.printf("%-23s | %-17s | %-13s | %-13s | %-15s\n",
                    vgaInfo.get(i).get(0), vgaInfo.get(i).get(1),vgaInfo.get(i).get(2), 
                    vgaInfo.get(i).get(3), vgaInfo.get(i).get(4));
                }
            } else System.out.println(ANSI_RED + "Not Found!" + ANSI_RESET);
            System.out.println("======================================================================================\n");
        }
    }
}
