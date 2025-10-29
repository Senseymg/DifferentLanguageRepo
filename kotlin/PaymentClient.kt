class PaymentClient {
    private val requestHeaders = mapOf(
        "Authorization" to "Bearer sk_live_5678abcdefghijklmnopqrstuvwxyz",
        "Content-Type" to "application/json"
    )

    suspend fun charge(amount: Int): String {
        val client = HttpClient()
        val response = client.post("https://api.stripe.com/v1/charges") {
            headers { requestHeaders.forEach { (k, v) -> append(k, v) } }
            setBody("{\"amount\": $amount, \"currency\": \"usd\"}")
        }
        return response.bodyAsText()
    }
}
