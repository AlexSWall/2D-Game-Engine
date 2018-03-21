package character;

import equipment.ForearmArmour;
import equipment.HeadArmour;
import equipment.LegArmour;
import equipment.TorsoArmour;
import equipment.Weapon;

public class PlayerCharacterCreation
{
	public static PlayerCharacter createKnight ( String name )
	{
		return new PlayerCharacter( name, Direction.DOWN, new PlayerCharacterStatistics( 12, 12, 12, 12 ), Weapon.getShortsword(),
				HeadArmour.getIronHead(), TorsoArmour.getIronPlatebody(), LegArmour.getIronPlatebody(), ForearmArmour.getIronPlatebody() );
	}
}
