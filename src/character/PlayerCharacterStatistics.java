package character;

public class PlayerCharacterStatistics
{
	private int	vitality;
	private int	endurance;
	private int	strength;
	private int	dexterity;
	private int	maxHealth;
	private int	maxEquipmentWeight;

	public PlayerCharacterStatistics( int vitality, int endurance, int strength, int dexterity )
	{
		this.vitality = vitality;
		this.endurance = endurance;
		this.strength = strength;
		this.dexterity = dexterity;
		this.maxHealth = 50 + 20 * vitality;
		this.maxEquipmentWeight = 40 + endurance;
	}

	public int getVitality ()
	{
		return vitality;
	}

	public void setVitality ( int vitality )
	{
		this.vitality = vitality;
	}

	public int getEndurance ()
	{
		return endurance;
	}

	public void setEndurance ( int endurance )
	{
		this.endurance = endurance;
	}

	public int getStrength ()
	{
		return strength;
	}

	public void setStrength ( int strength )
	{
		this.strength = strength;
	}

	public int getDexterity ()
	{
		return dexterity;
	}

	public void setDexterity ( int dexterity )
	{
		this.dexterity = dexterity;
	}

	public int getMaxHealth ()
	{
		return maxHealth;
	}

	public void setMaxHealth ( int maxHealth )
	{
		this.maxHealth = maxHealth;
	}

	public int getMaxEquipmentWeight ()
	{
		return maxEquipmentWeight;
	}

	public void setMaxEquipmentWeight ( int maxEquipmentWeight )
	{
		this.maxEquipmentWeight = maxEquipmentWeight;
	}

}
