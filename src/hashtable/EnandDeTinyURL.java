package hashtable;

//leetcode对这题的测试方法有问题，完全可以钻空子不做任何映射，但是不代表真的应该这样做。
//我的写法要点有二：
// 1. 维护两个hashmap，这样有利于双向查找，这是为了查重方便，否则就要通过取entryset再遍历的办法查重，这样效率极其低下；
// 2. 在code这个长串里随机选择一个字符append到生成的result字符串后面生成短链接，短链接字符长度我和题目的范例一样都是6个字符

import java.util.HashMap;
import java.util.Random;
//如果在安全方面有考量可以用更好的加密算法而不是Random class的伪随机
//执行效率当然会打折扣，Securerandom在leetcode的运行时间是68ms，而random是16ms
//import java.security.SecureRandom



public class EnandDeTinyURL {

        //Two hashmaps are used to store generated link mappings
        //the reverse one is used to ease checking of repetitions instead of iterating the entryset
        private HashMap<String,String> linkDB=new HashMap<>();
        private HashMap<String,String> reverseLinkDB=new HashMap<>();
        private String code="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";


        // Encodes a URL to a shortened URL.
        public String encode(String longUrl) {

            //if a stored mapping is detected, simply return the mapped value
            if (reverseLinkDB.containsKey(longUrl))
            {
                return "http://tinyurl.com/"+reverseLinkDB.get(longUrl);
            }
            //声明一个随机生成器，如果是用的安全随机则是
            //SecureRandom srnd=new SecureRandom();
            // 其它照旧，因为SecureRandom是继承了Random的
            Random srnd=new Random();
            String result="";
            boolean repDetect=true;
            while(repDetect){
                for (int i=0;i<6;i++)
                {
                    //pick a character randomly each time and append to the result
                    result+=code.charAt(srnd.nextInt(code.length()));
                }
                //check if a same key has been generated
                if (!linkDB.containsKey(result))
                    repDetect=false;
            }
            linkDB.put(result,longUrl);
            reverseLinkDB.put(longUrl,result);
            return "http://tinyurl.com/"+result;
        }

        // Decodes a shortened URL to its original URL.
        //解码函数就只是简单的在hashmap里面找对应的值返回
        public String decode(String shortUrl) {
            //extract the key
            shortUrl=shortUrl.substring(shortUrl.length()-6);
            if (linkDB.containsKey(shortUrl)){
                return linkDB.get(shortUrl);
            }
            else return "";

        }


// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));

    //driver function
    public static void main(String[] args)
    {
        EnandDeTinyURL test=new EnandDeTinyURL();
        String shortURL=test.encode("www.facebook.com");
        System.out.println("first time: "+shortURL);
        System.out.println("second time: "+test.encode("www.facebook.com"));
        System.out.println(test.decode(shortURL));
    }
}
