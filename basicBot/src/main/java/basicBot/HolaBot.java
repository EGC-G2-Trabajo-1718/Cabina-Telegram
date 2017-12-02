package basicBot;

import org.telegram.abilitybots.api.bot.AbilityBot;
import org.telegram.abilitybots.api.objects.Ability;

import static org.telegram.abilitybots.api.objects.Locality.ALL;
import static org.telegram.abilitybots.api.objects.Privacy.PUBLIC;

public class HolaBot extends AbilityBot {

	/** Token y usuario para el bot del grupo ***/	
//	public static String BOT_TOKEN = "364453770:AAGsdhgKm_Lz526QcezaiO38vjuWA557P-0";
//	public static String BOT_USERNAME = "CabinaDevBot";

	
/** Token y usuario para el bot de Víctor ***/
	public static String BOT_TOKEN = "402713141:AAG9jF3NFtLHuWaPALrpO51M4wB2Yg5hYh8";
	public static String BOT_USERNAME = "rosa_victor_hola_bot";

	
	public HolaBot() {
		super(BOT_TOKEN, BOT_USERNAME);
	}

	@Override
	public int creatorId() {
		return 403201590;
	}

	public Ability sayHello() {
		return Ability.builder()
					  .name("hola")
					  .info("dice hola!")
					  .locality(ALL)
					  .privacy(PUBLIC)
					  .action(ctx -> silent.send("Hola desde el bot de votaciones para EGC grupo 2!", ctx.chatId()))
					  .build();
	}
}












// .action(ctx -> silent.send("Hola desde el bot de votaciones para EGC grupo 2!", ctx.chatId()))