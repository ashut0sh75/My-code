import java.util.*;

public class Test2 {

    public static class Point {
        public int l;
        public int r;
        public int xt;
        public int yt;
        public long tot;

        public Point(int l, int r, int xt, int yt) {
            this.l = l;
            this.r = r;
            this.xt = xt;
            this.yt = yt;
            this.tot = 0;
        }
    }

    static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt(), x = scanner.nextInt(), y = scanner.nextInt();
        System.out.println("n: " + n + ", x: " + x + ", y: " + y); // Print input values
        
        HashMap<Integer, ArrayList<Point>> blocks = new HashMap<>();
        long maxPoints = Long.MIN_VALUE;
        int MAXIMUM = 200000;
        Point[] points = new Point[MAXIMUM];
        Arrays.fill(points, null);

        for (int i = 0; i < n; i++) {
            int l = scanner.nextInt(), r = scanner.nextInt(), xt = scanner.nextInt(), yt = scanner.nextInt();
            System.out.println("l: " + l + ", r: " + r + ", xt: " + xt + ", yt: " + yt); // Print point values
            Point point = new Point(l, r, xt, yt);
            points[xt - 1] = point;
        }

        for (int i = 0; i < MAXIMUM; i++) {
            Point curPoint = points[i];
            if (points[i] != null) {
                int blockNumber = points[i].l / x;
                System.out.println("Current point: (" + curPoint.l + ", " + curPoint.r + ", " + curPoint.xt + ", " + curPoint.yt + ")");
                System.out.println("Block number: " + blockNumber);
                
                Point curMax = null;
                Point max = null;
                ArrayList<Point> prevBlock = getBlock(blockNumber - 1, blocks);
                ArrayList<Point> curBlock = getBlock(blockNumber, blocks);
                ArrayList<Point> nextBlock = getBlock(blockNumber + 1, blocks);
                
                if (prevBlock != null) {
                    curMax = findMax(prevBlock, curPoint, x, y);
                    max = curMax;
                }
                curMax = findMax(curBlock, curPoint, x, y);
                if (max == null) {
                    max = curMax;
                } else {
                    if (curMax != null && curMax.tot >= max.tot) {
                        max = curMax;
                    }
                }
                curMax = findMax(nextBlock, curPoint, x, y);
                if (max == null) {
                    max = curMax;
                } else {
                    if (curMax != null && curMax.tot >= max.tot) {
                        max = curMax;
                    }
                }
                curPoint.tot = (max != null ? max.tot + curPoint.yt : curPoint.yt);
                addPoint(curBlock, curPoint, 0, curBlock.size() - 1);
                if (maxPoints < curPoint.tot) {
                    maxPoints = curPoint.tot;
                }
                System.out.println("Current max points: " + maxPoints);
            }
        }

        if (maxPoints == Long.MIN_VALUE) {
            System.out.println(0);
        } else {
            System.out.println(maxPoints);
        }
    }

    private static ArrayList<Point> getBlock(int blockNumber, HashMap<Integer, ArrayList<Point>> blocks) {
        if (blockNumber < 0) {
            return null;
        }
        ArrayList<Point> block = blocks.get(blockNumber);
        if (block == null) {
            block = new ArrayList<>();
            blocks.put(blockNumber, block);
        }
        return block;
    }

    private static Point findMax(ArrayList<Point> block, Point point, int ld, int rd) {
        for (int i = block.size(); i > 0; i--) {
            Point prevPoint = block.get(i - 1);
            if (Math.abs(prevPoint.r - point.r) <= rd
                    && Math.abs(prevPoint.l - point.l) <= ld) {
                return prevPoint;
            }
        }
        return null;
    }

    private static void addPoint(ArrayList<Point> block, Point point, int left, int right) {
        final long value = point.tot;
        if (block.isEmpty()) {
            block.add(point);
        } else if (right - left <= 1) {
            long leftValue = block.get(left).tot;
            long rightValue = block.get(right).tot;
            if (value < leftValue) {
                block.add(left, point);
            } else if (value >= leftValue && value <= rightValue) {
                block.add(right, point);
            } else {
                if (block.size() - 1 == right) {
                    block.add(point);
                } else {
                    int index = right + 1;
                    block.add(index, point);
                }
            }
        } else {
            int middle = (right + left) / 2;
            long middleValue = block.get(middle).tot;
            if (middleValue <= value) {
                addPoint(block, point, middle, right);
            } else {
                addPoint(block, point, left, middle);
            }
        }
    }
}
