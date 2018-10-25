package com.single;

import org.junit.Test;

import java.util.List;

/**
 * Created by Walker on 2018/10/16.
 */
public class TestMergeTwoLists {

    /**
     * ��������������ϲ�Ϊһ���µ������������ء���������ͨ��ƴ�Ӹ�����������������нڵ���ɵġ�
     * <p>
     * ʾ����
     * <p>
     * ���룺1->2->4, 1->3->4
     * �����1->1->2->3->4->4
     */
    @Test
    public void test() {
        ListNode l1 = new ListNode(-9);
        l1.next = new ListNode(-7);
        l1.next.next = new ListNode(-3);
        l1.next.next.next = new ListNode(-3);
        l1.next.next.next.next = new ListNode(-3);
        l1.next.next.next.next.next = new ListNode(-1);
        l1.next.next.next.next.next.next = new ListNode(2);
        l1.next.next.next.next.next.next.next = new ListNode(3);

        ListNode l2 = new ListNode(-7);
        l2.next = new ListNode(-7);
        l2.next.next = new ListNode(-6);
        l2.next.next.next = new ListNode(-6);
        l2.next.next.next.next = new ListNode(-5);
        l2.next.next.next.next.next = new ListNode(-3);
        l2.next.next.next.next.next.next = new ListNode(2);
        l2.next.next.next.next.next.next.next = new ListNode(4);

        ListNode listNode = mergeTwoLists3(l1, l2);

        while (listNode != null) {
            if (listNode.next != null) {
                System.out.print(listNode.val + " --> ");
            } else {
                System.out.print(listNode.val);
            }
            listNode = listNode.next;
        }

    }

    //�ڵ�����
    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * ��򵥴ֱ���ʵ���ǣ���������е�ÿһ���ڵ����ȡ��������������һ�ֺ��ʵ�λ�ô�
     * <p>
     * ʱ�临�Ӷ�Ϊ��O(n^2);
     *
     * @param l1
     * @param l2
     */
    private ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        //�߽������жϴ���
        if (l1 != null && l2 != null) {

        } else if (l1 == null) {
            return l2;
        } else {
            return l1;
        }

        //�� l1 ��Ϊ������������ l2 �е�ÿ���ڵ��� l1 �н��в���
        int temp;
        ListNode head1 = l1;

        while (l2 != null) {
            temp = l2.val;
            //ͷ������
            if (temp <= l1.val) {
                ListNode node = new ListNode(temp);
                node.next = l1;
                head1 = l1 = node;
                l2 = l2.next;
                continue;
            }

            //�ҵ����ʵĲ���λ��
            while (l1 != null) {
                if (l1.next != null && l1.next.val > temp) {
                    //�½��Ӧ�������� l1 �� next
                    ListNode node = new ListNode(l2.val);
                    ListNode l1Next = l1.next;
                    l1.next = node;
                    node.next = l1Next;
                    l1 = head1;
                    break;
                } else if (l1.next == null) {
                    //�½��ֱ�Ӳ���������һ��β��
                    ListNode node = new ListNode(l2.val);
                    l1.next = node;
                    l1 = head1;
                    break;
                } else {
                    //˵����ǰ��㲻���ʺϲ����λ��
                    l1 = l1.next;
                }
            }
            l2 = l2.next;
        }

        return head1;
    }


    /**
     * ����ʵ��һ���������������ģ����Խ���һ���̶ȵ��Ż�������
     * ֱ�Ӵ��ϴβ����λ�õ㴦�����Ƚ϶������ͷ�Ƚ�
     * <p>
     * ʱ�临�Ӷ�Ϊ��O(n^2);
     *
     * @param l1
     * @param l2
     */
    private ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        //�߽������жϴ���
        if (l1 != null && l2 != null) {

        } else if (l1 == null) {
            return l2;
        } else {
            return l1;
        }

        //�� l1 ��Ϊ������������ l2 �е�ÿ���ڵ��� l1 �н��в���
        int temp, l1Value;
        ListNode head1 = l1;
        l1Value = l1.val;

        while (l2 != null) {
            temp = l2.val;
            //ͷ������
            if (temp <= l1.val) {
                ListNode node = new ListNode(temp);
                node.next = l1;
                head1 = l1 = node;
                l2 = l2.next;
                continue;
            }

            //�ҵ����ʵĲ���λ��
            while (l1 != null) {
                if (l1.next != null && l1.next.val >= temp) {
                    //�½��Ӧ�������� l1 �� next
                    ListNode node = new ListNode(l2.val);
                    ListNode l1Next = l1.next;
                    l1.next = node;
                    node.next = l1Next;
                    break;
                } else if (l1.next == null) {
                    //�½��ֱ�Ӳ���������һ��β��
                    ListNode node = new ListNode(l2.val);
                    l1.next = node;
                    break;
                } else {
                    //˵����ǰ��㲻���ʺϲ����λ��
                    l1 = l1.next;
                }
            }
            l2 = l2.next;
        }

        return head1;
    }

    /**
     * �ռ任ʱ��Ĳ�����������������ÿ��ͬʱȡ����һ���������ͷ�ڵ㣬
     * �Ƚϴ�С�󽫽�С�Ľڵ������������ɾ���ýڵ�
     *
     * ʱ�临�Ӷ�Ϊ��O(n);
     *
     * @param l1
     * @param l2
     */
    private ListNode mergeTwoLists3(ListNode l1, ListNode l2) {
        //��������һ��Ĭ�ϵĳ�ʼֵ
        ListNode l3 = new ListNode(0);
        ListNode head = l3;
        while(l1 != null && l2 != null){
            if (l1.val <= l2.val){
                //β�巨����
                ListNode node = new ListNode(l1.val);
                l3.next = node;
                l3 = l3.next;
                l1 = l1.next;
            }else{
                //β�巨����
                ListNode node = new ListNode(l2.val);
                l3.next = node;
                l3 = l3.next;
                l2 = l2.next;
            }
        }

        //�߳�ѭ�������¼��ֿ��ܵ����
        //1������һ����������l1 = null
        if (l1 == null){
            l3.next = l2;
        }else if (l2 == null){
            //2�����������������l2 = null
            l3.next = l1;
        }else{
            //�߼����ǲ����� l1 �� l2 ����Ϊ null �����������Ͳ����˳�ѭ��
            System.out.println("�쳣�����");
        }

        return head.next;
    }
}
