import service.MessageService;
import adapter.EmailAdapter;
import adapter.TelegramAdapter;
import adapter.WhatsAppAdapter;


public class Main {
    public static void main(String[] args) {
        MessageService whatsapp = new WhatsAppAdapter();
        MessageService telegram = new TelegramAdapter();
        MessageService email = new EmailAdapter();

        whatsapp.sendMessage("Hello via WhatsApp");
        telegram.sendMessage("Hello via Telegram");
        email.sendMessage("Hello via Email");
    }
}