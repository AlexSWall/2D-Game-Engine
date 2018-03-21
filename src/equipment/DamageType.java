package equipment;

public enum DamageType
{
	SLASH ( "Slash" ), STAB ( "Stab" ), BLUDGEON ( "Bludgeon" ), FIRE ( "Fire" ), LIGHTNING ( "Lightning" ), POISON ( "Poison" );

	public String type;

	DamageType( String str )
	{
		type = str;
	}
}
