package coding.interview;

public class Test {
//
//    static volatile Main instance = null;
//
//    public static Main getInstance(){
//        if(instance == null){
//            synchronized {
//                if(instance == null){
//                    instance = new Main();
//                    return instance;
//                }
//            }
//        }
//        return instance;
//    }
//    private Main(){
//
//    }



    public String AddLongInteger(String addend, String augend){
        /*在这里实现功能*/
        int i = addend.length() -1;
        int j = augend.length() -1;
        String result= "";
        boolean flag = false;
        while(i>=0 || j>=0) {
            char addChar;
            if (i < 0) {
                addChar = '0';
            } else {
                addChar = addend.charAt(i);
            }
            char augendChar;
            if (j < 0) {
                augendChar = '0';
            } else {
                augendChar = augend.charAt(j);
            }

            int temp = 0;
            if (flag) {
                temp = 1;
            }
            temp = (addChar - '0') + (augendChar - '0') + temp;
            if(temp< 10){
                result = temp + result;
                flag = false;
            }else{
                flag = true;
                temp = temp - 10;
                result = temp + result;
            }
            i--;
            j--;
        }
        return result;
    }
}
