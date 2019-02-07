package cn.chenjianlink.blog.test;

import cn.chenjianlink.blog.common.utils.AddressUtils;
import org.junit.Test;

import java.io.UnsupportedEncodingException;

public class IpTest {
    @Test
    public void ipTest() {
        AddressUtils addressUtils = new AddressUtils();
        // 测试ip 119.167.110.110
        String ip = "119.167.110.110";
        String address = "";
        try {
            address = addressUtils.getAddresses("ip=" + ip, "utf-8");
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(address);
    }
}

