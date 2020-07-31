import dto.MailAccountDto;
import dto.MailRequest;
import handler.EmailHandler;
import handler.MailAccountHandler;
import handler.UserController;
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
                    ApiBuilder.path("user", () -> {
                        ApiBuilder.post((req) -> req.json(UserController.create(req.queryParam("email"), req.queryParam("name"))));
                        ApiBuilder.get((ctx) -> ctx.json(UserController.list()));
                        ApiBuilder.path(":id", () -> {
                            ApiBuilder.get((ctx) -> ctx.json(UserController.get(ctx.param("id"))));
                            ApiBuilder.put((ctx) -> ctx.json(UserController.update(ctx.param("id"), ctx.formParam("name"))));
                            ApiBuilder.delete((ctx) -> ctx.json(UserController.delete(ctx.param("id"))));
                        });
                    });
                    ApiBuilder.path("mailaccount", () -> {
                        ApiBuilder.post((req) -> req.json(MailAccountHandler.create(req.bodyAsClass(MailAccountDto.class))));
                        ApiBuilder.get((ctx) -> ctx.json(MailAccountHandler.list()));
                        ApiBuilder.path(":id", () -> {
                            ApiBuilder.get((ctx) -> ctx.json(UserController.get(ctx.param("id"))));
                            ApiBuilder.put((ctx) -> ctx.json(UserController.update(ctx.param("id"), ctx.formParam("name"))));
                            ApiBuilder.delete((ctx) -> ctx.json(UserController.delete(ctx.param("id"))));
                        });
                    });
                    ApiBuilder.path("email", () -> {
                       ApiBuilder.post((req) -> EmailHandler.triggerEmail(req.bodyAsClass(MailRequest.class)));
                    });
                });
    }
}
