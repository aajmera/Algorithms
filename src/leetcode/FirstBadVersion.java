package leetcode;

public class FirstBadVersion {
    public int firstBadVersion(int n) {
        if(isBadVersion(1)) return 1;
        return getBadVersion(1, n);
    }

    public int getBadVersion(int start, int end) {
        if(end - start == 1) {
            if(!isBadVersion(start) && isBadVersion(end)) return end;
        }

        int n = start + ((end - start) / 2);
        if(isBadVersion(n)) return getBadVersion(start, n);
        else return getBadVersion(n, end);
    }

    //created dummy method just to resolve compilation issue
    public boolean isBadVersion(int n) {
        return false;
    }
}
