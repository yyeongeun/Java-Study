package sub2.test;

public class Test02 {
    public static void main(String[] args) {

        int count = 0;

        for (int i=0; i<7; i++){   // i=     0,1,2,3,4,5,6

            if (i<=3)              // count= 1,2,3,4,3,2,1
                count++;
            else
                count--;

            for (int j=1; j<5-count; j++) // j=3,2,1,0,1,2,3
                System.out.print("☆");
            for (int k=1; k<2*count-1; k++) // k=1,3,5,7,5,3,1 //빈칸
                System.out.print("★");
            for (int j=1; j<5-count; j++)
                System.out.print("☆");

            System.out.println("\n");
        }

        System.out.println("\n");
    }

}
