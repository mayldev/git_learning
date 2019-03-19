import java.util.Scanner;

public class Array {
    /**
     * data 定义整型数组保存数据
     */
    private int[] data;
    /**
     * n 定义数组大小
     */
    private int n;
    /**
     * count 定义数组实际长度
     */
    private int count;

    /**
     * @param capacity 定义数组大小
     */
    private Array(int capacity) {
        this.data = new int[capacity];
        this.n = capacity;
        this.count = 0;
    }

    /**
     * 判断数组是否为空
     *
     * @return 数组是否为空
     */
    public boolean isEmpty() {
        return count == 0;
    }

    /**
     * 获取数组当前元素个数
     *
     * @return 数组元素个数
     */
    public int size() {
        return count;
    }

    /**
     * 按位查找：根据索引，找到数组中的元素并返回
     *
     * @param index 需要查找元素的位置
     * @return 对应位置上数组元素的值，找不到返回 -1
     */
    public int findByIndex(int index) {
        if (index < 0 || index >= count) {
            return -1;
        }
        return data[index];
    }

    /**
     * 按值查找：根据元素的值，找到在数组中的位置并返回
     *
     * @param value 需要查找元素的值
     * @return 对应值的元素的位置，找不到返回 -1
     */
    public int findByValue(int value) {
        for (int i = 0; i < count; i++) {
            if (data[i] == value) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 插入元素：根据索引，向数组中插入元素
     *
     * @param index 插入元素的位置
     * @param value 插入元素的值
     * @return 插入结果
     */
    public boolean insert(int index, int value) {
        // 数组空间已满
        if (count == n) {
            System.out.println("没有可插入的位置");
            return false;
        }

        /*
        如果数组空间未满，则插入数据到数组中
        位置不合法，插入失败
        */
        if (index < 0 || index > count) {
            System.out.println("插入位置不合法");
            return false;
        }
        // 位置合法，从最后一个元素开始依次后移
        for (int i = count; i > index; i--) {
            data[i] = data[i - 1];
        }
        data[index] = value;
        count++;
        return true;
    }

    /**
     * 删除元素：根据索引，删除数组中元素
     *
     * @param index 删除元素的位置
     * @return 删除结果
     */
    public boolean delete(int index) {
        if (index < 0 || index >= count) {
            System.out.println("删除位置不合法");
            return false;
        }

        // 从删除位置开始，将后面的元素向前移动一位
        for (int i = index+1; i < count; i++) {
            data[i-1] = data[i];
        }
        count--;
        return true;
    }

    /**
     * 输出数组元素
     */
    public void printAll() {
        for (int i = 0; i < count; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }

    /**
     * 查找数组中的最大元素
     *
     * @return 数组中的最大元素
     */
    public int max() {
        int max = data[0];
        for (int i = 1; i < count; i++) {
            if (data[i] > max) {
                max = data[i];
            }
        }
        return max;
    }

    /**
     * 计算数组元素的平均值
     *
     * @return 数组元素的平均值
     */
    public double average() {
        double sum = 0.0;
        for (int i = 0; i < count; i++) {
            sum += data[i];
        }
        return sum / count;
    }

    /**
     * 颠倒数组元素的顺序
     */
    public void reverse() {
        for (int i = 0; i < count/2; i++) {
            int temp = data[i];
            data[i] = data[count - 1 - i];
            data[count-1-i] = temp;
        }
    }

    /**
     * 复制数组
     */
    public void copy() {
        int[] a = new int[10];
        int[] b = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            b[i] = a[i];
        }
    }

    /**
     * 矩阵（方阵）相乘
     *
     * @param a 二维整型数组
     * @param b 二维整型数组
     */
    public void matrixMul(int[][] a, int[][] b) {
        // 数组 c 保存计算结果
        int[][] c = new int[a.length][a.length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                // 计算行 i 和 列 j 的点乘
                for (int k = 0; k < a.length; k++) {
                    c[i][j] += a[i][k]*b[k][j];
                }
            }
        }
        // 打印结果
        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < c.length; j++) {
                System.out.print(c[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("请输入数组大小：");
        int n = in.nextInt();
        Array array = new Array(n);

        System.out.println(array.isEmpty());

        array.insert(0, 3);
        array.printAll();
        array.insert(0,5);
        array.printAll();
        array.insert(1, 2);
        array.printAll();
        array.insert(2, 6);
        array.printAll();
        array.insert(5,5);
        array.printAll();

        array.delete(2);
        array.printAll();

        System.out.println(array.findByIndex(0));
        System.out.println(array.findByIndex(5));
        System.out.println(array.findByValue(5));
        System.out.println(array.findByValue(3));

        System.out.println(array.max());

        System.out.printf("%.2f\n", array.average());

        array.reverse();
        array.printAll();

        // 测试矩阵乘法
        int[][] a = {
                {1, 1, 1},
                {1, 1, 1},
                {1, 1, 1}
        };
        int[][] b = {
                {2, 2, 2},
                {2, 2, 2},
                {2, 2, 2}
        };
        array.matrixMul(a, b);
    }
}
