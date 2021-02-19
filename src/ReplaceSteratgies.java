import java.util.Arrays;

public class ReplaceSteratgies {

    public static boolean first_fit(Blocks block[], Fragment fragment) {
        if (block.length != 0) {
            for (int i = 0; i < block.length; i++) {
                if (block[i].getBlockSize() >= fragment.getFragmentSize() && !block[i].isAllocated()) {
                    block[i].setFragmet(fragment);
                    block[i].setAllocated(true);
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean best_fit(Blocks block[], Fragment fragment) {
        int b = sort(block, true, fragment.getFragmentSize());
        if (block.length != 0 && b != -1) {
            block[b].setFragmet(fragment);
            block[b].setAllocated(true);
            return true;


        }
        return false;

    }

    public static boolean worth_fit(Blocks block[], Fragment fragment) {
        int b = sort(block, false, fragment.getFragmentSize());
        if (block.length != 0 && b != -1) {
            block[b].setFragmet(fragment);
            block[b].setAllocated(true);
            return true;


        }
        return false;
    }

    public static int sort(Blocks blocks[], boolean flag, int fragmentSize) {
        int inialBS;
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;
        int p = -1;
        if (flag) {
            inialBS = max;
            for (int i = 0; i < blocks.length; i++) {

                if (inialBS >= blocks[i].getBlockSize() && !blocks[i].isAllocated() && blocks[i].getBlockSize() >= fragmentSize) {
                    inialBS = blocks[i].getBlockSize();
                    p = i;

                }
            }
            return p;
        } else {
            inialBS = min;
            for (int i = 0; i < blocks.length; i++) {

                if (inialBS <= blocks[i].getBlockSize() && !blocks[i].isAllocated() && blocks[i].getBlockSize() >= fragmentSize) {
                    p = i;
                    inialBS = blocks[i].getBlockSize();

                }

            }
            return p;
        }
    }


}
