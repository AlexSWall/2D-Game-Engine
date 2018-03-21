package equipment;

import java.util.List;
import java.util.ArrayList;

public class Weapon
{
	private String				weaponName;
	private WeaponClass			weaponClass;
	private int					damage;
	private List<DamageType>	damageTypes;
	private int					upgradeLevel;
	private UpgradeType			upgradeType;
	private int					range;
	private double				weight;
	private String				information;

	public static Weapon[]		axeList					= { Weapon.getBattleAxe(), Weapon.getHandAxe() };
	public static Weapon[]		bowList					= { Weapon.getCompositeBow(), Weapon.getLongbow(), Weapon.getShortbow() };
	public static Weapon[]		crossbowList			= { Weapon.getHeavyCrossbow(), Weapon.getLightCrossbow(),
			Weapon.getSniperCrossbow() };
	public static Weapon[]		curvedGreatswordList	= {};
	public static Weapon[]		curvedSwordList			= { Weapon.getFalchion(), Weapon.getScimitar(), Weapon.getShotel() };
	public static Weapon[]		smallBladeList			= { Weapon.getBanditsKnife(), Weapon.getDagger(), Weapon.getKnife() };
	public static Weapon[]		fistList				= { Weapon.getFists(), Weapon.getClaws(), Weapon.getDildo() };
	public static Weapon[]		greataxeList			= { Weapon.getGreataxe() };
	public static Weapon[]		greatbowList			= { Weapon.getDragonSlayerGreatbow() };
	public static Weapon[]		greatClubList			= { Weapon.getDragonTooth(), Weapon.getGreatClub(), Weapon.getLargeClub() };
	public static Weapon[]		greatswordList			= { Weapon.getBastardSword(), Weapon.getClaymore(), Weapon.getFlamberge(),
			Weapon.getStoneGreatsword() };
	public static Weapon[]		scytheList				= { Weapon.getGreatScythe() };
	public static Weapon[]		halberdList				= { Weapon.getHalberd() };
	public static Weapon[]		hammerList				= { Weapon.getBlacksmithHammer(), Weapon.getHammer(), Weapon.getMorningStar(),
			Weapon.getPickaxe() };
	public static Weapon[]		clubList				= { Weapon.getClub(), Weapon.getMace(), Weapon.getReinforcedClub() };
	public static Weapon[]		katanaList				= { Weapon.getKatana(), Weapon.getUchigatana() };
	public static Weapon[]		spearList				= { Weapon.getPike(), Weapon.getSpear() };
	public static Weapon[]		straightSwordList		= { Weapon.getBroadsword(), Weapon.getLongsword(), Weapon.getShortsword() };
	public static Weapon[]		thrustingSwordList		= { Weapon.getEstoc(), Weapon.getRapier() };
	public static Weapon[]		ultraGreatswordList		= { Weapon.getGreatsword(), Weapon.getZweihander() };
	public static Weapon[]		whipList				= { Weapon.getWhip() };
	public static Weapon[]		flailList				= { Weapon.getFlail() };

	public Weapon( String weaponName, WeaponClass weaponClass, int damage, List<DamageType> types, int range, int upgradeLevel,
			UpgradeType upgradeType, double weight, String information )
	{
		this.weaponName = weaponName;
		this.weaponClass = weaponClass;
		this.damage = damage;
		this.upgradeLevel = upgradeLevel;
		this.damageTypes = types;
		this.range = range;
		this.upgradeType = upgradeType;
		this.information = information;
	}

	public Weapon( String weaponName, WeaponClass weaponClass, int damage, DamageType type, int range, int upgradeLevel,
			UpgradeType upgradeType, double weight, String information )
	{
		List<DamageType> types = new ArrayList<DamageType>();
		types.add( type );

		this.weaponName = weaponName;
		this.weaponClass = weaponClass;
		this.damage = damage;
		this.upgradeLevel = upgradeLevel;
		this.damageTypes = types;
		this.range = range;
		this.upgradeType = upgradeType;
		this.information = information;
	}

	public Weapon( String weaponName, WeaponClass weaponClass, int damage, List<DamageType> types, int range, UpgradeType upgradeType,
			double weight, String information )
	{
		this.weaponName = weaponName;
		this.weaponClass = weaponClass;
		this.damage = damage;
		this.upgradeLevel = 0;
		this.damageTypes = types;
		this.range = range;
		this.upgradeType = upgradeType;
		this.information = information;
	}

