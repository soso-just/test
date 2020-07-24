package coding.oom;

import com.alibaba.fastjson.JSON;

/**
 * JVM配置
 * -Xms200M -Xmx200M -XX:MetaspaceSize=25M -XX:MaxMetaspaceSize=25M -XX:+UseConcMarkSweepGC -XX:+PrintGCDetails -XX:+PrintGCDateStamps -Xloggc:D:/logs/gc-200M.7-4-1.log
 */
public class FastjsonOOMDemo {

    public static void main(String[] args) throws Exception {
        String lineInVaild = "{\"a\":\"\\x";
        JSON.parse(lineInVaild);
    }


    /**
     *
     * 使用1.1.31版本时，oom报错：
     * Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
     * 	at com.alibaba.fastjson.parser.JSONScanner.putChar(JSONScanner.java:2009)
     * 	at com.alibaba.fastjson.parser.JSONScanner.scanString(JSONScanner.java:749)
     * 	at com.alibaba.fastjson.parser.DefaultJSONParser.parseObject(DefaultJSONParser.java:359)
     * 	at com.alibaba.fastjson.parser.DefaultJSONParser.parse(DefaultJSONParser.java:1048)
     * 	at com.alibaba.fastjson.parser.DefaultJSONParser.parse(DefaultJSONParser.java:1026)
     * 	at com.alibaba.fastjson.JSON.parse(JSON.java:102)
     * 	at com.alibaba.fastjson.JSON.parse(JSON.java:92)
     * 	at coding.oom.FastjsonOOMDemo.main(FastjsonOOMDemo.java:11)
     *
     * 	OOM原因：
     * 	在处理过程中，无法正常结束，死循环过程中不断 System.arraycopy(sbuf, 0, newsbuf, 0, sbuf.length); 创建数组
     *
     * 升级1.2.72后，报错但不再OOM
     * Exception in thread "main" com.alibaba.fastjson.JSONException: invalid escape character \x
     * 	at com.alibaba.fastjson.parser.JSONLexerBase.scanString(JSONLexerBase.java:985)
     * 	at com.alibaba.fastjson.parser.DefaultJSONParser.parseObject(DefaultJSONParser.java:479)
     * 	at com.alibaba.fastjson.parser.DefaultJSONParser.parse(DefaultJSONParser.java:1401)
     * 	at com.alibaba.fastjson.parser.DefaultJSONParser.parse(DefaultJSONParser.java:1367)
     * 	at com.alibaba.fastjson.JSON.parse(JSON.java:182)
     * 	at com.alibaba.fastjson.JSON.parse(JSON.java:192)
     * 	at com.alibaba.fastjson.JSON.parse(JSON.java:148)
     * 	at coding.oom.FastjsonOOMDemo.main(FastjsonOOMDemo.java:11)
     *
     * 	源码调整：
     * 	低版本（1.1.31）： com.alibaba.fastjson.parser.JSONScanner#scanString() 721
     * 	char x1 = ch = charAt(++bp);
     *  char x2 = ch = charAt(++bp);
     *
     *  int x_val = digits[x1] * 16 + digits[x2];
     *  char x_char = (char) x_val;
     *  putChar(x_char);
     *
     *   高版本（1.2.72）： com.alibaba.fastjson.parser.JSONLexerBase#scanString() 1047行
     * 	 char x1 = this.next();
     *   char x2 = this.next();
     *   boolean hex1 = x1 >= '0' && x1 <= '9' || x1 >= 'a' && x1 <= 'f' || x1 >= 'A' && x1 <= 'F';
     *   boolean hex2 = x2 >= '0' && x2 <= '9' || x2 >= 'a' && x2 <= 'f' || x2 >= 'A' && x2 <= 'F';
     *   if (!hex1 || !hex2) {
     *      throw new JSONException("invalid escape character \\x" + x1 + x2);
     *   }
     */
}
