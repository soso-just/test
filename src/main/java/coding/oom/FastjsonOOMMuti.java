package coding.oom;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * JVM配置
 * -Xms60M -Xmx60M -XX:MetaspaceSize=10M -XX:MaxMetaspaceSize=10M -XX:+UseConcMarkSweepGC -XX:+PrintGCDetails -XX:+PrintGCDateStamps -Xloggc:D:/logs/gc-100M.7-4-2.log
 */
public class FastjsonOOMMuti {

    public static void main(String[] args) throws Exception {
        for (int i=0; i<10; i++){
            new Thread(()->{
                List<User> users = new ArrayList<>();
                for (int j=0; j< 50; j++){
                    users.add(new User());
                }
//                List<UserDto> userDtoList = JSON.parseArray(JSON.toJSONString(users), UserDto.class);
                JSON.toJSONString(users);
//                System.out.println(userDtoList);
            }).start();
        }
    }


    /**
     * 多线程高并发下，meatspace OOM 分析：
     * 针对源代码： JSON.parseArray(JSON.toJSONString(users), UserDto.class);的使用，
     * 包括JSON.toJSONString(users)的序列化，以及JSON.parseArray反序列化；
     * 上面小程序是在序列化时，会通过ASM加载生成的代理类：
     * com.alibaba.fastjson.serializer.ASMSerializerFactory#createJavaBeanSerializer 255行（版本号：1.1.31）
     * Class<?> exampleClass = classLoader.defineClassPublic(className, code, 0, code.length);
     * 生成的代理类会放入metaspace,生成代理类过多因此产生metaspce OOM
     *
     * 如果场景还原没问题，那这个问题就可以认定为 服务承载了这个配置下不应承载的压力， 扩容或或负载均衡加机器就好
     */
}
