package bandrefilipe.brewer.web;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Locale;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class GlobalConstants {

    /* Cached Locales */
    public static final Locale LOCALE_EN_US = Locale.US;
    public static final Locale LOCALE_ES = new Locale("es");
    public static final Locale LOCALE_PT_BR = new Locale("pt", "BR");
}
