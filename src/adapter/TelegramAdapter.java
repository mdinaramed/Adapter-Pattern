package adapter;
import adaptee.TelegramAPI;
import service.MessageService;

public final class TelegramAdapter implements MessageService {
    private final TelegramAPI api;

    public TelegramAdapter() {
        this.api = new TelegramAPI();
    }

    public TelegramAdapter(TelegramAPI api) {
        if (api == null) throw new IllegalArgumentException("api == null");
        this.api = api;
    }

    @Override
    public void sendMessage(String message) {
        String text = validate(message);
        api.push(text);
    }
    private String validate(String message) {
        if (message == null || message.trim().isEmpty()) {
            throw new IllegalArgumentException("message can not be null");
        }
        return message;
    }
}