	public Weapon( String weaponName, WeaponClass weaponClass, int damage, DamageType type, int range, UpgradeType upgradeType,
			double weight, String information )
	{
		List<DamageType> types = new ArrayList<DamageType>();
		types.add( type );

		this.weaponName = weaponName;
		this.weaponClass = weaponClass;
		this.damage = damage;
		this.upgradeLevel = 0;
		this.damageTypes = types;
		this.range = range;
		this.upgradeType = upgradeType;
		this.information = information;
	}

	public String getWeaponName ()
	{
		return weaponName;
	}

	public int getDamage ()
	{
		return damage;
	}

	public List<DamageType> getType ()
	{
		return damageTypes;
	}

	public String getInformation ()
	{
		return information;
	}

	public WeaponClass getWeaponClass ()
	{
		return weaponClass;
	}

	public int getRange ()
	{
		return range;
	}

	public int getUpgradeLevel ()
	{
		return upgradeLevel;
	}

	public void setUpgradeLevel ( int upgradeLevel )
	{
		this.upgradeLevel = upgradeLevel;
	}

	public UpgradeType getUpgradeType ()
	{
		return upgradeType;
	}

	public double getWeight ()
	{
		return weight;
	}

	public static Weapon getBattleAxe ()
	{
		return new Weapon( "Battle Axe", WeaponClass.AXE, 95, DamageType.SLASH, 1, UpgradeType.STANDARD, 4,
				"Standard battle axe. Inflicts regular damage, making it effective in various situations. Powerful attack due to its weight, but one wrong swing leaves the wielder wide open, so timing and proximity to the enemy must be judged carefully." );
	}

	public static Weapon getHandAxe ()
	{
		return new Weapon( "Hand Axe", WeaponClass.AXE, 80, DamageType.SLASH, 1, UpgradeType.STANDARD, 2,
				"Small hand axe. Appears identical to a lumberjack's tool, but has an ideal weight and strength, and is easy to handle. One wrong swing leaves the wielder wide open, so timing and proximity to the enemy must be judged carefully." );
	}

	public static Weapon getCompositeBow ()
	{
		return new Weapon( "Composite Bow", WeaponClass.BOW, 55, DamageType.STAB, 38, UpgradeType.STANDARD, 1,
				"Composite bow emphasizing power. Requires more strength than standard bows. Fires Faster than the Longbow. \nHowever, its range is shorter, making it unfit for sniping" );
	}

	public static Weapon getLongbow ()
	{
		return new Weapon( "Longbow", WeaponClass.BOW, 36, DamageType.STAB, 50, UpgradeType.STANDARD, 1,
				"Large bow. Projectile weapon for experienced hunters. Equip arrows to use." );
	}

	public static Weapon getShortbow ()
	{
		return new Weapon( "Shortbow", WeaponClass.BOW, 31, DamageType.STAB, 50, UpgradeType.STANDARD, 0.5,
				"Small bow. Standard projectile weapon. Equip arrows to use." );
	}

	public static Weapon getHeavyCrossbow ()
	{
		return new Weapon( "Heavy Crossbow", WeaponClass.CROSSBOW, 55, DamageType.STAB, 50, UpgradeType.STANDARD, 5,
				"Powerful large crossbow. While bows require both hands, a crossbow is held in one, but arming each bolt takes time." );
	}

	public static Weapon getLightCrossbow ()
	{
		return new Weapon( "Light Crossbow", WeaponClass.CROSSBOW, 50, DamageType.STAB, 50, UpgradeType.STANDARD, 3,
				"Standard crossbow issued to soldiers. While bows require both hands, a crossbow is held in one, but arming each bolt takes time." );
	}

	public static Weapon getSniperCrossbow ()
	{
		return new Weapon( "Sniper Crossbow", WeaponClass.CROSSBOW, 52, DamageType.STAB, 70, UpgradeType.STANDARD, 8,
				"Large crossbow with long distance used by Carim snipers. Often used with sniper bolts." );
	}

	public static Weapon getFalchion ()
	{
		return new Weapon( "Falchion", WeaponClass.CURVEDSWORD, 82, DamageType.SLASH, 1, UpgradeType.STANDARD, 2.5,
				"Small curved sword. Each hit inflicts little damage, but fluid chain attacks are deadly. \nThe falchion's sharp slashing attacks are effective against cloth and flesh, but not against metal armor or tough scales." );
	}

