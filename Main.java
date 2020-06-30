class Main {
  public static void main(String[] args) {
    System.out.println("Hello world!");
  }
  //UNDERSTAND:
  //nodes can only store ints 0 - 9.
  //any space/time constraints? -> let's assume not for now
  //being asked to add values of given nodes in reverse order
  //assuming unordered/ can contain duplicates
  //sample test case:
  //2 -> 8
  //1 -> 2 -> 2
  //output should be: 82 + 221 = 303

  //method stub: 
  //public ListNode addTwoNumbers(ListNode n1, ListNode n2){}

  
  
  //MATCH: 
  //dummy node? yes, and have a carry flag for cases of 
  //the sum equaling larger than 9
  //slow/fast pointer? possibly -> maybe not
  //multiple pass? actually no 
  
  //PLAN:
  //First I would create a dummy head for each list. 
  //begin iterating through both lists until one reaches null, in the case of different sized lists.
  // as I iterate add the two nodes at the same spot.
  //maintain a carry flag for additions of 8 + 2 for example.
  //carry flag would start at: 0 and then become the division of the number by 10. 8 + 3 = 11 
  //carry flag would become 11/10 = 1;
  // 7 + 6 = 13 carry flag would be 13/ 10 = 1
  //getting ones place would be sum % 10 
 
  //2->8
  //8
  //carry = 0; initially
  // pointing at 2 and 8 currently
  //that sum would be 10
  //carry would be sum / 10
  // current node value of new head would be sum % 10
  //would be 0
  //only in the case of sum > 9;
  
  //while loop goes until one of the lists equals null 
  // whichever list doesnt equal become the dummy's .next value

  //IMPLEMENT

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //dummy nodes
        ListNode tempN1 = l1;
        ListNode tempN2 = l2;
        ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead;
        int carry = 0;

        while (tempN1 != null || tempN2 != null) {
            int x = 0;
            if (tempN1 != null) {
                x = tempN1.val;
            }
            int y = 0;
            if (tempN2 != null) {
                y = tempN2.val;
            }
            int tempSum = x + y + carry;
            if (tempSum > 9) {
                current.next =  new ListNode(tempSum % 10);
                carry = tempSum / 10;
            } else {
                current.next = new ListNode(tempSum);
                carry = 0;
            }
            current = current.next;
            if (tempN1 != null) {
                tempN1 = tempN1.next;
            }

            if (tempN2 != null) {
                tempN2 = tempN2.next;
            } 

        }
        if (carry > 0) {
            current.next =  new ListNode(carry);
        }
      return dummyHead.next;
    }







}