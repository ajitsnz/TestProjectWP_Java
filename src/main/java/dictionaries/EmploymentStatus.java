package dictionaries;

	public enum EmploymentStatus
	{
		None,
		Employed,
		SelfEmployed,
		NotEmployed;

		public static final int SIZE = java.lang.Integer.SIZE;

		public int getValue()
		{
			return this.ordinal();
		}

		public static EmploymentStatus forValue(int value)
		{
			return values()[value];
		}
	}