	public static Weapon getScimitar ()
	{
		return new Weapon( "Scimitar", WeaponClass.CURVEDSWORD, 80, DamageType.SLASH, 1, UpgradeType.STANDARD, 1.5,
				"Small curved sword. Each hit inflicts little damage, but fluid chain attacks are deadly. \nThe scimitar's sharp slashing attacks are effective against cloth and flesh, but not against metal armor or tough scales." );
	}

	public static Weapon getShotel ()
	{
		List<DamageType> damageTypes = new ArrayList<DamageType>();
		damageTypes.add( DamageType.SLASH );
		damageTypes.add( DamageType.STAB );

		return new Weapon( "Shotel", WeaponClass.CURVEDSWORD, 82, damageTypes, 1, UpgradeType.STANDARD, 2.5,
				"Curved sword with sharply curved blade. \nRequires great skill to wield, but evades shield defense to sneak in damage." );
	}

	public static Weapon getBanditsKnife ()
	{
		List<DamageType> damageTypes = new ArrayList<DamageType>();
		damageTypes.add( DamageType.SLASH );
		damageTypes.add( DamageType.STAB );

		return new Weapon( "Bandit's Knife", WeaponClass.SMALLBLADE, 56, damageTypes, 1, UpgradeType.STANDARD, 1,
				"This wide single-edged shortsword is the favorite of lowly thieves and bandits." );
	}

	public static Weapon getDagger ()
	{
		List<DamageType> damageTypes = new ArrayList<DamageType>();
		damageTypes.add( DamageType.SLASH );
		damageTypes.add( DamageType.STAB );

		return new Weapon( "Dagger", WeaponClass.SMALLBLADE, 56, damageTypes, 1, UpgradeType.STANDARD, 0.5,
				"This standard small dagger has only a modest attack but can be jabbed in rapid succession. With both slash and thrust attacks, this dagger is useful in various situations." );
	}

	public static Weapon getKnife ()
	{
		List<DamageType> damageTypes = new ArrayList<DamageType>();
		damageTypes.add( DamageType.SLASH );
		damageTypes.add( DamageType.STAB );

		return new Weapon( "Knife", WeaponClass.SMALLBLADE, 50, damageTypes, 1, UpgradeType.STANDARD, 0.5,
				"A standard knife that can be used both as utility or for combat." );
	}

	public static Weapon getFists ()
	{
		return new Weapon( "Fists", WeaponClass.FIST, 20, DamageType.BLUDGEON, 1, UpgradeType.STANDARD, 0,
				"Unequip any weapon and use your fists." );
	}

	public static Weapon getClaws ()
	{
		List<DamageType> damageTypes = new ArrayList<DamageType>();
		damageTypes.add( DamageType.SLASH );
		damageTypes.add( DamageType.STAB );

		return new Weapon( "Claws", WeaponClass.FIST, 70, damageTypes, 1, UpgradeType.STANDARD, 1,
				"A weapon formed by three sharped claws." );
	}

	public static Weapon getGreataxe ()
	{
		List<DamageType> damageTypes = new ArrayList<DamageType>();
		damageTypes.add( DamageType.SLASH );
		damageTypes.add( DamageType.BLUDGEON );

		return new Weapon( "Greataxe", WeaponClass.GREATAXE, 140, damageTypes, 1, UpgradeType.STANDARD, 14,
				"This greataxe is a veritable mass of iron. Its weight sends foes flying, but makes it difficult to handle without inhuman strength." );
	}

	public static Weapon getDragonSlayerGreatbow ()
	{
		return new Weapon( "DragonSlayer Greatbow", WeaponClass.GREATBOW, 90, DamageType.STAB, 50, UpgradeType.SPECIAL, 10,
				"Bow of the Dragonslayers. This bow's unusual size requires that it be anchored to the ground when fired. Only uses specialized great arrows." );
	}

	public static Weapon getDragonTooth ()
	{
		return new Weapon( "Dragon Tooth", WeaponClass.GREATCLUB, 290, DamageType.BLUDGEON, 1, UpgradeType.SPECIAL, 18,
				"A tooth of a dragon with a handle carved into the tip, to form a mighty Great Club" );
	}

