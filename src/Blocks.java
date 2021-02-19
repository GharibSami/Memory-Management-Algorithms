public class Blocks {
    int blockNumber;
    int blockSize;
    boolean allocated;
    long startingadress;
    long endingAdress;


    public Fragment getFragmet() {
        return fragmet;
    }

    public void setFragmet(Fragment fragmet) {
        this.fragmet = fragmet;
    }

    Fragment fragmet;


    public Blocks(int blockNumber, int blockSize, boolean allocated, long startingadress, long endingAdress) {
        this.blockNumber = blockNumber;
        this.blockSize = blockSize;
        this.allocated = allocated;
        this.startingadress = startingadress;
        this.endingAdress = endingAdress;
    }

    public int getBlockNumber() {
        return blockNumber;
    }

    public void setBlockNumber(int blockNumber) {
        this.blockNumber = blockNumber;
    }

    public int getBlockSize() {
        return blockSize;
    }

    public void setBlockSize(int blockSize) {
        this.blockSize = blockSize;
    }

    public boolean isAllocated() {
        return allocated;
    }

    public void setAllocated(boolean allocated) {
        this.allocated = allocated;
    }

    public long getStartingadress() {
        return startingadress;
    }

    public void setStartingadress(long startingadress) {
        this.startingadress = startingadress;
    }

    public long getEndingAdress() {
        return endingAdress;
    }

    public void setEndingAdress(long endingAdress) {
        this.endingAdress = endingAdress;
    }
}

class Fragment {
    String fragmentName;
    int fragmentSize;

    public Fragment(String fragmentName, int fragmentSize) {

        this.fragmentName = fragmentName;
        this.fragmentSize = fragmentSize;
    }

    public String getFragmentName() {
        return fragmentName;
    }

    public void setFragmentName(String fragmentName) {
        this.fragmentName = fragmentName;
    }

    public int getFragmentSize() {
        return fragmentSize;
    }

    public void setFragmentSize(int fragmentSize) {
        this.fragmentSize = fragmentSize;
    }
}
