import java.util.*;
public class reversePrefix {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string: ");
        String s = sc.nextLine();
        System.out.println("Enter the character: ");
        char ch = sc.next().charAt(0);
        System.out.println("Output: " + reversePrefix2String(s, ch));
        sc.close();

    }

    private static String reversePrefix2String(String word, char ch) {
        int index = word.indexOf(ch);
        if (index == -1) {
            return word;
        }
        return new StringBuilder(word.substring(0, index + 1)).reverse().toString() + word.substring(index + 1);
    }
    
}