	public static Weapon getGreatClub ()
	{
		return new Weapon( "Great Club", WeaponClass.GREATCLUB, 135, DamageType.BLUDGEON, 1, UpgradeType.SPECIAL, 12,
				"Giant tree branch serves as a wooden club. Smashes enemies from upside the head." );
	}

	public static Weapon getLargeClub ()
	{
		return new Weapon( "Large Club", WeaponClass.GREATCLUB, 120, DamageType.BLUDGEON, 1, UpgradeType.SPECIAL, 10,
				"Large wooden club." );
	}

	public static Weapon getBastardSword ()
	{
		List<DamageType> damageTypes = new ArrayList<DamageType>();
		damageTypes.add( DamageType.SLASH );
		damageTypes.add( DamageType.STAB );

		return new Weapon( "Bastard Sword", WeaponClass.GREATSWORD, 105, damageTypes, 1, UpgradeType.STANDARD, 6,
				"This standard greatsword is normally wielded with two hands due to its great weight. \nUsually swung in large arcs and effective against multiple foes. Far from ideal when fighting in tight quarters." );
	}

	public static Weapon getClaymore ()
	{
		List<DamageType> damageTypes = new ArrayList<DamageType>();
		damageTypes.add( DamageType.SLASH );
		damageTypes.add( DamageType.STAB );

		return new Weapon( "Claymore", WeaponClass.GREATSWORD, 103, damageTypes, 1, UpgradeType.STANDARD, 6,
				"This larger type of greatsword is normally wielded with two hands due to its weight. \nThis highly flexible greatsword can be used to attack in swings or thrusts." );
	}

	public static Weapon getFlamberge ()
	{
		return new Weapon( "Flamberge", WeaponClass.GREATSWORD, 100, DamageType.SLASH, 1, UpgradeType.STANDARD, 6,
				"This weapon is designed to flay the skin and causes heavy bleeding." );
	}

	public static Weapon getStoneGreatsword ()
	{
		return new Weapon( "Stone Greatsword", WeaponClass.GREATSWORD, 148, DamageType.BLUDGEON, 1, UpgradeType.SPECIAL, 18,
				"This greatsword has both a blunt blades and a blunt point, however its great mass makes it effective for Bludgeoning." );
	}

	public static Weapon getGreatScythe ()
	{
		List<DamageType> damageTypes = new ArrayList<DamageType>();
		damageTypes.add( DamageType.SLASH );
		damageTypes.add( DamageType.STAB );

		return new Weapon( "Great Scythe", WeaponClass.SCYTHE, 100, damageTypes, 2, UpgradeType.STANDARD, 5,
				"Weapon with a long curved blade. Converted from a wheat-harvesting tool. \nThe magnificent sharp curved blade instills fear in opponents. Perhaps it is their survival instinct at work." );
	}

	public static Weapon getHalberd ()
	{
		List<DamageType> damageTypes = new ArrayList<DamageType>();
		damageTypes.add( DamageType.SLASH );
		damageTypes.add( DamageType.STAB );

		return new Weapon( "Halberd", WeaponClass.HALBERD, 110, damageTypes, 2, UpgradeType.STANDARD, 6,
				"Long-hilted weapon mixing spear and axe is difficult to handle, requiring both strength and dexterity. The Halberd has two elementary attacks: spear-like thrusting and large sweeping swings. " );
	}

	public static Weapon getBlacksmithHammer ()
	{
		return new Weapon( "Blacksmith Hammer", WeaponClass.HAMMER, 80, DamageType.BLUDGEON, 1, UpgradeType.STANDARD, 4,
				"A hammer traditionally used by blacksmiths to forge weaponry. It can be used as a weapon, but is better left in the hands of a talented blacksmith." );
	}

	public static Weapon getHammer ()
	{
		return new Weapon( "Hammer", WeaponClass.HAMMER, 75, DamageType.BLUDGEON, 1, UpgradeType.STANDARD, 2,
				"A standard hammer for several uses, which can be used for bludgeoning." );
	}

