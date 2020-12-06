package dictionaries;

public enum Browser
{
	Chrome,
	Firefox,
	IE,
	Edge,
	Safari,
	Opera;

	public static final int SIZE = java.lang.Integer.SIZE;

	public int getValue()
	{
		return this.ordinal();
	}

	public static Browser forValue(int value)
	{
		return values()[value];
	}
}