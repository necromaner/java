/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: necromaner
 * Date: 2017-09-12
 * Time: 下午6:45
 */
public class text5 {
    public static void main(String[] args) {
        System.out.println("给定一个数组，\n" + "int[] abc = { 29, 90, 48, 92};\n" +
                "请遍历输出每一个数 (从头到尾顺序)");
        int[] abc = {29, 90, 48, 92};
        for (int i = 0; i < abc.length; i++) {
            System.out.print(abc[i] + " ");
        }
        System.out.println("\n\n给定一个数组，\n" +
                "int[] abc = { 20, 90, 48, 92};\n" +
                "请倒序输出每一个数。 即，输出 92 48 90 20");
        int[] abc1 = {20, 90, 48, 92};
        for (int i = abc1.length - 1; i >= 0; i--)
            System.out.print(abc1[i] + " ");
        System.out.println("\n\n给定一个数组，\n" +
                "int[] abc = { 20, 90, 48, 92};\n" +
                "输出其中6的倍数");
        for (int i = 0; i < abc1.length; i++) {
            if (abc1[i] % 6 == 0)
                System.out.print(abc1[i] + " ");
        }
        System.out.println("\n" +
                "\n" +
                "已知一个数组，将里面的负数变成正值。\n" +
                "double[] arr = { 90.0, -98.34,  -10, 199 };\n" +
                "写代码把 arr 里面所有的负数改成正的。");
        double[] arr = {90.0, -98.34, -10, 199};
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0)
                arr[i] = -arr[i];
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("\n\n已经两个数组 src 和 dst，\n" +
                "double[] src = { 4, 5.5,  6, 7.7 };\n" +
                "double[] dst =  new double[4];\n" +
                "要求写代码把src的内容拷贝到dst里");
        double[] src = {4, 5.5, 6, 7.7};
        double[] dst = new double[4];
        for (int i = 0; i < src.length; i++) {
            dst[i] = src[i];
        }
        System.out.print("dst=");
        for (int i = 0; i < dst.length; i++) {
            System.out.print(dst[i] + " ");
        }
        System.out.println("\n\n以下有四个学生的信息，请用数组表示：\n" +
                "姓名                             分数\n" +
                "----------------------------------\n" +
                "邵                                 97\n" +
                "王                                 89\n" +
                "张                                 94\n" +
                "李                                 93\n" +
                "定义两个数组 String[]  和 int[] ，并按行打印出来");
        String[] name = {"邵", "王", "张", "李"};
        int[] score = {97, 89, 94, 93};
        System.out.println("姓名                             分数\n" +
                "----------------------------------");
        for (int i = 0; i < name.length; i++) {
            System.out.println(name[i] + "                                 " + score[i]);
        }
        System.out.println("\n\n任意给定一个数组,\n" +
                "double[] src = { 4, 5.5,  6, 7.7 };\n" +
                "写代码把 src 中的内容倒序存储。倒序后，src的内容变成:   7.7   6   5.5   4");
        double[] src1 = {4, 5.5, 6, 7.7};
        double[] x = src1;
        for (int i = 0; i < src1.length; i++) {
            src[i] = x[src1.length - i - 1];
        }
        for (int i = 0; i < src1.length; i++) {
            System.out.print(src1[i] + " ");
        }
        System.out.println("\n\n求出所有1000以内的质数，并存到数组里。\n" +
                "int[] result = new int[50]; // 最多存50个\n" +
                "int count = 0;\n" +
                "即，把找到的质数存到数组 result 里，count表示实际存入的个数\n");
        int[] result = new int[50]; // 最多存50个
        int count = 0;
//        for (int i = 2; i <= 1000; i++) {
//            int xx = 0;
//            for (int m = 2; m <= i; m++) {
//                if (i % m == 0) {
//                    xx++;
//                }
//            }
//            if (xx == 1) {
//                result[count] = i;
//                count++;
//            }
//            if (count >= 50) {
//                break;
//            }
//        }
        for (int i = 2; i <= 1000; i++) {
            boolean xx = true;
            for (int m = 2; m < i; m++) {
                if (i % m == 0) {
                    xx=false;
                    break;
                }
            }
            if (xx) {
                result[count] = i;
                count++;
            }
            if (count >= 50) {
                break;
            }
        }
        
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }
}

