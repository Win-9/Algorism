import java.util.*;
import java.lang.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Room> roomList = new ArrayList<>();
        
        String[] str = br.readLine().split(" ");
        int p = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);
        
        for(int i = 0; i < p; i++) {
            str = br.readLine().split(" ");
            int level = Integer.parseInt(str[0]);
            String nick = str[1];
            boolean flag = true;
            for(Room room : roomList) {
                if (!room.isFull(m)) {
                    if (Math.abs(level - room.limit) <= 10) {
                        Human human = new Human(level, nick);
                        room.list.add(human);
                        flag = false;
                        break;
                    }
                }
            }
            
            if (flag) {
                Room room = new Room(level);
                Human human = new Human(level, nick);
                room.list.add(human);
                roomList.add(room);
            }
        }
        
        for(Room room : roomList) {
            if (room.isFull(m)) {
                System.out.println("Started!");
            } else {
                System.out.println("Waiting!");
            }
            
            Collections.sort(room.list, new Comparator<Human>() {
                public int compare(Human h1, Human h2) {
                    return h1.name.compareTo(h2.name);
                }
            });
            
            for(Human human : room.list) {
                System.out.println(human.level + " " + human.name);
            }
        }
        
        
    }
    
    static class Human {
        int level;
        String name;
        
        public Human(int level, String name) {
            this.level = level;
            this.name = name;
        }
    }
    
    static class Room {
        int limit;
        List<Human> list = new ArrayList<>();
        
        public Room(int limit) {
            this.limit = limit;
        }
        
        public boolean isFull(int m) {
            return list.size() == m;
        }
    }
}
