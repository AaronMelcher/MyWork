package doubleLinkedLists;

public class DLTest {

    public static void main(String[] args) {
        DList<String> dList = new DList<String>();
        System.out.println(dList.toString());
        dList.pop();
        System.out.println(dList.toString());
        dList.pop();
        System.out.println(dList.toString());
    }

}
