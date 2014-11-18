import java.util.Iterator;
import java.util.NoSuchElementException;


public class IteratorofIterators<T> implements Iterator<T>
{
	
	private Iterator<Iterator<T>> mainIterator;
	private Iterator<T> subIterator;
	
	public IteratorofIterators(Iterator<Iterator<T>> itr)
	{
		this.mainIterator = itr;
	}

	@Override
	public boolean hasNext() {
		if(setsubIterator())
			return true;
		return false;
	}
	
	public Iterator<T> getSubIterator()
	{
		Iterator<T> temp = null;
		if(temp == null && mainIterator.hasNext())
		{
			temp = mainIterator.next();
		}
		return temp;
	}

	public boolean setsubIterator()
	{
		if(subIterator == null || !subIterator.hasNext())
		{
			do
			{
				subIterator = getSubIterator();
				if(subIterator == null)
					return false;
			}while(!subIterator.hasNext());
		}
		return true;
	}
	@Override
	public T next() {
		if(!hasNext())
		{
			throw (new NoSuchElementException());
		}
		return subIterator.next();
	}

	@Override
	public void remove() {
		
		throw new UnsupportedOperationException();
	}

}
