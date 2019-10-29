package assign4;

import java.util.*;

import bookFiles.support.DLLNode;

public class DequeDriver {
    public static <T> void main(String[] args) {
        Scanner input = new Scanner(System.in);
        DeQueDLL deque = new DeQueDLL();
        boolean cont = true;
        Integer num;

        while (cont) {
            System.out.println("Choose an operation - 1: insert, 2: delete, 3: quit ");
            switch (input.nextInt()) {
            case 1:
                System.out.println("Enter the integer you want to insert in the deque:");
                num = input.nextInt();
                if (deque.isEmpty()) { //Tests for 0
                    deque.enqueueRear(num);
                    break;
                } else if (num <= (int)deque.front.getInfo()) { //Adds if smallest value in deque
                    deque.enqueueFront(num);
                    break;
                } else if (num >= (int) deque.rear.getInfo()) { //Adds if largest value in deque
                    deque.enqueueRear(num);
                    break;
                } else { //Adds between temp and tempFor if between or equal to any of those values
                    DLLNode<T> temp = deque.front;
                    DLLNode<T> tempFor = temp.getForward();
                    boolean forward = true;
                    do {
                        if ((num >= (int) temp.getInfo()) && (num <= (int) tempFor.getInfo())) {
                            T numT = (T) num;
                            DLLNode<T> newNode = new DLLNode<T>(numT);
                            temp.setForward(newNode);
                            newNode.setBack(temp);
                            tempFor.setBack(newNode);
                            newNode.setForward(tempFor);
                            forward = false;
                        } else {
                            temp = temp.getForward();
                            if (tempFor.getForward() != null)
                                tempFor = temp.getForward();
                        }
                    } while (forward);
                    break;
                }
            case 2:
                System.out.println("Enter the integer you want to delete from the deque");
                num = input.nextInt();
                if(deque.isEmpty()){
                    deque.dequeueFront();
                }else
                if(num == deque.front.getInfo())//Deletes if front is value
                    deque.dequeueFront();
                else if(num == deque.rear.getInfo())//Deletes if rear is value
                deque.dequeueRear();
                else{
                    DLLNode<T> temp = deque.front;
                    DLLNode<T> tempFor = temp.getForward();
                    while(tempFor.getInfo() != num){
                        temp = temp.getForward();
                        tempFor = tempFor.getForward();
                    }
                    if(tempFor != null && tempFor.getForward() != null){
                        temp.setForward(tempFor.getForward());
                        tempFor.getForward().setBack(temp);
                        tempFor.setBack(null);
                        tempFor.setForward(null);
                    }else{
                        temp.setForward(tempFor.getForward());
                        tempFor.setBack(null);
                        tempFor.setForward(null);
                    }
                }
                break;
            case 3:
                cont = false;
                break;
            }
            System.out.println("Deque: " + deque.toString());
        }
        System.out.println("Goodbye!");
        input.close();
    }
}
