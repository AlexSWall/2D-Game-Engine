package view.battle;

import java.nio.file.Paths;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

import view.StateEnum;
import view.font.MaiandraGD;

public class Battle extends BasicGameState
{
	final private int	state;

	private MaiandraGD	maiandraGD;

	private Image		menuBackground;

	private boolean		playNowPointer;

	public Battle( int state )
	{
		this.state = state;
	}

	@Override
	public int getID ()
	{
		return state;
	}

	@Override
	public void init ( GameContainer gc, StateBasedGame sbg ) throws SlickException
	{
		menuBackground = new Image( Paths.get( "resources", "Graphics", "Battle", "Battle Background 800x480.PNG" ).toString() );
		playNowPointer = true;
		maiandraGD = new MaiandraGD();
	}

	@Override
	public void render ( GameContainer gc, StateBasedGame sbg, Graphics g ) throws SlickException
	{
		menuBackground.draw( 0, 0 );
		g.drawImage(
				new Image( Paths.get( "resources", "Graphics", "Battle", "Enemies", "Pikachu", "Pikachu Appears 205x183.png" ).toString() ),
				30f, 30f );
		maiandraGD.get20ptFont().drawString( 200, 425, "A wild Pikachu appears!" );
	}

	@Override
	public void update ( GameContainer gc, StateBasedGame sbg, int delta ) throws SlickException
	{
		Input input = gc.getInput();
		if ( input.isKeyDown( Input.KEY_DOWN ) )
			playNowPointer = false;

		if ( input.isKeyDown( Input.KEY_UP ) )
			playNowPointer = true;

		if ( input.isKeyDown( Input.KEY_ENTER ) )
		{
			if ( playNowPointer )
				sbg.enterState( StateEnum.PLAY.getValue(), new FadeOutTransition( Color.black, 1000 ),
						new FadeInTransition( Color.black, 400 ) );
			else
				System.exit( 0 );
		}
	}

}
