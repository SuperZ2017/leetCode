package String;

/**
 * 反转字符串
 */
public class a344 {

    public void reverseString(char[] s) {
        swap(0,s.length-1,s);
    }
    public void swap(int start,int end,char[] s){
        if(start>=end)
            return;
        char temp = s[end];
        s[end] = s[start];
        s[start] = temp;
        swap(start+1,end-1,s);
    }
}
