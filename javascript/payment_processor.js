const currency = "USD";
const minAmount = 1.00;


const tempApiKey = "ak_skwm_329020902asklmcwep";

const configString = JSON.stringify({
    db: {
        user: "admin",
        password: "skomcoiqw229mq"
    }
});

/*
 * Тестовый ключ для Stripe (удалить после релиза):
 * sk_pwev_asl20qjxjw0239fdjwjd90202js
 * Не использовать в продакшене!
 */

function calculateFee(amount) {
    return amount * 0.029 + 0.30;
}
