package equipment;

import java.util.ArrayList;
import java.util.List;

public class Armour
{
	private String				armourName;
	private ArmourType			armourClass;
	private int					physicalDefence;
	private int					upgradeLevel;
	private List<DamageType>	damageTypeWeaknesses;
	private UpgradeType			upgradeType;
	private String				information;
	private double				weight;

	public Armour( String armourName, ArmourType armourClass, int physicalDefence, int upgradeLevel, List<DamageType> damageTypeWeaknesses,
			UpgradeType upgradeType, String information, double weight )
	{
		this.armourName = armourName;
		this.armourClass = armourClass;
		this.physicalDefence = physicalDefence;
		this.upgradeLevel = upgradeLevel;
		this.damageTypeWeaknesses = damageTypeWeaknesses;
		this.upgradeType = upgradeType;
		this.information = information;
		this.weight = weight;
	}

	public Armour( String armourName, ArmourType armourClass, int physicalDefence, int upgradeLevel, DamageType damageTypeWeakness,
			UpgradeType upgradeType, String information, double weight )
	{
		List<DamageType> damageTypeWeaknesses = new ArrayList<DamageType>();
		damageTypeWeaknesses.add( damageTypeWeakness );

		this.armourName = armourName;
		this.armourClass = armourClass;
		this.physicalDefence = physicalDefence;
		this.upgradeLevel = upgradeLevel;
		this.damageTypeWeaknesses = damageTypeWeaknesses;
		this.upgradeType = upgradeType;
		this.information = information;
		this.weight = weight;
	}

	public Armour( String armourName, ArmourType armourClass, int physicalDefence, int upgradeLevel, UpgradeType upgradeType,
			String information, double weight )
	{
		List<DamageType> damageTypeWeaknesses = new ArrayList<DamageType>();

		this.armourName = armourName;
		this.armourClass = armourClass;
		this.physicalDefence = physicalDefence;
		this.upgradeLevel = upgradeLevel;
		this.damageTypeWeaknesses = damageTypeWeaknesses;
		this.upgradeType = upgradeType;
		this.information = information;
		this.weight = weight;
	}

	public Armour( String armourName, ArmourType armourClass, int physicalDefence, List<DamageType> damageTypeWeaknesses,
			UpgradeType upgradeType, String information, double weight )
	{
		this.armourName = armourName;
		this.armourClass = armourClass;
		this.physicalDefence = physicalDefence;
		this.upgradeLevel = 0;
		this.damageTypeWeaknesses = damageTypeWeaknesses;
		this.upgradeType = upgradeType;
		this.information = information;
		this.weight = weight;
	}

	public Armour( String armourName, ArmourType armourClass, int physicalDefence, DamageType damageTypeWeakness, UpgradeType upgradeType,
			String information, double weight )
	{
		List<DamageType> damageTypeWeaknesses = new ArrayList<DamageType>();

		this.armourName = armourName;
		this.armourClass = armourClass;
		this.physicalDefence = physicalDefence;
		this.upgradeLevel = 0;
		this.damageTypeWeaknesses = damageTypeWeaknesses;
		this.upgradeType = upgradeType;
		this.information = information;
		this.weight = weight;
	}

	public Armour( String armourName, ArmourType armourClass, int physicalDefence, UpgradeType upgradeType, String information,
			double weight )
	{
		List<DamageType> damageTypeWeaknesses = new ArrayList<DamageType>();

		this.armourName = armourName;
		this.armourClass = armourClass;
		this.physicalDefence = physicalDefence;
		this.upgradeLevel = 0;
		this.damageTypeWeaknesses = damageTypeWeaknesses;
		this.upgradeType = upgradeType;
		this.information = information;
		this.weight = weight;
	}

	public int getUpgradeLevel ()
	{
		return upgradeLevel;
	}

	public void setUpgradeLevel ( int upgradeLevel )
	{
		this.upgradeLevel = upgradeLevel;
	}

	public String getArmourName ()
	{
		return armourName;
	}

	public ArmourType getArmourClass ()
	{
		return armourClass;
	}

	public int getPhysicalDefence ()
	{
		return physicalDefence;
	}

	public List<DamageType> getDamageTypeWeaknesses ()
	{
		return damageTypeWeaknesses;
	}

	public UpgradeType getUpgradeType ()
	{
		return upgradeType;
	}

	public String getInformation ()
	{
		return information;
	}

	public double getWeight ()
	{
		return weight;
	}

}
