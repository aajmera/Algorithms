package recursion;

public class TowerOfHanoi {

    static int count = 0;

    public void move(int numOfDiscs, char from, char to, char using) {
        if(numOfDiscs == 1) {
            System.out.println("Move 1 from " + from + " to " + to);
            count++;
            return;
        }
        move(numOfDiscs-1, from, using, to);
        System.out.println("Move " + numOfDiscs + " from " + from + " to " + to);
        count++;
        move(numOfDiscs-1, using, to, from);
    }

    public static void main(String[] args) {
        TowerOfHanoi toh = new TowerOfHanoi();
        toh.move(6, 'A', 'C', 'B');
        System.out.print("total steps: " + count);
    }

}
