package dictionaries;

	public enum KiwiMemberContribution
	{
		None,
		ThreePercent,
		FourPercent,
		SixPercent,
		EightPercent,
		TenPercent;

		public static final int SIZE = java.lang.Integer.SIZE;

		public int getValue()
		{
			return this.ordinal();
		}

		public static KiwiMemberContribution forValue(int value)
		{
			return values()[value];
		}
	}