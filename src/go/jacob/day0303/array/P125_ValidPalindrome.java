package go.jacob.day0303.array;

/**
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

 For example,
 "A man, a plan, a canal: Panama" is a palindrome.
 "race a car" is not a palindrome.

 Note:
 Have you consider that the string might be empty? This is a good question to ask during an interview.

 For the purpose of this problem, we define empty string as valid palindrome.
 */
public class P125_ValidPalindrome {

    public boolean isPalindrome(String s) {
        if(s==null)
            return false;

        int l=0,r=s.length()-1;
        char cleft,cright;

        while(l<r){
            cleft=s.charAt(l);
            cright=s.charAt(r);
            if(!Character.isLetterOrDigit(cleft))
                l++;
            else if(!Character.isLetterOrDigit(cright))
                r--;
            else{
                if(Character.toLowerCase(cleft)!=Character.toLowerCase(cright))
                    return false;
                l++;
                r--;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String s="DGJD,.S,;".toLowerCase();
        System.out.println(s);

    }
}
