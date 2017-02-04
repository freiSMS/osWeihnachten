package os.synchron;

import java.util.Random;

public class Actor extends Thread
{
	private final static SantaClaus santaClaus = new SantaClaus();
	private final static Random RAND = new Random();

	public Actor(String name)
	{
		super(name);
		this.start();
	}

	protected static int getTime(int timeSpan)
	{
		return RAND.nextInt(timeSpan * 1000);
	}

	protected SantaClaus getSanta()
	{
		return santaClaus;
	}
}
