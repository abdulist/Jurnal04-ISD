import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        LinkedList<Music> playList = new LinkedList<>();

        boolean quit = false;
        while (!quit) {
            System.out.println("-----Select Option-----");
            System.out.println("1. Input a Song");
            System.out.println("2. Delete a Song");
            System.out.println("3. Play Playlist");
            System.out.println("4. Quit");
            System.out.print("Select Option with a Number: ");
            int select = input.nextInt();
            input.nextLine();
            switch (select) {
                case 1:
                    System.out.print("Input a Song Title: ");
                    String songTitle = input.nextLine();
                    System.out.print("Input the Singer: ");
                    String singer = input.nextLine();
                    playList.addLast(new Music(songTitle, singer));
                             break;
                    case 2:
                        System.out.println("1. Remove Last Inputed Song");
                        System.out.println("2. Remove Song by Title");
                        System.out.print("Select Option with a Number: ");
                        int opt = input.nextInt();
                        input.nextLine();
                        if (opt == 1) {
                            playList.removeLast();
                            System.out.println("-----Removing Success!-----");
                        }
                            else if (opt == 2) {
                                System.out.print("Input the Song Title: ");
                                String optSongTitle = input.nextLine();
                                removeByTitle(playList, optSongTitle);
                                System.out.println("-----Removing Success!-----");
                            }
                                else {
                                    System.out.println("-----Option is Unavailable!-----");
                                }
                                            break;
                                case 3:
                                    playSong(playList);
                                                break;
                                    case 4:
                                        quit = true;
                                                    break;
                                        default:
                                            System.out.println("-----Menu is Unavailable!-----");
            }
        }
    }

    public static void removeByTitle(LinkedList<Music> ob, String songTitle) {
        ListIterator<Music> iterator = ob.listIterator();

        while (iterator.hasNext()) {
            Music current = iterator.next();
            if (current.getsongTitle().equalsIgnoreCase(songTitle)) {
                iterator.remove();
            }
        }
    }
    
    public static void playSong(LinkedList<Music> ob) {
        ListIterator<Music> iterator = ob.listIterator();

        while (iterator.hasNext()) {
            if (iterator.hasPrevious()) {
                System.out.print(", " + iterator.next());
            }
            else {
                System.out.print(iterator.next());
            }
        }
        iterator.previous();
        while (iterator.hasPrevious()) {
            System.out.print(", " + iterator.previous());
        }
        System.out.println();
    }
}