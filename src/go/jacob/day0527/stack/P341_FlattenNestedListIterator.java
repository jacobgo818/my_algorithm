package go.jacob.day0527.stack;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * Given a nested list of integers, implement an iterator to flatten it.
 * <p>
 * Each element is either an integer, or a list -- whose elements may also be integers or other lists.
 * <p>
 * Example 1:
 * Given the list [[1,1],2,[1,1]],
 * <p>
 * By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,1,2,1,1].
 * <p>
 * Example 2:
 * Given the list [1,[4,[6]]],
 * <p>
 * By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,4,6].
 * <p>
 * ˼·��
 * ʹ��ջ���������
 * ÿ�ε���hasNext����ջ����Ԫ�ص���
 * ���ջ��Ԫ����һ��list����ô��Ԫ���������ջ���ٴ�ѭ��
 */
public class P341_FlattenNestedListIterator {
}

class NestedIterator implements Iterator<Integer> {

    Stack<NestedInteger> stack = null;

    public NestedIterator(List<NestedInteger> nestedList) {
        stack = new Stack<NestedInteger>();
        for (int i = nestedList.size() - 1; i >= 0; i--) {
            stack.push(nestedList.get(i));
        }

    }


    public Integer next() {
        return stack.pop().getInteger();
    }


    public boolean hasNext() {
        while (!stack.isEmpty()) {
            NestedInteger peek = stack.peek();
            if (peek.isInteger())
                return true;
            stack.pop();
            for (int i = peek.getList().size() - 1; i >= 0; i--) {
                stack.push(peek.getList().get(i));
            }
        }

        return false;
    }

    public void remove() {

    }
}


// This is the interface that allows for creating nested lists.
// You should not implement it, or speculate about its implementation
interface NestedInteger {

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger();

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return null if this NestedInteger holds a single integer
    public List<NestedInteger> getList();
}
