package equipment;

import java.util.List;

public class LegArmour extends Armour
{
	public LegArmour( String armourName, ArmourType armourClass, int physicalDefence, int upgradeLevel,
			List<DamageType> damageTypeWeaknesses, UpgradeType upgradeType, String information, double weight )
	{
		super( armourName, armourClass, physicalDefence, upgradeLevel, damageTypeWeaknesses, upgradeType, information, weight );
	}

	public LegArmour( String armourName, ArmourType armourClass, int physicalDefence, int upgradeLevel, DamageType damageTypeWeakness,
			UpgradeType upgradeType, String information, double weight )
	{
		super( armourName, armourClass, physicalDefence, upgradeLevel, damageTypeWeakness, upgradeType, information, weight );
	}

	public LegArmour( String armourName, ArmourType armourClass, int physicalDefence, int upgradeLevel, UpgradeType upgradeType,
			String information, double weight )
	{
		super( armourName, armourClass, physicalDefence, upgradeLevel, upgradeType, information, weight );
	}

	public LegArmour( String armourName, ArmourType armourClass, int physicalDefence, List<DamageType> damageTypeWeaknesses,
			UpgradeType upgradeType, String information, double weight )
	{
		super( armourName, armourClass, physicalDefence, damageTypeWeaknesses, upgradeType, information, weight );
	}

	public LegArmour( String armourName, ArmourType armourClass, int physicalDefence, DamageType damageTypeWeakness,
			UpgradeType upgradeType, String information, double weight )
	{
		super( armourName, armourClass, physicalDefence, damageTypeWeakness, upgradeType, information, weight );
	}

	public LegArmour( String armourName, ArmourType armourClass, int physicalDefence, UpgradeType upgradeType, String information,
			double weight )
	{
		super( armourName, armourClass, physicalDefence, upgradeType, information, weight );
	}

	public static LegArmour getIronPlatebody ()
	{
		return new LegArmour( "Iron Platelegs", ArmourType.LEGS, 0, UpgradeType.STANDARD, "A standard set of iron platelegs.", 8.0 );
	}
}
