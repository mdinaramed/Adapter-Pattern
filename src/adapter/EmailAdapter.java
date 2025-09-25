package adapter;
import adaptee.EmailClient;
import service.MessageService;

public final class EmailAdapter implements MessageService {
    private final EmailClient client;

    public EmailAdapter() {
        this.client = new EmailClient();
    }

    public EmailAdapter(EmailClient cliet) {
        if (cliet == null) throw new IllegalArgumentException("cliet == null");
        this.client = cliet;
    }

    @Override
    public void sendMessage(String message) {
        String text = validate(message);
        client.deliver(text);
    }
    private static String validate(String message) {
        if (message == null || message.trim().isEmpty()) {
            throw new IllegalArgumentException("message can not be null");
        }
        return message;
    }
}
