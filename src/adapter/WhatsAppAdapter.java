package adapter;
import adaptee.WhatsAppAPI;
import service.MessageService;

public final class WhatsAppAdapter implements MessageService {
    private final WhatsAppAPI api;

    public WhatsAppAdapter() {
        this.api = new WhatsAppAPI();
    }

    public WhatsAppAdapter(WhatsAppAPI api) {
        if (api == null) throw new IllegalArgumentException("api can not be null");
        this.api = api;
    }

    @Override
    public void sendMessage(String message) {
        String text = validate(message);
        api.send(text);
    }

    private static String validate(String message) {
        if (message == null || message.trim().isEmpty()) {
            throw new IllegalArgumentException("message can not be null");
        }
        return message;
    }

}
