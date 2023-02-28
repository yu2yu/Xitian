package structure.string;

import sort.CommonUtil;

public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length < 1){
            return "";
        }
        String str = strs[0];
        int strLen = strs[0].length();
        for (int i = 0; i < strLen; i++) {
            for (int j = 1; j < strs.length; i++) {
                if(i > strs[j].length() || strs[j].charAt(i) !=  str.charAt(i)){
                    return strs[0].substring(0,i);
                }
            }
        }
        return str;

    }

}
