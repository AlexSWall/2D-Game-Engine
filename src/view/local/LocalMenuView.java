package view.local;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.fills.GradientFill;
import org.newdawn.slick.geom.Rectangle;

public class LocalMenuView
{
	private Color menuBackgroundColour;
	private Color menuTextColour;
	
	LocalMenuView()
	{
		menuBackgroundColour = new Color( 40, 40, 40 );
		menuTextColour = Color.cyan;
	}
	protected void draw ( Graphics g )
	{
		g.fill( new Rectangle( 30, 85, 160, 260 ), new GradientFill( 0, 0, menuBackgroundColour, 100, 100, menuBackgroundColour ) );
		g.setColor( menuTextColour );
		g.drawString( "Resume (R)", 50, 100 );
		g.drawString( "Main Menu (M)", 50, 150 );
		g.drawString( "Quit (Q)", 50, 200 );
		g.drawString( "Save (S)", 50, 250 );
		g.drawString( "Load (L)", 50, 300 );
	}
}
