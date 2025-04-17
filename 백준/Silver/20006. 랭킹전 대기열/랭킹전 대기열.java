import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static class Player implements Comparable<Player> {

        int level;
        String nickname;

        public Player(int level, String nickname) {
            this.level = level;
            this.nickname = nickname;
        }

        @Override
        public int compareTo(Player o) {
            return this.nickname.compareTo(o.nickname);
        }
    }

    public static int findRoom(List<List<Player>> room, Player player, int m) {
        for (int i = 0; i < room.size(); i++) {
            List<Player> players = room.get(i);

            if ((player.level >= players.get(0).level - 10
                && player.level <= players.get(0).level + 10) && players.size() < m) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int p = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<List<Player>> rooms = new ArrayList<>();

        for (int i = 0; i < p; i++) {
            st = new StringTokenizer(br.readLine());
            Player player = new Player(Integer.parseInt(st.nextToken()), st.nextToken());

            if (rooms.isEmpty()) {
                rooms.add(new ArrayList<>(Arrays.asList(player)));
            } else {
                int roomNumber = findRoom(rooms, player, m);

                if (roomNumber == -1) {
                    rooms.add(new ArrayList<>(Arrays.asList(player)));
                } else {
                    rooms.get(roomNumber).add(player);
                }
            }
        }

        for (int i = 0; i < rooms.size(); i++) {
            List<Player> players = rooms.get(i);
            Collections.sort(players);

            if (players.size() != m) {
                System.out.println("Waiting!");

            } else {
                System.out.println("Started!");
            }

            for (Player player : players) {
                System.out.print(player.level + " " + player.nickname);
                System.out.println();
            }
        }

    }
}
