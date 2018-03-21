package controller.mainmenu;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

import controller.MasterController;
import data.mainmenu.MainMenuData;
import view.StateEnum;
import view.UpdateListener;
import view.mainmenu.MainMenuView;

public class MainMenuController implements UpdateListener
{
	private MasterController masterController;
	private MainMenuData menuData;
	private MainMenuView menuView;
	
	public MainMenuController ( MasterController masterController )
	{
		this.masterController = masterController;
		this.menuData = masterController.getMasterData().getMenuData();
		this.menuView = masterController.getMasterView().getMenuView();
	}
	
	@Override
	public void update ( GameContainer gc, StateBasedGame sbg, int delta ) throws SlickException
	{
		Input input = gc.getInput();

		if ( !( input.isKeyDown( Input.KEY_DOWN ) || input.isKeyDown( Input.KEY_UP ) ) )
		{
			menuData.setButtonHeldDown( false );
			menuData.setButtonTimer( 0 );
		}
		else
		{
			if ( !menuData.isButtonHeldDown() )
			{
				if ( menuData.getButtonTimer() == 0 )
				{
					if ( input.isKeyDown( Input.KEY_UP ) )
					{
						menuData.increaseArrowPositionPointer( -1 );
					}
					if ( input.isKeyDown( Input.KEY_DOWN ) )
					{
						menuData.increaseArrowPositionPointer( 1 );
					}
				}
				else if ( menuData.getButtonTimer() > 200 )
				{
					menuData.setButtonTimer( 0 );
					menuData.setButtonHeldDown( true );
				}
			}
			else
			{
				if ( menuData.getButtonTimer() > 100 )
				{
					menuData.setButtonTimer( 0 );
					
					if ( input.isKeyDown( Input.KEY_UP ) )
					{
						menuData.increaseArrowPositionPointer( -1 );
					}
					if ( input.isKeyDown( Input.KEY_DOWN ) )
					{
						menuData.increaseArrowPositionPointer( 1 );
					}
				}
			}
			
			menuData.increaseButtonTimer( delta );
		}

		if ( input.isKeyDown( Input.KEY_ENTER ) )
		{
			if ( menuData.getArrowPositionPointer() == 0 )
			{
				sbg.enterState( StateEnum.PLAY.getValue(), new FadeOutTransition( Color.black, 1000 ),
						new FadeInTransition( Color.black, 400 ) );
			}
			else if ( menuData.getArrowPositionPointer() == 1 )
				System.exit( 0 );
		}
	}
}
