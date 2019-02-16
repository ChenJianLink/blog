package cn.chenjianlink.blog.test;


import org.apache.shiro.crypto.hash.Md5Hash;
import org.junit.Test;

public class MD5Test {
    //Md5散列测试
    @Test
    public void md5Test() {
        Md5Hash md5Hash = new Md5Hash("1111", "hehe", 2);
        System.out.println(md5Hash);
    }
}
