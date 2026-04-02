package Test_examples;

import java.util.Scanner;

// 主类必须是 public，且名字要和文件名（Test1_1）完全一致
public class Test1_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入数组元素（用空格分隔）：");
        String[] inputArr = scanner.nextLine().trim().split("\\s+");
        int[] nums = new int[inputArr.length];

        for(int i = 0; i < inputArr.length; ++i) {
            nums[i] = Integer.parseInt(inputArr[i]);
        }

        System.out.print("请输入目标值 target：");
        int target = scanner.nextInt();

        // 直接调用下面的 Solution1 类
        Solution1 solution = new Solution1();
        int[] result = solution.twoSum(nums, target);

        if (result.length == 2) {
            System.out.println("结果索引: [" + result[0] + ", " + result[1] + "]");
            System.out.println("对应数值: " + nums[result[0]] + " + " + nums[result[1]] + " = " + (nums[result[0]] + nums[result[1]]));
        } else {
            System.out.println("未找到符合条件的两个数");
        }

        scanner.close();
    }
}

// 辅助类：去掉 public，写在同一个文件里
// 注意：不要复制那段 "Source code recreated" 的注释，那是 IDEA 自动生成的垃圾
class Solution1 {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;

        for(int i = 0; i < n; ++i) {
            for(int j = i + 1; j < n; ++j) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }

        return new int[0];
    }
}