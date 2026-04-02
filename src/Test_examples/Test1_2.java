package Test_examples;

import java.util.Scanner;

// 主类：文件名必须叫 Test1_2.java
public class Test1_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("输入 l1（空格分隔，如 2 4 3）：");
        ListNode l1 = buildList(sc.nextLine());

        System.out.print("输入 l2（空格分隔，如 5 6 4）：");
        ListNode l2 = buildList(sc.nextLine());

        Solution2 sol = new Solution2();
        ListNode result = sol.addTwoNumbers(l1, l2);

        System.out.print("结果链表：");
        printList(result);

        sc.close();
    }

    // 辅助方法：把字符串转成链表
    static ListNode buildList(String input) {
        String[] parts = input.trim().split("\\s+");
        if (parts.length != 0 && !parts[0].isEmpty()) {
            ListNode dummy = new ListNode(0);
            ListNode curr = dummy;

            for(String s : parts) {
                curr.next = new ListNode(Integer.parseInt(s));
                curr = curr.next;
            }

            return dummy.next;
        } else {
            return null;
        }
    }

    // 辅助方法：打印链表
    static void printList(ListNode head) {
        for(; head != null; head = head.next) {
            System.out.print(head.val);
            if (head.next != null) {
                System.out.print(" → ");
            }
        }
        System.out.println();
    }
}

// 辅助类：链表节点定义
// 注意：去掉 public，这样它才能和主类待在同一个文件里
class ListNode {
    int val;
    ListNode next; // 修正：属性名通常用小写 next

    ListNode(int val) {
        this.val = val;
    }
}

// 辅助类：算法实现
class Solution2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode tail = null;
        int carry = 0;

        while(l1 != null || l2 != null) {
            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;
            int sum = n1 + n2 + carry;

            if (head == null) {
                head = tail = new ListNode(sum % 10);
            } else {
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }

            carry = sum / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }

        if (carry > 0) {
            tail.next = new ListNode(carry);
        }

        return head;
    }
}
