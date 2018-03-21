package save.xml;

public enum SaveAttribute
{
	NAME, MAP, X, Y, DIRECTION, DATA;

	@Override
	public String toString ()
	{
		return this.name().toLowerCase();
	}
}
