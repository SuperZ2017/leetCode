package Double_Pointer;

/**
 * 压缩字符串
 */
public class a443 {

/*
    保留指针 anchor，指向当前读到连续字符串的起始位置。

    从左到右进行读取。当读到最后一个字符，或者下一个下一个字符与当前不同时，则到达连续区块的结尾。

    当我们到达连续区块的结尾时，就从 write 写入压缩的结果。chars[anchor] 为字符，read - anchor + 1 （若大于 1）为长度。
*/

    // TODO rewrite
    public int compress(char[] chars) {
        /*
         read 指向读的位置，
         write 指向写的位置，
         anchor 指向当前读取到连续字符串的起始位置
         */
        int anchor = 0, write = 0;
        for (int read = 0; read < chars.length; read++) {
            if (read + 1 == chars.length || chars[read + 1] != chars[read]) {
                chars[write++] = chars[anchor];
                if (read > anchor) {
                    for (char c : ("" + (read - anchor + 1)).toCharArray()) {
                        chars[write++] = c;
                    }
                }
                anchor = read + 1;
            }
        }

        return write;
    }


    public static void main(String[] args) {
        char[] chars = {'a', 'a', 'a', 'b', 'b', 'c'};

        a443 a = new a443();
        a.compress(chars);
    }


}
