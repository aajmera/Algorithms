package hackerrank.interviewpreparation.trees;

public class HuffmanDecoding {

    class Node {
        Node left;
        Node right;
        int data;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    void decode(String s, Node root) {
        Node temp = root;
        for(char ch : s.toCharArray()) {
            if(ch == '0') temp = temp.left;
            else temp = temp.right;

            if(temp.data != '\u0000') {
                System.out.print(temp.data);
                temp = root;
            }
        }

    }
}
