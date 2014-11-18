
import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 * 
 * @author sukanyamani
 * 
 * peekIterator is the class which will have the peek function to return the peak value
 * 
 * (eg) :
 * 
 * [1,2,3,4,5] hasNext will return true and value = 1
 * 			   next will return 1 and make the list be [2,3,4,5] and value = null.
 * 			   peek will return 2.
 * 
 * should override the hasNext,next,remove and have an extra peek method.
 * in hasNext method : (each time save the value .)
 * in next method : get the peak value and make the value to be null.
 * in peek method : just return the value. 
 * @param <T>
 */
public class IteratorPeek<T> implements Iterator<T>
{
	private final Iterator<T> itr;
	private T value;
	
	// Create a constructor for this class with iterator as a parameter.
	
	public IteratorPeek(Iterator<T> itr)
	{
		this.itr = itr;
	}
	
	@Override
	public boolean hasNext() 
	{
		if(value !=  null) return true;
		if(itr.hasNext())
		{
			value = itr.next();
		}
		return (value != null);
	}

	@Override
	public T next() {
		if(!hasNext())
			throw (new NoSuchElementException("Next exception"));
		else
		{
			T temp = itr.next();
			value = null;
			return temp;
		}
	}
	
	public T peak()
	{
		if(!hasNext()) 
			throw (new NoSuchElementException("Next exception"));
		return value;
	}

	@Override
	public void remove() {
		
		throw new UnsupportedOperationException();
	}
	

}
