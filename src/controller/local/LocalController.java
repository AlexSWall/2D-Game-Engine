package controller.local;

import java.time.LocalDateTime;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

import controller.MasterController;
import data.MasterData;
import data.local.LocalData;
import data.local.LocalMenuData;
import geometry.Position;
import maps.MapChange;
import save.xml.Save;
import view.MasterView;
import view.StateEnum;
import view.UpdateListener;
import view.local.LocalView;

public class LocalController implements UpdateListener
{
	private MasterController	masterController;
	private MasterData			masterData;
	private MasterView			masterView;
	private LocalData			localData;
	private LocalView			localView;
	private LocalMenuData		localMenuData;

	public LocalController( MasterController masterController )
	{
		this.masterController = masterController;
		this.masterData = masterController.getMasterData();
		this.masterView = masterController.getMasterView();
		this.localData = masterController.getMasterData().getLocalData();
		this.localView = masterController.getMasterView().getLocalView();

	}

	@Override
	public void update ( GameContainer gc, StateBasedGame sbg, int delta ) throws SlickException
	{
		Input input = gc.getInput();

		if ( input.isKeyPressed( Input.KEY_ESCAPE ) )
		{
			localData.setEscMenu( !localData.isEscMenuVisible() );
			if ( localData.isEscMenuVisible() )
				localMenuData = new LocalMenuData();
		}

		if ( localData.isEscMenuVisible() )
			menuUpdate( gc, sbg, delta, input );
		else
			standardUpdate( gc, sbg, delta, input );
	}

	private void standardUpdate ( GameContainer gc, StateBasedGame sbg, int delta, Input input ) throws SlickException
	{
		boolean hasCharacterMoved = masterData.getCharacter().moveCharacter( delta, input, localData.getMap() );

		Position characterPos = masterData.getCharacter().getCharacterPhysics().getPosition();

		if ( hasCharacterMoved && localData.getMap().startBattle( characterPos.getX(), characterPos.getY(), delta ) )
		{
			masterData.getCharacter().getCharacterAnimation().stopCharacterAnimation();
			sbg.enterState( StateEnum.BATTLE.getValue(), new FadeOutTransition( Color.black, 1000 ),
					new FadeInTransition( Color.black, 1000 ) );
		}

		for ( MapChange mapChangeArea : localData.getMap().getMapChangeAreas() )

			if ( mapChangeArea.getMapChangeArea().intersects( masterData.getCharacter().getCharacterPhysics().getCollisionBox() ) )
			{
				localData.changeMap( mapChangeArea );
			}
	}

	private void menuUpdate ( GameContainer gc, StateBasedGame sbg, int delta, Input input ) throws SlickException
	{
		masterData.getCharacter().getCharacterAnimation().stopCharacterAnimation();

		if ( input.isKeyDown( Input.KEY_R ) )
			localData.setEscMenu( false );

		if ( input.isKeyDown( Input.KEY_M ) )
		{
			localData.setEscMenu( false );
			try
			{
				masterData.getSaveDataHandler().write();
			}
			catch ( Exception e )
			{
				System.out.println( "Can't write new save files!" );
			}
			sbg.enterState( 0 );
		}
		if ( input.isKeyDown( Input.KEY_Q ) )
		{
			localData.setEscMenu( false );
			try
			{
				masterData.getSaveDataHandler().write();
			}
			catch ( Exception e )
			{
				System.out.println( "Can't write new save files!" );
			}
			System.exit( 0 );
		}
		if ( input.isKeyDown( Input.KEY_S ) )
		{
			int charXPos = (int) masterData.getCharacter().getCharacterPhysics().getPosition().getX();
			int charYPos = (int) masterData.getCharacter().getCharacterPhysics().getPosition().getY();
			Save saveData = new Save( "SaveName", localData.getMap(), charXPos, charYPos,
					masterData.getCharacter().getCharacterAnimation().getLookDirection(), "No Data" );

			masterData.getSaveDataHandler().addSave( LocalDateTime.now().toString(), saveData );
			try
			{
				Thread.sleep( 500 );
			}
			catch ( InterruptedException e )
			{
				e.printStackTrace();
			}
		}
		if ( input.isKeyDown( Input.KEY_L ) )
		{
			localView.loadGame( masterData.getSaveDataHandler().getSaveFiles().lastEntry().getValue() );
			localData.setEscMenu( false );
		}
		return;
	}

}
