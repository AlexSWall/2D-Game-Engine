package view.font;

import java.nio.file.Paths;

import org.newdawn.slick.AngelCodeFont;
import org.newdawn.slick.SlickException;

public class MaiandraGD
{
	private AngelCodeFont	the32ptFont;
	private AngelCodeFont	the24ptFont;
	private AngelCodeFont	the20ptFont;
	private AngelCodeFont	the16ptFont;

	public MaiandraGD() throws SlickException
	{
		String path = Paths.get( "resources", "Graphics", "Fonts" ).toString();

		the32ptFont = new AngelCodeFont( Paths.get( path, "Maiandra GD Bitmap Font 32pt.fnt" ).toString(),
				Paths.get( path, "Maiandra GD Bitmap Font 32pt_0.png" ).toString() );
		the24ptFont = new AngelCodeFont( Paths.get( path, "Maiandra GD Bitmap Font 24pt.fnt" ).toString(),
				Paths.get( path, "Maiandra GD Bitmap Font 24pt_0.png" ).toString() );
		the20ptFont = new AngelCodeFont( Paths.get( path, "Maiandra GD Bitmap Font 20pt.fnt" ).toString(),
				Paths.get( path, "Maiandra GD Bitmap Font 20pt_0.png" ).toString() );
		the16ptFont = new AngelCodeFont( Paths.get( path, "Maiandra GD Bitmap Font 16pt.fnt" ).toString(),
				Paths.get( path, "Maiandra GD Bitmap Font 16pt_0.png" ).toString() );
	}

	public AngelCodeFont get32ptFont ()
	{
		return the32ptFont;
	}

	public AngelCodeFont get24ptFont ()
	{
		return the24ptFont;
	}

	public AngelCodeFont get20ptFont ()
	{
		return the20ptFont;
	}

	public AngelCodeFont get16ptFont ()
	{
		return the16ptFont;
	}
}
