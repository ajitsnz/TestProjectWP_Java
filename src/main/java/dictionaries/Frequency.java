package dictionaries;

	public enum Frequency
	{
		None,
		Weekly,
		Fortnightly,
		Monthly,
		Annually;

		public static final int SIZE = java.lang.Integer.SIZE;

		public int getValue()
		{
			return this.ordinal();
		}

		public static Frequency forValue(int value)
		{
			return values()[value];
		}
	}