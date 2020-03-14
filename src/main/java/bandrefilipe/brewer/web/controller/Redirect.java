package bandrefilipe.brewer.web.controller;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * Package-visible Spring Web MVC redirect constants.
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
final class Redirect {

    private static final String PREFIX = "redirect:";

    public static final String BEVERAGES_NEW = PREFIX + API.BEVERAGES + "/new";
    public static final String CLIENTS_NEW = PREFIX + API.CLIENTS + "/new";
    public static final String USERS_NEW = PREFIX + API.CLIENTS + "/new";
    public static final String CITIES_NEW = PREFIX + API.CITIES + "/new";
}
