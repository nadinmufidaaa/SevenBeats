public class Menu {
    MenuNode head;

    public void addMenu (String data){
        MenuNode newNode = new MenuNode(data);
        if (head == null) {
            head = newNode;
            return;
        }
        MenuNode curr = head;
        while (curr.next!= null){
            curr = curr.next;
        }
        curr.next = newNode;
    }
}
