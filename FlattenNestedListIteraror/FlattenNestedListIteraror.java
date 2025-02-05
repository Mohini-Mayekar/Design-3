/* Time Complexity : O(d) ~ amotized O(1) 
 *	d - max. depth of the list */
/* Space Complexity : O(h)
 *	h - height of the stack */
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this :


/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
    
    Stack<Iterator<NestedInteger>> st;
    NestedInteger nextEle;

    public NestedIterator(List<NestedInteger> nestedList) {
        this.st = new Stack<>();
        this.st.push(nestedList.iterator());   
    }

    @Override
    public Integer next() {
        return nextEle.getInteger();
    }

    @Override
    public boolean hasNext() {
        while(!st.isEmpty()){
            if(!st.peek().hasNext()){
                st.pop();
            }
            else if((nextEle = st.peek().next()).isInteger()){
                return true;
            }
            else{
                st.push(nextEle.getList().iterator());
            }
        }
        return false;
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */