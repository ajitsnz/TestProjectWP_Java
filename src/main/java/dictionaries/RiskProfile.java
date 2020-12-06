package dictionaries;

	public enum RiskProfile
	{
		None,
		Defensive,
		Conservative,
		Balanced,
		Growth;

		public static final int SIZE = java.lang.Integer.SIZE;

		public int getValue()
		{
			return this.ordinal();
		}

		public static RiskProfile forValue(int value)
		{
			return values()[value];
		}
	}