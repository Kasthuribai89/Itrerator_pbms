import java.util.Iterator;
import java.util.Stack;
import java.util.Collection;

/**
 * 
 * @author sukanyamani
 * 
 * Below is an explanation of DeepIterator
 * 
 * [int a,int b,vector v1, int e,vector v2]
 * v1 = [int c,int d]
 * v2 = [int f,int g]
 * 
 * So 
 * the iterator of hasNext() should be true when it points to a,
 * the iterator of next() should be b when it points to a.
 * 
 *  1) USe 
 *
 */

public class IteratorDeep<T> implements Iterator
{
	// Since we implementing it we need a constructor for this class
	private T nextItem = null;
	private Stack<Iterator<?>> stack = new Stack<Iterator<?>>();
	
	public IteratorDeep(Collection<T> collection)
	{
		if(collection == null)
			throw (new NullPointerException("There is no collections"));
		else
		{
			stack.push(collection.iterator());
		}
	}
	

	@Override
	public boolean hasNext() 
	{
		if(nextItem != null)
			return true;
		while(!stack.isEmpty())
		{
			Iterator<?> itr = stack.peek();
			if(itr.hasNext())
			{
				Object item = itr.next();
				if(item instanceof Collection<?>)
				{
					stack.push(((Collection<?>) item).iterator());
					
				}
				else
				{
					nextItem = (T) item;
					return true;
				}
			}
			else
			{
				stack.pop();
			}
		}
		return false;
	}

	@Override
	public T next() {
		
		if(hasNext())
		{
			T retItem = nextItem;
			nextItem = null;
					return retItem;
		}
		return null;
	}

	@Override
	public void remove() {
		
		throw new UnsupportedOperationException();
	}
	
}
