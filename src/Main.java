import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    static class Reserves {
        int startDay, endDay, price;
        Reserves(int start, int end, int price) {
            this.startDay = start;
            this.endDay = end;
            this.price = price;
        }
    }
    private static int MaxProfit(int Index, int[] roomAvailability, List<Reserves> reserve, HashMap<String, Integer> memo) {
        if (Index >= reserve.size()) {
            return 0;
        }

        String memoKey = Index + "-" + roomAvailability[0] + "-" + roomAvailability[1];
        if (memo.containsKey(memoKey)) {
            return memo.get(memoKey);
        }

        int maxProfit = MaxProfit(Index + 1, roomAvailability, reserve, memo);
        for (int i = 0; i < 2; i++) {
            if (reserve.get(Index).startDay >= roomAvailability[i]) {
                int[] newAvailability = roomAvailability.clone();
                newAvailability[i] = reserve.get(Index).endDay;

                int profit = reserve.get(Index).price + MaxProfit(Index + 1, newAvailability, reserve, memo);
                maxProfit = Math.max(maxProfit, profit);
            }
        }
        memo.put(memoKey, maxProfit);
        return maxProfit;
    }

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("in.txt");
        Scanner scanner = new Scanner(file);
        List<Reserves> reserve = new ArrayList<>();
        int numberOfBookings = scanner.nextInt();
        for (int i = 0; i < numberOfBookings; i++) {
            reserve.add(new Reserves(scanner.nextInt(), scanner.nextInt(), scanner.nextInt()));
        }

        Collections.sort(reserve, Comparator.comparingInt(b -> b.startDay));
        HashMap<String, Integer> memo = new HashMap<>();
        System.out.println("Max Profit: " + MaxProfit(0, new int[]{0, 0}, reserve, memo));
    }
}