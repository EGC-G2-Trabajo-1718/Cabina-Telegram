package basicBot;

import org.telegram.abilitybots.api.bot.AbilityBot;
import org.telegram.abilitybots.api.objects.Ability;
import org.telegram.abilitybots.api.objects.Flag;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;

import functionality.exitFunctionality;

import static org.telegram.abilitybots.api.objects.Locality.ALL;
import static org.telegram.abilitybots.api.objects.Privacy.PUBLIC;

import java.util.Map;
import java.util.function.Predicate;

public class HolaBot extends AbilityBot {

	/** Token y usuario para el bot del grupo ***/	
	public static String BOT_TOKEN = "364453770:AAGsdhgKm_Lz526QcezaiO38vjuWA557P-0";
	public static String BOT_USERNAME = "CabinaDevBot";

	
/** Token y usuario para el bot de Victor ***/
//	public static String BOT_TOKEN = "402713141:AAG9jF3NFtLHuWaPALrpO51M4wB2Yg5hYh8";
//	public static String BOT_USERNAME = "rosa_victor_hola_bot";

	
	public HolaBot() {
		super(BOT_TOKEN, BOT_USERNAME);
	}

	@Override
	public int creatorId() {
		return 403201590;
	}
	
	public Ability login() {
	    String message1 = "Dime tu nombre";
	    String message2 = "Ahora dime tu apellido";
	    
	    return Ability.builder()
	        .name("login")
	        .info("Mensaje con replies")
	        .privacy(PUBLIC)
	        .locality(ALL)
	        .input(0)
	        .action(ctx -> silent.forceReply(message1, ctx.chatId()))
	        // The signature of a reply is -> (Consumer<Update> action, Predicate<Update>... conditions)
	        // So, we  first declare the action that takes an update (NOT A MESSAGECONTEXT) like the action above
	        // The reason of that is that a reply can be so versatile depending on the message, context becomes an inefficient wrapping
	        .reply(upd -> {
	              // Prints to console
	              System.out.println("I'm in a reply!");
	              
	              //llama al mapa de db y le introduce la respuesta del usuario con la clave de la id del chat
	              Map<String, String> nombreMap = db.getMap("Nombres");
	              String chatId = upd.getMessage().getChatId()+"";
	              nombreMap.put(chatId, upd.getMessage().getText());

	              // Sends message
	              silent.forceReply(message2, upd.getMessage().getChatId());
	            },
	            // Now we start declaring conditions, MESSAGE is a member of the enum Flag class
	            // That class contains out-of-the-box predicates for your replies!
	            // MESSAGE means that the update must have a message
	            // This is imported statically, Flag.MESSAGE
	            Flag.MESSAGE,
	            // REPLY means that the update must be a reply, Flag.REPLY
	            Flag.REPLY,
	            // A new predicate user-defined
	            // The reply must be to the bot
	            isReplyToBot(),
	            // If we process similar logic in other abilities, then we have to make this reply specific to this message
	            // The reply is to the playMessage
	            isReplyToMessage(message1)
	        ).reply(upd -> {
	        	// el apellido se puede obtener con el mensaje actual, pero para el nombre hay que acceder al mapa de
	        	// db con la key de la id del chat
	        	  Map<String, String> nombreMap = db.getMap("Nombres");
	              String chatId = upd.getMessage().getChatId()+"";
	              String nombre = nombreMap.get(chatId);
	              silent.send("Hola "+ nombre +" "+upd.getMessage().getText(), upd.getMessage().getChatId());
	            },
	            Flag.MESSAGE,
	            Flag.REPLY,
	            isReplyToBot(),
	            isReplyToMessage(message2)
	        )
	        // You can add more replies by calling .reply(...)
	        .build();
	}
	

	public Ability votacionesAbiertas() {
		String texto = "Las votaciones abiertas son las siguientes:"
				+ "\r\n- Votaci�n de prueba 1, c�digo:abcd1234"
				+ "\r\n- Votaci�n de prueba 2, c�digo:abce1284"
				+ "\r\n- Votaci�n de prueba 3, c�digo:arsq5664"
				+ "\r\nSi desea ver todas las votaciones haga click en http://congreso.us.es/splc2017/";
		//TODO: url donde esten directamente las votaciones
		return Ability.builder()
					  .name("votacionesAbiertas")
					  .info("devuelve las votaciones que hay disponibles para votar")
					  .locality(ALL)
					  .privacy(PUBLIC)
					  .action(ctx -> silent.send(texto, ctx.chatId()))
					  .build();
	}
	

	public Ability exit() {
		
		String confirmation = "Esto cerrar� la sesi�n actual. �Continuar?";
		String close = "ha cerrado sesi�n exitosamente";
		String noClose = "No se ha cerrado la sesi�n";
		
		return Ability.builder()
					  .name("exit")
					  .info("sale del login")
					  .locality(ALL)
					  .privacy(PUBLIC)
					  .action(ctx -> silent.forceReply(confirmation, ctx.chatId()))
				        .reply(upd -> {
				           
				            if(upd.getMessage().getText().equalsIgnoreCase("si")) {
				            	 exitFunctionality.exit();
				            	 silent.send(close, upd.getMessage().getChatId());
				            }
				            else {
				            	silent.send(noClose, upd.getMessage().getChatId());
				            }
				             
				            },
				 
				            Flag.MESSAGE,
				            
				            Flag.REPLY,
				
				            isReplyToBot()
				    
				           
				            
				        )
				        // You can add more replies by calling .reply(...)
				        .build();
	}
	
	public Ability votar() {
		String votacion = "Introduzca la id de la votaci�n que desee:";
		String pregunta = "Introduzca la id de la pregunta";
		String respuesta = "Introduzca la id de la respuesta";
		return Ability.builder()
					  .name("votar")
					  .info("Crea y env�a un voto")
					  .locality(ALL)
					  .privacy(PUBLIC)
					  .action(ctx -> silent.forceReply(votacion, ctx.chatId()))
				        .reply(upd -> {
				           
				            if(upd.getMessage().getText()) {
				            	 exitFunctionality.exit();
				            	 silent.send(close, upd.getMessage().getChatId());
				            }
				            else {
				            	silent.send(noClose, upd.getMessage().getChatId());
				            }
				             
				            },
				 
				            Flag.MESSAGE,
				            
				            Flag.REPLY,
				
				            isReplyToBot()
				    
				           
				            
				        )
				        // You can add more replies by calling .reply(...)
				        .build();
	}
	
	private Predicate<Update> isReplyToMessage(String message) {
      return upd -> {
        Message reply = upd.getMessage().getReplyToMessage();
        return reply.hasText() && reply.getText().equalsIgnoreCase(message);
      };
    }
	  
    private Predicate<Update> isReplyToBot() {
      return upd -> upd.getMessage().getReplyToMessage().getFrom().getUserName().equalsIgnoreCase(getBotUsername());
    }
}












// .action(ctx -> silent.send("Hola desde el bot de votaciones para EGC grupo 2!", ctx.chatId()))