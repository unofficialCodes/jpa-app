package org.jpa.app.enumeration;

@SuppressWarnings("all")
public enum Currency {
    DOLLAR("DOLLAR"), // ordinal 0
    INR("INR"); // ordinal 1

    private final String currency;

    private Currency(String currency) {
        this.currency = currency;
    }
    public String getCurrency() { return this.currency; }
}
