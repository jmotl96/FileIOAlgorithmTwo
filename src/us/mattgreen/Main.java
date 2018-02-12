package us.mattgreen;
public class Main {
    private static String line = "";
    private final static FileInput cardAccts = new FileInput("movie_cards.csv");
    private final static FileInput cardPurchases = new FileInput("movie_purchases.csv");
    public final static FileInput score = new FileInput("move_ratings.csv");

    public static void main(String[] args) {
        String line;
        String[] fields;
        int[] nums = new int[2];
        String line2;
        String[] fields2;
        int[] nums2 = new int[2];
        boolean first = true;
        System.out.format("%8s  %-18s %6s %6s\n","Account","Name", "Movies", "Points", "score");
        while ((line = cardAccts.fileReadLine()) != null) {
            fields = line.split(",");
            findPurchases(first,fields[0], nums);
            //new line findSCores(soming
            first = false;
            System.out.format("00%6s  %-18s  %2d   %4d\n",fields[0],fields[1], nums[0], nums[1]); //modify
        }
    }

    public static void findPurchases(boolean first, String acct, int[] nums) {
        nums[0] = 0;
        nums[1] = 0;
        //String line;
        String[] fields;
        boolean done = false;
        if (first) {
            line = cardPurchases.fileReadLine();
        }
        while ((line != null) && !(done)) {
            fields = line.split(",");
            if (fields[0].compareTo(acct) > 0) {
                done = true;
            }
            else if (fields[0].equals(acct)) {
                nums[0]++;
                nums[1] += Integer.parseInt(fields[2]);
                line = cardPurchases.fileReadLine();
            }
        }
    }

    //Modify method
    public static void findSCores(boolean first, String acct, int[] nums2) {
        nums2[0] = 0;
        nums2[1] = 0;
        //String line;
        String[] fields;
        boolean done = false;
        if (first) {
            //line = cardPurchases.fileReadLine();
            line = score.fileReadLine();
        }
        while ((line != null) && !(done)) {
            fields = line.split(",");
            if (fields[0].compareTo(acct) > 0) {
                done = true;
            }
            else if (fields[0].equals(acct)) {
                nums2[0]++;
                nums2[1] += Integer.parseInt(fields[2]);
                line = score.fileReadLine();
            }
        }
    }
}