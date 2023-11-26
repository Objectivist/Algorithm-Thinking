package Programmers;

import java.util.*;

public class 주차_요금_계산 {
    public int[] solution(int[] fees, String[] records) {
        int[] answer = {};
        List<int[]> list = new ArrayList<>();   //차량번호 별로 요금 정렬을 위한 리스트
        Map<String, Queue<Record>> map = new HashMap<>();

        for (String str : records) {
            String[] s = str.split(" ");
            Queue<Record> q = map.getOrDefault(s[1], new LinkedList<>());
            q.offer(new Record(s[0], s[2]));
            map.put(s[1], q);
        }

        answer = new int[map.size()];

        map.forEach((s, q) -> {
            double sumTime = cal(q);

            if (sumTime <= fees[0]) {
                list.add(new int[]{Integer.parseInt(s), fees[1]});
            } else {
                int fee = (int) (fees[1] + Math.ceil((sumTime - fees[0]) / fees[2]) * fees[3]);
                list.add(new int[]{Integer.parseInt(s), fee});
            }
        });

        list.sort(Comparator.comparingInt(o -> o[0]));

        int cnt = 0;
        for (int[] arr : list) {
            answer[cnt++] = arr[1];
        }

        return answer;
    }

    private int cal(Queue<Record> q) {
        int sumTime = 0;

        while (!q.isEmpty()) {
            Record r1 = q.poll();
            Record r2 = q.poll();

            if (r2 == null) {
                String[] split = r1.time.split(":");
                sumTime += (23 - Integer.parseInt(split[0])) * 60;
                sumTime += (59 - Integer.parseInt(split[1]));
                continue;
            }

            String[] split1 = r1.time.split(":");
            String[] split2 = r2.time.split(":");

            sumTime += (Integer.parseInt(split2[0]) - Integer.parseInt(split1[0])) * 60;
            sumTime += (Integer.parseInt(split2[1]) - Integer.parseInt(split1[1]));
        }

        return sumTime;
    }

    private class Record {
        private String time;
        private String detail;

        public Record(String time, String detail) {
            this.time = time;
            this.detail = detail;
        }
    }
}
