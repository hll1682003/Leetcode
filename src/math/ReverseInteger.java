package math;

public class ReverseInteger {

        public static int reverse(int x) {
            long reverse=0;
            int num=x;
            while (num!=0)
            {
                reverse=reverse*10+num%10;
                num/=10;
            }
            //翻转后的数字存在一个long型变量内，再将long类型强制转换为int类型，如果有溢出，
            //转换前后的reverse和test值一定不同（考察原码，补码，反码相关知识），从而达到判断效果
            //另外这里要注意这里判断是否溢出的部分（17行），int和long是可以用于比较的，因为这两者是包含关系。这一点很重要
            int test=(int) reverse;
            if (test!=reverse)
            {
                return 0;
            }
            else
            {
                return test;
            }
        }

        //driver function
        public static void main(String[] args)
        {
            System.out.println(reverse(0));
            System.out.println(reverse(100000));
            System.out.println(reverse(2147483647));
        }
}
