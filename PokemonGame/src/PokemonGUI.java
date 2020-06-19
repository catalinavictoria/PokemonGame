import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.SecureRandom;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PokemonGUI extends JFrame
{
	//declare GUI elements
	private JPanel mainPanel;
	private JPanel pnlLogo;
	private JPanel pnlCounters;
	private JPanel pnlPokemons;
	private JPanel pnlOptions;
	private JPanel pnlMessage;
	private JPanel pnlNew;
	
	//the logo image
	private JLabel pkmLogo, pkmGuessed, pkmNotGuessed, pkmTotalGuessed, guessPkm, message;
	//create buttons for display
	private JButton btnPoke1, btnPoke2, btnIdk, btnNew, btnFinish;
	
	//create an arrayList of Pokemons
	ArrayList<Pokemon> pokemones = new ArrayList<Pokemon>();
	//ArrayList<Pokemon> pkmSelect = new ArrayList<Pokemon>();
	
	//create random number generators
	SecureRandom randomNum1 = new SecureRandom();
	SecureRandom randomNum2 = new SecureRandom();
	
	//ImageIcon for the logo
	private ImageIcon logo;
	
	//variables to calculate total pokemon guessed and not guessed
	int guessed = 0;
	int notGuessed = 0;
	Pokemon pkm1;
	Pokemon pkm2;
	
	//array with silhouette and images names
	private static final String[] siluetas =
		{"001bulbasaur.jpg", "004charmander.jpg", "012Butterfree.jpg", "015Beedrill.jpg", "018Pidgeot.jpg",
				"020Raticate.jpg", "026Raichu.jpg", "027Sandshrew.jpg", "035Clefairy.jpg", "039Jigglypuff.jpg",
				"042Golbat.jpg", "045Vileplume.jpg", "046Paras.jpg", "053Persian.jpg", "054Psyduck.jpg",
				"056Mankey,jpg", "061Poliwhirl.jpg", "062Poliwrath.jpg", "064Kadabra.jpg", "067Machoke.jpg",
				"068Machamp.jpg", "070Weepinbell.jpg", "074Geodude.jpg", "077Ponyta.jpg", "079Slowpoke.jpg",
				"082Magneton.jpg", "084Doduo.jpg", "086Seel.jpg", "088Grimer.jpg", "090Shellder.jpg",
				"092Gastly.jpg", "096Drowzee.jpg", "102Exeggcute.jpg", "103Exeggutor.jpg", "104Cubone.jpg",
				"107Hitmonchan.jpg", "109Koffing.jpg", "114Tangela.jpg", "117Seadra.jpg", "120Staryu.jpg",
				"124Jynx.jpg", "126Magmar.jpg", "128Tauros.jpg", "132Ditto.jpg", "133Eevee.jpg",
				"134Vaporeon.jpg", "136Flareon.jpg", "137Porygon.jpg", "138Omanyte.jpg", "151Mew.jpg"};
	
	private static final String[] imagenes =
		{"001BulbasaurIMG.jpg", "004CharmanderIMG.jpg", "012ButterfreeIMG.jpg", "015BeedrillIMG.jpg", "018PidgeotIMG.jpg",
				"020RaticateIMG.jpg", "026RaichuIMG.jpg", "027SandshrewIMG.jpg", "035ClefairyIMG.jpg", "039JigglypuffIMG.jpg",
				"042GolbatIMG.jpg", "045VileplumeIMG.jpg", "046ParasIMG.jpg", "053PersianIMG.jpg", "054PsyduckIMG.jpg",
				"056MankeyIMG.jpg", "061PoliwhirlIMG.jpg", "062PoliwrathIMG.jpg", "064KadabraIMG.jpg", "067MachokeIMG.jpg",
				"068MachampIMG.jpg", "070WeepinbellIMG.jpg", "074GeodudeIMG.jpg", "077PonytaIMG.jpg", "079SlowpokeIMG.jpg",
				"082MagnetonIMG.jpg", "084DoduoIMG.jpg", "086SeelIMG.jpg", "088GrimerIMG.jpg", "090ShellderIMG.jpg",
				"092GastlyIMG.jpg", "096DrowzeeIMG.jpg", "102ExeggcuteIMG.jpg", "103ExeggutorIMG.jpg", "104CuboneIMG.jpg",
				"107HitmonchanIMG.jpg", "109KoffingIMG.jpg", "114TangelaIMG.jpg", "117SeadraIMG.jpg", "120StaryuIMG.jpg",
				"124JynxIMG.jpg", "126MagmarIMG.jpg", "128TaurosIMG.jpg", "132DittoIMG.jpg", "133EeveeIMG.jpg",
				"134VaporeonIMG.jpg", "136FlareonIMG.jpg", "137PorygonIMG.jpg", "138OmanyteIMG.jpg", "151MewIMG.jpg"};
	
	private static final String[] nombres =
		{"Bulbasaur", "Charmander", "Butterfree", "Beedrill", "Pidgeot", "Raticate",
				"Raichu", "Sandshrew", "Clefairy", "Jigglypuff", "Golbat", "Vileplume",
				"Paras", "Persian", "Psyduck", "Mankey", "Poliwhirl", "Poliwrath",
				"Kadabra", "Machoke", "Machamp", "Weepinbell", "Geodude", "Ponyta",
				"Slowpoke", "Magneton", "Doduo", "Seel", "Grimer", "Shellder", "Gastly",
				"Drowzee", "Exeggcute", "Exeggutor", "Cubone", "Hitmonchan", "Koffing",
				"Tangela", "Seadra", "Staryu", "Jynx", "Magmar", "Tauros", "Ditto",
				"Eevee", "Vaporeon", "Flareon", "Porygon", "Omanyte", "Mew"};
	
	
	//CONSTRUCTOR FOR GUI
	public PokemonGUI()
	{
		setTitle("Who's that Pokémon?");
		//call buildPanel method
		buildPanel();
		//add panel to JFrame
		add(mainPanel);
	}
	
	//BUILDPANEL METHOD TO BUILD GUI
	private void buildPanel()
	{
		//set mainPanel to have a boxLayout and white background
		mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		mainPanel.setBackground(Color.white);
		
		//set the rest of the panels to have a flow layout
		pnlLogo = new JPanel();
		pnlLogo.setBackground(Color.white);
		
		pnlCounters = new JPanel();
		pnlCounters.setBackground(Color.white);
		
		pnlPokemons = new JPanel();
		pnlPokemons.setBackground(Color.white);
		
		pnlOptions = new JPanel();
		pnlOptions.setBackground(Color.white);
		
		pnlMessage = new JPanel();
		pnlMessage.setBackground(Color.white);
		
		pnlNew = new JPanel();
		pnlNew.setBackground(Color.white);
		
		////////////////////PNLLOGO PANEL\\\\\\\\\\\\\\\\\
		
		//creating logo image
		logo = new ImageIcon("50_pics" + java.io.File.separator + "Pokémon_logo_English.jpg");
		pkmLogo = new JLabel(logo);
		//adding logo image to the pnlLogo panel
		pnlLogo.add(pkmLogo);
		//adding pnlLogo to the main panel
		mainPanel.add(pnlLogo);
		
		////////////PNLCOUNTERS PANEL\\\\\\\\\\\\\\
		
		//create pokemon guessed and not guessed label objects
		pkmGuessed = new JLabel("POKÉMON GUESSED: ");
		pkmNotGuessed = new JLabel("POKÉMON NOT GUESSED: ");
		//adding labels to pnlCounter panel
		pnlCounters.add(pkmGuessed);
		pnlCounters.add(pkmNotGuessed);
		//adding panel to the main panel
		mainPanel.add(pnlCounters);
		
		/////////////////////PNLPOKEMONS\\\\\\\\\\\\\\\\\\\\\\\\\\
		
		//THIS PART SETS EVERYTHING I NEED FOR CALLING THE SELECTPOKEMON METHOD
		
		//call the createPokemones method to populate the arrayList with pokemons
		createPokemones();
		
		//create JLabel for showing pokemon
		guessPkm = new JLabel();
		
		///////////////////PNLOPTIONS PANEL\\\\\\\\\\\\\\\\\\\\\\\\
		
		//create button objects
		btnPoke1 = new JButton();
		btnPoke2 = new JButton();
		btnIdk = new JButton("I don't know");
		
		////adding it to subpanel and mainpanel
		pnlPokemons.add(guessPkm);
		mainPanel.add(pnlPokemons);
		
		//call the selectPokemon to get to random pokemons from the arrayList
		selectPokemon();
		
		//add buttons to subpanel
		pnlOptions.add(btnPoke1);
		pnlOptions.add(btnIdk);
		pnlOptions.add(btnPoke2);
		//adding buttons to the main panel
		mainPanel.add(pnlOptions);
		
		//connect buttons to actions
		btnPoke1.addActionListener(new ButtonHandler());
		btnIdk.addActionListener(new ButtonHandler());
		btnPoke2.addActionListener(new ButtonHandler());
		
		////////////////////PNLNEW\\\\\\\\\\\\\\\
		
		//create button objects
		btnNew = new JButton("New guess");
		//enabling the new game button
		btnNew.setEnabled(false);
		btnFinish = new JButton("Finish game");
		
		//connect buttons to actions
		btnNew.addActionListener(new ButtonHandler());
		btnFinish.addActionListener(new ButtonHandler());
		
		//create message label object
		message = new JLabel("-----------");
		
		//add these elements to main panel
		pnlNew.add(message);
		pnlNew.add(btnNew);
		pnlNew.add(btnFinish);
		mainPanel.add(pnlNew);
		
		
	}//end buildPanel method
	
	//method for creating pokemos and store them in the arrayList
	private void createPokemones()
	{
		//access to the folder with all images
		String folder = "50_pics" + java.io.File.separator;
		
		//set for loop para crear todos los pokemones
		for (int i = 0; i < nombres.length; i++)
		{
			//create new pokemon and add it to the arrayList of pokemon
			pokemones.add(new Pokemon(nombres[i], folder + siluetas[i], folder + imagenes[i]));
		}
		
	}//end createPokemones method
	
	//method for selecting two random pokemons from the pokemon arrayList
	public void selectPokemon()
	{
		//retrieve a pokemon objects from the arrayList
		pkm1 = pokemones.get(randomNum1.nextInt(50));
		pkm2 = pokemones.get(randomNum2.nextInt(50));
		
		//set a while loop to avoid choosing the same pokemon
		while(pkm1.getName().equals(pkm2.getName()))
		{
			//select a new pokemon
			pkm2 = pokemones.get(randomNum2.nextInt(50));
		}
		
		//add them to the arrayList of selected pokemons
		//pkmSelect.add(pkm1);
		//pkmSelect.add(pkm2);
		
		//access to the folder with all images
		String folder = "50_pics" + java.io.File.separator;
				
		//set the JLabel to show the silhoutte of one of the pokemon selected
		guessPkm.setIcon(pkm1.getSilhoutte());
		
		//adding it to subpanel and mainpanel
		//pnlPokemons.add(guessPkm);
		//mainPanel.add(pnlPokemons);
		
		//set buttons for pokemon 1 and pokemon 2
		btnPoke1.setText(pkm1.getName());
		btnPoke2.setText(pkm2.getName());
	}//end selectPokemon method
	
	private class ButtonHandler implements ActionListener
	{
		
		@Override
		public void actionPerformed(ActionEvent e)
		{
			System.out.println(e.getActionCommand());
			
			//set if statement for guesses
			if (e.getActionCommand().equals(pkm1.getName()))
			{
				//set label to show the answer is correct
				message.setText("CORRECT!");
				//change JLabel to show pokemon image
				guessPkm.setIcon(pkm1.getImage());
				//add one to correct pokemons counter
				guessed++;
				//change label to show new count of correct pokemon
				pkmGuessed.setText("POKÉMON GUESSED:" + guessed);
			}
			else if ((e.getActionCommand()).equals(pkm2.getName()))
			{
				//set label to show the answer is incorrect
				message.setText("INCORRECT :( It's " + pkm1.getName());
				//change JLabel to show pokemon imagenes
				guessPkm.setIcon(pkm1.getImage());
				//add one to incorrect pokemons counter
				notGuessed++;
				//change label to show new count of incorrect pokemon
				pkmNotGuessed.setText("POKÉMON NOT GUESSED: " + notGuessed);
			}
			else if (e.getActionCommand().equals("I don't know"))
			{
				//set label to show correct pokemon
				message.setText("It's " + pkm1.getName());
				//change JLabel to show pokemon imagenes
				guessPkm.setIcon(pkm1.getImage());
				//add one to not guessed pokemon counter
				notGuessed++;
				//change label to show new count
				pkmNotGuessed.setText("POKÉMON NOT GUESSED: " + notGuessed);
			}//end if statement
			
			//enable new guess button
			btnNew.setEnabled(true);
			//disable buttons for guessing pokemon
			btnPoke1.setEnabled(false);
			btnPoke2.setEnabled(false);
			btnIdk.setEnabled(false);
			
			//set switch statement for other game options
			switch (e.getActionCommand())
			{
			case "New guess":
				//reset message label
				message.setText("-----------");
				//reset pokemon icon
				guessPkm.setIcon(null);
				//call selectPokemon method for showing a new pokemon
				selectPokemon();
				//enable buttons for guessing the new pokemon
				btnPoke1.setEnabled(true);
				btnPoke2.setEnabled(true);
				btnIdk.setEnabled(true);
				break;
			case "Finish game":
				//show goodbye message in label
				message.setText("GOOD GAME! GOODBYE :)");
				//disable all buttons
				btnNew.setEnabled(false);
				btnPoke1.setEnabled(false);
				btnPoke2.setEnabled(false);
				btnIdk.setEnabled(false);
				break;
			}//end switch statement
							
		}//end actionPerformed method
		
	}//end buttonHandler class

}//end pokemonGUI class
