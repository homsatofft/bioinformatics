package utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParameterParser
{

	BufferedReader br;
	Map<String, Parameter<Integer>> namedInputIntegers = new HashMap<>();
	Map<String, Parameter<Integer>> namedOutputIntegers = new HashMap<>();
	Map<String, Parameter<String>> namedInputStrings = new HashMap<>();
	ParameterCollection<Integer> inputIntegers;
	ParameterCollection<String> inputStrings;
	ParameterCollection<String> outputStrings;
	Parameter<double[][]> profile;

	private boolean integers = false;
	private boolean strings = false;
	private boolean inline = false;
	private boolean input = false;
	private boolean canWrite = false;
	private boolean profileDoubles;

	/**
	 * Returns a Parameters object with needed input and output data
	 * 
	 * @param source
	 * @param parameters
	 * @return
	 * @throws IOException
	 */
	public void parseDataFile(String[] args) throws IOException
	{
		if (args.length == 0)
		{
			throw new IllegalArgumentException("Please specify parameters!");
		}
		String source = args[0];
		String[] parameters = new String[args.length - 1];
		for (int i = 1; i < args.length; i++)
		{
			parameters[i - 1] = args[i];
		}
		List<String> namesCollection = new ArrayList<>();
		br = new BufferedReader(new FileReader(source));
		for (String parameter : parameters)
		{
			if (parameter.startsWith("-"))
			{
				if (canWrite)
				{
					processData(br, namesCollection);
					namesCollection.clear();
					canWrite = false;
				}
				switch (parameter)
				{
				case Config.INPUT_STRING:
					input = true;
					break;
				case Config.INT_PARAM:
					integers = true;
					strings = false;
					profileDoubles = false;
					inline = false;
					break;
				case Config.STRING_PARAM:
					strings = true;
					integers = false;
					profileDoubles = false;
					inline = false;
					break;
				case Config.IN_LINE_PARAM:
					inline = true;
					break;
				case Config.OUTPUT_STRING:
					input = false;
					break;
				case Config.PROFILE_PARAM:
					strings = false;
					integers = false;
					profileDoubles = true;
					inline = false;
				case Config.END:
					break;
				default:
					break;
				}
				continue;
			}
			namesCollection.add(parameter);
			canWrite = true;
		}
		br.close();
	}

	private void processData(BufferedReader br, List<String> namesCollection)
			throws IOException
	{

		String line;
		line = br.readLine();
		if (line == null)
		{
			return;
		}
		if (line.startsWith(Config.INPUT))
		{
			line = br.readLine();
		}
		if (line.startsWith(Config.OUTPUT))
		{
			input = false;
			line = br.readLine();
		}
		if (inline)
		{
			if (integers)
			{
				parseIntegersLine(line, namesCollection);
			}
			else if (strings)
			{
				parseStringsLine(line, namesCollection);
			}
		}
		else
		{
			while (true)
			{
				if (integers)
				{
					parseIntegerLine(line, namesCollection);
				}
				else if (strings)
				{
					parseStringLine(line, namesCollection);
				}
				else if (profileDoubles)
				{
					parseDoublesLine(line, namesCollection, 0);
					for (int i = 1; i < 4; i++)
					{
						line = br.readLine();
						parseDoublesLine(line, namesCollection, i);
					}
				}
				line = br.readLine();
				if (line == null || line.startsWith(Config.OUTPUT))
				{
					return;
				}
			}
		}
	}

	private void parseDoublesLine(String line, List<String> namesCollection,
			int lineCounter)
	{
		String[] dStrings = line.split(" ");
		if (profile == null)
		{
			profile = new Parameter<double[][]>(namesCollection.get(0));
			double[][] value = new double[4][dStrings.length];
			profile.setValue(value);
		}
		for (int i = 0; i < dStrings.length; i++)
		{
			double d = Double.parseDouble(dStrings[i]);
			profile.value()[lineCounter][i] = d;
		}
	}

	private void parseStringLine(String line, List<String> namesCollection)
	{

		if (input)
		{
			if (inputStrings == null)
			{
				inputStrings = new ParameterCollection<String>(
						namesCollection.get(0));
			}
			inputStrings.add(line);
		}
		else
		{
			if (outputStrings == null)
			{
				outputStrings = new ParameterCollection<String>(
						namesCollection.get(0));
			}
			outputStrings.add(line);
		}
	}

	private void parseIntegerLine(String line, List<String> namesCollection)
	{

		if (input)
		{
			if (inputIntegers == null)
			{
				inputIntegers = new ParameterCollection<Integer>(
						namesCollection.get(0));
			}
			int num = Integer.parseInt(line);
			inputIntegers.add(num);
		}
		else
		{
			// TODO: add output collection
		}
	}

	private void parseStringsLine(String line, List<String> namesCollection)
	{

		String[] strings = line.split(" ");
		if (strings.length == namesCollection.size())
		{
			for (int i = 0; i < strings.length; i++)
			{
				String str = strings[i];
				String name = namesCollection.get(i);
				if (input)
				{

					namedInputStrings.put(name,
							new Parameter<String>(name, str));
				}
				else
				{
					// TODO: add output var here
				}
			}
		}
		else if (namesCollection.size() == 1)
		{
			if (input)
			{
				inputStrings = new ParameterCollection<String>(
						namesCollection.get(0));
				for (int i = 0; i < strings.length; i++)
				{
					inputStrings.add(strings[i]);
				}
			}
			else
			{
				outputStrings = new ParameterCollection<String>(
						namesCollection.get(0));
				for (int i = 0; i < strings.length; i++)
				{
					outputStrings.add(strings[i]);
				}
			}
		}
	}

	private void parseIntegersLine(String line, List<String> namesCollection)
	{

		String[] strings = line.split(" ");
		if (strings.length == namesCollection.size())
		{
			for (int i = 0; i < strings.length; i++)
			{
				int num = Integer.parseInt(strings[i]);
				String name = namesCollection.get(i);
				if (input)
				{
					namedInputIntegers.put(name, new Parameter<Integer>(name,
							num));
				}
				else
				{
					namedOutputIntegers.put(name, new Parameter<Integer>(name,
							num));
				}
			}
		}
		else if (namesCollection.size() == 1)
		{
			inputIntegers = new ParameterCollection<Integer>(
					namesCollection.get(0));
			for (int i = 0; i < strings.length; i++)
			{
				int num = Integer.parseInt(strings[i]);
				if (input)
				{
					inputIntegers.add(num);
				}
				else
				{
					// TODO: add output param
				}
			}
		}
	}

	public int namedInteger(String name)
	{

		return namedInputIntegers.get(name).value();
	}

	public String namedString(String name)
	{

		return namedInputStrings.get(name).value();
	}

	public Collection<String> inputStrings()
	{

		return inputStrings.values();
	}

	public Collection<String> outputStrings()
	{

		return outputStrings.values();
	}

	public double[][] profile()
	{
		return profile.value();
	}
}
