package os.synchron;

import java.util.ArrayList;

public class SantaClaus extends Actor
{
	private ArrayList<String> elfs = new ArrayList<String>();
	private ArrayList<String> reindeers = new ArrayList<String>();

	public SantaClaus(String name)
	{
		super(name);
	}

	public SantaClaus()
	{
		this("Santa Claus");
	}

	public void run()
	{
		try
		{
			this.doYourThing();
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}

	private synchronized void doYourThing() throws InterruptedException
	{
		while (true)
		{
			while (this.elfs.size() < 3 && this.reindeers.size() < Main.REINDEER_NAMES.length)
			{
				wait();
			}
			if (this.reindeers.size() == Main.REINDEER_NAMES.length)
			{
				this.santaDoesJob();
				continue;
			} else if (this.elfs.size() >= 3)
			{
				this.santaHelpsElfs();
			}

		}

	}

	private void santaDoesJob() throws InterruptedException
	{
		System.out.println();
		System.out.println(
				"Alle wieder zurueck. Santa spannt die Tierchen in der Reihenfolge des Eintreffens an den Karren");
		for (String temp : this.reindeers)
			System.out.print(temp + ", ");
		System.out.println("Santa macht gerade eine Menge Kinder gluecklich....");
		Thread.sleep(1000);
		System.out.println(
				"Santa is back from action. Alle Kids gluecklich, die Damen auch. Jetzt ab in den Urlaub und ich geh schlafen");
		System.out.println("-----------------------------");
		System.out.println("-----------------------------");
		this.reindeers = new ArrayList<String>();
		this.notifyAll();
	}

	private void santaHelpsElfs() throws InterruptedException
	{
		System.out.println("Santa says: You " + this.elfs.size() + " elfs suck. Can't you do anything withou me?");
		Thread.sleep(1000);
		System.out.println("*Santa is doing his work*");
		System.out.println("Can I go to sleep now? Thanks...");
		System.out.println("-----------------------------");
		System.out.println("-----------------------------");
		System.out.println();
		elfs = new ArrayList<String>();
		this.notifyAll();
	}
	int anzahlWartenderElfen =0;
	public synchronized void elfNeedsHelp() throws InterruptedException
	{
		String name = Thread.currentThread().getName();
		if (!elfs.contains(name))
		{
			System.out.println("I need some help " + name);
			elfs.add(name);
			anzahlWartenderElfen++;
			System.out.println("GeheSchlafen: " + name +" es wartet folgende Elfenanzahl: " + anzahlWartenderElfen );
			if (elfs.size() == 3)
			{
				System.out.println("Die Elfen wecken alle auf");
				this.notifyAll();
			}
			else {wait();}
		}

		while (elfs.contains(name))
		{
			System.out.println("bin schon auf der liste mit namen: " +name);
			wait();
		}

	}

	public synchronized void reindeerDoingStuff() throws InterruptedException
	{
		System.out.println("Reindeer " + Thread.currentThread().getName() + " returning home");
		this.reindeers.add(Thread.currentThread().getName());
		if (this.reindeers.size() == Main.REINDEER_NAMES.length)
		{
			System.out.println("Die Rentiere wecken alle auf!");
			this.notifyAll();
		}
		while (this.reindeers.size() != 0)
		{
			wait();
		}
	}

}
