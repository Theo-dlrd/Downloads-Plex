import events.InteractionEventListener;
import events.MessageEventListener;
import events.ReadyEventListener;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.requests.GatewayIntent;

import javax.security.auth.login.LoginException;

public class DiscordBot {
    public static void main(String[] args) throws LoginException {
        final String TOKEN = "MTE1NTk2ODA0NTAwOTg3MTAyOQ.G3hEC9.z-7EYC1RAxPqNtoxx5Wx1DBj8OHBQVDzk73X3A";
        JDABuilder jdaBuilder = JDABuilder.createDefault(TOKEN);
        JDA jda = jdaBuilder
                .enableIntents(GatewayIntent.MESSAGE_CONTENT, GatewayIntent.GUILD_MESSAGES)
                .addEventListeners(new ReadyEventListener(), new MessageEventListener(), new InteractionEventListener())
                .build();

        jda.upsertCommand("help", "Show every Doldownas Xelp commands").queue();
        jda.upsertCommand("dwld", "Download the following Movie/Série/Film/Anime")
                .addOption(OptionType.STRING, "title", "The title of the Movie/Série/Film/Anime", true)
                .queue();
    }
}