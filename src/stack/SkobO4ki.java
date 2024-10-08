package stack;

public class SkobO4ki {
    public static void main(String[] args) {
        Stack<Character> stack = new Stack<>();
        String str = "]({})";
        boolean flag = true;
        try {
            for (int i = 0; i < str.length() && flag; i++) {
                if (str.charAt(i) == '[' || str.charAt(i) == '(' || str.charAt(i) == '{') {
                    stack.push(str.charAt(i));
                } else if (str.charAt(i) == ']' && stack.peek() == '[' ||
                        str.charAt(i) == '}' && stack.peek() == '{' ||
                        str.charAt(i) == ')' && stack.peek() == '(') {
                    stack.pop();
                } else {
                    flag = false;
                }
            }
        } catch (IndexOutOfBoundsException e) {
            flag = false;
        }
        if (stack.getSize() != 0) {
            flag = false;
        }
        System.out.println(flag ? "Верно" : "Неверно");
    }
}
