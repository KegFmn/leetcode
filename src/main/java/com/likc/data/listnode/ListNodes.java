package com.likc.data.listnode;

/**
 * @author likc
 * @date 2022/3/23
 * @description
 */

public class ListNodes {
         class ListNode {
            int val;
            ListNode next;

            ListNode() {
            }

            ListNode(int val) {
                this.val = val;
            }

            ListNode(int val, ListNode next) {
                this.val = val;
                this.next = next;
            }
        }

         /*合并两个有序链表*/
         ListNode orderListNode(ListNode list1, ListNode list2) {
             if (list1 == null) {
                 return list2;
             } else if (list2 == null) {
                 return list1;
             } else if (list1.val < list2.val) {
                 list1.next = orderListNode(list1.next, list2);
                 return list1;
             } else {
                 list2.next = orderListNode(list1, list2.next);
                 return list2;
             }
         }

         /**
          * 反转链表
          *
          * @param l1
          * @return
          */
         ListNode reverListNode(ListNode l1) {
             ListNode head = null;
             ListNode curr = l1;

             while (curr != null) {
                 ListNode temp = curr.next;
                 curr.next = head;
                 head = curr;
                 curr = temp;
             }
             return head;
         }

         /**
          * 两个链表相加
          *
          * @param l1
          * @param l2
          * @return
          */
         ListNode twoNumAdd(ListNode l1, ListNode l2) {
             // 初始化头结点，我们需要的结果是pre.next
             ListNode pre = new ListNode(0);
             // 将cur同样指向pre所指向的地址
             ListNode cur = pre;

             // 初始化进位
             int carry = 0;
             // 用或者是因为 可能有一个先为null也就是短一些
             while (l1 != null || l2 != null) {
                 int x = l1 == null ? 0 : l1.val;
                 int y = l2 == null ? 0 : l2.val;
                 int sum = x + y + carry;
                 // 取进位
                 carry = sum / 10;
                 // 取下一个节点的值
                 sum = sum % 10;
                 // 将cur的下一节点为 ListNode z，pre和cur指向同一地址所以相当于吧pre的也改了
                 cur.next = new ListNode(sum);

                 // 将cur的指向地址改为ListNode z，形成pre->cur的局面
                 cur = cur.next;

                 // 不为空节点前移
                 if (l1 != null) {
                     l1 = l1.next;
                 }
                 // 不为空节点前移
                 if (l2 != null) {
                     l2 = l2.next;
                 }

             }
             if (carry == 1) {
                 cur.next = new ListNode(carry);
             }

             // 返回pre的下一个节点，也就是我们需要的一整条链表
             return pre.next;
         }

         /*给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。*/
         ListNode temp;

         boolean isPalindrome(ListNode head) {
             temp = head;
             return check(head);
         }

         boolean check(ListNode head) {
             if (head == null)
                 return true;
             // temp 从头节点开始， head由于不停的递归，当到最后一个节点时开始，从后往前
             boolean res = check(head.next) && (temp.val == head.val);
             temp = temp.next;
             return res;
         }

    public static void main(String[] args){

    }
}
