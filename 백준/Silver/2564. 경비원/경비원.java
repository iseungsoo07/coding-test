import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int width = Integer.parseInt(st.nextToken());
        int height = Integer.parseInt(st.nextToken());

        int shops = Integer.parseInt(br.readLine());

        List<int[]> list = new ArrayList<>();

        for (int i = 0; i < shops; i++) {
            st = new StringTokenizer(br.readLine());
            list.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }

        st = new StringTokenizer(br.readLine());

        // 동근이 위치
        int[] pos = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};

        int distance = 0;

        switch (pos[0]) {
            case 1:
                for (int[] shop : list) {
                    if (shop[0] == 1) { // 같은 변에 있으면 y좌표 차이가 최솟값
                        distance += Math.abs(shop[1] - pos[1]);
                    } else if (shop[0] == 2) {
                        distance += Math.min(height + pos[1] + shop[1],
                            height + (width - pos[1]) + (width - shop[1]));
                    } else if (shop[0] == 3) {
                        distance += pos[1] + shop[1];
                    } else {
                        distance += (width - pos[1]) + shop[1];
                    }
                }
                break;
            case 2:
                for (int[] shop : list) {
                    if (shop[0] == 2) {
                        distance += Math.abs(shop[1] - pos[1]);
                    } else if (shop[0] == 1) {
                        distance += Math.min(height + pos[1] + shop[1],
                            height + (width - pos[1]) + (width - shop[1]));
                    } else if (shop[0] == 3) {
                        distance += (height - shop[1]) + pos[1];
                    } else {
                        distance += (width - pos[1]) + (height - shop[1]);
                    }
                }
                break;
            case 3:
                for (int[] shop : list) {
                    if (shop[0] == 3) {
                        distance += Math.abs(shop[1] - pos[1]);
                    } else if (shop[0] == 1) {
                        distance += shop[1] + pos[1];
                    } else if (shop[0] == 2) {
                        distance += (height - pos[1]) + shop[1];
                    } else {
                        distance += Math.min(width + pos[1] + shop[1],
                            width + (height - pos[1]) + (height - shop[1]));
                    }
                }
                break;
            case 4:
                for (int[] shop : list) {
                    if (shop[0] == 4) {
                        distance += Math.abs(shop[1] - pos[1]);
                    } else if (shop[0] == 1) {
                        distance += (width - shop[1]) + pos[1];
                    } else if (shop[0] == 2) {
                        distance += (height - pos[1]) + (width - shop[1]);
                    } else {
                        distance += Math.min(width + pos[1] + shop[1],
                            width + (height - pos[1]) + (height - shop[1]));
                    }
                }
                break;
            default:
                break;
        }

        System.out.println(distance);

    }
}
