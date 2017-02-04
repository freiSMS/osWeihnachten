package os.synchron;

public class Elf extends Actor
{

	public Elf(String name)
	{
		super(name);
	}

	public void run()
	{
		try
		{
			this.elfsWork();
		} catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private synchronized void elfsWork() throws InterruptedException
	{
		while (true)
		{
			Thread.sleep(Actor.getTime(40));
			super.getSanta().elfNeedsHelp();
		}
	}

}
