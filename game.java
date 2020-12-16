 import java.io.IOException;
 import game_manager.general_manager;

/**
 * 
 * <p>Un jeu a la con</p>
 * @author jviatge , Pierre maxime
 * @version 0.1
 *
 */
public class game
{
	/**
	 * Point d'entrée de l'application
	 * @param args
	 */
	public static void main(String[] args) throws IOException {

          general_manager GM = new general_manager();
          GM.start();
        
    }

}