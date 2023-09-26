package events;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import org.jetbrains.annotations.NotNull;

public class InteractionEventListener extends ListenerAdapter{
    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        super.onSlashCommandInteraction(event);

        switch(event.getName()){
            case "help":
                event.reply("Vous avez besoin daide ?").queue();
                break;
            case "dwld":
                OptionMapping option = event.getOption("title");
                if(option == null){
                    event.reply("Display name not provided").queue();
                }
                event.reply("En cours : Téléchargement de " + option.getAsString()).queue();
                break;
            default: break;
        }
    }
}
