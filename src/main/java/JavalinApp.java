import dto.MailAccountDto;
import dto.MailRequest;
import handler.EmailHandler;
import handler.MailAccountHandler;
import io.javalin.ApiBuilder;
import io.javalin.Javalin;

/**
 * @author sugamagarwal
 */
public class JavalinApp {
    public static void main(String[] args) {
        Javalin app = Javalin.create()
                .port(7000)
                .start().routes(() -> {
                    ApiBuilder.path("mailaccount", () -> {
                        ApiBuilder.post((req) -> req.json(MailAccountHandler.create(req.bodyAsClass(MailAccountDto.class))));
                        ApiBuilder.get((ctx) -> ctx.json(MailAccountHandler.list()));
                    });
                    ApiBuilder.path("email", () -> {
                       ApiBuilder.post((req) -> EmailHandler.triggerEmail(req.bodyAsClass(MailRequest.class)));
                    });
                });
    }
}
