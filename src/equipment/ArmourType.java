package equipment;

public enum ArmourType
{
	HEAD ( "Head" ), TORSO ( "Torso" ), FOREARM ( "Forearms" ), LEGS ( "Legs" );

	public String type;

	ArmourType( String type )
	{
		this.type = type;
	}
}
