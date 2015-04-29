package utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ParameterCollection<T>
{
	private String _name;
	private List<T> _values;

	public ParameterCollection(String name)
	{
		_name = name;
		_values = new ArrayList<T>();
	}

	public String getName()
	{
		return _name;
	}

	public Collection<T> values()
	{
		return _values;
	}

	public void add(T value)
	{
		_values.add(value);
	}

	public T get(int i)
	{
		return _values.get(i);
	}

	public int size()
	{
		return _values.size();
	}
}
