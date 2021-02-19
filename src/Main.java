import java.util.Scanner;

public class Main {
    static Scanner in;

    public static void enterData(int i, int numOfPartions, Blocks b[]) {
        long startingAdress = 0, endingAdress = 0;
        in = new Scanner(System.in);

        System.out.print("enter size of partion " + i + " : ");
        int size = in.nextInt();
        endingAdress = (size) * 1000 -1;
        if ((i - 1) != 0) {
            startingAdress = (b[i - 2].endingAdress + 1);
            endingAdress = (b[i - 2].endingAdress + size*1000) ;
        }

        b[i - 1] = new Blocks(i, size, false, startingAdress, endingAdress);
        System.out.println();

    }

    public static void main(String[] args) {
        in = new Scanner(System.in);
        System.out.println("\t\t----------wellcome----------");
        System.out.println("please enter number of partions ?");
        System.out.print("number of partions is : ");
        int numOfPartions = in.nextInt();

        if (numOfPartions <= 0) {
            System.out.println("enter number of partions greater than 0");
            numOfPartions = in.nextInt();
        }
        Blocks b[] = new Blocks[numOfPartions];
        for (int i = 0; i < numOfPartions; i++) {
            enterData(i + 1, numOfPartions, b);


        }
        for (Blocks blocks : b) {
            System.out.println("block number " + blocks.blockNumber + " - block Size :" + blocks.blockSize
                    + " - start address :" + blocks.startingadress + " - end address :" + blocks.endingAdress);
        }

        while (true) {

            System.out.println("please choose which option you want ?\n\t1- Request \n\t2- Release\n\t3- Report\n\t4- exit");
            int option = in.nextInt();
            switch (option) {
                case 1:
                    System.out.println("Enter name of the fragment: ");
                    String name = in.next();
                    System.out.println("enter size of the proces: ");
                    int s = in.nextInt();
                    System.out.println("choose character that represent Replace stratgy that you want?\n\t\t1-First fit (f)\n\t\t" +
                            "2-best fit (b)\n\t\t3-worth fit (w)");
                    char r = in.next().charAt(0);
                    Fragment fragment = new Fragment(name, s);
                    boolean flag = replace(r, b, fragment);
                    if (!flag) {
                        System.out.println("Error");
                    }
                    break;
                case 2:
                    System.out.println("pleasev enter name of the process");
                    String pname = in.next();
                    boolean flag1 = search(pname, b);
                    if (!flag1) {
                        System.out.println("Error");
                    }
                    break;
                case 3:
                    report(b);
                    break;
                default:
                    System.out.println("other");
                    return;
            }

        }
    }

    public static boolean replace(char r, Blocks[] b, Fragment fragment) {

        char s1 = Character.toLowerCase(r);
        switch (r) {
            case 'f':
                return ReplaceSteratgies.first_fit(b, fragment);
            case 'b':
                return ReplaceSteratgies.best_fit(b, fragment);
            case 'w':
                return ReplaceSteratgies.worth_fit(b, fragment);
        }
        return false;
    }

    public static boolean search(String name, Blocks[] b) {
        for (int i = 0; i < b.length; i++) {
            if (b[i].getFragmet() != null && name.equals(b[i].getFragmet().getFragmentName())) {
                b[i].setFragmet(null);
                b[i].setAllocated(false);
                return true;
            }
        }
        return false;
    }

    public static void report(Blocks[] b) {
        for (Blocks blocks : b) {
            System.out.print("block number " + blocks.blockNumber + " - block Size :" + blocks.blockSize
                    + " - start address :" + blocks.startingadress + " - end address :" + blocks.endingAdress);
            if (blocks.isAllocated()) {
                System.out.print(" - Status is Allocated and process name is : " + blocks.getFragmet().getFragmentName()
                        + " - Size of preocess :" + blocks.getFragmet().getFragmentSize());
                System.out.println();
            } else {
                System.out.print(" - Status not Allocated");
                System.out.println();
            }
        }
    }
}
