package utils;

public class Parameter<T>
{
	private String _name;
	private T _value;

	public Parameter(String name)
	{
		_name = name;
	}
	
	public Parameter(String name, T value)
	{
		_name = name;
		_value = value;
	}

	public String getName()
	{
		return _name;
	}

	public void setValue(T value)
	{
		_value = value;
	}

	public T value()
	{
		return _value;
	}
}
