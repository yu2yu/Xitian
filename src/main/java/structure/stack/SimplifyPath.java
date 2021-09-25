package structure.stack;

import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 给你一个字符串 path ，表示指向某一文件或目录的Unix 风格 绝对路径 （以 '/' 开头），
 * 请你将其转化为更加简洁的规范路径。
 *
 * 在 Unix 风格的文件系统中，一个点（.）表示当前目录本身；此外，两个点 （..）
 * 表示将目录切换到上一级（指向父目录）；两者都可以是复杂相对路径的组成部分。
 * 任意多个连续的斜杠（即，'//'）都被视为单个斜杠 '/' 。 对于此问题，
 * 任何其他格式的点（例如，'...'）均被视为文件/目录名称。
 *
 */
public class SimplifyPath {

    public String simplifyPath(String path) {
        Stack stack = new Stack<String>();
        String[] paths = path.split("\\/");
        for (String s : paths) {
            if("".equals(s) || ".".equals(s)){
                continue;
            }else if("..".equals(s)){
                if(!stack.isEmpty()){
                    stack.pop();
                }
            }else{
                stack.push(s);
            }
        }
        return "/" + String.join("/",stack);
    }

    @Test
    public void testSimplifyPath(){
        String path = "/home/";
        assertEquals("/home",simplifyPath(path));
        String path2 = "/../";
        assertEquals("/",simplifyPath(path2));
        String path3 = "/home//foo/";
        assertEquals("/home/foo",simplifyPath(path3));
        String path4 = "/a/./b/../../c/";
        assertEquals("/c",simplifyPath(path4));

    }
}
