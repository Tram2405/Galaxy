package util;

public class Currency {
    public static String vndFormat(double value){
        String st = (int)value + "";
        String st2 = " vnd";
        int d = 0;
        for (int i = st.length() - 1; i >= 0; i--) {
            st2 = st.charAt(i) + st2;
            d++;
            if ((d == 3) && (i != 0)) {
                st2 = '.' + st2;
                d = 0;
            }
        }
        return st2;
    }

    public static String vndFormatBuilder(double value) {
        String st = (int) value + "";
        StringBuilder st2 = new StringBuilder(" vnd");
        int d = 0;
        for (int i = st.length() - 1; i >= 0; i--) {
            st2.insert(0, st.charAt(i));
            d++;
            if ((d == 3) && (i != 0)) {
                st2.insert(0, '.');
                d = 0;
            }
        }

        return st2.toString(); //st2 là stringbuilder nên phải dùng toString để trả về String
    }

//    public static String vndStringBuilder(double value){
//
//    }

    public static String usdFormat(double value){
        return "";
    }
}
