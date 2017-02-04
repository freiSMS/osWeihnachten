package os.synchron;

public class Main
{
	public final static String[] REINDEER_NAMES =
	{ "Dasher", "Dancer", "Prancer", "Vixen", "Comet", "Cupid", "Donner", "Blitzen", "Rudolph" };

	public Main()
	{
		for (String actual : REINDEER_NAMES)
		{
			new Reindeer(actual);
		}
		for (int i = 0; i < 12; i++)
			new Elf("" + (i + 1));
	}

	public static void main(String[] args)
	{
		new Main();
	}
}