	public static Weapon getMorningStar ()
	{
		List<DamageType> damageTypes = new ArrayList<DamageType>();
		damageTypes.add( DamageType.BLUDGEON );
		damageTypes.add( DamageType.STAB );

		return new Weapon( "Mourning Star", WeaponClass.HAMMER, 83, damageTypes, 1, UpgradeType.STANDARD, 4,
				"Hammer with a sharp spike on its pommel. One of the more barbaric cleric weapons." );
	}

	public static Weapon getPickaxe ()
	{
		return new Weapon( "Pickaxe", WeaponClass.HAMMER, 89, DamageType.STAB, 1, UpgradeType.STANDARD, 4,
				"Traditionally a mining tool, but the hard cone of the pommel is effective in battle. \nA downward swing of the Pickaxe can crush stone; a human head would be an afterthought." );
	}

	public static Weapon getClub ()
	{
		return new Weapon( "Club", WeaponClass.CLUB, 87, DamageType.BLUDGEON, 1, UpgradeType.STANDARD, 3,
				"A simple wooden club. This simple bladeless strike weapon is effective against most foes, is easily handled, and can break the guard of a shield." );
	}

	public static Weapon getMace ()
	{
		return new Weapon( "Mace", WeaponClass.CLUB, 91, DamageType.BLUDGEON, 1, UpgradeType.STANDARD, 4,
				"A mace is a blunt weapon, a type of club or virge that uses a heavy head on the end of a handle to deliver powerful blows." );
	}

	public static Weapon getReinforcedClub ()
	{
		List<DamageType> damageTypes = new ArrayList<DamageType>();
		damageTypes.add( DamageType.BLUDGEON );
		damageTypes.add( DamageType.STAB );

		return new Weapon( "Reinforced Club", WeaponClass.CLUB, 97, damageTypes, 1, UpgradeType.STANDARD, 4,
				"A club with leather nailed to the pommel and nails sticking out from the opposide end." );
	}

	public static Weapon getKatana ()
	{
		return new Weapon( "Katana", WeaponClass.KATANA, 88, DamageType.SLASH, 1, UpgradeType.STANDARD, 5,
				"The Katana is drawn from the scabbard at lightning speed, using an Iaijutsu technique." );
	}

	public static Weapon getUchigatana ()
	{
		return new Weapon( "Uchigatana", WeaponClass.KATANA, 90, DamageType.SLASH, 1, UpgradeType.STANDARD, 5,
				"The Uchigatana cuts beautifully and causes bleeding, but its blade is easily nicked." );
	}

	public static Weapon getPike ()
	{
		return new Weapon( "Pike", WeaponClass.SPEAR, 86, DamageType.STAB, 3, UpgradeType.STANDARD, 7,
				"Long spear with a very long red hilt. Traditionally used by groups of soldiers. Specially designed for long distance thrusting. Has the longest range of the non-projectile weapons, but its very length makes it somewhat difficult to handle." );
	}

	public static Weapon getSpear ()
	{
		return new Weapon( "Spear", WeaponClass.SPEAR, 80, DamageType.STAB, 2, UpgradeType.STANDARD, 3.5,
				"Standard spear used commonly by soldiers. Long reach, and can be used with shield up. Effective against hard exteriors, and can hit for high damage at the right moment of an enemy's swing. But the hit radius is small, and it is easily blocked by shields." );
	}

	public static Weapon getBroadsword ()
	{
		List<DamageType> damageTypes = new ArrayList<DamageType>();
		damageTypes.add( DamageType.SLASH );
		damageTypes.add( DamageType.STAB );

		return new Weapon( "Broadsword", WeaponClass.STRAIGHTSWORD, 82, damageTypes, 1, UpgradeType.STANDARD, 3,
				"The wide blade of this straight sword emphasizes slicing, and the horizontal sweeping motion makes this sword effective against multiple enemies." );
	}

	public static Weapon getLongsword ()
	{
		List<DamageType> damageTypes = new ArrayList<DamageType>();
		damageTypes.add( DamageType.SLASH );
		damageTypes.add( DamageType.STAB );

		return new Weapon( "Longsword", WeaponClass.STRAIGHTSWORD, 80, damageTypes, 1, UpgradeType.STANDARD, 3,
				"Widely-used standard straight sword, only matched in ubiquity by the shortsword. \nAn accessible sword which inflicts consistent regular damage and high slash damage, making it applicable to a variety of situations." );
	}

