package view;

public enum StateEnum
{
	MENU ( 0 ), PLAY ( 1 ), BATTLE ( 2 );

	private int value;

	StateEnum( int value )
	{
		this.value = value;
	}

	public int getValue ()
	{
		return value;
	}
}
