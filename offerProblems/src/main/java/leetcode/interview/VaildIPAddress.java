package leetcode.interview;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2020-05-17 08:15
 **/
public class VaildIPAddress {

    public static void main(String[] args) {
        VaildIPAddress vaildIPAddress = new VaildIPAddress();
//        String ip = "172.16.254.01"; // error
        String ip =
//                "2001:0db8:85a3::8A2E:0370:7334";//error
//                "1.1.1.1.";
//                "2001:0db8:85a3:0000:0:8A2E:0370:733a";
                "20EE:FGb8:85a3:0:0:8A2E:0370:7334";

//                "2001:0db8:85a3:00000:0:8A2E:0370:7334";
//                "2001:0db8:85a3:0:0:8A2E:0370:7334:";
//        2001:db8:85a3:0:0:8A2E:0370:7334 //  true
        boolean matches = ip.matches("[f-zF-Z]");
        System.out.println(vaildIPAddress.validIPAddress(ip));
    }

    public String validIPAddress(String IP) {
        if (IP.contains(".")) {
            if (checkIpV4(IP)) {
                return "IPv4";
            }
        } else {
            if (checkIpV6(IP)) {
                return "IPv6";
            }
        }
        return "Neither";
    }

    boolean checkIpV4(String ip) {
        char[] chars = ip.toCharArray();
        if (chars[chars.length-1]=='.'|| chars[0]=='.') {
            return false ;
        }
//        if(ip.matches("[a-zA-Z]")){
//            return  false ;
//        }
        if (containsABC(ip)){
            return false ;
        }
        String[] split = ip.split("\\.");
        if(split.length!=4){
            return false;
        }
        for (String s : split) {
            if(s.isEmpty()){
                return false ;
            }

            if (s.length() > 1 && s.startsWith("0")) {
                return false;
            }



            int i = Integer.parseInt(s);
            if (i < 0 || i > 255) {
                return false;
            }
        }
        return true;
    }
    boolean containsABC(String s) {
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (c == '0' || c == '1' || c == '2' || c == '3' || c == '4' || c == '5' || c == '6' || c == '7' || c == '8' || c == '9')
                continue;
            else
                return true;
        }
        return false;
    }

    boolean checkIpV6(String ip) {
        String[] split = ip.split(":");
//        System.out.println(split);
        char[] chars = ip.toCharArray();
        if (chars[chars.length-1]==':'|| chars[0]==':') {
            return false ;
        }
        if(split.length!=8){
            return false;
        }
//
        if (ip.matches("[f-z|F-Z]")) {
            return  false;
        }
        boolean res = true;
        for (int i =0; i<split.length;i++) {
            String  s= split[i];
            if (s.isEmpty()||s.length()>4) {
                res = false;
                break;
            }

        }
        return res;
    }

}
