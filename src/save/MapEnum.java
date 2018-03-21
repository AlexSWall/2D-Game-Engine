package save;

public enum MapEnum
{
	HouseOuter ( "HouseOuter" ), HouseForest ( "HouseForest" );

	private String name;

	MapEnum( String name )
	{
		this.name = name;
	}

	public String getName ()
	{
		return name;
	}
}
