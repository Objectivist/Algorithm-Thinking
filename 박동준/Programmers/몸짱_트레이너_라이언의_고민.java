package Programmers;

import java.util.ArrayList;
import java.util.List;

public class 몸짱_트레이너_라이언의_고민 {
    private static final int MAX = 1320 + 1;

    private static int getDistance(Customer a, Customer b) {
        return Math.abs(a.x - b.x) + Math.abs(a.y - b.y);
    }

    private static boolean canPlaceFurther(Customer chkCustomer, int maxDistance, List<Customer> customerList) {
        for (Customer c : customerList) {
            if (getDistance(c, chkCustomer) < maxDistance) {
                return false;
            }
        }
        return true;
    }

    public int solution(int n, int m, int[][] timetable) {
        int answer = 0;
        int[] numberOfPeople = new int[MAX];
        int start = Integer.MAX_VALUE;
        int end = 0;

        for (int[] t : timetable) {
            for (int i = t[0]; i <= t[1]; i++) {
                numberOfPeople[i]++;
                start = Math.min(start, i);
                end = Math.max(end, i);
            }
        }

        int maxCrowded = 0;
        for (int i = start; i <= end; i++) {
            maxCrowded = Math.max(maxCrowded, numberOfPeople[i]);
        }

        if (maxCrowded <= 1) {
            return 0;
        }

        for (int distance = 2 * n - 2; distance > 0; distance--) {
            for (int x1 = 0; x1 < n; x1++) {
                for (int y1 = 0; y1 < n; y1++) {
                    List<Customer> customerList = new ArrayList<>();
                    customerList.add(new Customer(x1, y1));

                    for (int x2 = x1; x2 < n; x2++) {
                        for (int y2 = 0; y2 < n; y2++) {
                            if (x2 == x1 && y2 <= y1) {
                                continue;
                            }

                            if (canPlaceFurther(new Customer(x2, y2), distance, customerList)) {
                                customerList.add(new Customer(x2, y2));
                            }

                            if (customerList.size() == maxCrowded) {
                                return distance;
                            }
                        }
                    }
                }
            }
        }

        return answer;
    }

    static class Customer {
        public int x;
        public int y;

        public Customer(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
