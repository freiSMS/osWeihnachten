package os.synchron;

public class Reindeer extends Actor
{

	public Reindeer(String name)
	{
		super(name);
	}

	public void run()
	{
		try
		{
			this.reindeerWork();
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}

	private void reindeerWork() throws InterruptedException
	{
		while (true)
		{
			this.vacation();
			Thread.sleep(Actor.getTime(10));
			super.getSanta().reindeerDoingStuff();
		}
	}

	private void vacation()
	{
		System.out.println("Reindeer " + this.getName() + " is flying to Honolulu right now. See ya!");
	}
}
