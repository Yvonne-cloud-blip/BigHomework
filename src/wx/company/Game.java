package wx.company;

import java.util.Scanner;

/**
 * @description:
 * @author: DELL
 * @date: Created in 2020/6/14 0:22
 * @version: 1.0
 * @modified By:
 */
public class Game {
    private Rooms currentRoom;
    int magic = 5;
    public Game() {
        createRooms();
    }

    private void createRooms() {
        Rooms parlour, bedroom, library, treasure, kitchen, outside;
        parlour = new Rooms("客厅");
        bedroom = new Rooms("卧室");
        library = new Rooms("藏书阁");
        treasure = new Rooms("宝藏");
        kitchen = new Rooms("厨房");
        outside = new Rooms("沙漠");
        parlour.setExit(outside, kitchen, bedroom, treasure);
        bedroom.setExit(parlour, kitchen, null, library);
        library.setExit(treasure, bedroom, library, null);
        treasure.setExit(null, parlour, library, outside);
        kitchen.setExit(null, outside, outside, parlour);
        outside.setExit(null,null,parlour,null);
        currentRoom = outside;
    }

    private void printWelcome() {
        System.out.println("欢迎来到寻找宝藏的游戏");
        System.out.println("如果需要帮助，请输入help");
        System.out.println("你当前的位置为" + currentRoom);
        System.out.println("出口有：");
        if (currentRoom.westExit != null) {
            System.out.println("west");
        }
        if (currentRoom.southExit != null) {
            System.out.println("south");
        }
        if (currentRoom.eastExit != null) {
            System.out.println("east");
        }
        if (currentRoom.northExit != null) {
            System.out.println("north");
        }
        System.out.println();
    }

    private void printHelp() {
        System.out.println("你可以发出的指令有 go help");
        System.out.println("如 \tgo west");
    }

    private void goRoom(String direction) {
        Rooms nextRoom = null;
        if (direction.equals("north")) {
            nextRoom = currentRoom.northExit;
            System.out.println("你当前在" + nextRoom);
        }
        if (direction.equals("east")) {
            nextRoom = currentRoom.eastExit;
            System.out.println("你当前在" + nextRoom);
        }
        if (direction.equals("south")) {
            nextRoom = currentRoom.southExit;
            System.out.println("你当前在" + nextRoom);
        }
        if (direction.equals("west")) {
            nextRoom = currentRoom.westExit;
            System.out.println("你当前在" + nextRoom);
        }
        if (nextRoom == null) {
            System.out.println("那里没有门！");
        } else {
            currentRoom = nextRoom;
            System.out.print("出口有: ");
            if (currentRoom.northExit != null)
                System.out.print("north ");
            if (currentRoom.eastExit != null)
                System.out.print("east ");
            if (currentRoom.southExit != null)
                System.out.print("south ");
            if (currentRoom.westExit != null)
                System.out.print("west ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Knight k=new Knight("小顺子");
        Monster m1=new Monster("黑山老妖",40,22,8,10);
        Monster m2=new Monster("黑山小妖",30,15,6,20);
        Monster m3=new Monster("黑山小小妖",50,30,4,5);
//        k.fight(m1);
//        k.show();
//        m1.show();
//        k.fight(m2);
//        k.show();
//        m2.show();
        k.fight(m3);
        k.show();
        m3.show();
        Scanner input = new Scanner(System.in);
        Game game = new Game();
        game.printWelcome();
        while (true) {
            String line = input.nextLine();
            String[] words = line.split(" ");
            if (words[0].equals("help")) {
                game.printHelp();
            } else if (words[0].equals("go")) {
                game.goRoom(words[1]);
            } else if (words[0].equals("bye")) {
                break;
            }
        }
    }
}
