package arrays;

class RangeSumQueryMutable {
    class SegmentTreeNode {
        int start, end, sum;
        SegmentTreeNode left, right;

        SegmentTreeNode(int start, int end) {
            this.start = start;
            this.end = end;
            this.sum = 0;
        }
    }

    private SegmentTreeNode root;

    public RangeSumQueryMutable(int[] nums) {
        root = buildSegmentTree(nums, 0, nums.length - 1);
    }

    private SegmentTreeNode buildSegmentTree(int[] nums, int start, int end) {
        if (start > end) return null;
        SegmentTreeNode node = new SegmentTreeNode(start, end);
        if (start == end) {
            node.sum = nums[start];  // leaf nodes
        } else {
            int mid = start + (end - start) / 2;
            node.left = buildSegmentTree(nums, start, mid);
            node.right = buildSegmentTree(nums, mid + 1, end);
            node.sum = node.left.sum + node.right.sum;
        }
        return node; // return the node that's created to build.
    }

    public void update(int index, int val) {
        update(root, index, val);
    }

    private void update(SegmentTreeNode node, int index, int val) {
        // leave node needs to be updated.
        if (node.start == node.end) {
            node.sum = val;
        } else {
            int mid = node.start + (node.end - node.start) / 2;
            //
            if (index <= mid) {
                update(node.left, index, val);
            } else {
                update(node.right, index, val);
            }
            node.sum = node.left.sum + node.right.sum;
        }
    }

    public int sumRange(int left, int right) {
        return sumRange(root, left, right);
    }

    private int sumRange(SegmentTreeNode node, int start, int end) {
        if (node.start == start && node.end == end) {
            return node.sum;
        }
        int mid = node.start + (node.end - node.start) / 2;
        if (end <= mid) {
            // left child
            return sumRange(node.left, start, end);
        } else if (start > mid) {
            // right child
            return sumRange(node.right, start, end);
        } else {
            // consider both
            return sumRange(node.left, start, mid) + sumRange(node.right, mid + 1, end);
        }
    }
    public static void main(String[] args) {
        int[] nums = {1, 3, 5};
        RangeSumQueryMutable numArray = new RangeSumQueryMutable(nums);
        System.out.println(numArray.sumRange(0, 2)); // Output: 9
        numArray.update(1, 2);
        System.out.println(numArray.sumRange(0, 2)); // Output: 8
    }
}