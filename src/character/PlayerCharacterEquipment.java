package character;

import java.util.ArrayList;
import java.util.List;

import equipment.ForearmArmour;
import equipment.HeadArmour;
import equipment.LegArmour;
import equipment.TorsoArmour;
import equipment.Weapon;

public class PlayerCharacterEquipment
{
	private List<Weapon>		weapons;
	private int					weaponPointer;

	private List<HeadArmour>	headArmour;
	private int					headArmourPointer;

	private List<TorsoArmour>	torsoArmour;
	private int					torsoArmourPointer;

	private List<LegArmour>		legArmour;
	private int					legArmourPointer;

	private List<ForearmArmour>	forearmArmour;
	private int					forearmArmourPointer;

	public PlayerCharacterEquipment( Weapon weapon, HeadArmour headArmour, TorsoArmour torsoArmour, LegArmour legArmour,
			ForearmArmour forearmArmour )
	{
		this.weapons = new ArrayList<Weapon>();
		this.weapons.add( weapon );
		this.weaponPointer = 0;

		this.headArmour = new ArrayList<HeadArmour>();
		this.headArmour.add( headArmour );
		this.headArmourPointer = 0;

		this.torsoArmour = new ArrayList<TorsoArmour>();
		this.torsoArmour.add( torsoArmour );
		this.torsoArmourPointer = 0;

		this.legArmour = new ArrayList<LegArmour>();
		this.legArmour.add( legArmour );
		this.legArmourPointer = 0;

		this.forearmArmour = new ArrayList<ForearmArmour>();
		this.forearmArmour.add( forearmArmour );
		this.forearmArmourPointer = 0;
	}

	public int getWeaponPointer ()
	{
		return weaponPointer;
	}

	public void setWeaponPointer ( int weaponPointer )
	{
		this.weaponPointer = weaponPointer;
	}

	public int getHeadArmourPointer ()
	{
		return headArmourPointer;
	}

	public void setHeadArmourPointer ( int headArmourPointer )
	{
		this.headArmourPointer = headArmourPointer;
	}

	public int getTorsoArmourPointer ()
	{
		return torsoArmourPointer;
	}

	public void setTorsoArmourPointer ( int torsoArmourPointer )
	{
		this.torsoArmourPointer = torsoArmourPointer;
	}

	public int getLegArmourPointer ()
	{
		return legArmourPointer;
	}

	public void setLegArmourPointer ( int legArmourPointer )
	{
		this.legArmourPointer = legArmourPointer;
	}

	public int getForearmArmourPointer ()
	{
		return forearmArmourPointer;
	}

	public void setForearmArmourPointer ( int forearmArmourPointer )
	{
		this.forearmArmourPointer = forearmArmourPointer;
	}

	public List<Weapon> getWeapons ()
	{
		return weapons;
	}

	public List<HeadArmour> getHeadArmour ()
	{
		return headArmour;
	}

	public List<TorsoArmour> getTorsoArmour ()
	{
		return torsoArmour;
	}

	public List<LegArmour> getLegArmour ()
	{
		return legArmour;
	}

	public List<ForearmArmour> getForearmArmour ()
	{
		return forearmArmour;
	}

}
