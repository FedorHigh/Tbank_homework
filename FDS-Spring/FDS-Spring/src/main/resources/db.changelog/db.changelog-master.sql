CREATE TABLE currency (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    baseCurrency VARCHAR(255) NOT NULL DEFAULT = "RUB",
    priceChangeRate VARCHAR(255) NOT NULL,
    description VARCHAR(255) NOT NULL
);
