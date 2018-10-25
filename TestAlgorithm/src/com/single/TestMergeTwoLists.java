package com.single;

import org.junit.Test;

import java.util.List;

/**
 * Created by Walker on 2018/10/16.
 */
public class TestMergeTwoLists {

    /**
     * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
     * <p>
     * 示例：
     * <p>
     * 输入：1->2->4, 1->3->4
     * 输出：1->1->2->3->4->4
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

    //节点类型
    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 最简单粗暴的实现是，将链表二中的每一个节点逐个取出来放置在链表一种合适的位置处
     * <p>
     * 时间复杂度为：O(n^2);
     *
     * @param l1
     * @param l2
     */
    private ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        //边界条件判断处理
        if (l1 != null && l2 != null) {

        } else if (l1 == null) {
            return l2;
        } else {
            return l1;
        }

        //以 l1 作为基础链表，遍历 l2 中的每个节点向 l1 中进行插入
        int temp;
        ListNode head1 = l1;

        while (l2 != null) {
            temp = l2.val;
            //头部插入
            if (temp <= l1.val) {
                ListNode node = new ListNode(temp);
                node.next = l1;
                head1 = l1 = node;
                l2 = l2.next;
                continue;
            }

            //找到合适的插入位置
            while (l1 != null) {
                if (l1.next != null && l1.next.val > temp) {
                    //新结点应当插入在 l1 的 next
                    ListNode node = new ListNode(l2.val);
                    ListNode l1Next = l1.next;
                    l1.next = node;
                    node.next = l1Next;
                    l1 = head1;
                    break;
                } else if (l1.next == null) {
                    //新结点直接插入在链表一的尾部
                    ListNode node = new ListNode(l2.val);
                    l1.next = node;
                    l1 = head1;
                    break;
                } else {
                    //说明当前结点不是适合插入的位置
                    l1 = l1.next;
                }
            }
            l2 = l2.next;
        }

        return head1;
    }


    /**
     * 基于实现一，且链表二是有序的，可以进行一定程度的优化操作，
     * 直接从上次插入的位置点处继续比较而无需从头比较
     * <p>
     * 时间复杂度为：O(n^2);
     *
     * @param l1
     * @param l2
     */
    private ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        //边界条件判断处理
        if (l1 != null && l2 != null) {

        } else if (l1 == null) {
            return l2;
        } else {
            return l1;
        }

        //以 l1 作为基础链表，遍历 l2 中的每个节点向 l1 中进行插入
        int temp, l1Value;
        ListNode head1 = l1;
        l1Value = l1.val;

        while (l2 != null) {
            temp = l2.val;
            //头部插入
            if (temp <= l1.val) {
                ListNode node = new ListNode(temp);
                node.next = l1;
                head1 = l1 = node;
                l2 = l2.next;
                continue;
            }

            //找到合适的插入位置
            while (l1 != null) {
                if (l1.next != null && l1.next.val >= temp) {
                    //新结点应当插入在 l1 的 next
                    ListNode node = new ListNode(l2.val);
                    ListNode l1Next = l1.next;
                    l1.next = node;
                    node.next = l1Next;
                    break;
                } else if (l1.next == null) {
                    //新结点直接插入在链表一的尾部
                    ListNode node = new ListNode(l2.val);
                    l1.next = node;
                    break;
                } else {
                    //说明当前结点不是适合插入的位置
                    l1 = l1.next;
                }
            }
            l2 = l2.next;
        }

        return head1;
    }

    /**
     * 空间换时间的操作，定义链表三，每次同时取链表一和链表二的头节点，
     * 比较大小后将较小的节点插入链表三并删除该节点
     *
     * 时间复杂度为：O(n);
     *
     * @param l1
     * @param l2
     */
    private ListNode mergeTwoLists3(ListNode l1, ListNode l2) {
        //给链表三一个默认的初始值
        ListNode l3 = new ListNode(0);
        ListNode head = l3;
        while(l1 != null && l2 != null){
            if (l1.val <= l2.val){
                //尾插法即可
                ListNode node = new ListNode(l1.val);
                l3.next = node;
                l3 = l3.next;
                l1 = l1.next;
            }else{
                //尾插法即可
                ListNode node = new ListNode(l2.val);
                l3.next = node;
                l3 = l3.next;
                l2 = l2.next;
            }
        }

        //走出循环有以下几种可能的情况
        //1、链表一遍历结束，l1 = null
        if (l1 == null){
            l3.next = l2;
        }else if (l2 == null){
            //2、链表二遍历结束，l2 = null
            l3.next = l1;
        }else{
            //逻辑上是不存在 l1 和 l2 都不为 null 的情况，否则就不会退出循环
            System.out.println("异常情况！");
        }

        return head.next;
    }
}