	public static Weapon getShortsword ()
	{
		List<DamageType> damageTypes = new ArrayList<DamageType>();
		damageTypes.add( DamageType.SLASH );
		damageTypes.add( DamageType.STAB );

		return new Weapon( "Shortsword", WeaponClass.STRAIGHTSWORD, 78, damageTypes, 1, UpgradeType.STANDARD, 1,
				"This small straight sword is widely used, to an extent only matched by the longsword. \nAn accessible sword which inflicts consistent regular damage and high slash damage, making it applicable to a variety of situations." );
	}

	public static Weapon getEstoc ()
	{
		List<DamageType> damageTypes = new ArrayList<DamageType>();
		damageTypes.add( DamageType.SLASH );
		damageTypes.add( DamageType.STAB );

		return new Weapon( "Estoc", WeaponClass.THRUSTINGSWORD, 75, damageTypes, 1, UpgradeType.STANDARD, 2,
				"The largest of the thrusting swords. Can pierce an armored knight in one thrust. The blade is also sharp, allowing slicing in addition." );
	}

	public static Weapon getRapier ()
	{
		List<DamageType> damageTypes = new ArrayList<DamageType>();
		damageTypes.add( DamageType.SLASH );
		damageTypes.add( DamageType.STAB );

		return new Weapon( "Rapier", WeaponClass.THRUSTINGSWORD, 73, damageTypes, 1, UpgradeType.STANDARD, 1.5,
				"Standard thrusting sword. Regular one-handed attack can be delivered with a shield held up. Thrusting attacks pierce and are effective against foes with hard exteriors." );
	}

	public static Weapon getGreatsword ()
	{
		List<DamageType> damageTypes = new ArrayList<DamageType>();
		damageTypes.add( DamageType.SLASH );
		damageTypes.add( DamageType.BLUDGEON );

		return new Weapon( "Greatsword", WeaponClass.ULTRAGREATSWORD, 130, damageTypes, 2, UpgradeType.STANDARD, 12,
				"One of the gigantic straight greatswords. Very few have what is takes to wield this incredibly heavy, damage-dealing monster." );
	}

	public static Weapon getZweihander ()
	{
		List<DamageType> damageTypes = new ArrayList<DamageType>();
		damageTypes.add( DamageType.SLASH );
		damageTypes.add( DamageType.BLUDGEON );

		return new Weapon( "Zweihander", WeaponClass.GREATSWORD, 130, damageTypes, 2, UpgradeType.STANDARD, 10,
				"One of the gigantic straight greatswords. As the name suggests, the Zweihander is held with two hands, buts its wielder must still be inhumanly strong. It is this great weight that sends foes flying when hit solidly." );
	}

	public static Weapon getWhip ()
	{
		return new Weapon( "Whip", WeaponClass.WHIP, 80, DamageType.SLASH, 2, UpgradeType.STANDARD, 1.5,
				"A Leather Whip. not intended for battle. Virtually ineffective against armor and tough scale, but quite formidable against enemies with exposed skin." );
	}

	public static Weapon getFlail ()
	{
		List<DamageType> damageTypes = new ArrayList<DamageType>();
		damageTypes.add( DamageType.STAB );
		damageTypes.add( DamageType.BLUDGEON );

		return new Weapon( "Flail", WeaponClass.FLAIL, 90, damageTypes, 1, UpgradeType.STANDARD, 4,
				"A ball-and-chain flail. Not commonly seen to be used, but a fear-inspiring weapon that can be weilded with great skill to effectively combat shields." );
	}

	public static Weapon getSickle ()
	{
		List<DamageType> damageTypes = new ArrayList<DamageType>();
		damageTypes.add( DamageType.SLASH );
		damageTypes.add( DamageType.STAB );

		return new Weapon( "Sickle", WeaponClass.SMALLBLADE, 54, damageTypes, 1, UpgradeType.STANDARD, 2,
				"A reinforced sickle, once used as a farmer's implement, now treated for combat." );
	}

	public static Weapon getDildo ()
	{
		return new Weapon( "Huge Purple Dildo", WeaponClass.FIST, 40, DamageType.BLUDGEON, 1, UpgradeType.UNUPGRADEABLE, 10,
				"A heavy duty dildo used by MILFs everywhere. ;)" );
	}

	// public static Weapon get ()
	// {
	// return new Weapon ( "", WeaponClass, ,
	// DamageType, 1, "" );
	// }
}
