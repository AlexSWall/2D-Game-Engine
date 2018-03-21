package equipment;

public enum WeaponClass
{
	FIST ( "Fist" ), HAMMER ( "Hammer" ), CLUB ( "Club" ), GREATHAMMER ( "Great Hammer" ), GREATCLUB ( "Great Club" ), AXE (
			"Axe" ), GREATAXE ( "Great Axe" ), SMALLBLADE ( "Small Blade" ), THRUSTINGSWORD (
					"Thrusting Sword" ), STRAIGHTSWORD ( "Straight Sword" ), GREATSWORD ( "Greatsword" ), ULTRAGREATSWORD (
							"Ultra Greatsword" ), KATANA ( "Katana" ), CURVEDSWORD ( "Curved Sword" ), CURVEDGREATSWORD (
									"Curved Greatsword" ), SPEAR ( "Spear" ), HALBERD ( "Halberd" ), SCYTHE ( "Scythe" ), BOW (
											"Bow" ), CROSSBOW ( "Crossbow" ), GREATBOW ( "Greatbow" ), WHIP ( "Whip" ), FLAIL ( "Flail" );

	public String name;

	WeaponClass( String name )
	{
		this.name = name;
	}
}
