package com.algo.tree;

public class ListToBST109 {
    static void main() {
    }

    //Use slow and fast pointer to find mid of the list then
    //divide list node and recursively create each node
    //Slow approach
    //Time Complexity: O(N log N)
    //Space Complexity:
    //Time complexity: O(log N)
    private static TreeNode convertToBST1(ListNode head) {
        if (head == null) {
            return null;
        }
        var fast = head;
        var slow = head;
        ListNode prev = null;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        var root = new TreeNode(slow.val);
        if (prev != null) {
            prev.next = null;
            root.left = convertToBST1(head);
            root.right = convertToBST1(slow.next);
        }
        return root;
    }


    //Optimized approach
    //Time complexity: Time Complexity: O(n)
    //Space complexity: O(log n)
    // Since logic tries to build balanced BST, space complexity will be equal to heigh of the tree
    private static TreeNode convertToBST2(ListNode head) {
        var len = getLen(head);
        var node = new Head(head);
        return convertToBST2(node, 0, len - 1);
    }

    private static int getLen(ListNode head) {
        var count = 0;
        while (head != null) {
            ++count;
            head = head.next;
        }
        return count;
    }

    private static TreeNode convertToBST2(Head head, int start, int end) {
        if (start > end) {
            return null;
        }
        var mid = start + (end - start) / 2;
        var left = convertToBST2(head, start, mid - 1);
        var root = new TreeNode(head.node.val);
        root.left = left;
        head.node = head.node.next;
        root.right = convertToBST2(head, mid + 1, end);
        return root;
    }

    private static class Head {

        private ListNode node;

        public Head(ListNode node) {
            this.node = node;
        }
    }

    private static class TreeNode {
        int val;

        TreeNode left;

        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }


    private static class ListNode {
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
}
