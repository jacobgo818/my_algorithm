package go.jacob.day0526.stack;

import java.util.Stack;

/**
 * Given an absolute path for a file (Unix-style), simplify it.
 * <p>
 * For example,
 * path = "/home/", => "/home"
 * path = "/a/./b/../../c/", => "/c"
 * <p>
 * Corner Cases:
 * <p>
 * Did you consider the case where path = "/../"?
 * In this case, you should return "/".
 * Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
 * In this case, you should ignore redundant slashes and return "/home/foo".
 */
public class P71_SimplifyPath {
    public static String simplifyPath(String path) {
        if (path == null || path.length() == 0)
            return path;
        String[] strs = path.split("/");
        Stack<String> stack = new Stack<String>();
        for (int i = 0; i < strs.length; i++) {
            strs[i] = strs[i].trim();
            if (strs[i].equals("") || strs[i].equals("."))
                continue;
            else if (strs[i].equals("..")) {
                if (!stack.isEmpty())
                    stack.pop();
            } else
                stack.push(strs[i]);
        }
        String res = "";
        for (String s : stack) {
            res = res + "/" + s;
        }

        return res.equals("") ? "/" : res;

    }


    public static void main(String[] args) {
//        String s = "/a/./b/../../c/";
//        String s = "/home/";
//        String s = "/home//foo/";
        String s = "/abc/...";
        System.out.println(simplifyPath(s));

    }
}
