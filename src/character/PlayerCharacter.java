package character;

import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.Input;
import org.newdawn.slick.geom.Shape;

import equipment.ForearmArmour;
import equipment.HeadArmour;
import equipment.LegArmour;
import equipment.TorsoArmour;
import equipment.Weapon;
import maps.AbstractGameMap;
import quests.Quest;
import save.xml.Save;

public class PlayerCharacter
{
	private String						name;
	private PlayerCharacterStatistics	stats;
	private PlayerCharacterEquipment	equipment;
	private PlayerCharacterPhysics		physics;
	private PlayerCharacterAnimation	animation;
	private List<Quest>					quests;

	PlayerCharacter( String name, Direction direction, PlayerCharacterStatistics stats, Weapon weapon, HeadArmour headArmour,
			TorsoArmour torsoArmour, LegArmour legArmour, ForearmArmour forearmArmour )
	{
		this.name = name;
		this.stats = stats;
		this.equipment = new PlayerCharacterEquipment( weapon, headArmour, torsoArmour, legArmour, forearmArmour );
		this.physics = new PlayerCharacterPhysics();
		this.animation = new PlayerCharacterAnimation( direction, physics.getSpeed(), 0.57 );
		this.quests = new ArrayList<Quest>();
	}

	public PlayerCharacter( String name, Save save )
	{
		this( name, null, null, null, null, null, null, null );
		this.physics = new PlayerCharacterPhysics();
		this.animation = new PlayerCharacterAnimation( save.getDirection(), physics.getSpeed(), 0.57 );

		List<Shape> collShapes = new ArrayList<Shape>();
		collShapes.add( physics.getCollisionBox() );
	}

	public String getName ()
	{
		return name;
	}

	public PlayerCharacterStatistics getCharacterStats ()
	{
		return stats;
	}

	public PlayerCharacterEquipment getCharacterEquipment ()
	{
		return equipment;
	}

	public List<Quest> getQuests ()
	{
		return quests;
	}

	public PlayerCharacterPhysics getCharacterPhysics ()
	{
		return physics;
	}

	public PlayerCharacterAnimation getCharacterAnimation ()
	{
		return animation;
	}

	private int		relX;
	private int		relY;
	private boolean	isShiftDown;

	public boolean moveCharacter ( int delta, Input input, AbstractGameMap map )
	{
		relX = 0;
		relY = 0;

		if ( input.isKeyDown( Input.KEY_UP ) )
		{
			relY++;
		}

		if ( input.isKeyDown( Input.KEY_RIGHT ) )
		{
			relX++;
		}

		if ( input.isKeyDown( Input.KEY_DOWN ) )
		{
			relY--;
		}

		if ( input.isKeyDown( Input.KEY_LEFT ) )
		{
			relX--;
		}

		isShiftDown = input.isKeyDown( Input.KEY_LSHIFT );
		boolean return_bool = physics.moveCharacter( map, delta, relX, relY, isShiftDown );
		animation.moveCharacter( delta, relX, relY, isShiftDown );
		return return_bool;
	}
}
