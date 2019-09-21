import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * @author youyu.song
 * @date 2019/9/17 9:31
 */
public class NestedIterator implements Iterator<Integer> {

	Stack<NestedInteger> stack;

	/**
	 * 给定一个嵌套的整型列表。设计一个迭代器，使其能够遍历这个整型列表中的所有整数。
	 * 列表中的项或者为一个整数，或者是另一个列表。
	 *
	 * 输入: [[1,1],2,[1,1]]
	 * 输出: [1,1,2,1,1]
	 * 解释: 通过重复调用 next 直到 hasNext 返回false，next 返回的元素的顺序应该是: [1,1,2,1,1]。
	 *
	 * 输入: [1,[4,[6]]]
	 * 输出: [1,4,6]
	 * 解释: 通过重复调用 next 直到 hasNext 返回false，next 返回的元素的顺序应该是: [1,4,6]。
	 *
	 * 来源：力扣（LeetCode）
	 * 链接：https://leetcode-cn.com/problems/flatten-nested-list-iterator
	 *
	 * @param nestedList
	 */
	public NestedIterator(List<NestedInteger> nestedList) {
		stack = new Stack<>();
		for (int i = nestedList.size() - 1; i >= 0; i --) {
			stack.push(nestedList.get(i));
		}
	}

	@Override
	public Integer next() {
		return stack.pop().getInteger();
	}

	@Override
	public boolean hasNext() {
		while (! stack.isEmpty()) {
			if (stack.peek().isInteger()) {
				return true;
			}

			List<NestedInteger> list = stack.pop().getList();
			for (int i = list.size() - 1; i >= 0; i --) {
				stack.push(list.get(i));
			}
		}

		return false;
	}
}

interface NestedInteger {
	boolean isInteger();

	Integer getInteger();

	List<NestedInteger> getList();
}
