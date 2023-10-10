package Tree;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int n = 4;
        int week = 0;
        int max = 10;
        int[] arrayWeek;

        for (int i = 0; i < n; i++) {
            arrayWeek = new int[n];
            arrayWeek[i] = input.nextInt();
            if (arrayWeek[i] >= max) {
                week += 1;
            }
        }
        System.out.println(week);















        /*

        for(int i = 0 ; i  < n ; i++){
            for(int j = i ; j >= i;j--){
                int aa = input.nextInt();
            }
        }
*/


       /* Tree tree = new Tree();
        tree.insert(42);
        tree.insert(21);
        tree.insert(38);
        tree.insert(27);
        tree.insert(71);
        tree.insert(82);
        tree.insert(55);
        tree.insert(63);
        tree.insert(6);
        tree.insert(2);
        tree.insert(40);
        tree.insert(12);
        System.out.println(tree.findTheNode(16));
        System.out.println("Level order traversal : ");
        tree.breadthFirstSearch();
        tree.preOrderTraversal(tree.getRoot());
        int found = tree.findNode(71);
        if(found != -1) {
            System.out.println("Ketemu node key= 25");
        }
        else {
            System.out.println("Node key=25 Tidak Ketemu");
        }*/

    }
}