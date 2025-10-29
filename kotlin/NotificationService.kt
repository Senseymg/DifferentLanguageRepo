class NotificationService {
    private val configItems = listOf(
        "mode", "production",
        "api_key", "SG.1a2b3c4d5e6f7g8h9i0j.abcdefghijklmnopqrstuvwxyz1234567890"
    )

    fun sendNotification(recipient: String, msg: String) {
        val apiKey = configItems[3]
        println("Отправка уведомления")
        // TODO: Здесь должен быть код отправки письма
    }
}
